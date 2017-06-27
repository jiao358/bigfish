package ext.core.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ext.datasource.inf.CustomerMapper;
import ext.datasource.inf.SDicMapper;
import ext.datasource.inf.SUserMapper;
import ext.datasource.inf.TrxClassMapper;
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
