package com.csg.cn.db.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PartyMemberScoreDetilExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PartyMemberScoreDetilExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andScoredetilidIsNull() {
            addCriterion("scoreDetilId is null");
            return (Criteria) this;
        }

        public Criteria andScoredetilidIsNotNull() {
            addCriterion("scoreDetilId is not null");
            return (Criteria) this;
        }

        public Criteria andScoredetilidEqualTo(String value) {
            addCriterion("scoreDetilId =", value, "scoredetilid");
            return (Criteria) this;
        }

        public Criteria andScoredetilidNotEqualTo(String value) {
            addCriterion("scoreDetilId <>", value, "scoredetilid");
            return (Criteria) this;
        }

        public Criteria andScoredetilidGreaterThan(String value) {
            addCriterion("scoreDetilId >", value, "scoredetilid");
            return (Criteria) this;
        }

        public Criteria andScoredetilidGreaterThanOrEqualTo(String value) {
            addCriterion("scoreDetilId >=", value, "scoredetilid");
            return (Criteria) this;
        }

        public Criteria andScoredetilidLessThan(String value) {
            addCriterion("scoreDetilId <", value, "scoredetilid");
            return (Criteria) this;
        }

        public Criteria andScoredetilidLessThanOrEqualTo(String value) {
            addCriterion("scoreDetilId <=", value, "scoredetilid");
            return (Criteria) this;
        }

        public Criteria andScoredetilidLike(String value) {
            addCriterion("scoreDetilId like", value, "scoredetilid");
            return (Criteria) this;
        }

        public Criteria andScoredetilidNotLike(String value) {
            addCriterion("scoreDetilId not like", value, "scoredetilid");
            return (Criteria) this;
        }

        public Criteria andScoredetilidIn(List<String> values) {
            addCriterion("scoreDetilId in", values, "scoredetilid");
            return (Criteria) this;
        }

        public Criteria andScoredetilidNotIn(List<String> values) {
            addCriterion("scoreDetilId not in", values, "scoredetilid");
            return (Criteria) this;
        }

        public Criteria andScoredetilidBetween(String value1, String value2) {
            addCriterion("scoreDetilId between", value1, value2, "scoredetilid");
            return (Criteria) this;
        }

        public Criteria andScoredetilidNotBetween(String value1, String value2) {
            addCriterion("scoreDetilId not between", value1, value2, "scoredetilid");
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

        public Criteria andPipidIsNull() {
            addCriterion("pipId is null");
            return (Criteria) this;
        }

        public Criteria andPipidIsNotNull() {
            addCriterion("pipId is not null");
            return (Criteria) this;
        }

        public Criteria andPipidEqualTo(String value) {
            addCriterion("pipId =", value, "pipid");
            return (Criteria) this;
        }

        public Criteria andPipidNotEqualTo(String value) {
            addCriterion("pipId <>", value, "pipid");
            return (Criteria) this;
        }

        public Criteria andPipidGreaterThan(String value) {
            addCriterion("pipId >", value, "pipid");
            return (Criteria) this;
        }

        public Criteria andPipidGreaterThanOrEqualTo(String value) {
            addCriterion("pipId >=", value, "pipid");
            return (Criteria) this;
        }

        public Criteria andPipidLessThan(String value) {
            addCriterion("pipId <", value, "pipid");
            return (Criteria) this;
        }

        public Criteria andPipidLessThanOrEqualTo(String value) {
            addCriterion("pipId <=", value, "pipid");
            return (Criteria) this;
        }

        public Criteria andPipidLike(String value) {
            addCriterion("pipId like", value, "pipid");
            return (Criteria) this;
        }

        public Criteria andPipidNotLike(String value) {
            addCriterion("pipId not like", value, "pipid");
            return (Criteria) this;
        }

        public Criteria andPipidIn(List<String> values) {
            addCriterion("pipId in", values, "pipid");
            return (Criteria) this;
        }

        public Criteria andPipidNotIn(List<String> values) {
            addCriterion("pipId not in", values, "pipid");
            return (Criteria) this;
        }

        public Criteria andPipidBetween(String value1, String value2) {
            addCriterion("pipId between", value1, value2, "pipid");
            return (Criteria) this;
        }

        public Criteria andPipidNotBetween(String value1, String value2) {
            addCriterion("pipId not between", value1, value2, "pipid");
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

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("operator like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("operator not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatortimeIsNull() {
            addCriterion("operatorTime is null");
            return (Criteria) this;
        }

        public Criteria andOperatortimeIsNotNull() {
            addCriterion("operatorTime is not null");
            return (Criteria) this;
        }

        public Criteria andOperatortimeEqualTo(Date value) {
            addCriterionForJDBCTime("operatorTime =", value, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("operatorTime <>", value, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeGreaterThan(Date value) {
            addCriterionForJDBCTime("operatorTime >", value, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("operatorTime >=", value, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeLessThan(Date value) {
            addCriterionForJDBCTime("operatorTime <", value, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("operatorTime <=", value, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeIn(List<Date> values) {
            addCriterionForJDBCTime("operatorTime in", values, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("operatorTime not in", values, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("operatorTime between", value1, value2, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("operatorTime not between", value1, value2, "operatortime");
            return (Criteria) this;
        }

        public Criteria andRemakeIsNull() {
            addCriterion("remake is null");
            return (Criteria) this;
        }

        public Criteria andRemakeIsNotNull() {
            addCriterion("remake is not null");
            return (Criteria) this;
        }

        public Criteria andRemakeEqualTo(String value) {
            addCriterion("remake =", value, "remake");
            return (Criteria) this;
        }

        public Criteria andRemakeNotEqualTo(String value) {
            addCriterion("remake <>", value, "remake");
            return (Criteria) this;
        }

        public Criteria andRemakeGreaterThan(String value) {
            addCriterion("remake >", value, "remake");
            return (Criteria) this;
        }

        public Criteria andRemakeGreaterThanOrEqualTo(String value) {
            addCriterion("remake >=", value, "remake");
            return (Criteria) this;
        }

        public Criteria andRemakeLessThan(String value) {
            addCriterion("remake <", value, "remake");
            return (Criteria) this;
        }

        public Criteria andRemakeLessThanOrEqualTo(String value) {
            addCriterion("remake <=", value, "remake");
            return (Criteria) this;
        }

        public Criteria andRemakeLike(String value) {
            addCriterion("remake like", value, "remake");
            return (Criteria) this;
        }

        public Criteria andRemakeNotLike(String value) {
            addCriterion("remake not like", value, "remake");
            return (Criteria) this;
        }

        public Criteria andRemakeIn(List<String> values) {
            addCriterion("remake in", values, "remake");
            return (Criteria) this;
        }

        public Criteria andRemakeNotIn(List<String> values) {
            addCriterion("remake not in", values, "remake");
            return (Criteria) this;
        }

        public Criteria andRemakeBetween(String value1, String value2) {
            addCriterion("remake between", value1, value2, "remake");
            return (Criteria) this;
        }

        public Criteria andRemakeNotBetween(String value1, String value2) {
            addCriterion("remake not between", value1, value2, "remake");
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