package com.kkx.kkxuserword.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class kkxuserwordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public kkxuserwordExample() {
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

        public Criteria andKkxuserlinkwordidIsNull() {
            addCriterion("KKXUSERLINKWORDID is null");
            return (Criteria) this;
        }

        public Criteria andKkxuserlinkwordidIsNotNull() {
            addCriterion("KKXUSERLINKWORDID is not null");
            return (Criteria) this;
        }

        public Criteria andKkxuserlinkwordidEqualTo(Long value) {
            addCriterion("KKXUSERLINKWORDID =", value, "kkxuserlinkwordid");
            return (Criteria) this;
        }

        public Criteria andKkxuserlinkwordidNotEqualTo(Long value) {
            addCriterion("KKXUSERLINKWORDID <>", value, "kkxuserlinkwordid");
            return (Criteria) this;
        }

        public Criteria andKkxuserlinkwordidGreaterThan(Long value) {
            addCriterion("KKXUSERLINKWORDID >", value, "kkxuserlinkwordid");
            return (Criteria) this;
        }

        public Criteria andKkxuserlinkwordidGreaterThanOrEqualTo(Long value) {
            addCriterion("KKXUSERLINKWORDID >=", value, "kkxuserlinkwordid");
            return (Criteria) this;
        }

        public Criteria andKkxuserlinkwordidLessThan(Long value) {
            addCriterion("KKXUSERLINKWORDID <", value, "kkxuserlinkwordid");
            return (Criteria) this;
        }

        public Criteria andKkxuserlinkwordidLessThanOrEqualTo(Long value) {
            addCriterion("KKXUSERLINKWORDID <=", value, "kkxuserlinkwordid");
            return (Criteria) this;
        }

        public Criteria andKkxuserlinkwordidIn(List<Long> values) {
            addCriterion("KKXUSERLINKWORDID in", values, "kkxuserlinkwordid");
            return (Criteria) this;
        }

        public Criteria andKkxuserlinkwordidNotIn(List<Long> values) {
            addCriterion("KKXUSERLINKWORDID not in", values, "kkxuserlinkwordid");
            return (Criteria) this;
        }

        public Criteria andKkxuserlinkwordidBetween(Long value1, Long value2) {
            addCriterion("KKXUSERLINKWORDID between", value1, value2, "kkxuserlinkwordid");
            return (Criteria) this;
        }

        public Criteria andKkxuserlinkwordidNotBetween(Long value1, Long value2) {
            addCriterion("KKXUSERLINKWORDID not between", value1, value2, "kkxuserlinkwordid");
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

        public Criteria andWorduseridIsNull() {
            addCriterion("WORDUSERID is null");
            return (Criteria) this;
        }

        public Criteria andWorduseridIsNotNull() {
            addCriterion("WORDUSERID is not null");
            return (Criteria) this;
        }

        public Criteria andWorduseridEqualTo(Long value) {
            addCriterion("WORDUSERID =", value, "worduserid");
            return (Criteria) this;
        }

        public Criteria andWorduseridNotEqualTo(Long value) {
            addCriterion("WORDUSERID <>", value, "worduserid");
            return (Criteria) this;
        }

        public Criteria andWorduseridGreaterThan(Long value) {
            addCriterion("WORDUSERID >", value, "worduserid");
            return (Criteria) this;
        }

        public Criteria andWorduseridGreaterThanOrEqualTo(Long value) {
            addCriterion("WORDUSERID >=", value, "worduserid");
            return (Criteria) this;
        }

        public Criteria andWorduseridLessThan(Long value) {
            addCriterion("WORDUSERID <", value, "worduserid");
            return (Criteria) this;
        }

        public Criteria andWorduseridLessThanOrEqualTo(Long value) {
            addCriterion("WORDUSERID <=", value, "worduserid");
            return (Criteria) this;
        }

        public Criteria andWorduseridIn(List<Long> values) {
            addCriterion("WORDUSERID in", values, "worduserid");
            return (Criteria) this;
        }

        public Criteria andWorduseridNotIn(List<Long> values) {
            addCriterion("WORDUSERID not in", values, "worduserid");
            return (Criteria) this;
        }

        public Criteria andWorduseridBetween(Long value1, Long value2) {
            addCriterion("WORDUSERID between", value1, value2, "worduserid");
            return (Criteria) this;
        }

        public Criteria andWorduseridNotBetween(Long value1, Long value2) {
            addCriterion("WORDUSERID not between", value1, value2, "worduserid");
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