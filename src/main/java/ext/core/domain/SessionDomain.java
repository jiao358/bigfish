package ext.core.domain;

import javax.servlet.http.HttpSession;

public class SessionDomain {
	private long startTime;
	private String sessionKey;
	private HttpSession session;
	
	public SessionDomain(HttpSession session){
		this.session =session;
		sessionKey = session.getId();
		startTime = System.currentTimeMillis();
	}
	
	public Object getAttribute(String param){
		return session.getAttribute(param);
	}
	
	public void setStartTime(long start){
		startTime = start;
	}
	public void setSession(HttpSession session){
		this.session = session;
		sessionKey  = session.getId();
	}
	
	public long getStartTime(){
		return startTime;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj ==this )
			return true;
		if(obj instanceof SessionDomain){
			SessionDomain sd = (SessionDomain) obj;
			if(sessionKey.equals(sd.getkey())){
				return true;
			}else{
				return false;
			}
		}
		
		return false;
	}
	
	public String getkey(){
		return sessionKey;
	}
	
	
}
