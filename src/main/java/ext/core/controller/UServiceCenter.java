package ext.core.controller;

import java.util.Arrays;
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

import ext.core.batch.BatchTM;
import ext.core.batch.StartClassMessage;
import ext.core.batch.StartDutyMessage;
import ext.core.domain.BaseSys;
import ext.datasource.entity.Contract;
import ext.datasource.entity.Customer;
import ext.datasource.entity.SRole;
import ext.datasource.entity.SRoleKey;
import ext.datasource.entity.SUser;
import ext.datasource.entity.TrxClass;
import ext.datasource.inf.ContractMapper;
import ext.datasource.inf.CustomerMapper;
import ext.datasource.inf.SDicMapper;
import ext.datasource.inf.SRoleMapper;
import ext.datasource.inf.SUserMapper;
import ext.datasource.inf.TrxClassMapper;
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
	@Autowired
	private TrxClassMapper casDao;
	@Autowired
	private CustomerMapper customerDao;
	
	@Autowired
	private ContractMapper contDao;
	
	@Autowired
	private SRoleMapper roleDao;
	
	@RequestMapping(value = "/editSys.do", method = RequestMethod.POST)
	public void editSys(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
	
	
	@RequestMapping(value = "/editSysRole.do", method = RequestMethod.POST)
	public void editSysRole(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result=  Helper.initResponse();
		BaseSys basesys= (BaseSys) request.getSession().getAttribute(BigCont.BASESYS);
		int id = Integer.parseInt(request.getParameter("userId"));
		String content = request.getParameter("content");
		try{
			String[] module = content.split(",");
			for(String str:module){
				SRoleKey key = new SRoleKey();
				key.setsModule(str);
				key.setUserId(id);
				SRole sub=roleDao.selectByPrimaryKey(key);
				if(sub==null){
					SRole role = new SRole();
					role.setUserId(id);
					role.setsModule(str);
					role.setCreateDate(new Date());
					roleDao.insert(role);
				}
			}
			
			
		}catch (Exception e) {
			logger.error("Edit Sys Role error user id:"+id);
			Helper.errorRestful(response, "请检查输入内容格式");
			return;
		}
		Helper.restful(response, result);
	}	
	
	@RequestMapping(value = "/editCusMain.do", method = RequestMethod.POST)
	public void editCusMain(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result=  Helper.initResponse();
		BaseSys basesys= (BaseSys) request.getSession().getAttribute(BigCont.BASESYS);
		int operatorId = basesys.getUserId();
		String operName=  basesys.getUserName();
		
		int id = Integer.parseInt(request.getParameter("id"));
		Customer reource=customerDao.selectByPrimaryKey(id);
		
		Map customer = request.getParameterMap();
		Customer target = new Customer();
		
		BeanUtils.copyProperties(target,customer );
		target.setUpdateDate(new Date());
		target.setUpdateOperator(operatorId);
		
		HelperBean.copyProperties(target, reource);
		logger.info("update the cusMain");
		customerDao.updateByPrimaryKey(reource);
		Helper.restful(response, result);
	}	
	
	
	@RequestMapping(value = "/editContMain.do", method = RequestMethod.POST)
	public void editContMain(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result=  Helper.initResponse();
		BaseSys basesys= (BaseSys) request.getSession().getAttribute(BigCont.BASESYS);
		int operatorId = basesys.getUserId();
		int id = Integer.parseInt(request.getParameter("id"));
		Contract cont=contDao.selectByPrimaryKey(id);
		cont.setUpdateDate(new Date());
		cont.setUpdateOperator(operatorId);
		cont.setExecuteDate(new Date());
		cont.setContractState(1);
		logger.info("update the contMain");
		contDao.updateByPrimaryKey(cont);
		Helper.restful(response, result);
	}	
	
	@RequestMapping(value = "/editContMainOver.do", method = RequestMethod.POST)
	public void editContMainOver(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result=  Helper.initResponse();
		BaseSys basesys= (BaseSys) request.getSession().getAttribute(BigCont.BASESYS);
		int operatorId = basesys.getUserId();
		int id = Integer.parseInt(request.getParameter("id"));
		Contract cont=contDao.selectByPrimaryKey(id);
		cont.setUpdateDate(new Date());
		cont.setUpdateOperator(operatorId);
		cont.setContractState(2);
		logger.info("update over the contMain");
		contDao.updateByPrimaryKey(cont);
		Helper.restful(response, result);
	}	
	
	
	@RequestMapping(value = "/editCasMain.do", method = RequestMethod.POST)
	public void editCasMain(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result=  Helper.initResponse();
		BaseSys basesys= (BaseSys) request.getSession().getAttribute(BigCont.BASESYS);
		int operatorId = basesys.getUserId();
		String operName=  basesys.getUserName();
		
		int id = Integer.parseInt(request.getParameter("id"));
		TrxClass cas=casDao.selectByPrimaryKey(id);
		cas.setUpdateDate(new Date());
		cas.setUpdateOperator(operatorId);
		String teacherId= request.getParameter("teacherId");
		String assTeacherId=  request.getParameter("assTeacherId");
		cas.setTeacherId(Integer.valueOf(teacherId));
		if(assTeacherId!=null&&!"".equals(assTeacherId))
			cas.setAssTeacherId(Integer.valueOf(assTeacherId));
		
		String schedual  = request.getParameter("startScheduleBox");
		cas.setStartSchedule(schedual.substring(0,schedual.length()-1));
		
		logger.info("update the casMain");
		casDao.updateByPrimaryKey(cas);
		BatchTM.removeJob(cas.getId());
		String daliyCron ="";
		if(cas.getClassState()==1){
			StartDutyMessage sdm = new StartDutyMessage();
			sdm.setClassId(cas.getId());
			String[] time = cas.getStartSchedule().split(",");
			int[] classDays = new int[time.length];
			for (int i = 0; i < time.length; i++) {
				classDays[i] = Integer.parseInt(time[i]);
			}
			Arrays.sort(classDays);

			for(int i:classDays){
				int temp = (i+1)%7;
				if(temp==0)
					temp=7;
				daliyCron +=temp+",";
			}
			daliyCron=daliyCron.substring(0, daliyCron.length()-1);
			daliyCron = "0 "+cas.getStartMin()+" "+cas.getStartHour()+" ? * "+daliyCron;
			sdm.setCron(daliyCron);
			try {
				BatchTM.getDutymessage().put(sdm);
			} catch (InterruptedException e) {
				logger.error("duty job init error class id :"+cas.getId(),e);
			}
		}else if(cas.getClassState()==0){
			StartClassMessage scm=BatchTM.generateSCM(cas);
			scm.setDutyCron(daliyCron);
			BatchTM.getQueue().put(scm);
		}
		
		
		Helper.restful(response, result);
	}	
}
