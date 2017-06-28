package ext.core.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ext.core.batch.BatchTM;
import ext.core.batch.StartClassMessage;
import ext.core.domain.BaseSys;
import ext.datasource.entity.ClassRel;
import ext.datasource.entity.ClassRelExample;
import ext.datasource.entity.Contract;
import ext.datasource.entity.Customer;
import ext.datasource.entity.SUser;
import ext.datasource.entity.SUserExample;
import ext.datasource.entity.TrxClass;
import ext.datasource.entity.TrxClassExample;
import ext.datasource.inf.ClassRelMapper;
import ext.datasource.inf.ContractMapper;
import ext.datasource.inf.CustomerMapper;
import ext.datasource.inf.SDicMapper;
import ext.datasource.inf.SUserMapper;
import ext.datasource.inf.TrxClassMapper;
import ext.util.helper.BigCont;
import ext.util.helper.Helper;

@Controller
public class CServiceCenter {

	private final static Logger logger = LogManager.getLogger(CServiceCenter.class.getName());
	@Autowired
	private SUserMapper sUser;
	@Autowired
	private SDicMapper sDicDao;
	@Autowired
	private CustomerMapper customerDao;
	@Autowired
	private TrxClassMapper casDao;

	@Autowired
	private ContractMapper contDao;

	@Autowired
	private ClassRelMapper classRelDao;

	@RequestMapping(value = "/addsys.do", method = RequestMethod.POST)
	public void addSys(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result = Helper.initResponse();
		BaseSys basesys = (BaseSys) request.getSession().getAttribute(BigCont.BASESYS);
		try {
			String father = basesys.getUserName();
			String userName = request.getParameter("userName");
			String passwd = request.getParameter("userPwd");
			String type = request.getParameter("userType");
			logger.info("the userName:" + userName);
			SUserExample sexp = new SUserExample();

			sexp.createCriteria().andUserNameEqualTo(father);
			List<SUser> userList = sUser.selectByExample(sexp);
			int promotId = userList.get(0).getId();
			SUser user = new SUser();
			user.setOwnUser(promotId);
			user.setUserName(userName);
			user.setUserPwd(passwd);
			;
			user.setCreateDate(new Date());
			user.setUserType(Integer.parseInt(type));

			int xc = sUser.insert(user);
			logger.info(1);
			;
		} catch (Exception e) {
			logger.error("Insert User error->" + e);
			Helper.errorResonse(result);
		}
		Helper.restful(response, result);
	}

	@RequestMapping(value = "/addCusMain.do", method = RequestMethod.POST)
	public void addCusMain(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result = Helper.initResponse();
		BaseSys basesys = (BaseSys) request.getSession().getAttribute(BigCont.BASESYS);
		try {
			String operatorName = basesys.getUserName();
			int operatorId = basesys.getUserId();
			Customer customer = new Customer();
			BeanUtils.copyProperties(customer, request.getParameterMap());

			customer.setCreateDate(new Date());
			;
			customer.setCreateOperator(operatorId);
			customer.setId(null);
			int xc = customerDao.insert(customer);
			if (xc != 1) {
				result.put("state", "0");
				result.put("message", "添加失败，请检查班级信息填写");
			}
		} catch (Exception e) {
			logger.error("Insert User error->" + e);
			Helper.errorResonse(result);
		}
		Helper.restful(response, result);
	}

