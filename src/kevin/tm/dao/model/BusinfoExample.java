package kevin.tm.dao.model;

import java.util.ArrayList;
import java.util.List;

public class BusinfoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table businfo
     *
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table businfo
     *
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table businfo
     *
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table businfo
     *
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    public BusinfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table businfo
     *
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table businfo
     *
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table businfo
     *
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table businfo
     *
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table businfo
     *
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table businfo
     *
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table businfo
     *
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table businfo
     *
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
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
     * This method corresponds to the database table businfo
     *
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table businfo
     *
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table businfo
     *
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
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

        public Criteria andBusidIsNull() {
            addCriterion("busid is null");
            return (Criteria) this;
        }

        public Criteria andBusidIsNotNull() {
            addCriterion("busid is not null");
            return (Criteria) this;
        }

        public Criteria andBusidEqualTo(Integer value) {
            addCriterion("busid =", value, "busid");
            return (Criteria) this;
        }

        public Criteria andBusidNotEqualTo(Integer value) {
            addCriterion("busid <>", value, "busid");
            return (Criteria) this;
        }

        public Criteria andBusidGreaterThan(Integer value) {
            addCriterion("busid >", value, "busid");
            return (Criteria) this;
        }

        public Criteria andBusidGreaterThanOrEqualTo(Integer value) {
            addCriterion("busid >=", value, "busid");
            return (Criteria) this;
        }

        public Criteria andBusidLessThan(Integer value) {
            addCriterion("busid <", value, "busid");
            return (Criteria) this;
        }

        public Criteria andBusidLessThanOrEqualTo(Integer value) {
            addCriterion("busid <=", value, "busid");
            return (Criteria) this;
        }

        public Criteria andBusidIn(List<Integer> values) {
            addCriterion("busid in", values, "busid");
            return (Criteria) this;
        }

        public Criteria andBusidNotIn(List<Integer> values) {
            addCriterion("busid not in", values, "busid");
            return (Criteria) this;
        }

        public Criteria andBusidBetween(Integer value1, Integer value2) {
            addCriterion("busid between", value1, value2, "busid");
            return (Criteria) this;
        }

        public Criteria andBusidNotBetween(Integer value1, Integer value2) {
            addCriterion("busid not between", value1, value2, "busid");
            return (Criteria) this;
        }

        public Criteria andVehiclenoIsNull() {
            addCriterion("vehicleno is null");
            return (Criteria) this;
        }

        public Criteria andVehiclenoIsNotNull() {
            addCriterion("vehicleno is not null");
            return (Criteria) this;
        }

        public Criteria andVehiclenoEqualTo(String value) {
            addCriterion("vehicleno =", value, "vehicleno");
            return (Criteria) this;
        }

        public Criteria andVehiclenoNotEqualTo(String value) {
            addCriterion("vehicleno <>", value, "vehicleno");
            return (Criteria) this;
        }

        public Criteria andVehiclenoGreaterThan(String value) {
            addCriterion("vehicleno >", value, "vehicleno");
            return (Criteria) this;
        }

        public Criteria andVehiclenoGreaterThanOrEqualTo(String value) {
            addCriterion("vehicleno >=", value, "vehicleno");
            return (Criteria) this;
        }

        public Criteria andVehiclenoLessThan(String value) {
            addCriterion("vehicleno <", value, "vehicleno");
            return (Criteria) this;
        }

        public Criteria andVehiclenoLessThanOrEqualTo(String value) {
            addCriterion("vehicleno <=", value, "vehicleno");
            return (Criteria) this;
        }

        public Criteria andVehiclenoLike(String value) {
            addCriterion("vehicleno like", value, "vehicleno");
            return (Criteria) this;
        }

        public Criteria andVehiclenoNotLike(String value) {
            addCriterion("vehicleno not like", value, "vehicleno");
            return (Criteria) this;
        }

        public Criteria andVehiclenoIn(List<String> values) {
            addCriterion("vehicleno in", values, "vehicleno");
            return (Criteria) this;
        }

        public Criteria andVehiclenoNotIn(List<String> values) {
            addCriterion("vehicleno not in", values, "vehicleno");
            return (Criteria) this;
        }

        public Criteria andVehiclenoBetween(String value1, String value2) {
            addCriterion("vehicleno between", value1, value2, "vehicleno");
            return (Criteria) this;
        }

        public Criteria andVehiclenoNotBetween(String value1, String value2) {
            addCriterion("vehicleno not between", value1, value2, "vehicleno");
            return (Criteria) this;
        }

        public Criteria andDrivernameIsNull() {
            addCriterion("drivername is null");
            return (Criteria) this;
        }

        public Criteria andDrivernameIsNotNull() {
            addCriterion("drivername is not null");
            return (Criteria) this;
        }

        public Criteria andDrivernameEqualTo(String value) {
            addCriterion("drivername =", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameNotEqualTo(String value) {
            addCriterion("drivername <>", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameGreaterThan(String value) {
            addCriterion("drivername >", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameGreaterThanOrEqualTo(String value) {
            addCriterion("drivername >=", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameLessThan(String value) {
            addCriterion("drivername <", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameLessThanOrEqualTo(String value) {
            addCriterion("drivername <=", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameLike(String value) {
            addCriterion("drivername like", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameNotLike(String value) {
            addCriterion("drivername not like", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameIn(List<String> values) {
            addCriterion("drivername in", values, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameNotIn(List<String> values) {
            addCriterion("drivername not in", values, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameBetween(String value1, String value2) {
            addCriterion("drivername between", value1, value2, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameNotBetween(String value1, String value2) {
            addCriterion("drivername not between", value1, value2, "drivername");
            return (Criteria) this;
        }

        public Criteria andSeatcountIsNull() {
            addCriterion("seatcount is null");
            return (Criteria) this;
        }

        public Criteria andSeatcountIsNotNull() {
            addCriterion("seatcount is not null");
            return (Criteria) this;
        }

        public Criteria andSeatcountEqualTo(Integer value) {
            addCriterion("seatcount =", value, "seatcount");
            return (Criteria) this;
        }

        public Criteria andSeatcountNotEqualTo(Integer value) {
            addCriterion("seatcount <>", value, "seatcount");
            return (Criteria) this;
        }

        public Criteria andSeatcountGreaterThan(Integer value) {
            addCriterion("seatcount >", value, "seatcount");
            return (Criteria) this;
        }

        public Criteria andSeatcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("seatcount >=", value, "seatcount");
            return (Criteria) this;
        }

        public Criteria andSeatcountLessThan(Integer value) {
            addCriterion("seatcount <", value, "seatcount");
            return (Criteria) this;
        }

        public Criteria andSeatcountLessThanOrEqualTo(Integer value) {
            addCriterion("seatcount <=", value, "seatcount");
            return (Criteria) this;
        }

        public Criteria andSeatcountIn(List<Integer> values) {
            addCriterion("seatcount in", values, "seatcount");
            return (Criteria) this;
        }

        public Criteria andSeatcountNotIn(List<Integer> values) {
            addCriterion("seatcount not in", values, "seatcount");
            return (Criteria) this;
        }

        public Criteria andSeatcountBetween(Integer value1, Integer value2) {
            addCriterion("seatcount between", value1, value2, "seatcount");
            return (Criteria) this;
        }

        public Criteria andSeatcountNotBetween(Integer value1, Integer value2) {
            addCriterion("seatcount not between", value1, value2, "seatcount");
            return (Criteria) this;
        }

        public Criteria andBusstationidIsNull() {
            addCriterion("busstationid is null");
            return (Criteria) this;
        }

        public Criteria andBusstationidIsNotNull() {
            addCriterion("busstationid is not null");
            return (Criteria) this;
        }

        public Criteria andBusstationidEqualTo(Integer value) {
            addCriterion("busstationid =", value, "busstationid");
            return (Criteria) this;
        }

        public Criteria andBusstationidNotEqualTo(Integer value) {
            addCriterion("busstationid <>", value, "busstationid");
            return (Criteria) this;
        }

        public Criteria andBusstationidGreaterThan(Integer value) {
            addCriterion("busstationid >", value, "busstationid");
            return (Criteria) this;
        }

        public Criteria andBusstationidGreaterThanOrEqualTo(Integer value) {
            addCriterion("busstationid >=", value, "busstationid");
            return (Criteria) this;
        }

        public Criteria andBusstationidLessThan(Integer value) {
            addCriterion("busstationid <", value, "busstationid");
            return (Criteria) this;
        }

        public Criteria andBusstationidLessThanOrEqualTo(Integer value) {
            addCriterion("busstationid <=", value, "busstationid");
            return (Criteria) this;
        }

        public Criteria andBusstationidIn(List<Integer> values) {
            addCriterion("busstationid in", values, "busstationid");
            return (Criteria) this;
        }

        public Criteria andBusstationidNotIn(List<Integer> values) {
            addCriterion("busstationid not in", values, "busstationid");
            return (Criteria) this;
        }

        public Criteria andBusstationidBetween(Integer value1, Integer value2) {
            addCriterion("busstationid between", value1, value2, "busstationid");
            return (Criteria) this;
        }

        public Criteria andBusstationidNotBetween(Integer value1, Integer value2) {
            addCriterion("busstationid not between", value1, value2, "busstationid");
            return (Criteria) this;
        }

        public Criteria andBusstateIsNull() {
            addCriterion("busstate is null");
            return (Criteria) this;
        }

        public Criteria andBusstateIsNotNull() {
            addCriterion("busstate is not null");
            return (Criteria) this;
        }

        public Criteria andBusstateEqualTo(Integer value) {
            addCriterion("busstate =", value, "busstate");
            return (Criteria) this;
        }

        public Criteria andBusstateNotEqualTo(Integer value) {
            addCriterion("busstate <>", value, "busstate");
            return (Criteria) this;
        }

        public Criteria andBusstateGreaterThan(Integer value) {
            addCriterion("busstate >", value, "busstate");
            return (Criteria) this;
        }

        public Criteria andBusstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("busstate >=", value, "busstate");
            return (Criteria) this;
        }

        public Criteria andBusstateLessThan(Integer value) {
            addCriterion("busstate <", value, "busstate");
            return (Criteria) this;
        }

        public Criteria andBusstateLessThanOrEqualTo(Integer value) {
            addCriterion("busstate <=", value, "busstate");
            return (Criteria) this;
        }

        public Criteria andBusstateIn(List<Integer> values) {
            addCriterion("busstate in", values, "busstate");
            return (Criteria) this;
        }

        public Criteria andBusstateNotIn(List<Integer> values) {
            addCriterion("busstate not in", values, "busstate");
            return (Criteria) this;
        }

        public Criteria andBusstateBetween(Integer value1, Integer value2) {
            addCriterion("busstate between", value1, value2, "busstate");
            return (Criteria) this;
        }

        public Criteria andBusstateNotBetween(Integer value1, Integer value2) {
            addCriterion("busstate not between", value1, value2, "busstate");
            return (Criteria) this;
        }

        public Criteria andStationnameIsNull() {
            addCriterion("stationname is null");
            return (Criteria) this;
        }

        public Criteria andStationnameIsNotNull() {
            addCriterion("stationname is not null");
            return (Criteria) this;
        }

        public Criteria andStationnameEqualTo(String value) {
            addCriterion("stationname =", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameNotEqualTo(String value) {
            addCriterion("stationname <>", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameGreaterThan(String value) {
            addCriterion("stationname >", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameGreaterThanOrEqualTo(String value) {
            addCriterion("stationname >=", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameLessThan(String value) {
            addCriterion("stationname <", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameLessThanOrEqualTo(String value) {
            addCriterion("stationname <=", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameLike(String value) {
            addCriterion("stationname like", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameNotLike(String value) {
            addCriterion("stationname not like", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameIn(List<String> values) {
            addCriterion("stationname in", values, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameNotIn(List<String> values) {
            addCriterion("stationname not in", values, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameBetween(String value1, String value2) {
            addCriterion("stationname between", value1, value2, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameNotBetween(String value1, String value2) {
            addCriterion("stationname not between", value1, value2, "stationname");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table businfo
     *
     * @mbggenerated do_not_delete_during_merge Tue Mar 11 14:47:47 CST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table businfo
     *
     * @mbggenerated Tue Mar 11 14:47:47 CST 2014
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