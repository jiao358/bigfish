package ext.core.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseSys {
	private String userName;
	private Map role;
	private List<FontModule> modules = new ArrayList<FontModule>();
	private int userId;
	private int userType;
	
	
	
	
	
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public List<FontModule> getModules() {
		return modules;
	}
	public void setModules(List<FontModule> modules) {
		this.modules = modules;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Map getRole() {
		return role;
	}
	public void setRole(Map role) {
		this.role = role;
	}

	
	
	
	
}
