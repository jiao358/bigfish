package ext.core.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ext.core.domain.BaseSys;
import ext.datasource.entity.ClassRel;
import ext.datasource.entity.ClassRelExample;
import ext.datasource.entity.TrxClass;
import ext.datasource.inf.ClassRelMapper;
import ext.datasource.inf.CustomerMapper;
import ext.datasource.inf.SDicMapper;
import ext.datasource.inf.SUserMapper;
import ext.datasource.inf.TrxClassMapper;
import ext.util.helper.BigCont;
import ext.util.helper.Helper;

@Controller
public class DServiceCenter {
	
	private final static Logger logger = LogManager.getLogger(DServiceCenter.class.getName());
	@Autowired
	private SUserMapper sUser;
	@Autowired
	private SDicMapper sDicDao;
	@Autowired
	private CustomerMapper customerDao;
	@Autowired
	private TrxClassMapper casDao;
	@Autowired
	private ClassRelMapper classRelDao;

	@RequestMapping(value = "/delSysUser.do", method = RequestMethod.POST)
	public void delSysUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result=  Helper.initResponse();
		String ids=request.getParameter("id");
		if(ids==null||"".equals(ids)){
			Helper.errorResonse(result);;
			return;
		}
		int num =sUser.deleteByPrimaryKey((Integer.parseInt(ids)));
		if(num!=1){
			Helper.errorResonse(result);;
			return;
		}
		Helper.restful(response, result);
	}	
	
	@RequestMapping(value = "/delCusMain.do", method = RequestMethod.POST)
	public void delCusMain(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result=  Helper.initResponse();
		String ids=request.getParameter("id");
		if(ids==null||"".equals(ids)){
			Helper.errorResonse(result);;
			return;
		}
		int num =customerDao.deleteByPrimaryKey((Integer.parseInt(ids)));
		if(num!=1){
			Helper.errorResonse(result);;
			return;
		}
		Helper.restful(response, result);
	}	
	
	
	@RequestMapping(value = "/delCasNormal.do", method = RequestMethod.POST)
	@Transactional
	public void delCasNormal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result=  Helper.initResponse();
		String customerId = request.getParameter("cusId");
		String classId = request.getParameter("casId");
		ClassRelExample classRelQuery = new ClassRelExample();
		classRelQuery.createCriteria().andClassIdEqualTo(Integer.valueOf(classId)).andCustomerIdEqualTo(Integer.valueOf(customerId));
		List<ClassRel> queryList = classRelDao.selectByExample(classRelQuery);
		if(queryList.size()!=1){
			Helper.errorRestful(response, "该信息异常，请联系管理员!");
			return;
		}
		
		ClassRel domain = queryList.get(0);
		classRelDao.deleteByPrimaryKey(domain.getId());
		BaseSys basesys= (BaseSys) request.getSession().getAttribute(BigCont.BASESYS);
		
		TrxClass classMain = casDao.selectByPrimaryKey(domain.getClassId());
		classMain.setCurrentMember(classMain.getCurrentMember()-1);
		classMain.setUpdateDate(new Date());
		classMain.setUpdateOperator(basesys.getUserId());
		casDao.updateByPrimaryKey(classMain);
		Helper.restful(response, result);
	}	
	
	
	
	@RequestMapping(value = "/delCasMain.do", method = RequestMethod.POST)
	public void delCasMain(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result=  Helper.initResponse();
		String ids=request.getParameter("id");
		if(ids==null||"".equals(ids)){
			Helper.errorResonse(result);;
			return;
		}
		int num =casDao.deleteByPrimaryKey((Integer.parseInt(ids)));
		if(num!=1){
			Helper.errorResonse(result);;
			return;
		}
		Helper.restful(response, result);
	}	
	
	
}
