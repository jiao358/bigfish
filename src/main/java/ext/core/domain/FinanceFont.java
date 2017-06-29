package ext.core.domain;

import java.math.BigDecimal;

public class FinanceFont {
	private String year;
	private String quarter;
	private BigDecimal preAmt;
	private BigDecimal realAmt;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	public BigDecimal getPreAmt() {
		return preAmt;
	}
	public void setPreAmt(BigDecimal preAmt) {
		this.preAmt = preAmt;
	}
	public BigDecimal getRealAmt() {
		return realAmt;
	}
	public void setRealAmt(BigDecimal realAmt) {
		this.realAmt = realAmt;
	}
	
	
	
}
