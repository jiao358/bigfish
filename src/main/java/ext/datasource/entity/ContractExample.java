package ext.datasource.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ContractExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	public ContractExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
		}

		public Criteria andIdIsNull() {
			addCriterion("ID is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("ID is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("ID =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("ID <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("ID >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ID >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("ID <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("ID <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("ID in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("ID not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("ID between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ID not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andCustomerIdIsNull() {
			addCriterion("CUSTOMER_ID is null");
			return (Criteria) this;
		}

		public Criteria andCustomerIdIsNotNull() {
			addCriterion("CUSTOMER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCustomerIdEqualTo(Integer value) {
			addCriterion("CUSTOMER_ID =", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdNotEqualTo(Integer value) {
			addCriterion("CUSTOMER_ID <>", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdGreaterThan(Integer value) {
			addCriterion("CUSTOMER_ID >", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CUSTOMER_ID >=", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdLessThan(Integer value) {
			addCriterion("CUSTOMER_ID <", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdLessThanOrEqualTo(Integer value) {
			addCriterion("CUSTOMER_ID <=", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdIn(List<Integer> values) {
			addCriterion("CUSTOMER_ID in", values, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdNotIn(List<Integer> values) {
			addCriterion("CUSTOMER_ID not in", values, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdBetween(Integer value1, Integer value2) {
			addCriterion("CUSTOMER_ID between", value1, value2, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CUSTOMER_ID not between", value1, value2, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerNameIsNull() {
			addCriterion("CUSTOMER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andCustomerNameIsNotNull() {
			addCriterion("CUSTOMER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andCustomerNameEqualTo(String value) {
			addCriterion("CUSTOMER_NAME =", value, "customerName");
			return (Criteria) this;
		}

		public Criteria andCustomerNameNotEqualTo(String value) {
			addCriterion("CUSTOMER_NAME <>", value, "customerName");
			return (Criteria) this;
		}

		public Criteria andCustomerNameGreaterThan(String value) {
			addCriterion("CUSTOMER_NAME >", value, "customerName");
			return (Criteria) this;
		}

		public Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
			addCriterion("CUSTOMER_NAME >=", value, "customerName");
			return (Criteria) this;
		}

		public Criteria andCustomerNameLessThan(String value) {
			addCriterion("CUSTOMER_NAME <", value, "customerName");
			return (Criteria) this;
		}

		public Criteria andCustomerNameLessThanOrEqualTo(String value) {
			addCriterion("CUSTOMER_NAME <=", value, "customerName");
			return (Criteria) this;
		}

		public Criteria andCustomerNameLike(String value) {
			addCriterion("CUSTOMER_NAME like", value, "customerName");
			return (Criteria) this;
		}

		public Criteria andCustomerNameNotLike(String value) {
			addCriterion("CUSTOMER_NAME not like", value, "customerName");
			return (Criteria) this;
		}

		public Criteria andCustomerNameIn(List<String> values) {
			addCriterion("CUSTOMER_NAME in", values, "customerName");
			return (Criteria) this;
		}

		public Criteria andCustomerNameNotIn(List<String> values) {
			addCriterion("CUSTOMER_NAME not in", values, "customerName");
			return (Criteria) this;
		}

		public Criteria andCustomerNameBetween(String value1, String value2) {
			addCriterion("CUSTOMER_NAME between", value1, value2, "customerName");
			return (Criteria) this;
		}

		public Criteria andCustomerNameNotBetween(String value1, String value2) {
			addCriterion("CUSTOMER_NAME not between", value1, value2, "customerName");
			return (Criteria) this;
		}

		public Criteria andExecuteDateIsNull() {
			addCriterion("EXECUTE_DATE is null");
			return (Criteria) this;
		}

		public Criteria andExecuteDateIsNotNull() {
			addCriterion("EXECUTE_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andExecuteDateEqualTo(Date value) {
			addCriterionForJDBCDate("EXECUTE_DATE =", value, "executeDate");
			return (Criteria) this;
		}

		public Criteria andExecuteDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("EXECUTE_DATE <>", value, "executeDate");
			return (Criteria) this;
		}

		public Criteria andExecuteDateGreaterThan(Date value) {
			addCriterionForJDBCDate("EXECUTE_DATE >", value, "executeDate");
			return (Criteria) this;
		}

		public Criteria andExecuteDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("EXECUTE_DATE >=", value, "executeDate");
			return (Criteria) this;
		}

		public Criteria andExecuteDateLessThan(Date value) {
			addCriterionForJDBCDate("EXECUTE_DATE <", value, "executeDate");
			return (Criteria) this;
		}

		public Criteria andExecuteDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("EXECUTE_DATE <=", value, "executeDate");
			return (Criteria) this;
		}

		public Criteria andExecuteDateIn(List<Date> values) {
			addCriterionForJDBCDate("EXECUTE_DATE in", values, "executeDate");
			return (Criteria) this;
		}

		public Criteria andExecuteDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("EXECUTE_DATE not in", values, "executeDate");
			return (Criteria) this;
		}

		public Criteria andExecuteDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("EXECUTE_DATE between", value1, value2, "executeDate");
			return (Criteria) this;
		}

		public Criteria andExecuteDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("EXECUTE_DATE not between", value1, value2, "executeDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateIsNull() {
			addCriterion("CREATE_DATE is null");
			return (Criteria) this;
		}

		public Criteria andCreateDateIsNotNull() {
			addCriterion("CREATE_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andCreateDateEqualTo(Date value) {
			addCriterionForJDBCDate("CREATE_DATE =", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("CREATE_DATE <>", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateGreaterThan(Date value) {
			addCriterionForJDBCDate("CREATE_DATE >", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("CREATE_DATE >=", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateLessThan(Date value) {
			addCriterionForJDBCDate("CREATE_DATE <", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("CREATE_DATE <=", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateIn(List<Date> values) {
			addCriterionForJDBCDate("CREATE_DATE in", values, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("CREATE_DATE not in", values, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("CREATE_DATE between", value1, value2, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("CREATE_DATE not between", value1, value2, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateOperatorIsNull() {
			addCriterion("CREATE_OPERATOR is null");
			return (Criteria) this;
		}

		public Criteria andCreateOperatorIsNotNull() {
			addCriterion("CREATE_OPERATOR is not null");
			return (Criteria) this;
		}

		public Criteria andCreateOperatorEqualTo(Integer value) {
			addCriterion("CREATE_OPERATOR =", value, "createOperator");
			return (Criteria) this;
		}

		public Criteria andCreateOperatorNotEqualTo(Integer value) {
			addCriterion("CREATE_OPERATOR <>", value, "createOperator");
			return (Criteria) this;
		}

		public Criteria andCreateOperatorGreaterThan(Integer value) {
			addCriterion("CREATE_OPERATOR >", value, "createOperator");
			return (Criteria) this;
		}

		public Criteria andCreateOperatorGreaterThanOrEqualTo(Integer value) {
			addCriterion("CREATE_OPERATOR >=", value, "createOperator");
			return (Criteria) this;
		}

		public Criteria andCreateOperatorLessThan(Integer value) {
			addCriterion("CREATE_OPERATOR <", value, "createOperator");
			return (Criteria) this;
		}

		public Criteria andCreateOperatorLessThanOrEqualTo(Integer value) {
			addCriterion("CREATE_OPERATOR <=", value, "createOperator");
			return (Criteria) this;
		}

		public Criteria andCreateOperatorIn(List<Integer> values) {
			addCriterion("CREATE_OPERATOR in", values, "createOperator");
			return (Criteria) this;
		}

		public Criteria andCreateOperatorNotIn(List<Integer> values) {
			addCriterion("CREATE_OPERATOR not in", values, "createOperator");
			return (Criteria) this;
		}

		public Criteria andCreateOperatorBetween(Integer value1, Integer value2) {
			addCriterion("CREATE_OPERATOR between", value1, value2, "createOperator");
			return (Criteria) this;
		}

		public Criteria andCreateOperatorNotBetween(Integer value1, Integer value2) {
			addCriterion("CREATE_OPERATOR not between", value1, value2, "createOperator");
			return (Criteria) this;
		}

		public Criteria andUpdateDateIsNull() {
			addCriterion("UPDATE_DATE is null");
			return (Criteria) this;
		}

		public Criteria andUpdateDateIsNotNull() {
			addCriterion("UPDATE_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateDateEqualTo(Date value) {
			addCriterionForJDBCDate("UPDATE_DATE =", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("UPDATE_DATE <>", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateGreaterThan(Date value) {
			addCriterionForJDBCDate("UPDATE_DATE >", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("UPDATE_DATE >=", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateLessThan(Date value) {
			addCriterionForJDBCDate("UPDATE_DATE <", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("UPDATE_DATE <=", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateIn(List<Date> values) {
			addCriterionForJDBCDate("UPDATE_DATE in", values, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("UPDATE_DATE not in", values, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("UPDATE_DATE between", value1, value2, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("UPDATE_DATE not between", value1, value2, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateOperatorIsNull() {
			addCriterion("UPDATE_OPERATOR is null");
			return (Criteria) this;
		}

		public Criteria andUpdateOperatorIsNotNull() {
			addCriterion("UPDATE_OPERATOR is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateOperatorEqualTo(Integer value) {
			addCriterion("UPDATE_OPERATOR =", value, "updateOperator");
			return (Criteria) this;
		}

		public Criteria andUpdateOperatorNotEqualTo(Integer value) {
			addCriterion("UPDATE_OPERATOR <>", value, "updateOperator");
			return (Criteria) this;
		}

		public Criteria andUpdateOperatorGreaterThan(Integer value) {
			addCriterion("UPDATE_OPERATOR >", value, "updateOperator");
			return (Criteria) this;
		}

		public Criteria andUpdateOperatorGreaterThanOrEqualTo(Integer value) {
			addCriterion("UPDATE_OPERATOR >=", value, "updateOperator");
			return (Criteria) this;
		}

		public Criteria andUpdateOperatorLessThan(Integer value) {
			addCriterion("UPDATE_OPERATOR <", value, "updateOperator");
			return (Criteria) this;
		}

		public Criteria andUpdateOperatorLessThanOrEqualTo(Integer value) {
			addCriterion("UPDATE_OPERATOR <=", value, "updateOperator");
			return (Criteria) this;
		}

		public Criteria andUpdateOperatorIn(List<Integer> values) {
			addCriterion("UPDATE_OPERATOR in", values, "updateOperator");
			return (Criteria) this;
		}

		public Criteria andUpdateOperatorNotIn(List<Integer> values) {
			addCriterion("UPDATE_OPERATOR not in", values, "updateOperator");
			return (Criteria) this;
		}

		public Criteria andUpdateOperatorBetween(Integer value1, Integer value2) {
			addCriterion("UPDATE_OPERATOR between", value1, value2, "updateOperator");
			return (Criteria) this;
		}

		public Criteria andUpdateOperatorNotBetween(Integer value1, Integer value2) {
			addCriterion("UPDATE_OPERATOR not between", value1, value2, "updateOperator");
			return (Criteria) this;
		}

		public Criteria andContractAmtIsNull() {
			addCriterion("CONTRACT_AMT is null");
			return (Criteria) this;
		}

		public Criteria andContractAmtIsNotNull() {
			addCriterion("CONTRACT_AMT is not null");
			return (Criteria) this;
		}

		public Criteria andContractAmtEqualTo(BigDecimal value) {
			addCriterion("CONTRACT_AMT =", value, "contractAmt");
			return (Criteria) this;
		}

		public Criteria andContractAmtNotEqualTo(BigDecimal value) {
			addCriterion("CONTRACT_AMT <>", value, "contractAmt");
			return (Criteria) this;
		}

		public Criteria andContractAmtGreaterThan(BigDecimal value) {
			addCriterion("CONTRACT_AMT >", value, "contractAmt");
			return (Criteria) this;
		}

		public Criteria andContractAmtGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("CONTRACT_AMT >=", value, "contractAmt");
			return (Criteria) this;
		}

		public Criteria andContractAmtLessThan(BigDecimal value) {
			addCriterion("CONTRACT_AMT <", value, "contractAmt");
			return (Criteria) this;
		}

		public Criteria andContractAmtLessThanOrEqualTo(BigDecimal value) {
			addCriterion("CONTRACT_AMT <=", value, "contractAmt");
			return (Criteria) this;
		}

		public Criteria andContractAmtIn(List<BigDecimal> values) {
			addCriterion("CONTRACT_AMT in", values, "contractAmt");
			return (Criteria) this;
		}

		public Criteria andContractAmtNotIn(List<BigDecimal> values) {
			addCriterion("CONTRACT_AMT not in", values, "contractAmt");
			return (Criteria) this;
		}

		public Criteria andContractAmtBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("CONTRACT_AMT between", value1, value2, "contractAmt");
			return (Criteria) this;
		}

		public Criteria andContractAmtNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("CONTRACT_AMT not between", value1, value2, "contractAmt");
			return (Criteria) this;
		}

		public Criteria andContractBalanceIsNull() {
			addCriterion("CONTRACT_BALANCE is null");
			return (Criteria) this;
		}

		public Criteria andContractBalanceIsNotNull() {
			addCriterion("CONTRACT_BALANCE is not null");
			return (Criteria) this;
		}

		public Criteria andContractBalanceEqualTo(BigDecimal value) {
			addCriterion("CONTRACT_BALANCE =", value, "contractBalance");
			return (Criteria) this;
		}

		public Criteria andContractBalanceNotEqualTo(BigDecimal value) {
			addCriterion("CONTRACT_BALANCE <>", value, "contractBalance");
			return (Criteria) this;
		}

		public Criteria andContractBalanceGreaterThan(BigDecimal value) {
			addCriterion("CONTRACT_BALANCE >", value, "contractBalance");
			return (Criteria) this;
		}

		public Criteria andContractBalanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("CONTRACT_BALANCE >=", value, "contractBalance");
			return (Criteria) this;
		}

		public Criteria andContractBalanceLessThan(BigDecimal value) {
			addCriterion("CONTRACT_BALANCE <", value, "contractBalance");
			return (Criteria) this;
		}

		public Criteria andContractBalanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("CONTRACT_BALANCE <=", value, "contractBalance");
			return (Criteria) this;
		}

		public Criteria andContractBalanceIn(List<BigDecimal> values) {
			addCriterion("CONTRACT_BALANCE in", values, "contractBalance");
			return (Criteria) this;
		}

		public Criteria andContractBalanceNotIn(List<BigDecimal> values) {
			addCriterion("CONTRACT_BALANCE not in", values, "contractBalance");
			return (Criteria) this;
		}

		public Criteria andContractBalanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("CONTRACT_BALANCE between", value1, value2, "contractBalance");
			return (Criteria) this;
		}

		public Criteria andContractBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("CONTRACT_BALANCE not between", value1, value2, "contractBalance");
			return (Criteria) this;
		}

		public Criteria andContractStateIsNull() {
			addCriterion("CONTRACT_STATE is null");
			return (Criteria) this;
		}

		public Criteria andContractStateIsNotNull() {
			addCriterion("CONTRACT_STATE is not null");
			return (Criteria) this;
		}

		public Criteria andContractStateEqualTo(Integer value) {
			addCriterion("CONTRACT_STATE =", value, "contractState");
			return (Criteria) this;
		}

		public Criteria andContractStateNotEqualTo(Integer value) {
			addCriterion("CONTRACT_STATE <>", value, "contractState");
			return (Criteria) this;
		}

		public Criteria andContractStateGreaterThan(Integer value) {
			addCriterion("CONTRACT_STATE >", value, "contractState");
			return (Criteria) this;
		}

		public Criteria andContractStateGreaterThanOrEqualTo(Integer value) {
			addCriterion("CONTRACT_STATE >=", value, "contractState");
			return (Criteria) this;
		}

		public Criteria andContractStateLessThan(Integer value) {
			addCriterion("CONTRACT_STATE <", value, "contractState");
			return (Criteria) this;
		}

		public Criteria andContractStateLessThanOrEqualTo(Integer value) {
			addCriterion("CONTRACT_STATE <=", value, "contractState");
			return (Criteria) this;
		}

		public Criteria andContractStateIn(List<Integer> values) {
			addCriterion("CONTRACT_STATE in", values, "contractState");
			return (Criteria) this;
		}

		public Criteria andContractStateNotIn(List<Integer> values) {
			addCriterion("CONTRACT_STATE not in", values, "contractState");
			return (Criteria) this;
		}

		public Criteria andContractStateBetween(Integer value1, Integer value2) {
			addCriterion("CONTRACT_STATE between", value1, value2, "contractState");
			return (Criteria) this;
		}

		public Criteria andContractStateNotBetween(Integer value1, Integer value2) {
			addCriterion("CONTRACT_STATE not between", value1, value2, "contractState");
			return (Criteria) this;
		}

		public Criteria andNoteIsNull() {
			addCriterion("NOTE is null");
			return (Criteria) this;
		}

		public Criteria andNoteIsNotNull() {
			addCriterion("NOTE is not null");
			return (Criteria) this;
		}

		public Criteria andNoteEqualTo(String value) {
			addCriterion("NOTE =", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteNotEqualTo(String value) {
			addCriterion("NOTE <>", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteGreaterThan(String value) {
			addCriterion("NOTE >", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteGreaterThanOrEqualTo(String value) {
			addCriterion("NOTE >=", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteLessThan(String value) {
			addCriterion("NOTE <", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteLessThanOrEqualTo(String value) {
			addCriterion("NOTE <=", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteLike(String value) {
			addCriterion("NOTE like", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteNotLike(String value) {
			addCriterion("NOTE not like", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteIn(List<String> values) {
			addCriterion("NOTE in", values, "note");
			return (Criteria) this;
		}

		public Criteria andNoteNotIn(List<String> values) {
			addCriterion("NOTE not in", values, "note");
			return (Criteria) this;
		}

		public Criteria andNoteBetween(String value1, String value2) {
			addCriterion("NOTE between", value1, value2, "note");
			return (Criteria) this;
		}

		public Criteria andNoteNotBetween(String value1, String value2) {
			addCriterion("NOTE not between", value1, value2, "note");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TRX_CONTRACT
     *
     * @mbg.generated do_not_delete_during_merge Thu Jun 22 01:49:36 GMT+08:00 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}