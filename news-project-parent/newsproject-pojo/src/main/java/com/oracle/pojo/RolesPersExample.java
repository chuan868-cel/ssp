package com.oracle.pojo;

import java.util.ArrayList;
import java.util.List;

public class RolesPersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RolesPersExample() {
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

        public Criteria andRolesIsNull() {
            addCriterion("roles is null");
            return (Criteria) this;
        }

        public Criteria andRolesIsNotNull() {
            addCriterion("roles is not null");
            return (Criteria) this;
        }

        public Criteria andRolesEqualTo(Integer value) {
            addCriterion("roles =", value, "roles");
            return (Criteria) this;
        }

        public Criteria andRolesNotEqualTo(Integer value) {
            addCriterion("roles <>", value, "roles");
            return (Criteria) this;
        }

        public Criteria andRolesGreaterThan(Integer value) {
            addCriterion("roles >", value, "roles");
            return (Criteria) this;
        }

        public Criteria andRolesGreaterThanOrEqualTo(Integer value) {
            addCriterion("roles >=", value, "roles");
            return (Criteria) this;
        }

        public Criteria andRolesLessThan(Integer value) {
            addCriterion("roles <", value, "roles");
            return (Criteria) this;
        }

        public Criteria andRolesLessThanOrEqualTo(Integer value) {
            addCriterion("roles <=", value, "roles");
            return (Criteria) this;
        }

        public Criteria andRolesIn(List<Integer> values) {
            addCriterion("roles in", values, "roles");
            return (Criteria) this;
        }

        public Criteria andRolesNotIn(List<Integer> values) {
            addCriterion("roles not in", values, "roles");
            return (Criteria) this;
        }

        public Criteria andRolesBetween(Integer value1, Integer value2) {
            addCriterion("roles between", value1, value2, "roles");
            return (Criteria) this;
        }

        public Criteria andRolesNotBetween(Integer value1, Integer value2) {
            addCriterion("roles not between", value1, value2, "roles");
            return (Criteria) this;
        }

        public Criteria andPersIsNull() {
            addCriterion("pers is null");
            return (Criteria) this;
        }

        public Criteria andPersIsNotNull() {
            addCriterion("pers is not null");
            return (Criteria) this;
        }

        public Criteria andPersEqualTo(Integer value) {
            addCriterion("pers =", value, "pers");
            return (Criteria) this;
        }

        public Criteria andPersNotEqualTo(Integer value) {
            addCriterion("pers <>", value, "pers");
            return (Criteria) this;
        }

        public Criteria andPersGreaterThan(Integer value) {
            addCriterion("pers >", value, "pers");
            return (Criteria) this;
        }

        public Criteria andPersGreaterThanOrEqualTo(Integer value) {
            addCriterion("pers >=", value, "pers");
            return (Criteria) this;
        }

        public Criteria andPersLessThan(Integer value) {
            addCriterion("pers <", value, "pers");
            return (Criteria) this;
        }

        public Criteria andPersLessThanOrEqualTo(Integer value) {
            addCriterion("pers <=", value, "pers");
            return (Criteria) this;
        }

        public Criteria andPersIn(List<Integer> values) {
            addCriterion("pers in", values, "pers");
            return (Criteria) this;
        }

        public Criteria andPersNotIn(List<Integer> values) {
            addCriterion("pers not in", values, "pers");
            return (Criteria) this;
        }

        public Criteria andPersBetween(Integer value1, Integer value2) {
            addCriterion("pers between", value1, value2, "pers");
            return (Criteria) this;
        }

        public Criteria andPersNotBetween(Integer value1, Integer value2) {
            addCriterion("pers not between", value1, value2, "pers");
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