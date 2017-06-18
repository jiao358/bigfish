package ext.core.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ext.core.domain.BaseSys;
import ext.datasource.entity.SUser;
import ext.datasource.inf.SDicMapper;
import ext.datasource.inf.SUserMapper;
import ext.util.helper.BigCont;
import ext.util.helper.Helper;
import ext.util.helper.HelperBean;

@Controller
public class UServiceCenter {
	
	private final static Logger logger = LogManager.getLogger(UServiceCenter.class.getName());
	@Autowired
	private SUserMapper sUser;
	@Autowired
	private SDicMapper sDicDao;
	
	
	@RequestMapping(value = "/editSys.do", method = RequestMethod.POST)
	public void addSys(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result=  Helper.initResponse();
		BaseSys basesys= (BaseSys) request.getSession().getAttribute(BigCont.BASESYS);
//		int id =module.getId();
		int id = Integer.parseInt(request.getParameter("id"));
		SUser reource=sUser.selectByPrimaryKey(id);
		Map user = request.getParameterMap();
		SUser target = new SUser();
		BeanUtils.copyProperties(target,user );
		target.setUpdateDaate(new Date());
		HelperBean.copyProperties(target, reource);
		logger.info("update the sysuser");
		sUser.updateByPrimaryKey(reource);
		Helper.restful(response, result);
	}	
}
