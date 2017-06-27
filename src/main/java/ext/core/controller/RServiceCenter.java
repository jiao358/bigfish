package ext.core.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import ext.core.domain.Datagrid;
import ext.core.domain.TrxClassFont;
import ext.datasource.entity.Contract;
import ext.datasource.entity.ContractExample;
import ext.datasource.entity.Customer;
import ext.datasource.entity.CustomerExample;
import ext.datasource.entity.SDic;
import ext.datasource.entity.SDicExample;
import ext.datasource.entity.SUser;
import ext.datasource.entity.SUserExample;
import ext.datasource.entity.TrxClass;
import ext.datasource.entity.TrxClassExample;
import ext.datasource.inf.ContractMapper;
import ext.datasource.inf.CustomerMapper;
import ext.datasource.inf.SDicMapper;
import ext.datasource.inf.SUserMapper;
import ext.datasource.inf.TrxClassMapper;
import ext.util.helper.Helper;

@Controller
public class RServiceCenter {
	private final static Logger logger = LogManager.getLogger(RServiceCenter.class.getName());

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

	@RequestMapping(value = "/rsysuser.do", method = RequestMethod.GET)
	public void getCurrentCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// HttpSession session = request.getSession();
		// TODO verify the right
		// BaseSys sys=(BaseSys) session.getAttribute(BigCont.BASESYS);
		String pageSize = request.getParameter("page");
		String pageNum = request.getParameter("rows");
		String pino = request.getParameter("pino");
		String name2 = request.getParameter("userName");
		String date = request.getParameter("createDate");
		String teacherPop = request.getParameter("teacherPop");
		Datagrid dg = new Datagrid();
		SUserExample sexp = new SUserExample();
		sexp.setOrderByClause("ID ASC");
		if (!"".equals(date)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sexp.createCriteria().andCreateDateEqualTo(sdf.parse(date));
		}
		if (!"".equals(name2)) {
			sexp.createCriteria().andUserNameEqualTo(name2);
		}
		if ("1".equals(teacherPop)) {
			sexp.createCriteria().andUserTypeEqualTo(Integer.valueOf(teacherPop));
		}

		// long total = sUser.countByExample(sexp);
		PageHelper.startPage(Integer.valueOf(pageSize), Integer.valueOf(pageNum));
		// PageHelper.startPage(1, items)
		Page<SUser> list = (Page<SUser>) sUser.selectByExample(sexp);
		logger.info("the pagesize=" + request.getParameter("page"));
		long total = list.getTotal();
		dg.setTotal(total);
		for (SUser user : list) {
			String name = user.getUserName();
		}
		Map<String, String> dic = getDic("SYS_ROLE");
		for (SUser user : list.getResult()) {
			int utype = user.getUserType();
			user.setUserTypeStr(dic.get(utype + ""));
		}

		dg.setRows(list.getResult());
		// Page{count=true, pageNum=1, pageSize=20, startRow=0, endRow=20,
		// total=2, pages=1, countSignal=false, orderBy='null',
		// orderByOnly=false, reasonable=false, pageSizeZero=false}

