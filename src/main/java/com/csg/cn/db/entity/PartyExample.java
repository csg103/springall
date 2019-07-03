package com.csg.cn.db.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PartyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PartyExample() {
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

        public Criteria andPartyidIsNull() {
            addCriterion("partyId is null");
            return (Criteria) this;
        }

        public Criteria andPartyidIsNotNull() {
            addCriterion("partyId is not null");
            return (Criteria) this;
        }

        public Criteria andPartyidEqualTo(String value) {
            addCriterion("partyId =", value, "partyid");
            return (Criteria) this;
        }

        public Criteria andPartyidNotEqualTo(String value) {
            addCriterion("partyId <>", value, "partyid");
            return (Criteria) this;
        }

        public Criteria andPartyidGreaterThan(String value) {
            addCriterion("partyId >", value, "partyid");
            return (Criteria) this;
        }

        public Criteria andPartyidGreaterThanOrEqualTo(String value) {
            addCriterion("partyId >=", value, "partyid");
            return (Criteria) this;
        }

        public Criteria andPartyidLessThan(String value) {
            addCriterion("partyId <", value, "partyid");
            return (Criteria) this;
        }

        public Criteria andPartyidLessThanOrEqualTo(String value) {
            addCriterion("partyId <=", value, "partyid");
            return (Criteria) this;
        }

        public Criteria andPartyidLike(String value) {
            addCriterion("partyId like", value, "partyid");
            return (Criteria) this;
        }

        public Criteria andPartyidNotLike(String value) {
            addCriterion("partyId not like", value, "partyid");
            return (Criteria) this;
        }

        public Criteria andPartyidIn(List<String> values) {
            addCriterion("partyId in", values, "partyid");
            return (Criteria) this;
        }

        public Criteria andPartyidNotIn(List<String> values) {
            addCriterion("partyId not in", values, "partyid");
            return (Criteria) this;
        }

        public Criteria andPartyidBetween(String value1, String value2) {
            addCriterion("partyId between", value1, value2, "partyid");
            return (Criteria) this;
        }

        public Criteria andPartyidNotBetween(String value1, String value2) {
            addCriterion("partyId not between", value1, value2, "partyid");
            return (Criteria) this;
        }

        public Criteria andPartynameIsNull() {
            addCriterion("partyName is null");
            return (Criteria) this;
        }

        public Criteria andPartynameIsNotNull() {
            addCriterion("partyName is not null");
            return (Criteria) this;
        }

        public Criteria andPartynameEqualTo(String value) {
            addCriterion("partyName =", value, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameNotEqualTo(String value) {
            addCriterion("partyName <>", value, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameGreaterThan(String value) {
            addCriterion("partyName >", value, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameGreaterThanOrEqualTo(String value) {
            addCriterion("partyName >=", value, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameLessThan(String value) {
            addCriterion("partyName <", value, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameLessThanOrEqualTo(String value) {
            addCriterion("partyName <=", value, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameLike(String value) {
            addCriterion("partyName like", value, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameNotLike(String value) {
            addCriterion("partyName not like", value, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameIn(List<String> values) {
            addCriterion("partyName in", values, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameNotIn(List<String> values) {
            addCriterion("partyName not in", values, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameBetween(String value1, String value2) {
            addCriterion("partyName between", value1, value2, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameNotBetween(String value1, String value2) {
            addCriterion("partyName not between", value1, value2, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartytimeIsNull() {
            addCriterion("partyTime is null");
            return (Criteria) this;
        }

        public Criteria andPartytimeIsNotNull() {
            addCriterion("partyTime is not null");
            return (Criteria) this;
        }

        public Criteria andPartytimeEqualTo(Date value) {
            addCriterionForJDBCDate("partyTime =", value, "partytime");
            return (Criteria) this;
        }

        public Criteria andPartytimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("partyTime <>", value, "partytime");
            return (Criteria) this;
        }

        public Criteria andPartytimeGreaterThan(Date value) {
            addCriterionForJDBCDate("partyTime >", value, "partytime");
            return (Criteria) this;
        }

        public Criteria andPartytimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("partyTime >=", value, "partytime");
            return (Criteria) this;
        }

        public Criteria andPartytimeLessThan(Date value) {
            addCriterionForJDBCDate("partyTime <", value, "partytime");
            return (Criteria) this;
        }

        public Criteria andPartytimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("partyTime <=", value, "partytime");
            return (Criteria) this;
        }

        public Criteria andPartytimeIn(List<Date> values) {
            addCriterionForJDBCDate("partyTime in", values, "partytime");
            return (Criteria) this;
        }

        public Criteria andPartytimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("partyTime not in", values, "partytime");
            return (Criteria) this;
        }

        public Criteria andPartytimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("partyTime between", value1, value2, "partytime");
            return (Criteria) this;
        }

        public Criteria andPartytimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("partyTime not between", value1, value2, "partytime");
            return (Criteria) this;
        }

        public Criteria andPartyadressIsNull() {
            addCriterion("partyAdress is null");
            return (Criteria) this;
        }

        public Criteria andPartyadressIsNotNull() {
            addCriterion("partyAdress is not null");
            return (Criteria) this;
        }

        public Criteria andPartyadressEqualTo(String value) {
            addCriterion("partyAdress =", value, "partyadress");
            return (Criteria) this;
        }

        public Criteria andPartyadressNotEqualTo(String value) {
            addCriterion("partyAdress <>", value, "partyadress");
            return (Criteria) this;
        }

        public Criteria andPartyadressGreaterThan(String value) {
            addCriterion("partyAdress >", value, "partyadress");
            return (Criteria) this;
        }

        public Criteria andPartyadressGreaterThanOrEqualTo(String value) {
            addCriterion("partyAdress >=", value, "partyadress");
            return (Criteria) this;
        }

        public Criteria andPartyadressLessThan(String value) {
            addCriterion("partyAdress <", value, "partyadress");
            return (Criteria) this;
        }

        public Criteria andPartyadressLessThanOrEqualTo(String value) {
            addCriterion("partyAdress <=", value, "partyadress");
            return (Criteria) this;
        }

        public Criteria andPartyadressLike(String value) {
            addCriterion("partyAdress like", value, "partyadress");
            return (Criteria) this;
        }

        public Criteria andPartyadressNotLike(String value) {
            addCriterion("partyAdress not like", value, "partyadress");
            return (Criteria) this;
        }

        public Criteria andPartyadressIn(List<String> values) {
            addCriterion("partyAdress in", values, "partyadress");
            return (Criteria) this;
        }

        public Criteria andPartyadressNotIn(List<String> values) {
            addCriterion("partyAdress not in", values, "partyadress");
            return (Criteria) this;
        }

        public Criteria andPartyadressBetween(String value1, String value2) {
            addCriterion("partyAdress between", value1, value2, "partyadress");
            return (Criteria) this;
        }

        public Criteria andPartyadressNotBetween(String value1, String value2) {
            addCriterion("partyAdress not between", value1, value2, "partyadress");
            return (Criteria) this;
        }

        public Criteria andPartyplayersIsNull() {
            addCriterion("partyPlayers is null");
            return (Criteria) this;
        }

        public Criteria andPartyplayersIsNotNull() {
            addCriterion("partyPlayers is not null");
            return (Criteria) this;
        }

        public Criteria andPartyplayersEqualTo(String value) {
            addCriterion("partyPlayers =", value, "partyplayers");
            return (Criteria) this;
        }

        public Criteria andPartyplayersNotEqualTo(String value) {
            addCriterion("partyPlayers <>", value, "partyplayers");
            return (Criteria) this;
        }

        public Criteria andPartyplayersGreaterThan(String value) {
            addCriterion("partyPlayers >", value, "partyplayers");
            return (Criteria) this;
        }

        public Criteria andPartyplayersGreaterThanOrEqualTo(String value) {
            addCriterion("partyPlayers >=", value, "partyplayers");
            return (Criteria) this;
        }

        public Criteria andPartyplayersLessThan(String value) {
            addCriterion("partyPlayers <", value, "partyplayers");
            return (Criteria) this;
        }

        public Criteria andPartyplayersLessThanOrEqualTo(String value) {
            addCriterion("partyPlayers <=", value, "partyplayers");
            return (Criteria) this;
        }

        public Criteria andPartyplayersLike(String value) {
            addCriterion("partyPlayers like", value, "partyplayers");
            return (Criteria) this;
        }

        public Criteria andPartyplayersNotLike(String value) {
            addCriterion("partyPlayers not like", value, "partyplayers");
            return (Criteria) this;
        }

        public Criteria andPartyplayersIn(List<String> values) {
            addCriterion("partyPlayers in", values, "partyplayers");
            return (Criteria) this;
        }

        public Criteria andPartyplayersNotIn(List<String> values) {
            addCriterion("partyPlayers not in", values, "partyplayers");
            return (Criteria) this;
        }

        public Criteria andPartyplayersBetween(String value1, String value2) {
            addCriterion("partyPlayers between", value1, value2, "partyplayers");
            return (Criteria) this;
        }

        public Criteria andPartyplayersNotBetween(String value1, String value2) {
            addCriterion("partyPlayers not between", value1, value2, "partyplayers");
            return (Criteria) this;
        }

        public Criteria andOperIsNull() {
            addCriterion("oper is null");
            return (Criteria) this;
        }

        public Criteria andOperIsNotNull() {
            addCriterion("oper is not null");
            return (Criteria) this;
        }

        public Criteria andOperEqualTo(String value) {
            addCriterion("oper =", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperNotEqualTo(String value) {
            addCriterion("oper <>", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperGreaterThan(String value) {
            addCriterion("oper >", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperGreaterThanOrEqualTo(String value) {
            addCriterion("oper >=", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperLessThan(String value) {
            addCriterion("oper <", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperLessThanOrEqualTo(String value) {
            addCriterion("oper <=", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperLike(String value) {
            addCriterion("oper like", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperNotLike(String value) {
            addCriterion("oper not like", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperIn(List<String> values) {
            addCriterion("oper in", values, "oper");
            return (Criteria) this;
        }

        public Criteria andOperNotIn(List<String> values) {
            addCriterion("oper not in", values, "oper");
            return (Criteria) this;
        }

        public Criteria andOperBetween(String value1, String value2) {
            addCriterion("oper between", value1, value2, "oper");
            return (Criteria) this;
        }

        public Criteria andOperNotBetween(String value1, String value2) {
            addCriterion("oper not between", value1, value2, "oper");
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
            addCriterionForJDBCDate("operTime =", value, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("operTime <>", value, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeGreaterThan(Date value) {
            addCriterionForJDBCDate("operTime >", value, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("operTime >=", value, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeLessThan(Date value) {
            addCriterionForJDBCDate("operTime <", value, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("operTime <=", value, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeIn(List<Date> values) {
            addCriterionForJDBCDate("operTime in", values, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("operTime not in", values, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("operTime between", value1, value2, "opertime");
            return (Criteria) this;
        }

        public Criteria andOpertimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("operTime not between", value1, value2, "opertime");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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