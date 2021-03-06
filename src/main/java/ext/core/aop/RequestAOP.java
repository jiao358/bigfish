package ext.core.aop;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import ext.core.domain.BaseSys;
import ext.datasource.entity.RequestInfo;
import ext.datasource.inf.RequestInfoMapper;
import ext.util.helper.BigCont;

public class RequestAOP {
	private static final Logger logger = Logger.getLogger(RequestAOP.class);
	@Autowired
	private RequestInfoMapper requestDao;
	
	
	public void filterRequest(ProceedingJoinPoint  jp) throws ServletException, IOException{
		HttpServletRequest request=(HttpServletRequest) jp.getArgs()[0];
		HttpServletResponse response = (HttpServletResponse) jp.getArgs()[1];
		String id=UUID.randomUUID().toString(); 
		RequestInfo requestInfo = generateInfo(request);
		try{
			requestInfo.setId(id);
			requestDao.insert(requestInfo);
		}catch (Exception e) {
			logger.error("Insert RequestInfo error",e);
		}
		try{
			jp.proceed();
		
		}catch (Throwable e) {
			logger.error("RequestInfoException arise " + request.getQueryString() ,e);
			request.getRequestDispatcher("/static/500.html").forward(request, response);
		}finally{
			requestInfo.setResponseDate(new Date());
			requestDao.updateByPrimaryKey(requestInfo);
		}
		
	}
	
	private RequestInfo generateInfo(HttpServletRequest request){
		RequestInfo requestInfo = new RequestInfo();
		Date begin = new Date();
		requestInfo.setCreateDate(begin);
		requestInfo.setContentLength(request.getContentLength());
	//	requestInfo.setContentType(request.getContentType());
		BaseSys sys=(BaseSys) 	request.getSession().getAttribute(BigCont.BASESYS);
		requestInfo.setIsWork(true);
		requestInfo.setLocalAddr(request.getLocalAddr());
		requestInfo.setProtocol(request.getProtocol());
		requestInfo.setQuery(request.getQueryString());
		requestInfo.setRequestMethod(request.getMethod());
		requestInfo.setRequestPath(request.getServletPath());
		requestInfo.setRequestServer(request.getServerName());
		requestInfo.setUserId(sys.getUserId());
		
		 String ip = request.getHeader("x-forwarded-for");   
		  if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip) || "null".equalsIgnoreCase(ip))    {     
		    ip = request.getHeader("Proxy-Client-IP");  
		 }  
		 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)   || "null".equalsIgnoreCase(ip)) {    
		  ip = request.getHeader("WL-Proxy-Client-IP");  
		 }  
		 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)    || "null".equalsIgnoreCase(ip)) {  
		  ip = request.getRemoteAddr();   
		 }  
		requestInfo.setIp(ip);
		return requestInfo;
	}
}
