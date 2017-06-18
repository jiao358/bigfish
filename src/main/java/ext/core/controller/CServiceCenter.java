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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ext.core.domain.BaseSys;
import ext.datasource.entity.SUser;
import ext.datasource.entity.SUserExample;
import ext.datasource.inf.SDicMapper;
import ext.datasource.inf.SUserMapper;
import ext.util.helper.BigCont;
import ext.util.helper.Helper;

@Controller
public class CServiceCenter {
	
	private final static Logger logger = LogManager.getLogger(CServiceCenter.class.getName());
	@Autowired
	private SUserMapper sUser;
	@Autowired
	private SDicMapper sDicDao;
	
	
	@RequestMapping(value = "/addsys.do", method = RequestMethod.POST)
	public void addSys(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result=  Helper.initResponse();
		BaseSys basesys= (BaseSys) request.getSession().getAttribute(BigCont.BASESYS);
		try{
			String father = basesys.getUserName();
			String userName = request.getParameter("userName");
			String passwd = request.getParameter("userPwd");
			String type = request.getParameter("userType");
			logger.info("the userName:"+userName);
			SUserExample sexp=  new SUserExample();
			
			sexp.createCriteria().andUserNameEqualTo(father);
			List<SUser> userList =sUser.selectByExample(sexp);
			int promotId=userList.get(0).getId();
			SUser user= new SUser();
			user.setOwnUser(promotId);
			user.setUserName(userName);
			user.setUserPwd(passwd);;
			user.setCreateDate(new Date());
			user.setUserType(Integer.parseInt(type));
			
			int xc=sUser.insert(user);
			logger.info(1);;
		}catch (Exception e) {
			logger.error("Insert User error->"+e);
			Helper.errorResonse(result);
		}
		Helper.restful(response, result);
	}	
}
