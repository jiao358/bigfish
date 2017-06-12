package ext.core.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ext.util.helper.Helper;

@Controller
public class OneEsayUiTest {
	
	private final static Logger logger = LogManager.getLogger(OneEsayUiTest.class.getName());
	@RequestMapping(value = "/current.do", method = RequestMethod.GET)
	public void getCurrentCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		System.out.println(request.getParameterMap());
		Helper.restful(response, request.getParameterMap());
	}	
}
