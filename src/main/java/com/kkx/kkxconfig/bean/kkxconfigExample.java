package com.kkx.kkxconfig.bean;

import java.util.ArrayList;
import java.util.List;

public class kkxconfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public kkxconfigExample() {
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

        public Criteria andConfigidIsNull() {
            addCriterion("CONFIGID is null");
            return (Criteria) this;
        }

        public Criteria andConfigidIsNotNull() {
            addCriterion("CONFIGID is not null");
            return (Criteria) this;
        }

        public Criteria andConfigidEqualTo(Long value) {
            addCriterion("CONFIGID =", value, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidNotEqualTo(Long value) {
            addCriterion("CONFIGID <>", value, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidGreaterThan(Long value) {
            addCriterion("CONFIGID >", value, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidGreaterThanOrEqualTo(Long value) {
            addCriterion("CONFIGID >=", value, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidLessThan(Long value) {
            addCriterion("CONFIGID <", value, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidLessThanOrEqualTo(Long value) {
            addCriterion("CONFIGID <=", value, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidIn(List<Long> values) {
            addCriterion("CONFIGID in", values, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidNotIn(List<Long> values) {
            addCriterion("CONFIGID not in", values, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidBetween(Long value1, Long value2) {
            addCriterion("CONFIGID between", value1, value2, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidNotBetween(Long value1, Long value2) {
            addCriterion("CONFIGID not between", value1, value2, "configid");
            return (Criteria) this;
        }

        public Criteria andConfignameIsNull() {
            addCriterion("CONFIGNAME is null");
            return (Criteria) this;
        }

        public Criteria andConfignameIsNotNull() {
            addCriterion("CONFIGNAME is not null");
            return (Criteria) this;
        }

        public Criteria andConfignameEqualTo(String value) {
            addCriterion("CONFIGNAME =", value, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameNotEqualTo(String value) {
            addCriterion("CONFIGNAME <>", value, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameGreaterThan(String value) {
            addCriterion("CONFIGNAME >", value, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameGreaterThanOrEqualTo(String value) {
            addCriterion("CONFIGNAME >=", value, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameLessThan(String value) {
            addCriterion("CONFIGNAME <", value, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameLessThanOrEqualTo(String value) {
            addCriterion("CONFIGNAME <=", value, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameLike(String value) {
            addCriterion("CONFIGNAME like", value, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameNotLike(String value) {
            addCriterion("CONFIGNAME not like", value, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameIn(List<String> values) {
            addCriterion("CONFIGNAME in", values, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameNotIn(List<String> values) {
            addCriterion("CONFIGNAME not in", values, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameBetween(String value1, String value2) {
            addCriterion("CONFIGNAME between", value1, value2, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameNotBetween(String value1, String value2) {
            addCriterion("CONFIGNAME not between", value1, value2, "configname");
            return (Criteria) this;
        }

        public Criteria andConfigvalueIsNull() {
            addCriterion("CONFIGVALUE is null");
            return (Criteria) this;
        }

        public Criteria andConfigvalueIsNotNull() {
            addCriterion("CONFIGVALUE is not null");
            return (Criteria) this;
        }

        public Criteria andConfigvalueEqualTo(String value) {
            addCriterion("CONFIGVALUE =", value, "configvalue");
            return (Criteria) this;
        }

        public Criteria andConfigvalueNotEqualTo(String value) {
            addCriterion("CONFIGVALUE <>", value, "configvalue");
            return (Criteria) this;
        }

        public Criteria andConfigvalueGreaterThan(String value) {
            addCriterion("CONFIGVALUE >", value, "configvalue");
            return (Criteria) this;
        }

        public Criteria andConfigvalueGreaterThanOrEqualTo(String value) {
            addCriterion("CONFIGVALUE >=", value, "configvalue");
            return (Criteria) this;
        }

        public Criteria andConfigvalueLessThan(String value) {
            addCriterion("CONFIGVALUE <", value, "configvalue");
            return (Criteria) this;
        }

        public Criteria andConfigvalueLessThanOrEqualTo(String value) {
            addCriterion("CONFIGVALUE <=", value, "configvalue");
            return (Criteria) this;
        }

        public Criteria andConfigvalueLike(String value) {
            addCriterion("CONFIGVALUE like", value, "configvalue");
            return (Criteria) this;
        }

        public Criteria andConfigvalueNotLike(String value) {
            addCriterion("CONFIGVALUE not like", value, "configvalue");
            return (Criteria) this;
        }

        public Criteria andConfigvalueIn(List<String> values) {
            addCriterion("CONFIGVALUE in", values, "configvalue");
            return (Criteria) this;
        }

        public Criteria andConfigvalueNotIn(List<String> values) {
            addCriterion("CONFIGVALUE not in", values, "configvalue");
            return (Criteria) this;
        }

        public Criteria andConfigvalueBetween(String value1, String value2) {
            addCriterion("CONFIGVALUE between", value1, value2, "configvalue");
            return (Criteria) this;
        }

        public Criteria andConfigvalueNotBetween(String value1, String value2) {
            addCriterion("CONFIGVALUE not between", value1, value2, "configvalue");
            return (Criteria) this;
        }

        public Criteria andConfigdescIsNull() {
            addCriterion("CONFIGDESC is null");
            return (Criteria) this;
        }

        public Criteria andConfigdescIsNotNull() {
            addCriterion("CONFIGDESC is not null");
            return (Criteria) this;
        }

        public Criteria andConfigdescEqualTo(String value) {
            addCriterion("CONFIGDESC =", value, "configdesc");
            return (Criteria) this;
        }

        public Criteria andConfigdescNotEqualTo(String value) {
            addCriterion("CONFIGDESC <>", value, "configdesc");
            return (Criteria) this;
        }

        public Criteria andConfigdescGreaterThan(String value) {
            addCriterion("CONFIGDESC >", value, "configdesc");
            return (Criteria) this;
        }

        public Criteria andConfigdescGreaterThanOrEqualTo(String value) {
            addCriterion("CONFIGDESC >=", value, "configdesc");
            return (Criteria) this;
        }

        public Criteria andConfigdescLessThan(String value) {
            addCriterion("CONFIGDESC <", value, "configdesc");
            return (Criteria) this;
        }

        public Criteria andConfigdescLessThanOrEqualTo(String value) {
            addCriterion("CONFIGDESC <=", value, "configdesc");
            return (Criteria) this;
        }

        public Criteria andConfigdescLike(String value) {
            addCriterion("CONFIGDESC like", value, "configdesc");
            return (Criteria) this;
        }

        public Criteria andConfigdescNotLike(String value) {
            addCriterion("CONFIGDESC not like", value, "configdesc");
            return (Criteria) this;
        }

        public Criteria andConfigdescIn(List<String> values) {
            addCriterion("CONFIGDESC in", values, "configdesc");
            return (Criteria) this;
        }

        public Criteria andConfigdescNotIn(List<String> values) {
            addCriterion("CONFIGDESC not in", values, "configdesc");
            return (Criteria) this;
        }

        public Criteria andConfigdescBetween(String value1, String value2) {
            addCriterion("CONFIGDESC between", value1, value2, "configdesc");
            return (Criteria) this;
        }

        public Criteria andConfigdescNotBetween(String value1, String value2) {
            addCriterion("CONFIGDESC not between", value1, value2, "configdesc");
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