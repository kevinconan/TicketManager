package kevin.tm.model;

import java.util.ArrayList;
import java.util.List;

public class AdminBeanExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    public AdminBeanExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
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
     * This method corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
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

        public Criteria andLoginidIsNull() {
            addCriterion("LoginId is null");
            return (Criteria) this;
        }

        public Criteria andLoginidIsNotNull() {
            addCriterion("LoginId is not null");
            return (Criteria) this;
        }

        public Criteria andLoginidEqualTo(String value) {
            addCriterion("LoginId =", value, "loginid");
            return (Criteria) this;
        }

        public Criteria andLoginidNotEqualTo(String value) {
            addCriterion("LoginId <>", value, "loginid");
            return (Criteria) this;
        }

        public Criteria andLoginidGreaterThan(String value) {
            addCriterion("LoginId >", value, "loginid");
            return (Criteria) this;
        }

        public Criteria andLoginidGreaterThanOrEqualTo(String value) {
            addCriterion("LoginId >=", value, "loginid");
            return (Criteria) this;
        }

        public Criteria andLoginidLessThan(String value) {
            addCriterion("LoginId <", value, "loginid");
            return (Criteria) this;
        }

        public Criteria andLoginidLessThanOrEqualTo(String value) {
            addCriterion("LoginId <=", value, "loginid");
            return (Criteria) this;
        }

        public Criteria andLoginidLike(String value) {
            addCriterion("LoginId like", value, "loginid");
            return (Criteria) this;
        }

        public Criteria andLoginidNotLike(String value) {
            addCriterion("LoginId not like", value, "loginid");
            return (Criteria) this;
        }

        public Criteria andLoginidIn(List<String> values) {
            addCriterion("LoginId in", values, "loginid");
            return (Criteria) this;
        }

        public Criteria andLoginidNotIn(List<String> values) {
            addCriterion("LoginId not in", values, "loginid");
            return (Criteria) this;
        }

        public Criteria andLoginidBetween(String value1, String value2) {
            addCriterion("LoginId between", value1, value2, "loginid");
            return (Criteria) this;
        }

        public Criteria andLoginidNotBetween(String value1, String value2) {
            addCriterion("LoginId not between", value1, value2, "loginid");
            return (Criteria) this;
        }

        public Criteria andLoginpwdIsNull() {
            addCriterion("LoginPwd is null");
            return (Criteria) this;
        }

        public Criteria andLoginpwdIsNotNull() {
            addCriterion("LoginPwd is not null");
            return (Criteria) this;
        }

        public Criteria andLoginpwdEqualTo(String value) {
            addCriterion("LoginPwd =", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdNotEqualTo(String value) {
            addCriterion("LoginPwd <>", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdGreaterThan(String value) {
            addCriterion("LoginPwd >", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdGreaterThanOrEqualTo(String value) {
            addCriterion("LoginPwd >=", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdLessThan(String value) {
            addCriterion("LoginPwd <", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdLessThanOrEqualTo(String value) {
            addCriterion("LoginPwd <=", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdLike(String value) {
            addCriterion("LoginPwd like", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdNotLike(String value) {
            addCriterion("LoginPwd not like", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdIn(List<String> values) {
            addCriterion("LoginPwd in", values, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdNotIn(List<String> values) {
            addCriterion("LoginPwd not in", values, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdBetween(String value1, String value2) {
            addCriterion("LoginPwd between", value1, value2, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdNotBetween(String value1, String value2) {
            addCriterion("LoginPwd not between", value1, value2, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andAdminnameIsNull() {
            addCriterion("AdminName is null");
            return (Criteria) this;
        }

        public Criteria andAdminnameIsNotNull() {
            addCriterion("AdminName is not null");
            return (Criteria) this;
        }

        public Criteria andAdminnameEqualTo(String value) {
            addCriterion("AdminName =", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameNotEqualTo(String value) {
            addCriterion("AdminName <>", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameGreaterThan(String value) {
            addCriterion("AdminName >", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameGreaterThanOrEqualTo(String value) {
            addCriterion("AdminName >=", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameLessThan(String value) {
            addCriterion("AdminName <", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameLessThanOrEqualTo(String value) {
            addCriterion("AdminName <=", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameIn(List<String> values) {
            addCriterion("AdminName in", values, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameNotIn(List<String> values) {
            addCriterion("AdminName not in", values, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameBetween(String value1, String value2) {
            addCriterion("AdminName between", value1, value2, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameNotBetween(String value1, String value2) {
            addCriterion("AdminName not between", value1, value2, "adminname");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table Admin
     *
     * @mbggenerated do_not_delete_during_merge Sun Mar 02 22:36:18 CST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table Admin
     *
     * @mbggenerated Sun Mar 02 22:36:18 CST 2014
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