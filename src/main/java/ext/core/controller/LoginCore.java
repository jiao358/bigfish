package ext.core.controller;

import java.util.List;
import java.util.Map;

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
import ext.datasource.entity.SRole;
import ext.datasource.entity.SRoleExample;
import ext.datasource.entity.SUser;
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
			SRoleExample sexample = new SRoleExample();
			sexample.createCriteria().andUserIdEqualTo(su.getId());
			List<SRole> listRole = sRole.selectByExample(sexample);
			sys.setUserName(user);
			sys.setRoleList(listRole);
			session.setAttribute(BigCont.BASESYS, sys);
			sessionControl.sessionCheck(request);
			result.put("sessionKey", sessionId);
		}

		Helper.restful(response, result);
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
	
	@RequestMapping(value = "/getBaseSys.do", method = RequestMethod.GET)
	public void getBaseSysInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String sessionKey=session.getId();
		boolean isLogin=sessionControl.isLogin(sessionKey);
		if(!isLogin){
			request.getRequestDispatcher("/static/500.html").forward(request, response);
			return;
		}
		
		BaseSys sys=sessionControl.getBaseSys(sessionKey);
		
		Helper.restful(response, sys);
	}
	
	
}
