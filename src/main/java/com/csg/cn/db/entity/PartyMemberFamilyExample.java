package com.csg.cn.db.entity;

import java.util.ArrayList;
import java.util.List;

public class PartyMemberFamilyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PartyMemberFamilyExample() {
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

        public Criteria andFamilymemberidIsNull() {
            addCriterion("familyMemberId is null");
            return (Criteria) this;
        }

        public Criteria andFamilymemberidIsNotNull() {
            addCriterion("familyMemberId is not null");
            return (Criteria) this;
        }

        public Criteria andFamilymemberidEqualTo(String value) {
            addCriterion("familyMemberId =", value, "familymemberid");
            return (Criteria) this;
        }

        public Criteria andFamilymemberidNotEqualTo(String value) {
            addCriterion("familyMemberId <>", value, "familymemberid");
            return (Criteria) this;
        }

        public Criteria andFamilymemberidGreaterThan(String value) {
            addCriterion("familyMemberId >", value, "familymemberid");
            return (Criteria) this;
        }

        public Criteria andFamilymemberidGreaterThanOrEqualTo(String value) {
            addCriterion("familyMemberId >=", value, "familymemberid");
            return (Criteria) this;
        }

        public Criteria andFamilymemberidLessThan(String value) {
            addCriterion("familyMemberId <", value, "familymemberid");
            return (Criteria) this;
        }

        public Criteria andFamilymemberidLessThanOrEqualTo(String value) {
            addCriterion("familyMemberId <=", value, "familymemberid");
            return (Criteria) this;
        }

        public Criteria andFamilymemberidLike(String value) {
            addCriterion("familyMemberId like", value, "familymemberid");
            return (Criteria) this;
        }

        public Criteria andFamilymemberidNotLike(String value) {
            addCriterion("familyMemberId not like", value, "familymemberid");
            return (Criteria) this;
        }

        public Criteria andFamilymemberidIn(List<String> values) {
            addCriterion("familyMemberId in", values, "familymemberid");
            return (Criteria) this;
        }

        public Criteria andFamilymemberidNotIn(List<String> values) {
            addCriterion("familyMemberId not in", values, "familymemberid");
            return (Criteria) this;
        }

        public Criteria andFamilymemberidBetween(String value1, String value2) {
            addCriterion("familyMemberId between", value1, value2, "familymemberid");
            return (Criteria) this;
        }

