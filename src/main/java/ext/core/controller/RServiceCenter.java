package ext.core.controller;

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

import ext.core.domain.Datagrid;
import ext.datasource.entity.SUser;
import ext.datasource.entity.SUserExample;
import ext.datasource.inf.SUserMapper;
import ext.util.helper.Helper;

@Controller
public class RServiceCenter {
	private final static Logger logger = LogManager.getLogger(RServiceCenter.class.getName());
	
	@Autowired
	private SUserMapper sUser;
	
	
	@RequestMapping(value = "/rsysuser.do", method = RequestMethod.GET)
	public void getCurrentCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
//		HttpSession session = request.getSession();
		//TODO verify the right
//		BaseSys sys=(BaseSys) session.getAttribute(BigCont.BASESYS);
		Datagrid dg = new Datagrid();
		SUserExample sexp=  new SUserExample();
		sexp.setOrderByClause("CREATE_DATE DESC");
		int items = "".equals(request.getParameter("items"))?20:Integer.parseInt(request.getParameter("items"));
		long total = sUser.countByExample(sexp);
		dg.setTotoal(total);
		
		
		PageHelper.startPage(1, items);
		
		
		Page<SUser> list = (Page<SUser>) sUser.selectByExample(sexp);
		long totoal = list.getTotal();
		for(SUser user:list)	{
			String name = user.getUserName();
		}
		dg.setRows(list.getResult());
		//Page{count=true, pageNum=1, pageSize=20, startRow=0, endRow=20, total=2, pages=1, countSignal=false, orderBy='null', orderByOnly=false, reasonable=false, pageSizeZero=false}
		logger.info(list);;
		
		Helper.restful(response, dg);
	}	
}
