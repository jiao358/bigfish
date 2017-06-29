package ext.core.controller;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import ext.core.domain.BaseSys;
import ext.core.domain.SessionDomain;
import ext.util.helper.BigCont;

@Controller
public class SessionControl {
	private final static Logger logger = LogManager.getLogger(SessionControl.class.getName());
	private static final Map<String,SessionDomain> map = new ConcurrentHashMap<String,SessionDomain>();
	static{
		new Thread(){
			public void run(){
				while(true){
					try {
					Iterator<Entry<String, SessionDomain>> entries = map.entrySet().iterator();  
					
					while (entries.hasNext()) {  
						  
					    Map.Entry<String, SessionDomain> entry = entries.next();  
					    long start=entry.getValue().getStartTime();
					    long end = System.currentTimeMillis();
					    if((end-start)/1000 > 15*60){
					    	//timeout
					    	entries.remove();
					    }
					}
					
						sleep(15*1000);
					} catch (InterruptedException e) {
						logger.error("Timeout Controll error at:"+System.currentTimeMillis());
					}
					
				}
			}
		};
		
		
	}
	public void sessionCheck(HttpServletRequest request ){
		HttpSession session =request.getSession();
		String sk = session.getId();
		if(map.containsKey(sk)){
			SessionDomain sd = map.get(sk);
			sd.setStartTime(System.currentTimeMillis());
		}else{
			map.put(session.getId(),new SessionDomain(session) );
		}
	}
	
	public boolean isLogin(String sessionKey){
		return map.containsKey(sessionKey);
		
	}
	
	public BaseSys coreBaseSys(String key){
		SessionDomain sd= map.get(key);
		BaseSys base=(BaseSys) sd.getAttribute(BigCont.BASESYS);
		return base;
	}
	

	
	
	
	
}
