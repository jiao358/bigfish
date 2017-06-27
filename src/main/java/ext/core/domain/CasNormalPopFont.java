package ext.core.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import ext.util.helper.CustomDateSerializer;

public class CasNormalPopFont {
	private Integer contractId;
	private BigDecimal contractAmt;
	private BigDecimal contractBalance;
	private Integer customerId;
	private String customerName;
	private String sex;
	@JsonSerialize(using = CustomDateSerializer.class)  
	private Date createDate;
	private Integer age;
	private String phone;
	public Integer getContractId() {
		return contractId;
	}
	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}
	public BigDecimal getContractAmt() {
		return contractAmt;
	}
	public void setContractAmt(BigDecimal contractAmt) {
		this.contractAmt = contractAmt;
	}
	public BigDecimal getContractBalance() {
		return contractBalance;
	}
	public void setContractBalance(BigDecimal contractBalance) {
		this.contractBalance = contractBalance;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
