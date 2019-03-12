package com.kkx.word.bean;

import java.util.ArrayList;
import java.util.List;

public class kkxwordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public kkxwordExample() {
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

        public Criteria andTableidIsNull() {
            addCriterion("TABLEID is null");
            return (Criteria) this;
        }

        public Criteria andTableidIsNotNull() {
            addCriterion("TABLEID is not null");
            return (Criteria) this;
        }

        public Criteria andTableidEqualTo(Long value) {
            addCriterion("TABLEID =", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidNotEqualTo(Long value) {
            addCriterion("TABLEID <>", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidGreaterThan(Long value) {
            addCriterion("TABLEID >", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidGreaterThanOrEqualTo(Long value) {
            addCriterion("TABLEID >=", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidLessThan(Long value) {
            addCriterion("TABLEID <", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidLessThanOrEqualTo(Long value) {
            addCriterion("TABLEID <=", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidIn(List<Long> values) {
            addCriterion("TABLEID in", values, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidNotIn(List<Long> values) {
            addCriterion("TABLEID not in", values, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidBetween(Long value1, Long value2) {
            addCriterion("TABLEID between", value1, value2, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidNotBetween(Long value1, Long value2) {
            addCriterion("TABLEID not between", value1, value2, "tableid");
            return (Criteria) this;
        }

        public Criteria andWordnameIsNull() {
            addCriterion("WORDNAME is null");
            return (Criteria) this;
        }

        public Criteria andWordnameIsNotNull() {
            addCriterion("WORDNAME is not null");
            return (Criteria) this;
        }

        public Criteria andWordnameEqualTo(String value) {
            addCriterion("WORDNAME =", value, "wordname");
            return (Criteria) this;
        }

        public Criteria andWordnameNotEqualTo(String value) {
            addCriterion("WORDNAME <>", value, "wordname");
            return (Criteria) this;
        }

        public Criteria andWordnameGreaterThan(String value) {
            addCriterion("WORDNAME >", value, "wordname");
            return (Criteria) this;
        }

        public Criteria andWordnameGreaterThanOrEqualTo(String value) {
            addCriterion("WORDNAME >=", value, "wordname");
            return (Criteria) this;
        }

        public Criteria andWordnameLessThan(String value) {
            addCriterion("WORDNAME <", value, "wordname");
            return (Criteria) this;
        }

        public Criteria andWordnameLessThanOrEqualTo(String value) {
            addCriterion("WORDNAME <=", value, "wordname");
            return (Criteria) this;
        }

        public Criteria andWordnameLike(String value) {
            addCriterion("WORDNAME like", value, "wordname");
            return (Criteria) this;
        }

        public Criteria andWordnameNotLike(String value) {
            addCriterion("WORDNAME not like", value, "wordname");
            return (Criteria) this;
        }

        public Criteria andWordnameIn(List<String> values) {
            addCriterion("WORDNAME in", values, "wordname");
            return (Criteria) this;
        }

        public Criteria andWordnameNotIn(List<String> values) {
            addCriterion("WORDNAME not in", values, "wordname");
            return (Criteria) this;
        }

        public Criteria andWordnameBetween(String value1, String value2) {
            addCriterion("WORDNAME between", value1, value2, "wordname");
            return (Criteria) this;
        }

        public Criteria andWordnameNotBetween(String value1, String value2) {
            addCriterion("WORDNAME not between", value1, value2, "wordname");
            return (Criteria) this;
        }

        public Criteria andWordstatusIsNull() {
            addCriterion("WORDSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andWordstatusIsNotNull() {
            addCriterion("WORDSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andWordstatusEqualTo(Integer value) {
            addCriterion("WORDSTATUS =", value, "wordstatus");
            return (Criteria) this;
        }

        public Criteria andWordstatusNotEqualTo(Integer value) {
            addCriterion("WORDSTATUS <>", value, "wordstatus");
            return (Criteria) this;
        }

        public Criteria andWordstatusGreaterThan(Integer value) {
            addCriterion("WORDSTATUS >", value, "wordstatus");
            return (Criteria) this;
        }

        public Criteria andWordstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("WORDSTATUS >=", value, "wordstatus");
            return (Criteria) this;
        }

        public Criteria andWordstatusLessThan(Integer value) {
            addCriterion("WORDSTATUS <", value, "wordstatus");
            return (Criteria) this;
        }

        public Criteria andWordstatusLessThanOrEqualTo(Integer value) {
            addCriterion("WORDSTATUS <=", value, "wordstatus");
            return (Criteria) this;
        }

        public Criteria andWordstatusIn(List<Integer> values) {
            addCriterion("WORDSTATUS in", values, "wordstatus");
            return (Criteria) this;
        }

        public Criteria andWordstatusNotIn(List<Integer> values) {
            addCriterion("WORDSTATUS not in", values, "wordstatus");
            return (Criteria) this;
        }

        public Criteria andWordstatusBetween(Integer value1, Integer value2) {
            addCriterion("WORDSTATUS between", value1, value2, "wordstatus");
            return (Criteria) this;
        }

        public Criteria andWordstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("WORDSTATUS not between", value1, value2, "wordstatus");
            return (Criteria) this;
        }

        public Criteria andWordtypeIsNull() {
            addCriterion("WORDTYPE is null");
            return (Criteria) this;
        }

        public Criteria andWordtypeIsNotNull() {
            addCriterion("WORDTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andWordtypeEqualTo(Integer value) {
            addCriterion("WORDTYPE =", value, "wordtype");
            return (Criteria) this;
        }

        public Criteria andWordtypeNotEqualTo(Integer value) {
            addCriterion("WORDTYPE <>", value, "wordtype");
            return (Criteria) this;
        }

        public Criteria andWordtypeGreaterThan(Integer value) {
            addCriterion("WORDTYPE >", value, "wordtype");
            return (Criteria) this;
        }

        public Criteria andWordtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("WORDTYPE >=", value, "wordtype");
            return (Criteria) this;
        }

        public Criteria andWordtypeLessThan(Integer value) {
            addCriterion("WORDTYPE <", value, "wordtype");
            return (Criteria) this;
        }

        public Criteria andWordtypeLessThanOrEqualTo(Integer value) {
            addCriterion("WORDTYPE <=", value, "wordtype");
            return (Criteria) this;
        }

        public Criteria andWordtypeIn(List<Integer> values) {
            addCriterion("WORDTYPE in", values, "wordtype");
            return (Criteria) this;
        }

        public Criteria andWordtypeNotIn(List<Integer> values) {
            addCriterion("WORDTYPE not in", values, "wordtype");
            return (Criteria) this;
        }

        public Criteria andWordtypeBetween(Integer value1, Integer value2) {
            addCriterion("WORDTYPE between", value1, value2, "wordtype");
            return (Criteria) this;
        }

        public Criteria andWordtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("WORDTYPE not between", value1, value2, "wordtype");
            return (Criteria) this;
        }

        public Criteria andWordcolnameIsNull() {
            addCriterion("WORDCOLNAME is null");
            return (Criteria) this;
        }

        public Criteria andWordcolnameIsNotNull() {
            addCriterion("WORDCOLNAME is not null");
            return (Criteria) this;
        }

        public Criteria andWordcolnameEqualTo(String value) {
            addCriterion("WORDCOLNAME =", value, "wordcolname");
            return (Criteria) this;
        }

        public Criteria andWordcolnameNotEqualTo(String value) {
            addCriterion("WORDCOLNAME <>", value, "wordcolname");
            return (Criteria) this;
        }

        public Criteria andWordcolnameGreaterThan(String value) {
            addCriterion("WORDCOLNAME >", value, "wordcolname");
            return (Criteria) this;
        }

        public Criteria andWordcolnameGreaterThanOrEqualTo(String value) {
            addCriterion("WORDCOLNAME >=", value, "wordcolname");
            return (Criteria) this;
        }

        public Criteria andWordcolnameLessThan(String value) {
            addCriterion("WORDCOLNAME <", value, "wordcolname");
            return (Criteria) this;
        }

        public Criteria andWordcolnameLessThanOrEqualTo(String value) {
            addCriterion("WORDCOLNAME <=", value, "wordcolname");
            return (Criteria) this;
        }

        public Criteria andWordcolnameLike(String value) {
            addCriterion("WORDCOLNAME like", value, "wordcolname");
            return (Criteria) this;
        }

        public Criteria andWordcolnameNotLike(String value) {
            addCriterion("WORDCOLNAME not like", value, "wordcolname");
            return (Criteria) this;
        }

        public Criteria andWordcolnameIn(List<String> values) {
            addCriterion("WORDCOLNAME in", values, "wordcolname");
            return (Criteria) this;
        }

        public Criteria andWordcolnameNotIn(List<String> values) {
            addCriterion("WORDCOLNAME not in", values, "wordcolname");
            return (Criteria) this;
        }

        public Criteria andWordcolnameBetween(String value1, String value2) {
            addCriterion("WORDCOLNAME between", value1, value2, "wordcolname");
            return (Criteria) this;
        }

        public Criteria andWordcolnameNotBetween(String value1, String value2) {
            addCriterion("WORDCOLNAME not between", value1, value2, "wordcolname");
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