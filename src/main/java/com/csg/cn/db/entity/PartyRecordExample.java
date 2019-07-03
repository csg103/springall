package com.csg.cn.db.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PartyRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PartyRecordExample() {
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

        public Criteria andRecordidIsNull() {
            addCriterion("recordId is null");
            return (Criteria) this;
        }

        public Criteria andRecordidIsNotNull() {
            addCriterion("recordId is not null");
            return (Criteria) this;
        }

        public Criteria andRecordidEqualTo(String value) {
            addCriterion("recordId =", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidNotEqualTo(String value) {
            addCriterion("recordId <>", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidGreaterThan(String value) {
            addCriterion("recordId >", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidGreaterThanOrEqualTo(String value) {
            addCriterion("recordId >=", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidLessThan(String value) {
            addCriterion("recordId <", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidLessThanOrEqualTo(String value) {
            addCriterion("recordId <=", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidLike(String value) {
            addCriterion("recordId like", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidNotLike(String value) {
            addCriterion("recordId not like", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidIn(List<String> values) {
            addCriterion("recordId in", values, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidNotIn(List<String> values) {
            addCriterion("recordId not in", values, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidBetween(String value1, String value2) {
            addCriterion("recordId between", value1, value2, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidNotBetween(String value1, String value2) {
            addCriterion("recordId not between", value1, value2, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordnameIsNull() {
            addCriterion("recordName is null");
            return (Criteria) this;
        }

        public Criteria andRecordnameIsNotNull() {
            addCriterion("recordName is not null");
            return (Criteria) this;
        }

        public Criteria andRecordnameEqualTo(String value) {
            addCriterion("recordName =", value, "recordname");
            return (Criteria) this;
        }

        public Criteria andRecordnameNotEqualTo(String value) {
            addCriterion("recordName <>", value, "recordname");
            return (Criteria) this;
        }

        public Criteria andRecordnameGreaterThan(String value) {
            addCriterion("recordName >", value, "recordname");
            return (Criteria) this;
        }

        public Criteria andRecordnameGreaterThanOrEqualTo(String value) {
            addCriterion("recordName >=", value, "recordname");
            return (Criteria) this;
        }

        public Criteria andRecordnameLessThan(String value) {
            addCriterion("recordName <", value, "recordname");
            return (Criteria) this;
        }

        public Criteria andRecordnameLessThanOrEqualTo(String value) {
            addCriterion("recordName <=", value, "recordname");
            return (Criteria) this;
        }

        public Criteria andRecordnameLike(String value) {
            addCriterion("recordName like", value, "recordname");
            return (Criteria) this;
        }

        public Criteria andRecordnameNotLike(String value) {
            addCriterion("recordName not like", value, "recordname");
            return (Criteria) this;
        }

        public Criteria andRecordnameIn(List<String> values) {
            addCriterion("recordName in", values, "recordname");
            return (Criteria) this;
        }

        public Criteria andRecordnameNotIn(List<String> values) {
            addCriterion("recordName not in", values, "recordname");
            return (Criteria) this;
        }

        public Criteria andRecordnameBetween(String value1, String value2) {
            addCriterion("recordName between", value1, value2, "recordname");
            return (Criteria) this;
        }

        public Criteria andRecordnameNotBetween(String value1, String value2) {
            addCriterion("recordName not between", value1, value2, "recordname");
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

        public Criteria andPicurlIsNull() {
            addCriterion("picUrl is null");
            return (Criteria) this;
        }

        public Criteria andPicurlIsNotNull() {
            addCriterion("picUrl is not null");
            return (Criteria) this;
        }

        public Criteria andPicurlEqualTo(String value) {
            addCriterion("picUrl =", value, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlNotEqualTo(String value) {
            addCriterion("picUrl <>", value, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlGreaterThan(String value) {
            addCriterion("picUrl >", value, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlGreaterThanOrEqualTo(String value) {
            addCriterion("picUrl >=", value, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlLessThan(String value) {
            addCriterion("picUrl <", value, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlLessThanOrEqualTo(String value) {
            addCriterion("picUrl <=", value, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlLike(String value) {
            addCriterion("picUrl like", value, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlNotLike(String value) {
            addCriterion("picUrl not like", value, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlIn(List<String> values) {
            addCriterion("picUrl in", values, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlNotIn(List<String> values) {
            addCriterion("picUrl not in", values, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlBetween(String value1, String value2) {
            addCriterion("picUrl between", value1, value2, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlNotBetween(String value1, String value2) {
            addCriterion("picUrl not between", value1, value2, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicipIsNull() {
            addCriterion("PicIp is null");
            return (Criteria) this;
        }

        public Criteria andPicipIsNotNull() {
            addCriterion("PicIp is not null");
            return (Criteria) this;
        }

        public Criteria andPicipEqualTo(String value) {
            addCriterion("PicIp =", value, "picip");
            return (Criteria) this;
        }

        public Criteria andPicipNotEqualTo(String value) {
            addCriterion("PicIp <>", value, "picip");
            return (Criteria) this;
        }

        public Criteria andPicipGreaterThan(String value) {
            addCriterion("PicIp >", value, "picip");
            return (Criteria) this;
        }

        public Criteria andPicipGreaterThanOrEqualTo(String value) {
            addCriterion("PicIp >=", value, "picip");
            return (Criteria) this;
        }

        public Criteria andPicipLessThan(String value) {
            addCriterion("PicIp <", value, "picip");
            return (Criteria) this;
        }

        public Criteria andPicipLessThanOrEqualTo(String value) {
            addCriterion("PicIp <=", value, "picip");
            return (Criteria) this;
        }

        public Criteria andPicipLike(String value) {
            addCriterion("PicIp like", value, "picip");
            return (Criteria) this;
        }

        public Criteria andPicipNotLike(String value) {
            addCriterion("PicIp not like", value, "picip");
            return (Criteria) this;
        }

        public Criteria andPicipIn(List<String> values) {
            addCriterion("PicIp in", values, "picip");
            return (Criteria) this;
        }

        public Criteria andPicipNotIn(List<String> values) {
            addCriterion("PicIp not in", values, "picip");
            return (Criteria) this;
        }

        public Criteria andPicipBetween(String value1, String value2) {
            addCriterion("PicIp between", value1, value2, "picip");
            return (Criteria) this;
        }

        public Criteria andPicipNotBetween(String value1, String value2) {
            addCriterion("PicIp not between", value1, value2, "picip");
            return (Criteria) this;
        }

        public Criteria andUploadtimeIsNull() {
            addCriterion("uploadTime is null");
            return (Criteria) this;
        }

        public Criteria andUploadtimeIsNotNull() {
            addCriterion("uploadTime is not null");
            return (Criteria) this;
        }

        public Criteria andUploadtimeEqualTo(Date value) {
            addCriterionForJDBCDate("uploadTime =", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("uploadTime <>", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("uploadTime >", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("uploadTime >=", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeLessThan(Date value) {
            addCriterionForJDBCDate("uploadTime <", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("uploadTime <=", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeIn(List<Date> values) {
            addCriterionForJDBCDate("uploadTime in", values, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("uploadTime not in", values, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("uploadTime between", value1, value2, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("uploadTime not between", value1, value2, "uploadtime");
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