        public Criteria andFamilymemberidNotBetween(String value1, String value2) {
            addCriterion("familyMemberId not between", value1, value2, "familymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidIsNull() {
            addCriterion("partyMemberId is null");
            return (Criteria) this;
        }

        public Criteria andPartymemberidIsNotNull() {
            addCriterion("partyMemberId is not null");
            return (Criteria) this;
        }

        public Criteria andPartymemberidEqualTo(String value) {
            addCriterion("partyMemberId =", value, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidNotEqualTo(String value) {
            addCriterion("partyMemberId <>", value, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidGreaterThan(String value) {
            addCriterion("partyMemberId >", value, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidGreaterThanOrEqualTo(String value) {
            addCriterion("partyMemberId >=", value, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidLessThan(String value) {
            addCriterion("partyMemberId <", value, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidLessThanOrEqualTo(String value) {
            addCriterion("partyMemberId <=", value, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidLike(String value) {
            addCriterion("partyMemberId like", value, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidNotLike(String value) {
            addCriterion("partyMemberId not like", value, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidIn(List<String> values) {
            addCriterion("partyMemberId in", values, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidNotIn(List<String> values) {
            addCriterion("partyMemberId not in", values, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidBetween(String value1, String value2) {
            addCriterion("partyMemberId between", value1, value2, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andPartymemberidNotBetween(String value1, String value2) {
            addCriterion("partyMemberId not between", value1, value2, "partymemberid");
            return (Criteria) this;
        }

        public Criteria andRelationIsNull() {
            addCriterion("relation is null");
            return (Criteria) this;
        }

        public Criteria andRelationIsNotNull() {
            addCriterion("relation is not null");
            return (Criteria) this;
        }

        public Criteria andRelationEqualTo(String value) {
            addCriterion("relation =", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotEqualTo(String value) {
            addCriterion("relation <>", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationGreaterThan(String value) {
            addCriterion("relation >", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationGreaterThanOrEqualTo(String value) {
            addCriterion("relation >=", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLessThan(String value) {
            addCriterion("relation <", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLessThanOrEqualTo(String value) {
            addCriterion("relation <=", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLike(String value) {
            addCriterion("relation like", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotLike(String value) {
            addCriterion("relation not like", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationIn(List<String> values) {
            addCriterion("relation in", values, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotIn(List<String> values) {
            addCriterion("relation not in", values, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationBetween(String value1, String value2) {
            addCriterion("relation between", value1, value2, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotBetween(String value1, String value2) {
            addCriterion("relation not between", value1, value2, "relation");
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

        public Criteria andZhengzhimianmaoIsNull() {
            addCriterion("zhengZhiMianMao is null");
            return (Criteria) this;
        }

        public Criteria andZhengzhimianmaoIsNotNull() {
            addCriterion("zhengZhiMianMao is not null");
            return (Criteria) this;
        }

        public Criteria andZhengzhimianmaoEqualTo(String value) {
            addCriterion("zhengZhiMianMao =", value, "zhengzhimianmao");
            return (Criteria) this;
        }

        public Criteria andZhengzhimianmaoNotEqualTo(String value) {
            addCriterion("zhengZhiMianMao <>", value, "zhengzhimianmao");
            return (Criteria) this;
        }

        public Criteria andZhengzhimianmaoGreaterThan(String value) {
            addCriterion("zhengZhiMianMao >", value, "zhengzhimianmao");
            return (Criteria) this;
        }

        public Criteria andZhengzhimianmaoGreaterThanOrEqualTo(String value) {
            addCriterion("zhengZhiMianMao >=", value, "zhengzhimianmao");
            return (Criteria) this;
        }

        public Criteria andZhengzhimianmaoLessThan(String value) {
            addCriterion("zhengZhiMianMao <", value, "zhengzhimianmao");
            return (Criteria) this;
        }

        public Criteria andZhengzhimianmaoLessThanOrEqualTo(String value) {
            addCriterion("zhengZhiMianMao <=", value, "zhengzhimianmao");
            return (Criteria) this;
        }

        public Criteria andZhengzhimianmaoLike(String value) {
            addCriterion("zhengZhiMianMao like", value, "zhengzhimianmao");
            return (Criteria) this;
        }

        public Criteria andZhengzhimianmaoNotLike(String value) {
            addCriterion("zhengZhiMianMao not like", value, "zhengzhimianmao");
            return (Criteria) this;
        }

        public Criteria andZhengzhimianmaoIn(List<String> values) {
            addCriterion("zhengZhiMianMao in", values, "zhengzhimianmao");
            return (Criteria) this;
        }

        public Criteria andZhengzhimianmaoNotIn(List<String> values) {
            addCriterion("zhengZhiMianMao not in", values, "zhengzhimianmao");
            return (Criteria) this;
        }

        public Criteria andZhengzhimianmaoBetween(String value1, String value2) {
            addCriterion("zhengZhiMianMao between", value1, value2, "zhengzhimianmao");
            return (Criteria) this;
        }

        public Criteria andZhengzhimianmaoNotBetween(String value1, String value2) {
            addCriterion("zhengZhiMianMao not between", value1, value2, "zhengzhimianmao");
            return (Criteria) this;
        }

        public Criteria andWorkIsNull() {
            addCriterion("work is null");
            return (Criteria) this;
        }

        public Criteria andWorkIsNotNull() {
            addCriterion("work is not null");
            return (Criteria) this;
        }

        public Criteria andWorkEqualTo(String value) {
            addCriterion("work =", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkNotEqualTo(String value) {
            addCriterion("work <>", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkGreaterThan(String value) {
            addCriterion("work >", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkGreaterThanOrEqualTo(String value) {
            addCriterion("work >=", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkLessThan(String value) {
            addCriterion("work <", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkLessThanOrEqualTo(String value) {
            addCriterion("work <=", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkLike(String value) {
            addCriterion("work like", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkNotLike(String value) {
            addCriterion("work not like", value, "work");
            return (Criteria) this;
        }

        public Criteria andWorkIn(List<String> values) {
            addCriterion("work in", values, "work");
            return (Criteria) this;
        }

        public Criteria andWorkNotIn(List<String> values) {
            addCriterion("work not in", values, "work");
            return (Criteria) this;
        }

        public Criteria andWorkBetween(String value1, String value2) {
            addCriterion("work between", value1, value2, "work");
            return (Criteria) this;
        }

        public Criteria andWorkNotBetween(String value1, String value2) {
            addCriterion("work not between", value1, value2, "work");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
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