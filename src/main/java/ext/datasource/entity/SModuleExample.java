package ext.datasource.entity;

import java.util.ArrayList;
import java.util.List;

public class SModuleExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table S_MODULE
	 * @mbg.generated  Tue Jun 13 22:26:58 GMT+08:00 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table S_MODULE
	 * @mbg.generated  Tue Jun 13 22:26:58 GMT+08:00 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table S_MODULE
	 * @mbg.generated  Tue Jun 13 22:26:58 GMT+08:00 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_MODULE
	 * @mbg.generated  Tue Jun 13 22:26:58 GMT+08:00 2017
	 */
	public SModuleExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_MODULE
	 * @mbg.generated  Tue Jun 13 22:26:58 GMT+08:00 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_MODULE
	 * @mbg.generated  Tue Jun 13 22:26:58 GMT+08:00 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_MODULE
	 * @mbg.generated  Tue Jun 13 22:26:58 GMT+08:00 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_MODULE
	 * @mbg.generated  Tue Jun 13 22:26:58 GMT+08:00 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_MODULE
	 * @mbg.generated  Tue Jun 13 22:26:58 GMT+08:00 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_MODULE
	 * @mbg.generated  Tue Jun 13 22:26:58 GMT+08:00 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_MODULE
	 * @mbg.generated  Tue Jun 13 22:26:58 GMT+08:00 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_MODULE
	 * @mbg.generated  Tue Jun 13 22:26:58 GMT+08:00 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_MODULE
	 * @mbg.generated  Tue Jun 13 22:26:58 GMT+08:00 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_MODULE
	 * @mbg.generated  Tue Jun 13 22:26:58 GMT+08:00 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table S_MODULE
	 * @mbg.generated  Tue Jun 13 22:26:58 GMT+08:00 2017
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

		public Criteria andModuleNameIsNull() {
			addCriterion("MODULE_NAME is null");
			return (Criteria) this;
		}

		public Criteria andModuleNameIsNotNull() {
			addCriterion("MODULE_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andModuleNameEqualTo(String value) {
			addCriterion("MODULE_NAME =", value, "moduleName");
			return (Criteria) this;
		}

		public Criteria andModuleNameNotEqualTo(String value) {
			addCriterion("MODULE_NAME <>", value, "moduleName");
			return (Criteria) this;
		}

		public Criteria andModuleNameGreaterThan(String value) {
			addCriterion("MODULE_NAME >", value, "moduleName");
			return (Criteria) this;
		}

		public Criteria andModuleNameGreaterThanOrEqualTo(String value) {
			addCriterion("MODULE_NAME >=", value, "moduleName");
			return (Criteria) this;
		}

		public Criteria andModuleNameLessThan(String value) {
			addCriterion("MODULE_NAME <", value, "moduleName");
			return (Criteria) this;
		}

		public Criteria andModuleNameLessThanOrEqualTo(String value) {
			addCriterion("MODULE_NAME <=", value, "moduleName");
			return (Criteria) this;
		}

		public Criteria andModuleNameLike(String value) {
			addCriterion("MODULE_NAME like", value, "moduleName");
			return (Criteria) this;
		}

		public Criteria andModuleNameNotLike(String value) {
			addCriterion("MODULE_NAME not like", value, "moduleName");
			return (Criteria) this;
		}

		public Criteria andModuleNameIn(List<String> values) {
			addCriterion("MODULE_NAME in", values, "moduleName");
			return (Criteria) this;
		}

		public Criteria andModuleNameNotIn(List<String> values) {
			addCriterion("MODULE_NAME not in", values, "moduleName");
			return (Criteria) this;
		}

		public Criteria andModuleNameBetween(String value1, String value2) {
			addCriterion("MODULE_NAME between", value1, value2, "moduleName");
			return (Criteria) this;
		}

		public Criteria andModuleNameNotBetween(String value1, String value2) {
			addCriterion("MODULE_NAME not between", value1, value2, "moduleName");
			return (Criteria) this;
		}

		public Criteria andModuleLinkIsNull() {
			addCriterion("MODULE_LINK is null");
			return (Criteria) this;
		}

		public Criteria andModuleLinkIsNotNull() {
			addCriterion("MODULE_LINK is not null");
			return (Criteria) this;
		}

		public Criteria andModuleLinkEqualTo(String value) {
			addCriterion("MODULE_LINK =", value, "moduleLink");
			return (Criteria) this;
		}

		public Criteria andModuleLinkNotEqualTo(String value) {
			addCriterion("MODULE_LINK <>", value, "moduleLink");
			return (Criteria) this;
		}

		public Criteria andModuleLinkGreaterThan(String value) {
			addCriterion("MODULE_LINK >", value, "moduleLink");
			return (Criteria) this;
		}

		public Criteria andModuleLinkGreaterThanOrEqualTo(String value) {
			addCriterion("MODULE_LINK >=", value, "moduleLink");
			return (Criteria) this;
		}

		public Criteria andModuleLinkLessThan(String value) {
			addCriterion("MODULE_LINK <", value, "moduleLink");
			return (Criteria) this;
		}

		public Criteria andModuleLinkLessThanOrEqualTo(String value) {
			addCriterion("MODULE_LINK <=", value, "moduleLink");
			return (Criteria) this;
		}

		public Criteria andModuleLinkLike(String value) {
			addCriterion("MODULE_LINK like", value, "moduleLink");
			return (Criteria) this;
		}

		public Criteria andModuleLinkNotLike(String value) {
			addCriterion("MODULE_LINK not like", value, "moduleLink");
			return (Criteria) this;
		}

		public Criteria andModuleLinkIn(List<String> values) {
			addCriterion("MODULE_LINK in", values, "moduleLink");
			return (Criteria) this;
		}

		public Criteria andModuleLinkNotIn(List<String> values) {
			addCriterion("MODULE_LINK not in", values, "moduleLink");
			return (Criteria) this;
		}

		public Criteria andModuleLinkBetween(String value1, String value2) {
			addCriterion("MODULE_LINK between", value1, value2, "moduleLink");
			return (Criteria) this;
		}

		public Criteria andModuleLinkNotBetween(String value1, String value2) {
			addCriterion("MODULE_LINK not between", value1, value2, "moduleLink");
			return (Criteria) this;
		}

		public Criteria andIframeIsNull() {
			addCriterion("IFRAME is null");
			return (Criteria) this;
		}

		public Criteria andIframeIsNotNull() {
			addCriterion("IFRAME is not null");
			return (Criteria) this;
		}

		public Criteria andIframeEqualTo(Boolean value) {
			addCriterion("IFRAME =", value, "iframe");
			return (Criteria) this;
		}

		public Criteria andIframeNotEqualTo(Boolean value) {
			addCriterion("IFRAME <>", value, "iframe");
			return (Criteria) this;
		}

		public Criteria andIframeGreaterThan(Boolean value) {
			addCriterion("IFRAME >", value, "iframe");
			return (Criteria) this;
		}

		public Criteria andIframeGreaterThanOrEqualTo(Boolean value) {
			addCriterion("IFRAME >=", value, "iframe");
			return (Criteria) this;
		}

		public Criteria andIframeLessThan(Boolean value) {
			addCriterion("IFRAME <", value, "iframe");
			return (Criteria) this;
		}

		public Criteria andIframeLessThanOrEqualTo(Boolean value) {
			addCriterion("IFRAME <=", value, "iframe");
			return (Criteria) this;
		}

		public Criteria andIframeIn(List<Boolean> values) {
			addCriterion("IFRAME in", values, "iframe");
			return (Criteria) this;
		}

		public Criteria andIframeNotIn(List<Boolean> values) {
			addCriterion("IFRAME not in", values, "iframe");
			return (Criteria) this;
		}

		public Criteria andIframeBetween(Boolean value1, Boolean value2) {
			addCriterion("IFRAME between", value1, value2, "iframe");
			return (Criteria) this;
		}

		public Criteria andIframeNotBetween(Boolean value1, Boolean value2) {
			addCriterion("IFRAME not between", value1, value2, "iframe");
			return (Criteria) this;
		}

		public Criteria andParentIsNull() {
			addCriterion("PARENT is null");
			return (Criteria) this;
		}

		public Criteria andParentIsNotNull() {
			addCriterion("PARENT is not null");
			return (Criteria) this;
		}

		public Criteria andParentEqualTo(String value) {
			addCriterion("PARENT =", value, "parent");
			return (Criteria) this;
		}

		public Criteria andParentNotEqualTo(String value) {
			addCriterion("PARENT <>", value, "parent");
			return (Criteria) this;
		}

		public Criteria andParentGreaterThan(String value) {
			addCriterion("PARENT >", value, "parent");
			return (Criteria) this;
		}

		public Criteria andParentGreaterThanOrEqualTo(String value) {
			addCriterion("PARENT >=", value, "parent");
			return (Criteria) this;
		}

		public Criteria andParentLessThan(String value) {
			addCriterion("PARENT <", value, "parent");
			return (Criteria) this;
		}

		public Criteria andParentLessThanOrEqualTo(String value) {
			addCriterion("PARENT <=", value, "parent");
			return (Criteria) this;
		}

		public Criteria andParentLike(String value) {
			addCriterion("PARENT like", value, "parent");
			return (Criteria) this;
		}

		public Criteria andParentNotLike(String value) {
			addCriterion("PARENT not like", value, "parent");
			return (Criteria) this;
		}

		public Criteria andParentIn(List<String> values) {
			addCriterion("PARENT in", values, "parent");
			return (Criteria) this;
		}

		public Criteria andParentNotIn(List<String> values) {
			addCriterion("PARENT not in", values, "parent");
			return (Criteria) this;
		}

		public Criteria andParentBetween(String value1, String value2) {
			addCriterion("PARENT between", value1, value2, "parent");
			return (Criteria) this;
		}

		public Criteria andParentNotBetween(String value1, String value2) {
			addCriterion("PARENT not between", value1, value2, "parent");
			return (Criteria) this;
		}

		public Criteria andIconIsNull() {
			addCriterion("ICON is null");
			return (Criteria) this;
		}

		public Criteria andIconIsNotNull() {
			addCriterion("ICON is not null");
			return (Criteria) this;
		}

		public Criteria andIconEqualTo(String value) {
			addCriterion("ICON =", value, "icon");
			return (Criteria) this;
		}

		public Criteria andIconNotEqualTo(String value) {
			addCriterion("ICON <>", value, "icon");
			return (Criteria) this;
		}

		public Criteria andIconGreaterThan(String value) {
			addCriterion("ICON >", value, "icon");
			return (Criteria) this;
		}

		public Criteria andIconGreaterThanOrEqualTo(String value) {
			addCriterion("ICON >=", value, "icon");
			return (Criteria) this;
		}

		public Criteria andIconLessThan(String value) {
			addCriterion("ICON <", value, "icon");
			return (Criteria) this;
		}

		public Criteria andIconLessThanOrEqualTo(String value) {
			addCriterion("ICON <=", value, "icon");
			return (Criteria) this;
		}

		public Criteria andIconLike(String value) {
			addCriterion("ICON like", value, "icon");
			return (Criteria) this;
		}

		public Criteria andIconNotLike(String value) {
			addCriterion("ICON not like", value, "icon");
			return (Criteria) this;
		}

		public Criteria andIconIn(List<String> values) {
			addCriterion("ICON in", values, "icon");
			return (Criteria) this;
		}

		public Criteria andIconNotIn(List<String> values) {
			addCriterion("ICON not in", values, "icon");
			return (Criteria) this;
		}

		public Criteria andIconBetween(String value1, String value2) {
			addCriterion("ICON between", value1, value2, "icon");
			return (Criteria) this;
		}

		public Criteria andIconNotBetween(String value1, String value2) {
			addCriterion("ICON not between", value1, value2, "icon");
			return (Criteria) this;
		}

		public Criteria andDesNameIsNull() {
			addCriterion("DES_NAME is null");
			return (Criteria) this;
		}

		public Criteria andDesNameIsNotNull() {
			addCriterion("DES_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andDesNameEqualTo(String value) {
			addCriterion("DES_NAME =", value, "desName");
			return (Criteria) this;
		}

		public Criteria andDesNameNotEqualTo(String value) {
			addCriterion("DES_NAME <>", value, "desName");
			return (Criteria) this;
		}

		public Criteria andDesNameGreaterThan(String value) {
			addCriterion("DES_NAME >", value, "desName");
			return (Criteria) this;
		}

		public Criteria andDesNameGreaterThanOrEqualTo(String value) {
			addCriterion("DES_NAME >=", value, "desName");
			return (Criteria) this;
		}

		public Criteria andDesNameLessThan(String value) {
			addCriterion("DES_NAME <", value, "desName");
			return (Criteria) this;
		}

		public Criteria andDesNameLessThanOrEqualTo(String value) {
			addCriterion("DES_NAME <=", value, "desName");
			return (Criteria) this;
		}

		public Criteria andDesNameLike(String value) {
			addCriterion("DES_NAME like", value, "desName");
			return (Criteria) this;
		}

		public Criteria andDesNameNotLike(String value) {
			addCriterion("DES_NAME not like", value, "desName");
			return (Criteria) this;
		}

		public Criteria andDesNameIn(List<String> values) {
			addCriterion("DES_NAME in", values, "desName");
			return (Criteria) this;
		}

		public Criteria andDesNameNotIn(List<String> values) {
			addCriterion("DES_NAME not in", values, "desName");
			return (Criteria) this;
		}

		public Criteria andDesNameBetween(String value1, String value2) {
			addCriterion("DES_NAME between", value1, value2, "desName");
			return (Criteria) this;
		}

		public Criteria andDesNameNotBetween(String value1, String value2) {
			addCriterion("DES_NAME not between", value1, value2, "desName");
			return (Criteria) this;
		}

		public Criteria andMRightIsNull() {
			addCriterion("M_RIGHT is null");
			return (Criteria) this;
		}

		public Criteria andMRightIsNotNull() {
			addCriterion("M_RIGHT is not null");
			return (Criteria) this;
		}

		public Criteria andMRightEqualTo(Integer value) {
			addCriterion("M_RIGHT =", value, "mRight");
			return (Criteria) this;
		}

		public Criteria andMRightNotEqualTo(Integer value) {
			addCriterion("M_RIGHT <>", value, "mRight");
			return (Criteria) this;
		}

		public Criteria andMRightGreaterThan(Integer value) {
			addCriterion("M_RIGHT >", value, "mRight");
			return (Criteria) this;
		}

		public Criteria andMRightGreaterThanOrEqualTo(Integer value) {
			addCriterion("M_RIGHT >=", value, "mRight");
			return (Criteria) this;
		}

		public Criteria andMRightLessThan(Integer value) {
			addCriterion("M_RIGHT <", value, "mRight");
			return (Criteria) this;
		}

		public Criteria andMRightLessThanOrEqualTo(Integer value) {
			addCriterion("M_RIGHT <=", value, "mRight");
			return (Criteria) this;
		}

		public Criteria andMRightIn(List<Integer> values) {
			addCriterion("M_RIGHT in", values, "mRight");
			return (Criteria) this;
		}

		public Criteria andMRightNotIn(List<Integer> values) {
			addCriterion("M_RIGHT not in", values, "mRight");
			return (Criteria) this;
		}

		public Criteria andMRightBetween(Integer value1, Integer value2) {
			addCriterion("M_RIGHT between", value1, value2, "mRight");
			return (Criteria) this;
		}

		public Criteria andMRightNotBetween(Integer value1, Integer value2) {
			addCriterion("M_RIGHT not between", value1, value2, "mRight");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table S_MODULE
	 * @mbg.generated  Tue Jun 13 22:26:58 GMT+08:00 2017
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
     * This class corresponds to the database table S_MODULE
     *
     * @mbg.generated do_not_delete_during_merge Tue Jun 13 03:21:14 GMT+08:00 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}