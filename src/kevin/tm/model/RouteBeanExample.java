package kevin.tm.model;

import java.util.ArrayList;
import java.util.List;

public class RouteBeanExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table Route
	 * @mbggenerated  Mon Mar 03 20:49:21 CST 2014
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table Route
	 * @mbggenerated  Mon Mar 03 20:49:21 CST 2014
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table Route
	 * @mbggenerated  Mon Mar 03 20:49:21 CST 2014
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Route
	 * @mbggenerated  Mon Mar 03 20:49:21 CST 2014
	 */
	public RouteBeanExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Route
	 * @mbggenerated  Mon Mar 03 20:49:21 CST 2014
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Route
	 * @mbggenerated  Mon Mar 03 20:49:21 CST 2014
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Route
	 * @mbggenerated  Mon Mar 03 20:49:21 CST 2014
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Route
	 * @mbggenerated  Mon Mar 03 20:49:21 CST 2014
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Route
	 * @mbggenerated  Mon Mar 03 20:49:21 CST 2014
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Route
	 * @mbggenerated  Mon Mar 03 20:49:21 CST 2014
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Route
	 * @mbggenerated  Mon Mar 03 20:49:21 CST 2014
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Route
	 * @mbggenerated  Mon Mar 03 20:49:21 CST 2014
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Route
	 * @mbggenerated  Mon Mar 03 20:49:21 CST 2014
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table Route
	 * @mbggenerated  Mon Mar 03 20:49:21 CST 2014
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table Route
	 * @mbggenerated  Mon Mar 03 20:49:21 CST 2014
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andRouteidIsNull() {
			addCriterion("RouteId is null");
			return (Criteria) this;
		}

		public Criteria andRouteidIsNotNull() {
			addCriterion("RouteId is not null");
			return (Criteria) this;
		}

		public Criteria andRouteidEqualTo(Integer value) {
			addCriterion("RouteId =", value, "routeid");
			return (Criteria) this;
		}

		public Criteria andRouteidNotEqualTo(Integer value) {
			addCriterion("RouteId <>", value, "routeid");
			return (Criteria) this;
		}

		public Criteria andRouteidGreaterThan(Integer value) {
			addCriterion("RouteId >", value, "routeid");
			return (Criteria) this;
		}

		public Criteria andRouteidGreaterThanOrEqualTo(Integer value) {
			addCriterion("RouteId >=", value, "routeid");
			return (Criteria) this;
		}

		public Criteria andRouteidLessThan(Integer value) {
			addCriterion("RouteId <", value, "routeid");
			return (Criteria) this;
		}

		public Criteria andRouteidLessThanOrEqualTo(Integer value) {
			addCriterion("RouteId <=", value, "routeid");
			return (Criteria) this;
		}

		public Criteria andRouteidIn(List<Integer> values) {
			addCriterion("RouteId in", values, "routeid");
			return (Criteria) this;
		}

		public Criteria andRouteidNotIn(List<Integer> values) {
			addCriterion("RouteId not in", values, "routeid");
			return (Criteria) this;
		}

		public Criteria andRouteidBetween(Integer value1, Integer value2) {
			addCriterion("RouteId between", value1, value2, "routeid");
			return (Criteria) this;
		}

		public Criteria andRouteidNotBetween(Integer value1, Integer value2) {
			addCriterion("RouteId not between", value1, value2, "routeid");
			return (Criteria) this;
		}

		public Criteria andStartstationidIsNull() {
			addCriterion("StartStationId is null");
			return (Criteria) this;
		}

		public Criteria andStartstationidIsNotNull() {
			addCriterion("StartStationId is not null");
			return (Criteria) this;
		}

		public Criteria andStartstationidEqualTo(Integer value) {
			addCriterion("StartStationId =", value, "startstationid");
			return (Criteria) this;
		}

		public Criteria andStartstationidNotEqualTo(Integer value) {
			addCriterion("StartStationId <>", value, "startstationid");
			return (Criteria) this;
		}

		public Criteria andStartstationidGreaterThan(Integer value) {
			addCriterion("StartStationId >", value, "startstationid");
			return (Criteria) this;
		}

		public Criteria andStartstationidGreaterThanOrEqualTo(Integer value) {
			addCriterion("StartStationId >=", value, "startstationid");
			return (Criteria) this;
		}

		public Criteria andStartstationidLessThan(Integer value) {
			addCriterion("StartStationId <", value, "startstationid");
			return (Criteria) this;
		}

		public Criteria andStartstationidLessThanOrEqualTo(Integer value) {
			addCriterion("StartStationId <=", value, "startstationid");
			return (Criteria) this;
		}

		public Criteria andStartstationidIn(List<Integer> values) {
			addCriterion("StartStationId in", values, "startstationid");
			return (Criteria) this;
		}

		public Criteria andStartstationidNotIn(List<Integer> values) {
			addCriterion("StartStationId not in", values, "startstationid");
			return (Criteria) this;
		}

		public Criteria andStartstationidBetween(Integer value1, Integer value2) {
			addCriterion("StartStationId between", value1, value2,
					"startstationid");
			return (Criteria) this;
		}

		public Criteria andStartstationidNotBetween(Integer value1,
				Integer value2) {
			addCriterion("StartStationId not between", value1, value2,
					"startstationid");
			return (Criteria) this;
		}

		public Criteria andEndstationidIsNull() {
			addCriterion("EndStationId is null");
			return (Criteria) this;
		}

		public Criteria andEndstationidIsNotNull() {
			addCriterion("EndStationId is not null");
			return (Criteria) this;
		}

		public Criteria andEndstationidEqualTo(Integer value) {
			addCriterion("EndStationId =", value, "endstationid");
			return (Criteria) this;
		}

		public Criteria andEndstationidNotEqualTo(Integer value) {
			addCriterion("EndStationId <>", value, "endstationid");
			return (Criteria) this;
		}

		public Criteria andEndstationidGreaterThan(Integer value) {
			addCriterion("EndStationId >", value, "endstationid");
			return (Criteria) this;
		}

		public Criteria andEndstationidGreaterThanOrEqualTo(Integer value) {
			addCriterion("EndStationId >=", value, "endstationid");
			return (Criteria) this;
		}

		public Criteria andEndstationidLessThan(Integer value) {
			addCriterion("EndStationId <", value, "endstationid");
			return (Criteria) this;
		}

		public Criteria andEndstationidLessThanOrEqualTo(Integer value) {
			addCriterion("EndStationId <=", value, "endstationid");
			return (Criteria) this;
		}

		public Criteria andEndstationidIn(List<Integer> values) {
			addCriterion("EndStationId in", values, "endstationid");
			return (Criteria) this;
		}

		public Criteria andEndstationidNotIn(List<Integer> values) {
			addCriterion("EndStationId not in", values, "endstationid");
			return (Criteria) this;
		}

		public Criteria andEndstationidBetween(Integer value1, Integer value2) {
			addCriterion("EndStationId between", value1, value2, "endstationid");
			return (Criteria) this;
		}

		public Criteria andEndstationidNotBetween(Integer value1, Integer value2) {
			addCriterion("EndStationId not between", value1, value2,
					"endstationid");
			return (Criteria) this;
		}

		public Criteria andRoutenameIsNull() {
			addCriterion("RouteName is null");
			return (Criteria) this;
		}

		public Criteria andRoutenameIsNotNull() {
			addCriterion("RouteName is not null");
			return (Criteria) this;
		}

		public Criteria andRoutenameEqualTo(String value) {
			addCriterion("RouteName =", value, "routename");
			return (Criteria) this;
		}

		public Criteria andRoutenameNotEqualTo(String value) {
			addCriterion("RouteName <>", value, "routename");
			return (Criteria) this;
		}

		public Criteria andRoutenameGreaterThan(String value) {
			addCriterion("RouteName >", value, "routename");
			return (Criteria) this;
		}

		public Criteria andRoutenameGreaterThanOrEqualTo(String value) {
			addCriterion("RouteName >=", value, "routename");
			return (Criteria) this;
		}

		public Criteria andRoutenameLessThan(String value) {
			addCriterion("RouteName <", value, "routename");
			return (Criteria) this;
		}

		public Criteria andRoutenameLessThanOrEqualTo(String value) {
			addCriterion("RouteName <=", value, "routename");
			return (Criteria) this;
		}

		public Criteria andRoutenameLike(String value) {
			addCriterion("RouteName like", value, "routename");
			return (Criteria) this;
		}

		public Criteria andRoutenameNotLike(String value) {
			addCriterion("RouteName not like", value, "routename");
			return (Criteria) this;
		}

		public Criteria andRoutenameIn(List<String> values) {
			addCriterion("RouteName in", values, "routename");
			return (Criteria) this;
		}

		public Criteria andRoutenameNotIn(List<String> values) {
			addCriterion("RouteName not in", values, "routename");
			return (Criteria) this;
		}

		public Criteria andRoutenameBetween(String value1, String value2) {
			addCriterion("RouteName between", value1, value2, "routename");
			return (Criteria) this;
		}

		public Criteria andRoutenameNotBetween(String value1, String value2) {
			addCriterion("RouteName not between", value1, value2, "routename");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table Route
	 * @mbggenerated  Mon Mar 03 20:49:21 CST 2014
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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
     * This class corresponds to the database table Route
     *
     * @mbggenerated do_not_delete_during_merge Mon Mar 03 17:46:15 CST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}