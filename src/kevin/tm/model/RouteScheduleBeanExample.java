package kevin.tm.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RouteScheduleBeanExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table RouteSchedule
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table RouteSchedule
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table RouteSchedule
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RouteSchedule
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public RouteScheduleBeanExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RouteSchedule
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RouteSchedule
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RouteSchedule
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RouteSchedule
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RouteSchedule
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RouteSchedule
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RouteSchedule
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RouteSchedule
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RouteSchedule
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RouteSchedule
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table RouteSchedule
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
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

		public Criteria andScheduleidIsNull() {
			addCriterion("ScheduleId is null");
			return (Criteria) this;
		}

		public Criteria andScheduleidIsNotNull() {
			addCriterion("ScheduleId is not null");
			return (Criteria) this;
		}

		public Criteria andScheduleidEqualTo(Integer value) {
			addCriterion("ScheduleId =", value, "scheduleid");
			return (Criteria) this;
		}

		public Criteria andScheduleidNotEqualTo(Integer value) {
			addCriterion("ScheduleId <>", value, "scheduleid");
			return (Criteria) this;
		}

		public Criteria andScheduleidGreaterThan(Integer value) {
			addCriterion("ScheduleId >", value, "scheduleid");
			return (Criteria) this;
		}

		public Criteria andScheduleidGreaterThanOrEqualTo(Integer value) {
			addCriterion("ScheduleId >=", value, "scheduleid");
			return (Criteria) this;
		}

		public Criteria andScheduleidLessThan(Integer value) {
			addCriterion("ScheduleId <", value, "scheduleid");
			return (Criteria) this;
		}

		public Criteria andScheduleidLessThanOrEqualTo(Integer value) {
			addCriterion("ScheduleId <=", value, "scheduleid");
			return (Criteria) this;
		}

		public Criteria andScheduleidIn(List<Integer> values) {
			addCriterion("ScheduleId in", values, "scheduleid");
			return (Criteria) this;
		}

		public Criteria andScheduleidNotIn(List<Integer> values) {
			addCriterion("ScheduleId not in", values, "scheduleid");
			return (Criteria) this;
		}

		public Criteria andScheduleidBetween(Integer value1, Integer value2) {
			addCriterion("ScheduleId between", value1, value2, "scheduleid");
			return (Criteria) this;
		}

		public Criteria andScheduleidNotBetween(Integer value1, Integer value2) {
			addCriterion("ScheduleId not between", value1, value2, "scheduleid");
			return (Criteria) this;
		}

		public Criteria andSchedulerouteidIsNull() {
			addCriterion("ScheduleRouteId is null");
			return (Criteria) this;
		}

		public Criteria andSchedulerouteidIsNotNull() {
			addCriterion("ScheduleRouteId is not null");
			return (Criteria) this;
		}

		public Criteria andSchedulerouteidEqualTo(Integer value) {
			addCriterion("ScheduleRouteId =", value, "schedulerouteid");
			return (Criteria) this;
		}

		public Criteria andSchedulerouteidNotEqualTo(Integer value) {
			addCriterion("ScheduleRouteId <>", value, "schedulerouteid");
			return (Criteria) this;
		}

		public Criteria andSchedulerouteidGreaterThan(Integer value) {
			addCriterion("ScheduleRouteId >", value, "schedulerouteid");
			return (Criteria) this;
		}

		public Criteria andSchedulerouteidGreaterThanOrEqualTo(Integer value) {
			addCriterion("ScheduleRouteId >=", value, "schedulerouteid");
			return (Criteria) this;
		}

		public Criteria andSchedulerouteidLessThan(Integer value) {
			addCriterion("ScheduleRouteId <", value, "schedulerouteid");
			return (Criteria) this;
		}

		public Criteria andSchedulerouteidLessThanOrEqualTo(Integer value) {
			addCriterion("ScheduleRouteId <=", value, "schedulerouteid");
			return (Criteria) this;
		}

		public Criteria andSchedulerouteidIn(List<Integer> values) {
			addCriterion("ScheduleRouteId in", values, "schedulerouteid");
			return (Criteria) this;
		}

		public Criteria andSchedulerouteidNotIn(List<Integer> values) {
			addCriterion("ScheduleRouteId not in", values, "schedulerouteid");
			return (Criteria) this;
		}

		public Criteria andSchedulerouteidBetween(Integer value1, Integer value2) {
			addCriterion("ScheduleRouteId between", value1, value2,
					"schedulerouteid");
			return (Criteria) this;
		}

		public Criteria andSchedulerouteidNotBetween(Integer value1,
				Integer value2) {
			addCriterion("ScheduleRouteId not between", value1, value2,
					"schedulerouteid");
			return (Criteria) this;
		}

		public Criteria andStarttimeIsNull() {
			addCriterion("StartTime is null");
			return (Criteria) this;
		}

		public Criteria andStarttimeIsNotNull() {
			addCriterion("StartTime is not null");
			return (Criteria) this;
		}

		public Criteria andStarttimeEqualTo(Date value) {
			addCriterion("StartTime =", value, "starttime");
			return (Criteria) this;
		}

		public Criteria andStarttimeNotEqualTo(Date value) {
			addCriterion("StartTime <>", value, "starttime");
			return (Criteria) this;
		}

		public Criteria andStarttimeGreaterThan(Date value) {
			addCriterion("StartTime >", value, "starttime");
			return (Criteria) this;
		}

		public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
			addCriterion("StartTime >=", value, "starttime");
			return (Criteria) this;
		}

		public Criteria andStarttimeLessThan(Date value) {
			addCriterion("StartTime <", value, "starttime");
			return (Criteria) this;
		}

		public Criteria andStarttimeLessThanOrEqualTo(Date value) {
			addCriterion("StartTime <=", value, "starttime");
			return (Criteria) this;
		}

		public Criteria andStarttimeIn(List<Date> values) {
			addCriterion("StartTime in", values, "starttime");
			return (Criteria) this;
		}

		public Criteria andStarttimeNotIn(List<Date> values) {
			addCriterion("StartTime not in", values, "starttime");
			return (Criteria) this;
		}

		public Criteria andStarttimeBetween(Date value1, Date value2) {
			addCriterion("StartTime between", value1, value2, "starttime");
			return (Criteria) this;
		}

		public Criteria andStarttimeNotBetween(Date value1, Date value2) {
			addCriterion("StartTime not between", value1, value2, "starttime");
			return (Criteria) this;
		}

		public Criteria andEndtimeIsNull() {
			addCriterion("EndTime is null");
			return (Criteria) this;
		}

		public Criteria andEndtimeIsNotNull() {
			addCriterion("EndTime is not null");
			return (Criteria) this;
		}

		public Criteria andEndtimeEqualTo(Date value) {
			addCriterion("EndTime =", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeNotEqualTo(Date value) {
			addCriterion("EndTime <>", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeGreaterThan(Date value) {
			addCriterion("EndTime >", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
			addCriterion("EndTime >=", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeLessThan(Date value) {
			addCriterion("EndTime <", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeLessThanOrEqualTo(Date value) {
			addCriterion("EndTime <=", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeIn(List<Date> values) {
			addCriterion("EndTime in", values, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeNotIn(List<Date> values) {
			addCriterion("EndTime not in", values, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeBetween(Date value1, Date value2) {
			addCriterion("EndTime between", value1, value2, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeNotBetween(Date value1, Date value2) {
			addCriterion("EndTime not between", value1, value2, "endtime");
			return (Criteria) this;
		}

		public Criteria andSchedulenameIsNull() {
			addCriterion("ScheduleName is null");
			return (Criteria) this;
		}

		public Criteria andSchedulenameIsNotNull() {
			addCriterion("ScheduleName is not null");
			return (Criteria) this;
		}

		public Criteria andSchedulenameEqualTo(String value) {
			addCriterion("ScheduleName =", value, "schedulename");
			return (Criteria) this;
		}

		public Criteria andSchedulenameNotEqualTo(String value) {
			addCriterion("ScheduleName <>", value, "schedulename");
			return (Criteria) this;
		}

		public Criteria andSchedulenameGreaterThan(String value) {
			addCriterion("ScheduleName >", value, "schedulename");
			return (Criteria) this;
		}

		public Criteria andSchedulenameGreaterThanOrEqualTo(String value) {
			addCriterion("ScheduleName >=", value, "schedulename");
			return (Criteria) this;
		}

		public Criteria andSchedulenameLessThan(String value) {
			addCriterion("ScheduleName <", value, "schedulename");
			return (Criteria) this;
		}

		public Criteria andSchedulenameLessThanOrEqualTo(String value) {
			addCriterion("ScheduleName <=", value, "schedulename");
			return (Criteria) this;
		}

		public Criteria andSchedulenameIn(List<String> values) {
			addCriterion("ScheduleName in", values, "schedulename");
			return (Criteria) this;
		}

		public Criteria andSchedulenameNotIn(List<String> values) {
			addCriterion("ScheduleName not in", values, "schedulename");
			return (Criteria) this;
		}

		public Criteria andSchedulenameBetween(String value1, String value2) {
			addCriterion("ScheduleName between", value1, value2, "schedulename");
			return (Criteria) this;
		}

		public Criteria andSchedulenameNotBetween(String value1, String value2) {
			addCriterion("ScheduleName not between", value1, value2,
					"schedulename");
			return (Criteria) this;
		}

		public Criteria andSchedulevehiclenoIsNull() {
			addCriterion("ScheduleVehicleNo is null");
			return (Criteria) this;
		}

		public Criteria andSchedulevehiclenoIsNotNull() {
			addCriterion("ScheduleVehicleNo is not null");
			return (Criteria) this;
		}

		public Criteria andSchedulevehiclenoEqualTo(String value) {
			addCriterion("ScheduleVehicleNo =", value, "schedulevehicleno");
			return (Criteria) this;
		}

		public Criteria andSchedulevehiclenoNotEqualTo(String value) {
			addCriterion("ScheduleVehicleNo <>", value, "schedulevehicleno");
			return (Criteria) this;
		}

		public Criteria andSchedulevehiclenoGreaterThan(String value) {
			addCriterion("ScheduleVehicleNo >", value, "schedulevehicleno");
			return (Criteria) this;
		}

		public Criteria andSchedulevehiclenoGreaterThanOrEqualTo(String value) {
			addCriterion("ScheduleVehicleNo >=", value, "schedulevehicleno");
			return (Criteria) this;
		}

		public Criteria andSchedulevehiclenoLessThan(String value) {
			addCriterion("ScheduleVehicleNo <", value, "schedulevehicleno");
			return (Criteria) this;
		}

		public Criteria andSchedulevehiclenoLessThanOrEqualTo(String value) {
			addCriterion("ScheduleVehicleNo <=", value, "schedulevehicleno");
			return (Criteria) this;
		}

		public Criteria andSchedulevehiclenoIn(List<String> values) {
			addCriterion("ScheduleVehicleNo in", values, "schedulevehicleno");
			return (Criteria) this;
		}

		public Criteria andSchedulevehiclenoNotIn(List<String> values) {
			addCriterion("ScheduleVehicleNo not in", values,
					"schedulevehicleno");
			return (Criteria) this;
		}

		public Criteria andSchedulevehiclenoBetween(String value1, String value2) {
			addCriterion("ScheduleVehicleNo between", value1, value2,
					"schedulevehicleno");
			return (Criteria) this;
		}

		public Criteria andSchedulevehiclenoNotBetween(String value1,
				String value2) {
			addCriterion("ScheduleVehicleNo not between", value1, value2,
					"schedulevehicleno");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table RouteSchedule
	 * @mbggenerated  Mon Mar 03 15:59:33 CST 2014
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
     * This class corresponds to the database table RouteSchedule
     *
     * @mbggenerated do_not_delete_during_merge Sun Mar 02 22:36:18 CST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}