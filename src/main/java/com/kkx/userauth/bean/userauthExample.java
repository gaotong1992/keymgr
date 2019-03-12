package com.kkx.userauth.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class userauthExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public userauthExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andUserauthidIsNull() {
            addCriterion("USERAUTHID is null");
            return (Criteria) this;
        }

        public Criteria andUserauthidIsNotNull() {
            addCriterion("USERAUTHID is not null");
            return (Criteria) this;
        }

        public Criteria andUserauthidEqualTo(Long value) {
            addCriterion("USERAUTHID =", value, "userauthid");
            return (Criteria) this;
        }

        public Criteria andUserauthidNotEqualTo(Long value) {
            addCriterion("USERAUTHID <>", value, "userauthid");
            return (Criteria) this;
        }

        public Criteria andUserauthidGreaterThan(Long value) {
            addCriterion("USERAUTHID >", value, "userauthid");
            return (Criteria) this;
        }

        public Criteria andUserauthidGreaterThanOrEqualTo(Long value) {
            addCriterion("USERAUTHID >=", value, "userauthid");
            return (Criteria) this;
        }

        public Criteria andUserauthidLessThan(Long value) {
            addCriterion("USERAUTHID <", value, "userauthid");
            return (Criteria) this;
        }

        public Criteria andUserauthidLessThanOrEqualTo(Long value) {
            addCriterion("USERAUTHID <=", value, "userauthid");
            return (Criteria) this;
        }

        public Criteria andUserauthidIn(List<Long> values) {
            addCriterion("USERAUTHID in", values, "userauthid");
            return (Criteria) this;
        }

        public Criteria andUserauthidNotIn(List<Long> values) {
            addCriterion("USERAUTHID not in", values, "userauthid");
            return (Criteria) this;
        }

        public Criteria andUserauthidBetween(Long value1, Long value2) {
            addCriterion("USERAUTHID between", value1, value2, "userauthid");
            return (Criteria) this;
        }

        public Criteria andUserauthidNotBetween(Long value1, Long value2) {
            addCriterion("USERAUTHID not between", value1, value2, "userauthid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("USERID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("USERID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Long value) {
            addCriterion("USERID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Long value) {
            addCriterion("USERID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Long value) {
            addCriterion("USERID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("USERID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Long value) {
            addCriterion("USERID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Long value) {
            addCriterion("USERID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Long> values) {
            addCriterion("USERID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Long> values) {
            addCriterion("USERID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Long value1, Long value2) {
            addCriterion("USERID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Long value1, Long value2) {
            addCriterion("USERID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andAuthidIsNull() {
            addCriterion("AUTHID is null");
            return (Criteria) this;
        }

        public Criteria andAuthidIsNotNull() {
            addCriterion("AUTHID is not null");
            return (Criteria) this;
        }

        public Criteria andAuthidEqualTo(Integer value) {
            addCriterion("AUTHID =", value, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidNotEqualTo(Integer value) {
            addCriterion("AUTHID <>", value, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidGreaterThan(Integer value) {
            addCriterion("AUTHID >", value, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidGreaterThanOrEqualTo(Integer value) {
            addCriterion("AUTHID >=", value, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidLessThan(Integer value) {
            addCriterion("AUTHID <", value, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidLessThanOrEqualTo(Integer value) {
            addCriterion("AUTHID <=", value, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidIn(List<Integer> values) {
            addCriterion("AUTHID in", values, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidNotIn(List<Integer> values) {
            addCriterion("AUTHID not in", values, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidBetween(Integer value1, Integer value2) {
            addCriterion("AUTHID between", value1, value2, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthidNotBetween(Integer value1, Integer value2) {
            addCriterion("AUTHID not between", value1, value2, "authid");
            return (Criteria) this;
        }

        public Criteria andAuthtypeIsNull() {
            addCriterion("AUTHTYPE is null");
            return (Criteria) this;
        }

        public Criteria andAuthtypeIsNotNull() {
            addCriterion("AUTHTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAuthtypeEqualTo(Integer value) {
            addCriterion("AUTHTYPE =", value, "authtype");
            return (Criteria) this;
        }

        public Criteria andAuthtypeNotEqualTo(Integer value) {
            addCriterion("AUTHTYPE <>", value, "authtype");
            return (Criteria) this;
        }

        public Criteria andAuthtypeGreaterThan(Integer value) {
            addCriterion("AUTHTYPE >", value, "authtype");
            return (Criteria) this;
        }

        public Criteria andAuthtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("AUTHTYPE >=", value, "authtype");
            return (Criteria) this;
        }

        public Criteria andAuthtypeLessThan(Integer value) {
            addCriterion("AUTHTYPE <", value, "authtype");
            return (Criteria) this;
        }

        public Criteria andAuthtypeLessThanOrEqualTo(Integer value) {
            addCriterion("AUTHTYPE <=", value, "authtype");
            return (Criteria) this;
        }

        public Criteria andAuthtypeIn(List<Integer> values) {
            addCriterion("AUTHTYPE in", values, "authtype");
            return (Criteria) this;
        }

        public Criteria andAuthtypeNotIn(List<Integer> values) {
            addCriterion("AUTHTYPE not in", values, "authtype");
            return (Criteria) this;
        }

        public Criteria andAuthtypeBetween(Integer value1, Integer value2) {
            addCriterion("AUTHTYPE between", value1, value2, "authtype");
            return (Criteria) this;
        }

        public Criteria andAuthtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("AUTHTYPE not between", value1, value2, "authtype");
            return (Criteria) this;
        }

        public Criteria andCrtimeIsNull() {
            addCriterion("CRTIME is null");
            return (Criteria) this;
        }

        public Criteria andCrtimeIsNotNull() {
            addCriterion("CRTIME is not null");
            return (Criteria) this;
        }

        public Criteria andCrtimeEqualTo(Date value) {
            addCriterion("CRTIME =", value, "crtime");
            return (Criteria) this;
        }

        public Criteria andCrtimeNotEqualTo(Date value) {
            addCriterion("CRTIME <>", value, "crtime");
            return (Criteria) this;
        }

        public Criteria andCrtimeGreaterThan(Date value) {
            addCriterion("CRTIME >", value, "crtime");
            return (Criteria) this;
        }

        public Criteria andCrtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CRTIME >=", value, "crtime");
            return (Criteria) this;
        }

        public Criteria andCrtimeLessThan(Date value) {
            addCriterion("CRTIME <", value, "crtime");
            return (Criteria) this;
        }

        public Criteria andCrtimeLessThanOrEqualTo(Date value) {
            addCriterion("CRTIME <=", value, "crtime");
            return (Criteria) this;
        }

        public Criteria andCrtimeIn(List<Date> values) {
            addCriterion("CRTIME in", values, "crtime");
            return (Criteria) this;
        }

        public Criteria andCrtimeNotIn(List<Date> values) {
            addCriterion("CRTIME not in", values, "crtime");
            return (Criteria) this;
        }

        public Criteria andCrtimeBetween(Date value1, Date value2) {
            addCriterion("CRTIME between", value1, value2, "crtime");
            return (Criteria) this;
        }

        public Criteria andCrtimeNotBetween(Date value1, Date value2) {
            addCriterion("CRTIME not between", value1, value2, "crtime");
            return (Criteria) this;
        }

        public Criteria andCruseridIsNull() {
            addCriterion("CRUSERID is null");
            return (Criteria) this;
        }

        public Criteria andCruseridIsNotNull() {
            addCriterion("CRUSERID is not null");
            return (Criteria) this;
        }

        public Criteria andCruseridEqualTo(Long value) {
            addCriterion("CRUSERID =", value, "cruserid");
            return (Criteria) this;
        }

        public Criteria andCruseridNotEqualTo(Long value) {
            addCriterion("CRUSERID <>", value, "cruserid");
            return (Criteria) this;
        }

        public Criteria andCruseridGreaterThan(Long value) {
            addCriterion("CRUSERID >", value, "cruserid");
            return (Criteria) this;
        }

        public Criteria andCruseridGreaterThanOrEqualTo(Long value) {
            addCriterion("CRUSERID >=", value, "cruserid");
            return (Criteria) this;
        }

        public Criteria andCruseridLessThan(Long value) {
            addCriterion("CRUSERID <", value, "cruserid");
            return (Criteria) this;
        }

        public Criteria andCruseridLessThanOrEqualTo(Long value) {
            addCriterion("CRUSERID <=", value, "cruserid");
            return (Criteria) this;
        }

        public Criteria andCruseridIn(List<Long> values) {
            addCriterion("CRUSERID in", values, "cruserid");
            return (Criteria) this;
        }

        public Criteria andCruseridNotIn(List<Long> values) {
            addCriterion("CRUSERID not in", values, "cruserid");
            return (Criteria) this;
        }

        public Criteria andCruseridBetween(Long value1, Long value2) {
            addCriterion("CRUSERID between", value1, value2, "cruserid");
            return (Criteria) this;
        }

        public Criteria andCruseridNotBetween(Long value1, Long value2) {
            addCriterion("CRUSERID not between", value1, value2, "cruserid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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