		Helper.restful(response, dg);
	}

	@RequestMapping(value = "/rsysuseredit.do", method = RequestMethod.GET)
	public void getEditSysUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		SUser user = sUser.selectByPrimaryKey(id);
		Helper.restful(response, user);
	}

	@RequestMapping(value = "/rcusmainedit.do", method = RequestMethod.GET)
	public void getEditCusMain(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		Customer cust = customerDao.selectByPrimaryKey(id);
		Helper.restful(response, cust);
	}

	@RequestMapping(value = "/rCasMainEdit.do", method = RequestMethod.GET)
	public void getEditCasMain(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		TrxClass cas = casDao.selectByPrimaryKey(id);
		TrxClassFont tf = new TrxClassFont();
		BeanUtils.copyProperties(cas, tf);
		Integer teacherId = cas.getTeacherId();
		Integer assTeacherId = cas.getAssTeacherId();
		if (teacherId != null)
			tf.setTeacherName(sUser.selectByPrimaryKey(teacherId).getUserName());
		if (assTeacherId != null)
			tf.setAssTeacherName(sUser.selectByPrimaryKey(assTeacherId).getUserName());

		Helper.restful(response, tf);
	}

	@RequestMapping(value = "/rcusmain.do", method = RequestMethod.GET)
	public void getCusMain(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String pageSize = request.getParameter("page");
		String pageNum = request.getParameter("rows");
		String customId = request.getParameter("id");
		String customName = request.getParameter("userName");
		String date = request.getParameter("createDate");
		Datagrid dg = new Datagrid();
		CustomerExample custQuery = new CustomerExample();
		custQuery.setOrderByClause("ID ASC");

		if (!"".equals(date)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			custQuery.createCriteria().andCreateDateEqualTo(sdf.parse(date));
		}
		if (!"".equals(customName.trim())) {
			custQuery.createCriteria().andNameEqualTo(customName);
		}
		if (customId != null && !"".equals(customId.trim())) {
			custQuery.createCriteria().andIdEqualTo(Integer.valueOf(customId));
		}
		PageHelper.startPage(Integer.valueOf(pageSize), Integer.valueOf(pageNum));
		Page<Customer> list = (Page<Customer>) customerDao.selectByExample(custQuery);

		logger.info("the pagesize=" + request.getParameter("page"));
		long total = list.getTotal();
		dg.setTotal(total);

		Map<String, String> dic = getDic("SEX_CUSTOMER");

		for (Customer user : list.getResult()) {
			int utype = user.getSex();
			user.setSexStr(dic.get(utype+"").toString());
		}

		dg.setRows(list.getResult());

		Helper.restful(response, dg);
	}

	@RequestMapping(value = "/rCasNormalCasPop.do", method = RequestMethod.GET)
	public void getCasNormalCasPop(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String pageSize = request.getParameter("page");
		String pageNum = request.getParameter("rows");
		String customId = request.getParameter("id");
		String customName = request.getParameter("userName");
		String date = request.getParameter("createDate");
		Datagrid dg = new Datagrid();
		
		ContractExample contQuery = new ContractExample();
		contQuery.createCriteria().andContractStateEqualTo(1);
		
		Map require = new HashMap();
		
		if (!"".equals(customName.trim())) {
			require.put("userName", customName);
		}
		if (customId != null && !"".equals(customId.trim())) {
			require.put("id", customId);
		}
	
		
		PageHelper.startPage(Integer.valueOf(pageSize), Integer.valueOf(pageNum));
		
		
		List<Map> list = (List<Map>) customerDao.selectCasNormalCasPop(require);

		
		
		
		
		logger.info("the pagesize=" + request.getParameter("page"));
		/*long total = list.getTotal();
		dg.setTotal(total);


		Map<String, String> dic = getDic("SEX_CUSTOMER");

		for (Customer user : list.getResult()) {
			int utype = user.getSex();
			user.setSexStr(dic.get(utype+"").toString());
		}
		
		
		dg.setRows(list.getResult());
*/
		Helper.restful(response, dg);
	}

	@RequestMapping(value = "/rCasMain.do", method = RequestMethod.GET)
	public void getCasMain(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String pageSize = request.getParameter("page");
		String pageNum = request.getParameter("rows");
		String casId = request.getParameter("casId");
		String casName = request.getParameter("casName");
		String casState = request.getParameter("casState");
		Datagrid dg = new Datagrid();
		TrxClassExample casQuery = new TrxClassExample();
		casQuery.setOrderByClause("ID ASC");

		if (!"".equals(casId)) {
			casQuery.createCriteria().andIdEqualTo(Integer.valueOf(casId));
		}
		if (!"".equals(casName.trim())) {
			casQuery.createCriteria().andClassNameEqualTo(casName);
		}
		if (casState != null && !"".equals(casState.trim())) {
			casQuery.createCriteria().andClassStateEqualTo(Integer.valueOf(casState));
		}

		PageHelper.startPage(Integer.valueOf(pageSize), Integer.valueOf(pageNum));
		Page<TrxClass> list = (Page<TrxClass>) casDao.selectByExample(casQuery);

		long total = list.getTotal();
		dg.setTotal(total);

		Map<String, String> year = getDic("ACADMEIC_YEAR");
		Map<String, String> quarter = getDic("ACADMEIC_QUARTER");
		Map<String, String> stateDic = getDic("CLASS_STATE");
		List result = new ArrayList();
		for (TrxClass obj : list) {
			TrxClassFont tf = new TrxClassFont();
			BeanUtils.copyProperties(obj, tf);
			int teacherId = obj.getTeacherId();
			Integer assTeacher = obj.getAssTeacherId();
			tf.setTeacherName(sUser.selectByPrimaryKey(teacherId).getUserName());
			if (assTeacher != null)
				tf.setAssTeacherName(sUser.selectByPrimaryKey(assTeacher).getUserName());
			tf.setAcademicYearStr(year.get(tf.getAcademicYear().intValue() + ""));
			tf.setAcademicQuarterStr(quarter.get(tf.getAcademicQuarter().intValue() + ""));
			tf.setClassStateStr(stateDic.get(tf.getClassState() + ""));
			int current = tf.getCurrentMember();
			int totalMember = tf.getClassMember();
			if (totalMember > current) {
				tf.setIsFull("未满员");
			} else {
				tf.setIsFull("满员");
			}
			result.add(tf);
		}

		/*
		 * for(SUser user:list.getResult()){ int utype=user.getUserType();
		 * user.setUserTypeStr(dic.get(utype+"")); }
		 */
		dg.setRows(result);

		Helper.restful(response, dg);
	}
	
	
	@RequestMapping(value = "/rCasNormalEdit.do", method = RequestMethod.GET)
	public void getCasNormalEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String pageSize = request.getParameter("page");
		String pageNum = request.getParameter("rows");
		
		String casId = request.getParameter("casId");
		String casName = request.getParameter("casName");
		String casState = request.getParameter("casState");
		
		
		Datagrid dg = new Datagrid();
		TrxClassExample casQuery = new TrxClassExample();
		casQuery.setOrderByClause("ID ASC");

		if (!"".equals(casId)) {
			casQuery.createCriteria().andIdEqualTo(Integer.valueOf(casId));
		}
		if (!"".equals(casName.trim())) {
			casQuery.createCriteria().andClassNameEqualTo(casName);
		}
		if (casState != null && !"".equals(casState.trim())) {
			casQuery.createCriteria().andClassStateEqualTo(Integer.valueOf(casState));
		}

		PageHelper.startPage(Integer.valueOf(pageSize), Integer.valueOf(pageNum));
		Page<TrxClass> list = (Page<TrxClass>) casDao.selectByExample(casQuery);

		long total = list.getTotal();
		dg.setTotal(total);

		Map<String, String> year = getDic("ACADMEIC_YEAR");
		Map<String, String> quarter = getDic("ACADMEIC_QUARTER");
		Map<String, String> stateDic = getDic("CLASS_STATE");
		List result = new ArrayList();
		for (TrxClass obj : list) {
			TrxClassFont tf = new TrxClassFont();
			BeanUtils.copyProperties(obj, tf);
			int teacherId = obj.getTeacherId();
			Integer assTeacher = obj.getAssTeacherId();
			tf.setTeacherName(sUser.selectByPrimaryKey(teacherId).getUserName());
			if (assTeacher != null)
				tf.setAssTeacherName(sUser.selectByPrimaryKey(assTeacher).getUserName());
			tf.setAcademicYearStr(year.get(tf.getAcademicYear().intValue() + ""));
			tf.setAcademicQuarterStr(quarter.get(tf.getAcademicQuarter().intValue() + ""));
			tf.setClassStateStr(stateDic.get(tf.getClassState() + ""));
			int current = tf.getCurrentMember();
			int totalMember = tf.getClassMember();
			if (totalMember > current) {
				tf.setIsFull("未满员");
			} else {
				tf.setIsFull("满员");
			}
			result.add(tf);
		}

		/*
		 * for(SUser user:list.getResult()){ int utype=user.getUserType();
		 * user.setUserTypeStr(dic.get(utype+"")); }
		 */
		dg.setRows(result);

		Helper.restful(response, dg);
	}

	@RequestMapping(value = "/rContMain.do", method = RequestMethod.GET)
	public void getContMain(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String pageSize = request.getParameter("page");
		String pageNum = request.getParameter("rows");
		String executeDate = request.getParameter("createDate");
		String customerName = request.getParameter("userName");
		String contId = request.getParameter("id");
		Datagrid dg = new Datagrid();
		ContractExample contQuery = new ContractExample();
		contQuery.setOrderByClause("ID ASC");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		if (!"".equals(contId)) {
			contQuery.createCriteria().andIdEqualTo(Integer.valueOf(contId));
		}
		if (!"".equals(customerName.trim())) {
			contQuery.createCriteria().andCustomerNameEqualTo(customerName);
		}
		if (executeDate != null && !"".equals(executeDate.trim())) {
			contQuery.createCriteria().andExecuteDateEqualTo(sdf.parse(executeDate));
		}
		Map<String, String> stateMap = getDic("CONTRACT_STATE");

		PageHelper.startPage(Integer.valueOf(pageSize), Integer.valueOf(pageNum));
		Page<Contract> list = (Page<Contract>) contDao.selectByExample(contQuery);

		long total = list.getTotal();
		dg.setTotal(total);

		for (Contract obj : list) {
			obj.setContractStateStr(stateMap.get(obj.getContractState() + ""));
		}
		/*
		 * for(SUser user:list.getResult()){ int utype=user.getUserType();
		 * user.setUserTypeStr(dic.get(utype+"")); }
		 */
		dg.setRows(list.getResult());

		Helper.restful(response, dg);
	}

	private Map getDic(String dicType) {
		Map<String, String> map = new HashMap<String, String>();
		SDicExample dic = new SDicExample();
		dic.createCriteria().andDicNameEqualTo(dicType);
		List<SDic> dicList = sDicDao.selectByExample(dic);
		for (SDic sub : dicList) {
			map.put(sub.getDicValue(), sub.getDicDesc());
		}

		return map;

	}

	/**
	 * false ASC true DESC
	 * 
	 * @param dicType
	 * @param flag
	 * @return
	 */
	private Map getDic(String dicType, boolean flag) {
		Map<String, String> map = new HashMap<String, String>();
		SDicExample dic = new SDicExample();
		if (flag) {
			dic.setOrderByClause("DIC_ORDER DESC");
		} else {
			dic.setOrderByClause("DIC_ORDER ASC");
		}
		dic.createCriteria().andDicNameEqualTo(dicType);
		List<SDic> dicList = sDicDao.selectByExample(dic);
		for (SDic sub : dicList) {
			map.put(sub.getDicValue(), sub.getDicDesc());
		}

		return map;

	}
}
