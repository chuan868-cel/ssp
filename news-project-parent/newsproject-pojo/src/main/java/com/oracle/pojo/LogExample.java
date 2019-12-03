package com.oracle.pojo;

import java.util.ArrayList;
import java.util.List;

public class LogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andExecutemethodnameIsNull() {
            addCriterion("executemethodname is null");
            return (Criteria) this;
        }

        public Criteria andExecutemethodnameIsNotNull() {
            addCriterion("executemethodname is not null");
            return (Criteria) this;
        }

        public Criteria andExecutemethodnameEqualTo(String value) {
            addCriterion("executemethodname =", value, "executemethodname");
            return (Criteria) this;
        }

        public Criteria andExecutemethodnameNotEqualTo(String value) {
            addCriterion("executemethodname <>", value, "executemethodname");
            return (Criteria) this;
        }

        public Criteria andExecutemethodnameGreaterThan(String value) {
            addCriterion("executemethodname >", value, "executemethodname");
            return (Criteria) this;
        }

        public Criteria andExecutemethodnameGreaterThanOrEqualTo(String value) {
            addCriterion("executemethodname >=", value, "executemethodname");
            return (Criteria) this;
        }

        public Criteria andExecutemethodnameLessThan(String value) {
            addCriterion("executemethodname <", value, "executemethodname");
            return (Criteria) this;
        }

        public Criteria andExecutemethodnameLessThanOrEqualTo(String value) {
            addCriterion("executemethodname <=", value, "executemethodname");
            return (Criteria) this;
        }

        public Criteria andExecutemethodnameLike(String value) {
            addCriterion("executemethodname like", value, "executemethodname");
            return (Criteria) this;
        }

        public Criteria andExecutemethodnameNotLike(String value) {
            addCriterion("executemethodname not like", value, "executemethodname");
            return (Criteria) this;
        }

        public Criteria andExecutemethodnameIn(List<String> values) {
            addCriterion("executemethodname in", values, "executemethodname");
            return (Criteria) this;
        }

        public Criteria andExecutemethodnameNotIn(List<String> values) {
            addCriterion("executemethodname not in", values, "executemethodname");
            return (Criteria) this;
        }

        public Criteria andExecutemethodnameBetween(String value1, String value2) {
            addCriterion("executemethodname between", value1, value2, "executemethodname");
            return (Criteria) this;
        }

        public Criteria andExecutemethodnameNotBetween(String value1, String value2) {
            addCriterion("executemethodname not between", value1, value2, "executemethodname");
            return (Criteria) this;
        }

        public Criteria andExecutetimeIsNull() {
            addCriterion("executetime is null");
            return (Criteria) this;
        }

        public Criteria andExecutetimeIsNotNull() {
            addCriterion("executetime is not null");
            return (Criteria) this;
        }

        public Criteria andExecutetimeEqualTo(String value) {
            addCriterion("executetime =", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeNotEqualTo(String value) {
            addCriterion("executetime <>", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeGreaterThan(String value) {
            addCriterion("executetime >", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeGreaterThanOrEqualTo(String value) {
            addCriterion("executetime >=", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeLessThan(String value) {
            addCriterion("executetime <", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeLessThanOrEqualTo(String value) {
            addCriterion("executetime <=", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeLike(String value) {
            addCriterion("executetime like", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeNotLike(String value) {
            addCriterion("executetime not like", value, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeIn(List<String> values) {
            addCriterion("executetime in", values, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeNotIn(List<String> values) {
            addCriterion("executetime not in", values, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeBetween(String value1, String value2) {
            addCriterion("executetime between", value1, value2, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutetimeNotBetween(String value1, String value2) {
            addCriterion("executetime not between", value1, value2, "executetime");
            return (Criteria) this;
        }

        public Criteria andExecutornameIsNull() {
            addCriterion("executorname is null");
            return (Criteria) this;
        }

        public Criteria andExecutornameIsNotNull() {
            addCriterion("executorname is not null");
            return (Criteria) this;
        }

        public Criteria andExecutornameEqualTo(String value) {
            addCriterion("executorname =", value, "executorname");
            return (Criteria) this;
        }

        public Criteria andExecutornameNotEqualTo(String value) {
            addCriterion("executorname <>", value, "executorname");
            return (Criteria) this;
        }

        public Criteria andExecutornameGreaterThan(String value) {
            addCriterion("executorname >", value, "executorname");
            return (Criteria) this;
        }

        public Criteria andExecutornameGreaterThanOrEqualTo(String value) {
            addCriterion("executorname >=", value, "executorname");
            return (Criteria) this;
        }

        public Criteria andExecutornameLessThan(String value) {
            addCriterion("executorname <", value, "executorname");
            return (Criteria) this;
        }

        public Criteria andExecutornameLessThanOrEqualTo(String value) {
            addCriterion("executorname <=", value, "executorname");
            return (Criteria) this;
        }

        public Criteria andExecutornameLike(String value) {
            addCriterion("executorname like", value, "executorname");
            return (Criteria) this;
        }

        public Criteria andExecutornameNotLike(String value) {
            addCriterion("executorname not like", value, "executorname");
            return (Criteria) this;
        }

        public Criteria andExecutornameIn(List<String> values) {
            addCriterion("executorname in", values, "executorname");
            return (Criteria) this;
        }

        public Criteria andExecutornameNotIn(List<String> values) {
            addCriterion("executorname not in", values, "executorname");
            return (Criteria) this;
        }

        public Criteria andExecutornameBetween(String value1, String value2) {
            addCriterion("executorname between", value1, value2, "executorname");
            return (Criteria) this;
        }

        public Criteria andExecutornameNotBetween(String value1, String value2) {
            addCriterion("executorname not between", value1, value2, "executorname");
            return (Criteria) this;
        }

        public Criteria andRequestipIsNull() {
            addCriterion("requestip is null");
            return (Criteria) this;
        }

        public Criteria andRequestipIsNotNull() {
            addCriterion("requestip is not null");
            return (Criteria) this;
        }

        public Criteria andRequestipEqualTo(String value) {
            addCriterion("requestip =", value, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipNotEqualTo(String value) {
            addCriterion("requestip <>", value, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipGreaterThan(String value) {
            addCriterion("requestip >", value, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipGreaterThanOrEqualTo(String value) {
            addCriterion("requestip >=", value, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipLessThan(String value) {
            addCriterion("requestip <", value, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipLessThanOrEqualTo(String value) {
            addCriterion("requestip <=", value, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipLike(String value) {
            addCriterion("requestip like", value, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipNotLike(String value) {
            addCriterion("requestip not like", value, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipIn(List<String> values) {
            addCriterion("requestip in", values, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipNotIn(List<String> values) {
            addCriterion("requestip not in", values, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipBetween(String value1, String value2) {
            addCriterion("requestip between", value1, value2, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipNotBetween(String value1, String value2) {
            addCriterion("requestip not between", value1, value2, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestimeIsNull() {
            addCriterion("requestime is null");
            return (Criteria) this;
        }

        public Criteria andRequestimeIsNotNull() {
            addCriterion("requestime is not null");
            return (Criteria) this;
        }

        public Criteria andRequestimeEqualTo(String value) {
            addCriterion("requestime =", value, "requestime");
            return (Criteria) this;
        }

        public Criteria andRequestimeNotEqualTo(String value) {
            addCriterion("requestime <>", value, "requestime");
            return (Criteria) this;
        }

        public Criteria andRequestimeGreaterThan(String value) {
            addCriterion("requestime >", value, "requestime");
            return (Criteria) this;
        }

        public Criteria andRequestimeGreaterThanOrEqualTo(String value) {
            addCriterion("requestime >=", value, "requestime");
            return (Criteria) this;
        }

        public Criteria andRequestimeLessThan(String value) {
            addCriterion("requestime <", value, "requestime");
            return (Criteria) this;
        }

        public Criteria andRequestimeLessThanOrEqualTo(String value) {
            addCriterion("requestime <=", value, "requestime");
            return (Criteria) this;
        }

        public Criteria andRequestimeLike(String value) {
            addCriterion("requestime like", value, "requestime");
            return (Criteria) this;
        }

        public Criteria andRequestimeNotLike(String value) {
            addCriterion("requestime not like", value, "requestime");
            return (Criteria) this;
        }

        public Criteria andRequestimeIn(List<String> values) {
            addCriterion("requestime in", values, "requestime");
            return (Criteria) this;
        }

        public Criteria andRequestimeNotIn(List<String> values) {
            addCriterion("requestime not in", values, "requestime");
            return (Criteria) this;
        }

        public Criteria andRequestimeBetween(String value1, String value2) {
            addCriterion("requestime between", value1, value2, "requestime");
            return (Criteria) this;
        }

        public Criteria andRequestimeNotBetween(String value1, String value2) {
            addCriterion("requestime not between", value1, value2, "requestime");
            return (Criteria) this;
        }

        public Criteria andRequestdescIsNull() {
            addCriterion("requestdesc is null");
            return (Criteria) this;
        }

        public Criteria andRequestdescIsNotNull() {
            addCriterion("requestdesc is not null");
            return (Criteria) this;
        }

        public Criteria andRequestdescEqualTo(String value) {
            addCriterion("requestdesc =", value, "requestdesc");
            return (Criteria) this;
        }

        public Criteria andRequestdescNotEqualTo(String value) {
            addCriterion("requestdesc <>", value, "requestdesc");
            return (Criteria) this;
        }

        public Criteria andRequestdescGreaterThan(String value) {
            addCriterion("requestdesc >", value, "requestdesc");
            return (Criteria) this;
        }

        public Criteria andRequestdescGreaterThanOrEqualTo(String value) {
            addCriterion("requestdesc >=", value, "requestdesc");
            return (Criteria) this;
        }

        public Criteria andRequestdescLessThan(String value) {
            addCriterion("requestdesc <", value, "requestdesc");
            return (Criteria) this;
        }

        public Criteria andRequestdescLessThanOrEqualTo(String value) {
            addCriterion("requestdesc <=", value, "requestdesc");
            return (Criteria) this;
        }

        public Criteria andRequestdescLike(String value) {
            addCriterion("requestdesc like", value, "requestdesc");
            return (Criteria) this;
        }

        public Criteria andRequestdescNotLike(String value) {
            addCriterion("requestdesc not like", value, "requestdesc");
            return (Criteria) this;
        }

        public Criteria andRequestdescIn(List<String> values) {
            addCriterion("requestdesc in", values, "requestdesc");
            return (Criteria) this;
        }

        public Criteria andRequestdescNotIn(List<String> values) {
            addCriterion("requestdesc not in", values, "requestdesc");
            return (Criteria) this;
        }

        public Criteria andRequestdescBetween(String value1, String value2) {
            addCriterion("requestdesc between", value1, value2, "requestdesc");
            return (Criteria) this;
        }

        public Criteria andRequestdescNotBetween(String value1, String value2) {
            addCriterion("requestdesc not between", value1, value2, "requestdesc");
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