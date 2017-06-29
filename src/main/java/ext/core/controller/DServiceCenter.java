package ext.core.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
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

import ext.core.batch.BatchTM;
import ext.core.domain.BaseSys;
import ext.datasource.entity.ClassRel;
import ext.datasource.entity.ClassRelExample;
import ext.datasource.entity.Contract;
import ext.datasource.entity.SRoleKey;
import ext.datasource.entity.TrxClass;
import ext.datasource.entity.TrxDuty;
import ext.datasource.entity.TrxDutyExample;
import ext.datasource.inf.ClassRelMapper;
import ext.datasource.inf.ContractMapper;
import ext.datasource.inf.CustomerMapper;
import ext.datasource.inf.SDicMapper;
import ext.datasource.inf.SRoleMapper;
import ext.datasource.inf.SUserMapper;
import ext.datasource.inf.TrxClassMapper;
import ext.datasource.inf.TrxDutyMapper;
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
	private ContractMapper contDao;
	@Autowired
	private CustomerMapper customerDao;
	@Autowired
	private TrxClassMapper casDao;
	@Autowired
	private ClassRelMapper classRelDao;
	@Autowired
	private TrxDutyMapper dutyDao;
	
	@Autowired
	private SRoleMapper roleDao;
	
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
	
	@RequestMapping(value = "/delSysRole.do", method = RequestMethod.POST)
	public void delSysRole(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result=  Helper.initResponse();
		String ids=request.getParameter("id");
		String module = request.getParameter("sModule");
		
		if(ids==null||"".equals(ids)||module==null || "".equals(module)){
			Helper.errorResonse(result);;
			return;
		}
		
		SRoleKey key = new SRoleKey();
		key.setsModule(module);
		key.setUserId(Integer.valueOf(ids));
		roleDao.deleteByPrimaryKey(key);
		Helper.restful(response, result);
	}	
	
	@RequestMapping(value = "/delDutyMain.do", method = RequestMethod.POST)
	public void delDutyMain(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result=  Helper.initResponse();
		String ids=request.getParameter("id");
		if(ids==null||"".equals(ids)){
			Helper.errorResonse(result);;
			return;
		}
		BaseSys basesys= (BaseSys) request.getSession().getAttribute(BigCont.BASESYS);
		String[] idtemp =ids.substring(0,ids.length()-1).split(",");
		List idList = new ArrayList();
		for(String id:idtemp){
			idList.add(Integer.valueOf(id));
		}
		TrxDutyExample dutyQuery = new TrxDutyExample();
		TrxDutyExample.Criteria criteria =dutyQuery.createCriteria();
		criteria.andIdIn(idList);
		
		List<TrxDuty> resultList = dutyDao.selectByExample(dutyQuery);
		for(TrxDuty domain:resultList){
			int classId = domain.getClassId();
			int contId = domain.getContractId();
			TrxClass clas = casDao.selectByPrimaryKey(classId);
			BigDecimal rate =clas.getClassRate();
			
			Contract cont=contDao.selectByPrimaryKey(contId);
			BigDecimal balance =cont.getContractBalance();
			BigDecimal nBalance = balance.subtract(rate);
			cont.setContractBalance(nBalance);
			cont.setUpdateDate(new Date());
			cont.setUpdateOperator(basesys.getUserId());
			contDao.updateByPrimaryKey(cont);
			dutyDao.deleteByPrimaryKey(domain.getId());
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
		BaseSys basesys= (BaseSys) request.getSession().getAttribute(BigCont.BASESYS);
		TrxClass domain =casDao.selectByPrimaryKey(Integer.valueOf(ids));
		domain.setClassState(3);
		domain.setUpdateDate(new Date());
		domain.setUpdateOperator(basesys.getUserId());
		int num=casDao.updateByPrimaryKey(domain);
		if(num!=1){
			Helper.errorResonse(result);;
			return;
		}
		boolean flag =BatchTM.removeJob(domain.getId());
		if(!flag){
			Helper.errorRestful(response, "删除自动化任务失败，请联系管理员");
		}
		Helper.restful(response, result);
	}	
	
	
}
