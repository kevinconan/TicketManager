package kevin.tm.model;

import java.util.ArrayList;
import java.util.List;

public class StationBeanExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Station
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Station
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Station
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Station
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    public StationBeanExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Station
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Station
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Station
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Station
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Station
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Station
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Station
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Station
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Station
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Station
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table Station
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
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

        public Criteria andStationidIsNull() {
            addCriterion("StationId is null");
            return (Criteria) this;
        }

        public Criteria andStationidIsNotNull() {
            addCriterion("StationId is not null");
            return (Criteria) this;
        }

        public Criteria andStationidEqualTo(Integer value) {
            addCriterion("StationId =", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidNotEqualTo(Integer value) {
            addCriterion("StationId <>", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidGreaterThan(Integer value) {
            addCriterion("StationId >", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidGreaterThanOrEqualTo(Integer value) {
            addCriterion("StationId >=", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidLessThan(Integer value) {
            addCriterion("StationId <", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidLessThanOrEqualTo(Integer value) {
            addCriterion("StationId <=", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidIn(List<Integer> values) {
            addCriterion("StationId in", values, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidNotIn(List<Integer> values) {
            addCriterion("StationId not in", values, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidBetween(Integer value1, Integer value2) {
            addCriterion("StationId between", value1, value2, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidNotBetween(Integer value1, Integer value2) {
            addCriterion("StationId not between", value1, value2, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationnameIsNull() {
            addCriterion("StationName is null");
            return (Criteria) this;
        }

        public Criteria andStationnameIsNotNull() {
            addCriterion("StationName is not null");
            return (Criteria) this;
        }

        public Criteria andStationnameEqualTo(String value) {
            addCriterion("StationName =", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameNotEqualTo(String value) {
            addCriterion("StationName <>", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameGreaterThan(String value) {
            addCriterion("StationName >", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameGreaterThanOrEqualTo(String value) {
            addCriterion("StationName >=", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameLessThan(String value) {
            addCriterion("StationName <", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameLessThanOrEqualTo(String value) {
            addCriterion("StationName <=", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameIn(List<String> values) {
            addCriterion("StationName in", values, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameNotIn(List<String> values) {
            addCriterion("StationName not in", values, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameBetween(String value1, String value2) {
            addCriterion("StationName between", value1, value2, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameNotBetween(String value1, String value2) {
            addCriterion("StationName not between", value1, value2, "stationname");
            return (Criteria) this;
        }

        public Criteria andLocationxIsNull() {
            addCriterion("LocationX is null");
            return (Criteria) this;
        }

        public Criteria andLocationxIsNotNull() {
            addCriterion("LocationX is not null");
            return (Criteria) this;
        }

        public Criteria andLocationxEqualTo(Double value) {
            addCriterion("LocationX =", value, "locationx");
            return (Criteria) this;
        }

        public Criteria andLocationxNotEqualTo(Double value) {
            addCriterion("LocationX <>", value, "locationx");
            return (Criteria) this;
        }

        public Criteria andLocationxGreaterThan(Double value) {
            addCriterion("LocationX >", value, "locationx");
            return (Criteria) this;
        }

        public Criteria andLocationxGreaterThanOrEqualTo(Double value) {
            addCriterion("LocationX >=", value, "locationx");
            return (Criteria) this;
        }

        public Criteria andLocationxLessThan(Double value) {
            addCriterion("LocationX <", value, "locationx");
            return (Criteria) this;
        }

        public Criteria andLocationxLessThanOrEqualTo(Double value) {
            addCriterion("LocationX <=", value, "locationx");
            return (Criteria) this;
        }

        public Criteria andLocationxIn(List<Double> values) {
            addCriterion("LocationX in", values, "locationx");
            return (Criteria) this;
        }

        public Criteria andLocationxNotIn(List<Double> values) {
            addCriterion("LocationX not in", values, "locationx");
            return (Criteria) this;
        }

        public Criteria andLocationxBetween(Double value1, Double value2) {
            addCriterion("LocationX between", value1, value2, "locationx");
            return (Criteria) this;
        }

        public Criteria andLocationxNotBetween(Double value1, Double value2) {
            addCriterion("LocationX not between", value1, value2, "locationx");
            return (Criteria) this;
        }

        public Criteria andLocationyIsNull() {
            addCriterion("LocationY is null");
            return (Criteria) this;
        }

        public Criteria andLocationyIsNotNull() {
            addCriterion("LocationY is not null");
            return (Criteria) this;
        }

        public Criteria andLocationyEqualTo(Double value) {
            addCriterion("LocationY =", value, "locationy");
            return (Criteria) this;
        }

        public Criteria andLocationyNotEqualTo(Double value) {
            addCriterion("LocationY <>", value, "locationy");
            return (Criteria) this;
        }

        public Criteria andLocationyGreaterThan(Double value) {
            addCriterion("LocationY >", value, "locationy");
            return (Criteria) this;
        }

        public Criteria andLocationyGreaterThanOrEqualTo(Double value) {
            addCriterion("LocationY >=", value, "locationy");
            return (Criteria) this;
        }

        public Criteria andLocationyLessThan(Double value) {
            addCriterion("LocationY <", value, "locationy");
            return (Criteria) this;
        }

        public Criteria andLocationyLessThanOrEqualTo(Double value) {
            addCriterion("LocationY <=", value, "locationy");
            return (Criteria) this;
        }

        public Criteria andLocationyIn(List<Double> values) {
            addCriterion("LocationY in", values, "locationy");
            return (Criteria) this;
        }

        public Criteria andLocationyNotIn(List<Double> values) {
            addCriterion("LocationY not in", values, "locationy");
            return (Criteria) this;
        }

        public Criteria andLocationyBetween(Double value1, Double value2) {
            addCriterion("LocationY between", value1, value2, "locationy");
            return (Criteria) this;
        }

        public Criteria andLocationyNotBetween(Double value1, Double value2) {
            addCriterion("LocationY not between", value1, value2, "locationy");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table Station
     *
     * @mbggenerated do_not_delete_during_merge Mon Mar 03 17:06:52 CST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table Station
     *
     * @mbggenerated Mon Mar 03 17:06:52 CST 2014
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
}