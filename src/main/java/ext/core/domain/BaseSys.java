package ext.core.domain;

import java.util.List;

import ext.datasource.entity.SRole;

public class BaseSys {
	private String userName;
	private List<SRole> roleList;
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<SRole> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<SRole> roleList) {
		this.roleList = roleList;
	}
	
	
	
}
