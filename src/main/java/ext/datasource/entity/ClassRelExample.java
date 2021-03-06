package ext.datasource.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ClassRelExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
	 */
	public ClassRelExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
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

		public Criteria andClassIdIsNull() {
			addCriterion("CLASS_ID is null");
			return (Criteria) this;
		}

		public Criteria andClassIdIsNotNull() {
			addCriterion("CLASS_ID is not null");
			return (Criteria) this;
		}

		public Criteria andClassIdEqualTo(Integer value) {
			addCriterion("CLASS_ID =", value, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdNotEqualTo(Integer value) {
			addCriterion("CLASS_ID <>", value, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdGreaterThan(Integer value) {
			addCriterion("CLASS_ID >", value, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CLASS_ID >=", value, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdLessThan(Integer value) {
			addCriterion("CLASS_ID <", value, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdLessThanOrEqualTo(Integer value) {
			addCriterion("CLASS_ID <=", value, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdIn(List<Integer> values) {
			addCriterion("CLASS_ID in", values, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdNotIn(List<Integer> values) {
			addCriterion("CLASS_ID not in", values, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdBetween(Integer value1, Integer value2) {
			addCriterion("CLASS_ID between", value1, value2, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CLASS_ID not between", value1, value2, "classId");
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

		public Criteria andContractIdIsNull() {
			addCriterion("CONTRACT_ID is null");
			return (Criteria) this;
		}

		public Criteria andContractIdIsNotNull() {
			addCriterion("CONTRACT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andContractIdEqualTo(Integer value) {
			addCriterion("CONTRACT_ID =", value, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdNotEqualTo(Integer value) {
			addCriterion("CONTRACT_ID <>", value, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdGreaterThan(Integer value) {
			addCriterion("CONTRACT_ID >", value, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CONTRACT_ID >=", value, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdLessThan(Integer value) {
			addCriterion("CONTRACT_ID <", value, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdLessThanOrEqualTo(Integer value) {
			addCriterion("CONTRACT_ID <=", value, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdIn(List<Integer> values) {
			addCriterion("CONTRACT_ID in", values, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdNotIn(List<Integer> values) {
			addCriterion("CONTRACT_ID not in", values, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdBetween(Integer value1, Integer value2) {
			addCriterion("CONTRACT_ID between", value1, value2, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CONTRACT_ID not between", value1, value2, "contractId");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
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
     * This class corresponds to the database table TRX_CLASS_REL
     *
     * @mbg.generated do_not_delete_during_merge Mon Jun 26 21:54:44 GMT+08:00 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}