	@RequestMapping(value = "/addCasNormal.do", method = RequestMethod.POST)
	@Transactional
	public void addCasNormal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result = Helper.initResponse();
		BaseSys basesys = (BaseSys) request.getSession().getAttribute(BigCont.BASESYS);
		try {
			String operatorName = basesys.getUserName();
			int operatorId = basesys.getUserId();
			int userId = Integer.parseInt(request.getParameter("id"));
			int classId = Integer.parseInt(request.getParameter("cid"));
			int contractId = Integer.parseInt(request.getParameter("contractId"));
			ClassRelExample classRelQuery = new ClassRelExample();
			classRelQuery.createCriteria().andClassIdEqualTo(classId).andCustomerIdEqualTo(userId);
			if (classRelDao.selectByExample(classRelQuery).size() > 0) {
				Helper.errorRestful(response, "该学生已经报名!");
				return;
			}

			TrxClass trxClass = casDao.selectByPrimaryKey(classId);
			int currentNum = trxClass.getCurrentMember();
			int totalNum = trxClass.getClassMember();
			if (currentNum == totalNum) {
				Helper.errorRestful(response, "添加失败，班级满员!");
				return;
			}

			ClassRel classRel = new ClassRel();
			classRel.setClassId(classId);
			;
			classRel.setCustomerId(userId);
			classRel.setCreateOperator(operatorId);
			classRel.setCreateDate(new Date());
			classRel.setContractId(contractId);
			classRelDao.insert(classRel);

			trxClass.setCurrentMember(currentNum + 1);
			if (casDao.updateByPrimaryKey(trxClass) != 1) {
				result.put("state", "0");
				result.put("message", "添加失败，请检查信息填写");
				Helper.restful(response, result);
				return;
			}

		} catch (Exception e) {
			logger.error("Insert User error->" + e);
			Helper.errorResonse(result);
		}
		Helper.restful(response, result);
	}

	@RequestMapping(value = "/addContMain.do", method = RequestMethod.POST)
	public void addContMain(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result = Helper.initResponse();
		BaseSys basesys = (BaseSys) request.getSession().getAttribute(BigCont.BASESYS);
		try {
			String operatorName = basesys.getUserName();
			int operatorId = basesys.getUserId();
			Contract contract = new Contract();
			BeanUtils.copyProperties(contract, request.getParameterMap());

			contract.setCreateDate(new Date());
			;
			contract.setCreateOperator(operatorId);
			contract.setId(null);
			contract.setContractBalance(new BigDecimal(0));
			contract.setContractState(0);
			int xc = contDao.insert(contract);
			if (xc != 1) {
				result.put("state", "0");
				result.put("message", "添加失败，请检查班级信息填写");
			}
		} catch (Exception e) {
			logger.error("Insert contract error->" + e);
			Helper.errorResonse(result);
		}
		Helper.restful(response, result);
	}

	public static void main(String[] args) {
		int a =-22;
		int b= 9;
		System.out.println(a>=1);
	}
	
	@RequestMapping(value = "/addCasMain.do", method = RequestMethod.POST)
	public void addCasMain(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result = Helper.initResponse();
		BaseSys basesys = (BaseSys) request.getSession().getAttribute(BigCont.BASESYS);
		try {
			int operatorId = basesys.getUserId();
			boolean noEmpty = true;
			TrxClass casMain = new TrxClass();
			String acadmeicYear = request.getParameter("academicYear");
			String className = request.getParameter("className");
			String acadmeicQuarter = request.getParameter("academicQuarter");
			String startTime = request.getParameter("startTime");
			String teacherName = request.getParameter("teacherName");
			String teacherId = request.getParameter("teacherId");
			String assTeacherName = request.getParameter("assTeacherName");
			String assTeacherId = request.getParameter("assTeacherId");
			String school = request.getParameter("school");
			String schoolArea = request.getParameter("schoolArea");
			String classMember = request.getParameter("classMember");
			String classRate = request.getParameter("classRate");
			String startHour = request.getParameter("startHour");
			String startMin = request.getParameter("startMin");
			// String schedual = request.getParameter("startSchedule");
			String schedual = request.getParameter("startScheduleBox");

			emptyCheck(noEmpty, acadmeicYear, className, acadmeicQuarter, startTime, teacherId, school, classMember,
					classRate, startHour, startMin, schedual);
			SimpleDateFormat checksdf = new SimpleDateFormat("yyyyMMdd");
			int todayCheck = Integer.valueOf(checksdf.format(new Date()));
			int startDayCheck =  Integer.parseInt(startTime.replaceAll("-", ""));
			int temp=startDayCheck-todayCheck ;
			if ( (startDayCheck-todayCheck ) <1) {
				Helper.errorRestful(response, "开课时间最少大于当前一天");
				return;
			}

			if (!noEmpty) {
				result.put("state", "0");
				result.put("message", "添加失败，请检查填写内容是否正确");
				Helper.restful(response, result);
				return;
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			casMain.setCreateDate(new Date());
			;
			casMain.setCreateOperator(operatorId);
			casMain.setId(null);
			casMain.setAcademicYear(Integer.valueOf(acadmeicYear));
			casMain.setClassName(className);
			casMain.setAcademicQuarter(Integer.valueOf(acadmeicQuarter));
			casMain.setStartTime(sdf.parse(startTime));
			casMain.setTeacherId(Integer.valueOf(teacherId));
			if (assTeacherId != null && !"".equals(assTeacherId))
				casMain.setAssTeacherId(Integer.valueOf(assTeacherId));
			casMain.setSchool(Integer.valueOf(school));
			casMain.setSchoolArea(Integer.valueOf(schoolArea));
			casMain.setClassMember(Integer.valueOf(classMember));
			casMain.setClassRate(new BigDecimal(classRate));
			casMain.setStartHour(Integer.valueOf(startHour));
			casMain.setStartMin(Integer.valueOf(startMin));
			casMain.setStartSchedule(schedual.substring(0, schedual.length() - 1));
			casMain.setCurrentMember(0);
			casMain.setClassState(0);
			casMain.setCurrentSchool(0);

			int xc = casDao.insert(casMain);
			if (xc != 1) {
				result.put("state", "0");
				result.put("message", "添加失败，请检查班级信息填写");
			}
			
			TrxClassExample casQuery = new TrxClassExample();
			casQuery.createCriteria().andClassNameEqualTo(className).andAcademicYearEqualTo(Integer.valueOf(acadmeicYear)).andAcademicQuarterEqualTo(Integer.valueOf(acadmeicQuarter));
			casMain  =casDao.selectByExample(casQuery).get(0);
			
			SimpleDateFormat messagesdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date now = new Date();
			StartClassMessage scm = new StartClassMessage();
			Date startDate = casMain.getStartTime();
			int hour = casMain.getStartHour();
			int min = casMain.getStartMin();
			String schedule = casMain.getStartSchedule();
			String classStartDate = messagesdf.format(startDate);

			scm.setDayWeek(schedule);
			scm.setIdentify(casMain.getId());
			scm.setHour(hour);
			scm.setMin(min);
			scm.setMonth(classStartDate.substring(5, 7));
			scm.setYear(classStartDate.substring(0, 4));
			scm.setDay(classStartDate.substring(8, 10));
			
			BatchTM.getQueue().put(scm);
			

		} catch (Exception e) {
			logger.error("Insert User error->" + e);
			Helper.errorResonse(result);
		}
		Helper.restful(response, result);
	}

	private void emptyCheck(boolean flag, String... obj) {
		for (String str : obj) {
			if (str == null || "".equals(str)) {
				flag = flag && false;
			}
		}

	}

}
