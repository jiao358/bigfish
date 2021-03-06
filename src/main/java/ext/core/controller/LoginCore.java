package ext.core.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ext.core.domain.BaseSys;
import ext.core.domain.FontModule;
import ext.datasource.entity.SModule;
import ext.datasource.entity.SModuleExample;
import ext.datasource.entity.SRole;
import ext.datasource.entity.SRoleExample;
import ext.datasource.entity.SUser;
import ext.datasource.inf.SModuleMapper;
import ext.datasource.inf.SRoleMapper;
import ext.datasource.inf.SUserMapper;
import ext.util.helper.BigCont;
import ext.util.helper.Helper;

@Controller
public class LoginCore {
	private final static Logger logger = LogManager.getLogger(LoginCore.class.getName());
	@Autowired
	private SUserMapper sUser;
	@Autowired
	private SRoleMapper sRole;
	
	@Autowired
	private SModuleMapper sModuleDao;
	
	@Autowired
	private SessionControl sessionControl;

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public void userLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		Map result = Helper.initResponse();
		logger.info("the session is " + sessionId);
		String user = request.getParameter("user");
		String pwd = request.getParameter("password");
		SUser su = sUser.getUser(user, pwd);
	
		
		BaseSys sys = new BaseSys();
		if (su == null) {
			result.put("state", 0);
		} else {
			//TODO will controll button 
			SRoleExample sexample = new SRoleExample();
			sexample.createCriteria().andUserIdEqualTo(su.getId());
			List<SRole> listRole = sRole.selectByExample(sexample);
			
			sys.setUserName(user);
			Map roleMap = new HashMap();
			for(SRole role:listRole){
				int right=2;
				String roleModule=  role.getsModule();
				roleMap.put(roleModule, right);
			}
			sys.setRole(roleMap);
			
			sys.setUserId(su.getId());
			sys.setUserType(su.getUserType());
			
			//get all module
			SModuleExample moduleExp = new SModuleExample();
			moduleExp.setOrderByClause("M_ORDER ASC");
			Map<SModule,List<SModule>> modulemap = new HashMap<SModule,List<SModule>>();
			moduleExp.createCriteria().andParentEqualTo("root");
			List<SModule> allRootModules =sModuleDao.selectByExample(moduleExp);
			for(SModule rootModule:allRootModules){
				SModuleExample subExp = new SModuleExample();
				subExp.createCriteria().andParentEqualTo(rootModule.getModuleName());
				List<SModule> childrens = sModuleDao.selectByExample(subExp);
				modulemap.put(rootModule,childrens);
			}
			
			if(su.getUserType()==0){
				sys.setModules(parseModuleMap(modulemap));
			}else{
				Map<String,SRole> subSRole = new HashMap();
				for(SRole subRole:listRole){
					subSRole.put(subRole.getsModule(), subRole);
				}
				//fiter the permonsion
				// CRUD  1 2 4 8
				Map<SModule,List<SModule>> targetModule = new HashMap<SModule,List<SModule>>();
				
				Iterator<Entry<SModule,List<SModule>>> entrys = modulemap.entrySet().iterator();
				
				while(entrys.hasNext()){
					Entry<SModule,List<SModule>> entry=entrys.next();
					SRole subRole = subSRole.get(entry.getKey().getModuleName());
					
					if(subRole==null ){
						entry.getKey().setmRight(0);	
						continue;
					}
				
					List<SModule> subChild = new ArrayList<SModule>();
					
					for(SModule subModule:entry.getValue()){
						
						SRole childRole = subSRole.get(subModule.getModuleName());
						if(childRole==null){
							subModule.setmRight(0);
							continue;
						}
						subChild.add(subModule);
					}
					targetModule.put(entry.getKey(), subChild);
				}
				
				sys.setModules(parseModuleMap(targetModule));
			}
			session.setAttribute(BigCont.BASESYS, sys);
			sessionControl.sessionCheck(request);
			result.put("sessionKey", sessionId);
		}

		Helper.restful(response, result);
	}
	
	
	@RequestMapping(value = "/loginOut.do", method = RequestMethod.GET)
	public void loginOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String sessionKey=session.getId();
		sessionControl.loginOut(sessionKey);
		logger.info("loginOut the session sessionKey:"+sessionKey);
		
		
	}
	
	private List<FontModule> parseModuleMap(	Map<SModule,List<SModule>> modulemap ){
		List<FontModule>  fontModules = new ArrayList<FontModule>();
		Iterator<Entry<SModule,List<SModule>>> entrys = modulemap.entrySet().iterator();
		while(entrys.hasNext()){
			Entry<SModule,List<SModule>> entry=entrys.next();
			FontModule root = new FontModule();
			root.setParent(entry.getKey());
			root.setChildrens(entry.getValue());
			fontModules.add(root);
			
		}
		return fontModules;
		
		
	}
	
	@RequestMapping(value = "/loginsuccess.do", method = RequestMethod.POST)
	public void userLoginSuccess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String sessionKey=session.getId();
		logger.info("success login key:"+sessionKey);
		if(sessionControl.isLogin(sessionKey)){
			request.getRequestDispatcher("/index.html").forward(request, response);
		}
		
	}
	
	@RequestMapping(value = "/coreBaseSys.do", method = RequestMethod.GET)
	public void coreBaseSysInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("start init basesys!!!");
		HttpSession session = request.getSession();
		String sessionKey=session.getId();
		boolean isLogin=sessionControl.isLogin(sessionKey);
		if(!isLogin){
			request.getRequestDispatcher("/static/500.html").forward(request, response);
			return;
		}
		
		BaseSys sys=sessionControl.coreBaseSys(sessionKey);
		
		Helper.restful(response, sys);
	}
	
	
	
	
	
	
	
	
}
