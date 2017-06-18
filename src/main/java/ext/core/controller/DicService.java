package ext.core.controller;

import java.util.List;

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
import ext.datasource.entity.SDic;
import ext.datasource.entity.SDicExample;
import ext.datasource.entity.SUser;
import ext.datasource.inf.SDicMapper;
import ext.util.helper.Helper;

@Controller
public class DicService {
	private final static Logger logger = LogManager.getLogger(DicService.class.getName());
	
	@Autowired
	private SDicMapper sDicDao;
	
	
	@RequestMapping(value = "/rdic.do", method = RequestMethod.GET)
	public void getCurrentCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String dicName=request.getParameter("dicName");
		String xx = (String) request.getAttribute("dicName");
		if(dicName==null||"".equals(dicName)){
			Helper.restful(response, "");
			return;
		}
		
		SDicExample sexp=  new SDicExample();
		sexp.createCriteria().andDicNameEqualTo(dicName);
		List<SDic> list =sDicDao.selectByExample(sexp);
		Helper.restful(response, list);
	}	
}
