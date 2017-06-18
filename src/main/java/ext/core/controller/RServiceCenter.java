package ext.core.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import ext.core.domain.BaseSys;
import ext.core.domain.Datagrid;
import ext.datasource.entity.SDic;
import ext.datasource.entity.SDicExample;
import ext.datasource.entity.SUser;
import ext.datasource.entity.SUserExample;
import ext.datasource.inf.SDicMapper;
import ext.datasource.inf.SUserMapper;
import ext.util.helper.BigCont;
import ext.util.helper.Helper;

@Controller
public class RServiceCenter {
	private final static Logger logger = LogManager.getLogger(RServiceCenter.class.getName());
	
	@Autowired
	private SUserMapper sUser;
	@Autowired
	private SDicMapper sDicDao;
	
	
	@RequestMapping(value = "/rsysuser.do", method = RequestMethod.GET)
	public void getCurrentCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
//		HttpSession session = request.getSession();
		//TODO verify the right
//		BaseSys sys=(BaseSys) session.getAttribute(BigCont.BASESYS);
        String pageSize = request.getParameter("page");
        String pageNum = request.getParameter("rows");
        String pino  =request.getParameter("pino");
        String name2= request.getParameter("userName");
        String date = request.getParameter("createDate");
		Datagrid dg = new Datagrid();
		SUserExample sexp=  new SUserExample();
		sexp.setOrderByClause("ID ASC");
		if(!"".equals(date)){
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
			sexp.createCriteria().andCreateDateEqualTo(sdf.parse(date));
		}
		if(!"".equals(name2)){
			sexp.createCriteria().andUserNameEqualTo(name2);
		}
		
//		long total = sUser.countByExample(sexp);
		PageHelper.startPage( Integer.valueOf(pageSize),Integer.valueOf(pageNum));
		//PageHelper.startPage(1, items)
		Page<SUser> list = (Page<SUser>) sUser.selectByExample(sexp);
		logger.info("the pagesize="+request.getParameter("page"));
		long total = list.getTotal();
		dg.setTotal(total);
		for(SUser user:list)	{
			String name = user.getUserName();
		}
		Map<String,String> dic = getDic("SYS_ROLE");
		for(SUser user:list.getResult()){
			int utype=user.getUserType();
			user.setUserTypeStr(dic.get(utype+""));
		}
		
		
		dg.setRows(list.getResult());
		//Page{count=true, pageNum=1, pageSize=20, startRow=0, endRow=20, total=2, pages=1, countSignal=false, orderBy='null', orderByOnly=false, reasonable=false, pageSizeZero=false}
		
		Helper.restful(response, dg);
	}	
	

	@RequestMapping(value = "/rsysuseredit.do", method = RequestMethod.GET)
	public void getEditSysUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt( request.getParameter("id"));
		SUser user = sUser.selectByPrimaryKey(id);
		Helper.restful(response, user);
	}	
	
	


	
	private Map getDic(String dicType){
		Map<String,String> map= new HashMap<String,String>();
		SDicExample dic = new SDicExample();
		dic.createCriteria().andDicNameEqualTo(dicType);
		List<SDic> dicList=sDicDao.selectByExample(dic);
		for(SDic sub:dicList){
			map.put(sub.getDicValue(), sub.getDicDesc());
		}
		
		return map;
		
	}
}
