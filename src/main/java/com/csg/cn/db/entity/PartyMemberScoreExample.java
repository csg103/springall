package com.csg.cn.db.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PartyMemberScoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PartyMemberScoreExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andPartmemberscoreidIsNull() {
            addCriterion("partMemberscoreId is null");
            return (Criteria) this;
        }

        public Criteria andPartmemberscoreidIsNotNull() {
            addCriterion("partMemberscoreId is not null");
            return (Criteria) this;
        }

        public Criteria andPartmemberscoreidEqualTo(String value) {
            addCriterion("partMemberscoreId =", value, "partmemberscoreid");
            return (Criteria) this;
        }

        public Criteria andPartmemberscoreidNotEqualTo(String value) {
            addCriterion("partMemberscoreId <>", value, "partmemberscoreid");
            return (Criteria) this;
        }

        public Criteria andPartmemberscoreidGreaterThan(String value) {
            addCriterion("partMemberscoreId >", value, "partmemberscoreid");
            return (Criteria) this;
        }

        public Criteria andPartmemberscoreidGreaterThanOrEqualTo(String value) {
            addCriterion("partMemberscoreId >=", value, "partmemberscoreid");
            return (Criteria) this;
        }

        public Criteria andPartmemberscoreidLessThan(String value) {
            addCriterion("partMemberscoreId <", value, "partmemberscoreid");
            return (Criteria) this;
        }

        public Criteria andPartmemberscoreidLessThanOrEqualTo(String value) {
            addCriterion("partMemberscoreId <=", value, "partmemberscoreid");
            return (Criteria) this;
        }

        public Criteria andPartmemberscoreidLike(String value) {
            addCriterion("partMemberscoreId like", value, "partmemberscoreid");
            return (Criteria) this;
        }

        public Criteria andPartmemberscoreidNotLike(String value) {
            addCriterion("partMemberscoreId not like", value, "partmemberscoreid");
            return (Criteria) this;
        }

        public Criteria andPartmemberscoreidIn(List<String> values) {
            addCriterion("partMemberscoreId in", values, "partmemberscoreid");
            return (Criteria) this;
        }

        public Criteria andPartmemberscoreidNotIn(List<String> values) {
            addCriterion("partMemberscoreId not in", values, "partmemberscoreid");
            return (Criteria) this;
        }

        public Criteria andPartmemberscoreidBetween(String value1, String value2) {
            addCriterion("partMemberscoreId between", value1, value2, "partmemberscoreid");
            return (Criteria) this;
        }

        public Criteria andPartmemberscoreidNotBetween(String value1, String value2) {
            addCriterion("partMemberscoreId not between", value1, value2, "partmemberscoreid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidIsNull() {
            addCriterion("partymemberId is null");
            return (Criteria) this;
        }

        public Criteria andPartymemberidIsNotNull() {
            addCriterion("partymemberId is not null");
            return (Criteria) this;
        }

        public Criteria andPartymemberidEqualTo(String value) {
            addCriterion("partymemberId =", value, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidNotEqualTo(String value) {
            addCriterion("partymemberId <>", value, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidGreaterThan(String value) {
            addCriterion("partymemberId >", value, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidGreaterThanOrEqualTo(String value) {
            addCriterion("partymemberId >=", value, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidLessThan(String value) {
            addCriterion("partymemberId <", value, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidLessThanOrEqualTo(String value) {
            addCriterion("partymemberId <=", value, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidLike(String value) {
            addCriterion("partymemberId like", value, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidNotLike(String value) {
            addCriterion("partymemberId not like", value, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidIn(List<String> values) {
            addCriterion("partymemberId in", values, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidNotIn(List<String> values) {
            addCriterion("partymemberId not in", values, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidBetween(String value1, String value2) {
            addCriterion("partymemberId between", value1, value2, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidNotBetween(String value1, String value2) {
            addCriterion("partymemberId not between", value1, value2, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(String value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(String value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(String value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(String value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(String value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(String value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLike(String value) {
            addCriterion("score like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotLike(String value) {
            addCriterion("score not like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<String> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<String> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(String value1, String value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(String value1, String value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Date value) {
            addCriterionForJDBCDate("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Date value) {
            addCriterionForJDBCDate("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Date value) {
            addCriterionForJDBCDate("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Date value) {
            addCriterionForJDBCDate("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Date> values) {
            addCriterionForJDBCDate("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Date> values) {
            addCriterionForJDBCDate("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("year not between", value1, value2, "year");
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