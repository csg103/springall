package com.csg.cn.db.entity;

import java.util.ArrayList;
import java.util.List;

public class PartyMemberScorePipExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PartyMemberScorePipExample() {
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

        public Criteria andScoreidIsNull() {
            addCriterion("scoreId is null");
            return (Criteria) this;
        }

        public Criteria andScoreidIsNotNull() {
            addCriterion("scoreId is not null");
            return (Criteria) this;
        }

        public Criteria andScoreidEqualTo(String value) {
            addCriterion("scoreId =", value, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidNotEqualTo(String value) {
            addCriterion("scoreId <>", value, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidGreaterThan(String value) {
            addCriterion("scoreId >", value, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidGreaterThanOrEqualTo(String value) {
            addCriterion("scoreId >=", value, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidLessThan(String value) {
            addCriterion("scoreId <", value, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidLessThanOrEqualTo(String value) {
            addCriterion("scoreId <=", value, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidLike(String value) {
            addCriterion("scoreId like", value, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidNotLike(String value) {
            addCriterion("scoreId not like", value, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidIn(List<String> values) {
            addCriterion("scoreId in", values, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidNotIn(List<String> values) {
            addCriterion("scoreId not in", values, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidBetween(String value1, String value2) {
            addCriterion("scoreId between", value1, value2, "scoreid");
            return (Criteria) this;
        }

        public Criteria andScoreidNotBetween(String value1, String value2) {
            addCriterion("scoreId not between", value1, value2, "scoreid");
            return (Criteria) this;
        }

        public Criteria andIsaddIsNull() {
            addCriterion("isAdd is null");
            return (Criteria) this;
        }

        public Criteria andIsaddIsNotNull() {
            addCriterion("isAdd is not null");
            return (Criteria) this;
        }

        public Criteria andIsaddEqualTo(String value) {
            addCriterion("isAdd =", value, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddNotEqualTo(String value) {
            addCriterion("isAdd <>", value, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddGreaterThan(String value) {
            addCriterion("isAdd >", value, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddGreaterThanOrEqualTo(String value) {
            addCriterion("isAdd >=", value, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddLessThan(String value) {
            addCriterion("isAdd <", value, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddLessThanOrEqualTo(String value) {
            addCriterion("isAdd <=", value, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddLike(String value) {
            addCriterion("isAdd like", value, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddNotLike(String value) {
            addCriterion("isAdd not like", value, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddIn(List<String> values) {
            addCriterion("isAdd in", values, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddNotIn(List<String> values) {
            addCriterion("isAdd not in", values, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddBetween(String value1, String value2) {
            addCriterion("isAdd between", value1, value2, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddNotBetween(String value1, String value2) {
            addCriterion("isAdd not between", value1, value2, "isadd");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPipIsNull() {
            addCriterion("pip is null");
            return (Criteria) this;
        }

        public Criteria andPipIsNotNull() {
            addCriterion("pip is not null");
            return (Criteria) this;
        }

        public Criteria andPipEqualTo(String value) {
            addCriterion("pip =", value, "pip");
            return (Criteria) this;
        }

        public Criteria andPipNotEqualTo(String value) {
            addCriterion("pip <>", value, "pip");
            return (Criteria) this;
        }

        public Criteria andPipGreaterThan(String value) {
            addCriterion("pip >", value, "pip");
            return (Criteria) this;
        }

        public Criteria andPipGreaterThanOrEqualTo(String value) {
            addCriterion("pip >=", value, "pip");
            return (Criteria) this;
        }

        public Criteria andPipLessThan(String value) {
            addCriterion("pip <", value, "pip");
            return (Criteria) this;
        }

        public Criteria andPipLessThanOrEqualTo(String value) {
            addCriterion("pip <=", value, "pip");
            return (Criteria) this;
        }

        public Criteria andPipLike(String value) {
            addCriterion("pip like", value, "pip");
            return (Criteria) this;
        }

        public Criteria andPipNotLike(String value) {
            addCriterion("pip not like", value, "pip");
            return (Criteria) this;
        }

        public Criteria andPipIn(List<String> values) {
            addCriterion("pip in", values, "pip");
            return (Criteria) this;
        }

        public Criteria andPipNotIn(List<String> values) {
            addCriterion("pip not in", values, "pip");
            return (Criteria) this;
        }

        public Criteria andPipBetween(String value1, String value2) {
            addCriterion("pip between", value1, value2, "pip");
            return (Criteria) this;
        }

        public Criteria andPipNotBetween(String value1, String value2) {
            addCriterion("pip not between", value1, value2, "pip");
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