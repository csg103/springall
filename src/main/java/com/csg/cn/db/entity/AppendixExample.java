package com.csg.cn.db.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppendixExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppendixExample() {
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

        public Criteria andAppendixidIsNull() {
            addCriterion("appendixId is null");
            return (Criteria) this;
        }

        public Criteria andAppendixidIsNotNull() {
            addCriterion("appendixId is not null");
            return (Criteria) this;
        }

        public Criteria andAppendixidEqualTo(String value) {
            addCriterion("appendixId =", value, "appendixid");
            return (Criteria) this;
        }

        public Criteria andAppendixidNotEqualTo(String value) {
            addCriterion("appendixId <>", value, "appendixid");
            return (Criteria) this;
        }

        public Criteria andAppendixidGreaterThan(String value) {
            addCriterion("appendixId >", value, "appendixid");
            return (Criteria) this;
        }

        public Criteria andAppendixidGreaterThanOrEqualTo(String value) {
            addCriterion("appendixId >=", value, "appendixid");
            return (Criteria) this;
        }

        public Criteria andAppendixidLessThan(String value) {
            addCriterion("appendixId <", value, "appendixid");
            return (Criteria) this;
        }

        public Criteria andAppendixidLessThanOrEqualTo(String value) {
            addCriterion("appendixId <=", value, "appendixid");
            return (Criteria) this;
        }

        public Criteria andAppendixidLike(String value) {
            addCriterion("appendixId like", value, "appendixid");
            return (Criteria) this;
        }

        public Criteria andAppendixidNotLike(String value) {
            addCriterion("appendixId not like", value, "appendixid");
            return (Criteria) this;
        }

        public Criteria andAppendixidIn(List<String> values) {
            addCriterion("appendixId in", values, "appendixid");
            return (Criteria) this;
        }

        public Criteria andAppendixidNotIn(List<String> values) {
            addCriterion("appendixId not in", values, "appendixid");
            return (Criteria) this;
        }

        public Criteria andAppendixidBetween(String value1, String value2) {
            addCriterion("appendixId between", value1, value2, "appendixid");
            return (Criteria) this;
        }

        public Criteria andAppendixidNotBetween(String value1, String value2) {
            addCriterion("appendixId not between", value1, value2, "appendixid");
            return (Criteria) this;
        }

        public Criteria andAppendnameIsNull() {
            addCriterion("appendName is null");
            return (Criteria) this;
        }

        public Criteria andAppendnameIsNotNull() {
            addCriterion("appendName is not null");
            return (Criteria) this;
        }

        public Criteria andAppendnameEqualTo(String value) {
            addCriterion("appendName =", value, "appendname");
            return (Criteria) this;
        }

        public Criteria andAppendnameNotEqualTo(String value) {
            addCriterion("appendName <>", value, "appendname");
            return (Criteria) this;
        }

        public Criteria andAppendnameGreaterThan(String value) {
            addCriterion("appendName >", value, "appendname");
            return (Criteria) this;
        }

        public Criteria andAppendnameGreaterThanOrEqualTo(String value) {
            addCriterion("appendName >=", value, "appendname");
            return (Criteria) this;
        }

        public Criteria andAppendnameLessThan(String value) {
            addCriterion("appendName <", value, "appendname");
            return (Criteria) this;
        }

        public Criteria andAppendnameLessThanOrEqualTo(String value) {
            addCriterion("appendName <=", value, "appendname");
            return (Criteria) this;
        }

        public Criteria andAppendnameLike(String value) {
            addCriterion("appendName like", value, "appendname");
            return (Criteria) this;
        }

        public Criteria andAppendnameNotLike(String value) {
            addCriterion("appendName not like", value, "appendname");
            return (Criteria) this;
        }

        public Criteria andAppendnameIn(List<String> values) {
            addCriterion("appendName in", values, "appendname");
            return (Criteria) this;
        }

        public Criteria andAppendnameNotIn(List<String> values) {
            addCriterion("appendName not in", values, "appendname");
            return (Criteria) this;
        }

        public Criteria andAppendnameBetween(String value1, String value2) {
            addCriterion("appendName between", value1, value2, "appendname");
            return (Criteria) this;
        }

        public Criteria andAppendnameNotBetween(String value1, String value2) {
            addCriterion("appendName not between", value1, value2, "appendname");
            return (Criteria) this;
        }

        public Criteria andAppendtypeIsNull() {
            addCriterion("appendType is null");
            return (Criteria) this;
        }

        public Criteria andAppendtypeIsNotNull() {
            addCriterion("appendType is not null");
            return (Criteria) this;
        }

        public Criteria andAppendtypeEqualTo(String value) {
            addCriterion("appendType =", value, "appendtype");
            return (Criteria) this;
        }

        public Criteria andAppendtypeNotEqualTo(String value) {
            addCriterion("appendType <>", value, "appendtype");
            return (Criteria) this;
        }

        public Criteria andAppendtypeGreaterThan(String value) {
            addCriterion("appendType >", value, "appendtype");
            return (Criteria) this;
        }

        public Criteria andAppendtypeGreaterThanOrEqualTo(String value) {
            addCriterion("appendType >=", value, "appendtype");
            return (Criteria) this;
        }

        public Criteria andAppendtypeLessThan(String value) {
            addCriterion("appendType <", value, "appendtype");
            return (Criteria) this;
        }

        public Criteria andAppendtypeLessThanOrEqualTo(String value) {
            addCriterion("appendType <=", value, "appendtype");
            return (Criteria) this;
        }

        public Criteria andAppendtypeLike(String value) {
            addCriterion("appendType like", value, "appendtype");
            return (Criteria) this;
        }

        public Criteria andAppendtypeNotLike(String value) {
            addCriterion("appendType not like", value, "appendtype");
            return (Criteria) this;
        }

        public Criteria andAppendtypeIn(List<String> values) {
            addCriterion("appendType in", values, "appendtype");
            return (Criteria) this;
        }

        public Criteria andAppendtypeNotIn(List<String> values) {
            addCriterion("appendType not in", values, "appendtype");
            return (Criteria) this;
        }

        public Criteria andAppendtypeBetween(String value1, String value2) {
            addCriterion("appendType between", value1, value2, "appendtype");
            return (Criteria) this;
        }

        public Criteria andAppendtypeNotBetween(String value1, String value2) {
            addCriterion("appendType not between", value1, value2, "appendtype");
            return (Criteria) this;
        }

        public Criteria andAppendixaddressIsNull() {
            addCriterion("appendixAddress is null");
            return (Criteria) this;
        }

        public Criteria andAppendixaddressIsNotNull() {
            addCriterion("appendixAddress is not null");
            return (Criteria) this;
        }

        public Criteria andAppendixaddressEqualTo(String value) {
            addCriterion("appendixAddress =", value, "appendixaddress");
            return (Criteria) this;
        }

        public Criteria andAppendixaddressNotEqualTo(String value) {
            addCriterion("appendixAddress <>", value, "appendixaddress");
            return (Criteria) this;
        }

        public Criteria andAppendixaddressGreaterThan(String value) {
            addCriterion("appendixAddress >", value, "appendixaddress");
            return (Criteria) this;
        }

        public Criteria andAppendixaddressGreaterThanOrEqualTo(String value) {
            addCriterion("appendixAddress >=", value, "appendixaddress");
            return (Criteria) this;
        }

        public Criteria andAppendixaddressLessThan(String value) {
            addCriterion("appendixAddress <", value, "appendixaddress");
            return (Criteria) this;
        }

        public Criteria andAppendixaddressLessThanOrEqualTo(String value) {
            addCriterion("appendixAddress <=", value, "appendixaddress");
            return (Criteria) this;
        }

        public Criteria andAppendixaddressLike(String value) {
            addCriterion("appendixAddress like", value, "appendixaddress");
            return (Criteria) this;
        }

        public Criteria andAppendixaddressNotLike(String value) {
            addCriterion("appendixAddress not like", value, "appendixaddress");
            return (Criteria) this;
        }

        public Criteria andAppendixaddressIn(List<String> values) {
            addCriterion("appendixAddress in", values, "appendixaddress");
            return (Criteria) this;
        }

        public Criteria andAppendixaddressNotIn(List<String> values) {
            addCriterion("appendixAddress not in", values, "appendixaddress");
            return (Criteria) this;
        }

        public Criteria andAppendixaddressBetween(String value1, String value2) {
            addCriterion("appendixAddress between", value1, value2, "appendixaddress");
            return (Criteria) this;
        }

        public Criteria andAppendixaddressNotBetween(String value1, String value2) {
            addCriterion("appendixAddress not between", value1, value2, "appendixaddress");
            return (Criteria) this;
        }

        public Criteria andOpernameIsNull() {
            addCriterion("operName is null");
            return (Criteria) this;
        }

        public Criteria andOpernameIsNotNull() {
            addCriterion("operName is not null");
            return (Criteria) this;
        }

        public Criteria andOpernameEqualTo(String value) {
            addCriterion("operName =", value, "opername");
            return (Criteria) this;
        }

        public Criteria andOpernameNotEqualTo(String value) {
            addCriterion("operName <>", value, "opername");
            return (Criteria) this;
        }

        public Criteria andOpernameGreaterThan(String value) {
            addCriterion("operName >", value, "opername");
            return (Criteria) this;
        }

        public Criteria andOpernameGreaterThanOrEqualTo(String value) {
            addCriterion("operName >=", value, "opername");
            return (Criteria) this;
        }

        public Criteria andOpernameLessThan(String value) {
            addCriterion("operName <", value, "opername");
            return (Criteria) this;
        }

        public Criteria andOpernameLessThanOrEqualTo(String value) {
            addCriterion("operName <=", value, "opername");
            return (Criteria) this;
        }

        public Criteria andOpernameLike(String value) {
            addCriterion("operName like", value, "opername");
            return (Criteria) this;
        }

        public Criteria andOpernameNotLike(String value) {
            addCriterion("operName not like", value, "opername");
            return (Criteria) this;
        }

        public Criteria andOpernameIn(List<String> values) {
            addCriterion("operName in", values, "opername");
            return (Criteria) this;
        }

        public Criteria andOpernameNotIn(List<String> values) {
            addCriterion("operName not in", values, "opername");
            return (Criteria) this;
        }

        public Criteria andOpernameBetween(String value1, String value2) {
            addCriterion("operName between", value1, value2, "opername");
            return (Criteria) this;
        }

        public Criteria andOpernameNotBetween(String value1, String value2) {
            addCriterion("operName not between", value1, value2, "opername");
            return (Criteria) this;
        }

        public Criteria andOpertimeIsNull() {
            addCriterion("operTime is null");
            return (Criteria) this;
        }

        public Criteria andOpertimeIsNotNull() {
            addCriterion("operTime is not null");
            return (Criteria) this;
        }

        public Criteria andOpertimeEqualTo(Date value) {
            addCriterion("operTime =", value, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeNotEqualTo(Date value) {
            addCriterion("operTime <>", value, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeGreaterThan(Date value) {
            addCriterion("operTime >", value, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeGreaterThanOrEqualTo(Date value) {
            addCriterion("operTime >=", value, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeLessThan(Date value) {
            addCriterion("operTime <", value, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeLessThanOrEqualTo(Date value) {
            addCriterion("operTime <=", value, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeIn(List<Date> values) {
            addCriterion("operTime in", values, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeNotIn(List<Date> values) {
            addCriterion("operTime not in", values, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeBetween(Date value1, Date value2) {
            addCriterion("operTime between", value1, value2, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeNotBetween(Date value1, Date value2) {
            addCriterion("operTime not between", value1, value2, "opertime");
            return (Criteria) this;
        }

        public Criteria andRemake1IsNull() {
            addCriterion("remake1 is null");
            return (Criteria) this;
        }

        public Criteria andRemake1IsNotNull() {
            addCriterion("remake1 is not null");
            return (Criteria) this;
        }

        public Criteria andRemake1EqualTo(String value) {
            addCriterion("remake1 =", value, "remake1");
            return (Criteria) this;
        }

        public Criteria andRemake1NotEqualTo(String value) {
            addCriterion("remake1 <>", value, "remake1");
            return (Criteria) this;
        }

        public Criteria andRemake1GreaterThan(String value) {
            addCriterion("remake1 >", value, "remake1");
            return (Criteria) this;
        }

        public Criteria andRemake1GreaterThanOrEqualTo(String value) {
            addCriterion("remake1 >=", value, "remake1");
            return (Criteria) this;
        }

        public Criteria andRemake1LessThan(String value) {
            addCriterion("remake1 <", value, "remake1");
            return (Criteria) this;
        }

        public Criteria andRemake1LessThanOrEqualTo(String value) {
            addCriterion("remake1 <=", value, "remake1");
            return (Criteria) this;
        }

        public Criteria andRemake1Like(String value) {
            addCriterion("remake1 like", value, "remake1");
            return (Criteria) this;
        }

        public Criteria andRemake1NotLike(String value) {
            addCriterion("remake1 not like", value, "remake1");
            return (Criteria) this;
        }

        public Criteria andRemake1In(List<String> values) {
            addCriterion("remake1 in", values, "remake1");
            return (Criteria) this;
        }

        public Criteria andRemake1NotIn(List<String> values) {
            addCriterion("remake1 not in", values, "remake1");
            return (Criteria) this;
        }

        public Criteria andRemake1Between(String value1, String value2) {
            addCriterion("remake1 between", value1, value2, "remake1");
            return (Criteria) this;
        }

        public Criteria andRemake1NotBetween(String value1, String value2) {
            addCriterion("remake1 not between", value1, value2, "remake1");
            return (Criteria) this;
        }

        public Criteria andRemake2IsNull() {
            addCriterion("remake2 is null");
            return (Criteria) this;
        }

        public Criteria andRemake2IsNotNull() {
            addCriterion("remake2 is not null");
            return (Criteria) this;
        }

        public Criteria andRemake2EqualTo(String value) {
            addCriterion("remake2 =", value, "remake2");
            return (Criteria) this;
        }

        public Criteria andRemake2NotEqualTo(String value) {
            addCriterion("remake2 <>", value, "remake2");
            return (Criteria) this;
        }

        public Criteria andRemake2GreaterThan(String value) {
            addCriterion("remake2 >", value, "remake2");
            return (Criteria) this;
        }

        public Criteria andRemake2GreaterThanOrEqualTo(String value) {
            addCriterion("remake2 >=", value, "remake2");
            return (Criteria) this;
        }

        public Criteria andRemake2LessThan(String value) {
            addCriterion("remake2 <", value, "remake2");
            return (Criteria) this;
        }

        public Criteria andRemake2LessThanOrEqualTo(String value) {
            addCriterion("remake2 <=", value, "remake2");
            return (Criteria) this;
        }

        public Criteria andRemake2Like(String value) {
            addCriterion("remake2 like", value, "remake2");
            return (Criteria) this;
        }

        public Criteria andRemake2NotLike(String value) {
            addCriterion("remake2 not like", value, "remake2");
            return (Criteria) this;
        }

        public Criteria andRemake2In(List<String> values) {
            addCriterion("remake2 in", values, "remake2");
            return (Criteria) this;
        }

        public Criteria andRemake2NotIn(List<String> values) {
            addCriterion("remake2 not in", values, "remake2");
            return (Criteria) this;
        }

        public Criteria andRemake2Between(String value1, String value2) {
            addCriterion("remake2 between", value1, value2, "remake2");
            return (Criteria) this;
        }

        public Criteria andRemake2NotBetween(String value1, String value2) {
            addCriterion("remake2 not between", value1, value2, "remake2");
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