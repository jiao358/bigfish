package ext.core.domain;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import ext.util.helper.CustomDateSerializer;

public class SUserFont {
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_USER.ID
	 * @mbg.generated  Thu Jun 15 20:37:45 GMT+08:00 2017
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_USER.USER_NAME
	 * @mbg.generated  Thu Jun 15 20:37:45 GMT+08:00 2017
	 */
	private String userName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_USER.USER_PWD
	 * @mbg.generated  Thu Jun 15 20:37:45 GMT+08:00 2017
	 */
	private String userPwd;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_USER.CREATE_DATE
	 * @mbg.generated  Thu Jun 15 20:37:45 GMT+08:00 2017
	 */
	@JsonSerialize(using = CustomDateSerializer.class)  
	private Date createDate;
	
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_USER.UPDATE_DAATE
	 * @mbg.generated  Thu Jun 15 20:37:45 GMT+08:00 2017
	 */
	@JsonSerialize(using = CustomDateSerializer.class)  
	private Date updateDaate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_USER.OWN_USER
	 * @mbg.generated  Thu Jun 15 20:37:45 GMT+08:00 2017
	 */
	private Integer ownUser;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column S_USER.USER_TYPE
	 * @mbg.generated  Thu Jun 15 20:37:45 GMT+08:00 2017
	 */
	private Integer userType;
	
	private String userTypeStr;
	
	

	public String getUserTypeStr() {
		return userTypeStr;
	}

	public void setUserTypeStr(String userTypeStr) {
		this.userTypeStr = userTypeStr;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_USER.ID
	 * @return  the value of S_USER.ID
	 * @mbg.generated  Thu Jun 15 20:37:45 GMT+08:00 2017
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_USER.ID
	 * @param id  the value for S_USER.ID
	 * @mbg.generated  Thu Jun 15 20:37:45 GMT+08:00 2017
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_USER.USER_NAME
	 * @return  the value of S_USER.USER_NAME
	 * @mbg.generated  Thu Jun 15 20:37:45 GMT+08:00 2017
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_USER.USER_NAME
	 * @param userName  the value for S_USER.USER_NAME
	 * @mbg.generated  Thu Jun 15 20:37:45 GMT+08:00 2017
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_USER.USER_PWD
	 * @return  the value of S_USER.USER_PWD
	 * @mbg.generated  Thu Jun 15 20:37:45 GMT+08:00 2017
	 */
	public String getUserPwd() {
		return userPwd;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_USER.USER_PWD
	 * @param userPwd  the value for S_USER.USER_PWD
	 * @mbg.generated  Thu Jun 15 20:37:45 GMT+08:00 2017
	 */
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_USER.CREATE_DATE
	 * @return  the value of S_USER.CREATE_DATE
	 * @mbg.generated  Thu Jun 15 20:37:45 GMT+08:00 2017
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_USER.CREATE_DATE
	 * @param createDate  the value for S_USER.CREATE_DATE
	 * @mbg.generated  Thu Jun 15 20:37:45 GMT+08:00 2017
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_USER.UPDATE_DAATE
	 * @return  the value of S_USER.UPDATE_DAATE
	 * @mbg.generated  Thu Jun 15 20:37:45 GMT+08:00 2017
	 */
	public Date getUpdateDaate() {
		return updateDaate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_USER.UPDATE_DAATE
	 * @param updateDaate  the value for S_USER.UPDATE_DAATE
	 * @mbg.generated  Thu Jun 15 20:37:45 GMT+08:00 2017
	 */
	public void setUpdateDaate(Date updateDaate) {
		this.updateDaate = updateDaate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_USER.OWN_USER
	 * @return  the value of S_USER.OWN_USER
	 * @mbg.generated  Thu Jun 15 20:37:45 GMT+08:00 2017
	 */
	public Integer getOwnUser() {
		return ownUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_USER.OWN_USER
	 * @param ownUser  the value for S_USER.OWN_USER
	 * @mbg.generated  Thu Jun 15 20:37:45 GMT+08:00 2017
	 */
	public void setOwnUser(Integer ownUser) {
		this.ownUser = ownUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column S_USER.USER_TYPE
	 * @return  the value of S_USER.USER_TYPE
	 * @mbg.generated  Thu Jun 15 20:37:45 GMT+08:00 2017
	 */
	public Integer getUserType() {
		return userType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column S_USER.USER_TYPE
	 * @param userType  the value for S_USER.USER_TYPE
	 * @mbg.generated  Thu Jun 15 20:37:45 GMT+08:00 2017
	 */
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
}