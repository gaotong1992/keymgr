package com.kkx.kkxpdf.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class kkxpdfExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public kkxpdfExample() {
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

        public Criteria andContentidIsNull() {
            addCriterion("CONTENTID is null");
            return (Criteria) this;
        }

        public Criteria andContentidIsNotNull() {
            addCriterion("CONTENTID is not null");
            return (Criteria) this;
        }

        public Criteria andContentidEqualTo(Long value) {
            addCriterion("CONTENTID =", value, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidNotEqualTo(Long value) {
            addCriterion("CONTENTID <>", value, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidGreaterThan(Long value) {
            addCriterion("CONTENTID >", value, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidGreaterThanOrEqualTo(Long value) {
            addCriterion("CONTENTID >=", value, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidLessThan(Long value) {
            addCriterion("CONTENTID <", value, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidLessThanOrEqualTo(Long value) {
            addCriterion("CONTENTID <=", value, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidIn(List<Long> values) {
            addCriterion("CONTENTID in", values, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidNotIn(List<Long> values) {
            addCriterion("CONTENTID not in", values, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidBetween(Long value1, Long value2) {
            addCriterion("CONTENTID between", value1, value2, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidNotBetween(Long value1, Long value2) {
            addCriterion("CONTENTID not between", value1, value2, "contentid");
            return (Criteria) this;
        }

        public Criteria andPdfnameIsNull() {
            addCriterion("PDFNAME is null");
            return (Criteria) this;
        }

        public Criteria andPdfnameIsNotNull() {
            addCriterion("PDFNAME is not null");
            return (Criteria) this;
        }

        public Criteria andPdfnameEqualTo(String value) {
            addCriterion("PDFNAME =", value, "pdfname");
            return (Criteria) this;
        }

        public Criteria andPdfnameNotEqualTo(String value) {
            addCriterion("PDFNAME <>", value, "pdfname");
            return (Criteria) this;
        }

        public Criteria andPdfnameGreaterThan(String value) {
            addCriterion("PDFNAME >", value, "pdfname");
            return (Criteria) this;
        }

        public Criteria andPdfnameGreaterThanOrEqualTo(String value) {
            addCriterion("PDFNAME >=", value, "pdfname");
            return (Criteria) this;
        }

        public Criteria andPdfnameLessThan(String value) {
            addCriterion("PDFNAME <", value, "pdfname");
            return (Criteria) this;
        }

        public Criteria andPdfnameLessThanOrEqualTo(String value) {
            addCriterion("PDFNAME <=", value, "pdfname");
            return (Criteria) this;
        }

        public Criteria andPdfnameLike(String value) {
            addCriterion("PDFNAME like", value, "pdfname");
            return (Criteria) this;
        }

        public Criteria andPdfnameNotLike(String value) {
            addCriterion("PDFNAME not like", value, "pdfname");
            return (Criteria) this;
        }

        public Criteria andPdfnameIn(List<String> values) {
            addCriterion("PDFNAME in", values, "pdfname");
            return (Criteria) this;
        }

        public Criteria andPdfnameNotIn(List<String> values) {
            addCriterion("PDFNAME not in", values, "pdfname");
            return (Criteria) this;
        }

        public Criteria andPdfnameBetween(String value1, String value2) {
            addCriterion("PDFNAME between", value1, value2, "pdfname");
            return (Criteria) this;
        }

        public Criteria andPdfnameNotBetween(String value1, String value2) {
            addCriterion("PDFNAME not between", value1, value2, "pdfname");
            return (Criteria) this;
        }

        public Criteria andPdfdescIsNull() {
            addCriterion("PDFDESC is null");
            return (Criteria) this;
        }

        public Criteria andPdfdescIsNotNull() {
            addCriterion("PDFDESC is not null");
            return (Criteria) this;
        }

        public Criteria andPdfdescEqualTo(String value) {
            addCriterion("PDFDESC =", value, "pdfdesc");
            return (Criteria) this;
        }

        public Criteria andPdfdescNotEqualTo(String value) {
            addCriterion("PDFDESC <>", value, "pdfdesc");
            return (Criteria) this;
        }

        public Criteria andPdfdescGreaterThan(String value) {
            addCriterion("PDFDESC >", value, "pdfdesc");
            return (Criteria) this;
        }

        public Criteria andPdfdescGreaterThanOrEqualTo(String value) {
            addCriterion("PDFDESC >=", value, "pdfdesc");
            return (Criteria) this;
        }

        public Criteria andPdfdescLessThan(String value) {
            addCriterion("PDFDESC <", value, "pdfdesc");
            return (Criteria) this;
        }

        public Criteria andPdfdescLessThanOrEqualTo(String value) {
            addCriterion("PDFDESC <=", value, "pdfdesc");
            return (Criteria) this;
        }

        public Criteria andPdfdescLike(String value) {
            addCriterion("PDFDESC like", value, "pdfdesc");
            return (Criteria) this;
        }

        public Criteria andPdfdescNotLike(String value) {
            addCriterion("PDFDESC not like", value, "pdfdesc");
            return (Criteria) this;
        }

        public Criteria andPdfdescIn(List<String> values) {
            addCriterion("PDFDESC in", values, "pdfdesc");
            return (Criteria) this;
        }

        public Criteria andPdfdescNotIn(List<String> values) {
            addCriterion("PDFDESC not in", values, "pdfdesc");
            return (Criteria) this;
        }

        public Criteria andPdfdescBetween(String value1, String value2) {
            addCriterion("PDFDESC between", value1, value2, "pdfdesc");
            return (Criteria) this;
        }

        public Criteria andPdfdescNotBetween(String value1, String value2) {
            addCriterion("PDFDESC not between", value1, value2, "pdfdesc");
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

        public Criteria andDomsgIsNull() {
            addCriterion("DOMSG is null");
            return (Criteria) this;
        }

        public Criteria andDomsgIsNotNull() {
            addCriterion("DOMSG is not null");
            return (Criteria) this;
        }

        public Criteria andDomsgEqualTo(String value) {
            addCriterion("DOMSG =", value, "domsg");
            return (Criteria) this;
        }

        public Criteria andDomsgNotEqualTo(String value) {
            addCriterion("DOMSG <>", value, "domsg");
            return (Criteria) this;
        }

        public Criteria andDomsgGreaterThan(String value) {
            addCriterion("DOMSG >", value, "domsg");
            return (Criteria) this;
        }

        public Criteria andDomsgGreaterThanOrEqualTo(String value) {
            addCriterion("DOMSG >=", value, "domsg");
            return (Criteria) this;
        }

        public Criteria andDomsgLessThan(String value) {
            addCriterion("DOMSG <", value, "domsg");
            return (Criteria) this;
        }

        public Criteria andDomsgLessThanOrEqualTo(String value) {
            addCriterion("DOMSG <=", value, "domsg");
            return (Criteria) this;
        }

        public Criteria andDomsgLike(String value) {
            addCriterion("DOMSG like", value, "domsg");
            return (Criteria) this;
        }

        public Criteria andDomsgNotLike(String value) {
            addCriterion("DOMSG not like", value, "domsg");
            return (Criteria) this;
        }

        public Criteria andDomsgIn(List<String> values) {
            addCriterion("DOMSG in", values, "domsg");
            return (Criteria) this;
        }

        public Criteria andDomsgNotIn(List<String> values) {
            addCriterion("DOMSG not in", values, "domsg");
            return (Criteria) this;
        }

        public Criteria andDomsgBetween(String value1, String value2) {
            addCriterion("DOMSG between", value1, value2, "domsg");
            return (Criteria) this;
        }

        public Criteria andDomsgNotBetween(String value1, String value2) {
            addCriterion("DOMSG not between", value1, value2, "domsg");
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