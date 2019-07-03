package com.csg.cn.db.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PartyMemberMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PartyMemberMessageExample() {
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

        public Criteria andParytmemberidIsNull() {
            addCriterion("parytMemberId is null");
            return (Criteria) this;
        }

        public Criteria andParytmemberidIsNotNull() {
            addCriterion("parytMemberId is not null");
            return (Criteria) this;
        }

        public Criteria andParytmemberidEqualTo(String value) {
            addCriterion("parytMemberId =", value, "parytmemberid");
            return (Criteria) this;
        }

        public Criteria andParytmemberidNotEqualTo(String value) {
            addCriterion("parytMemberId <>", value, "parytmemberid");
            return (Criteria) this;
        }

        public Criteria andParytmemberidGreaterThan(String value) {
            addCriterion("parytMemberId >", value, "parytmemberid");
            return (Criteria) this;
        }

        public Criteria andParytmemberidGreaterThanOrEqualTo(String value) {
            addCriterion("parytMemberId >=", value, "parytmemberid");
            return (Criteria) this;
        }

        public Criteria andParytmemberidLessThan(String value) {
            addCriterion("parytMemberId <", value, "parytmemberid");
            return (Criteria) this;
        }

        public Criteria andParytmemberidLessThanOrEqualTo(String value) {
            addCriterion("parytMemberId <=", value, "parytmemberid");
            return (Criteria) this;
        }

        public Criteria andParytmemberidLike(String value) {
            addCriterion("parytMemberId like", value, "parytmemberid");
            return (Criteria) this;
        }

        public Criteria andParytmemberidNotLike(String value) {
            addCriterion("parytMemberId not like", value, "parytmemberid");
            return (Criteria) this;
        }

        public Criteria andParytmemberidIn(List<String> values) {
            addCriterion("parytMemberId in", values, "parytmemberid");
            return (Criteria) this;
        }

        public Criteria andParytmemberidNotIn(List<String> values) {
            addCriterion("parytMemberId not in", values, "parytmemberid");
            return (Criteria) this;
        }

        public Criteria andParytmemberidBetween(String value1, String value2) {
            addCriterion("parytMemberId between", value1, value2, "parytmemberid");
            return (Criteria) this;
        }

        public Criteria andParytmemberidNotBetween(String value1, String value2) {
            addCriterion("parytMemberId not between", value1, value2, "parytmemberid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIsNull() {
            addCriterion("departmentId is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIsNotNull() {
            addCriterion("departmentId is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentidEqualTo(String value) {
            addCriterion("departmentId =", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotEqualTo(String value) {
            addCriterion("departmentId <>", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidGreaterThan(String value) {
            addCriterion("departmentId >", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidGreaterThanOrEqualTo(String value) {
            addCriterion("departmentId >=", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidLessThan(String value) {
            addCriterion("departmentId <", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidLessThanOrEqualTo(String value) {
            addCriterion("departmentId <=", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidLike(String value) {
            addCriterion("departmentId like", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotLike(String value) {
            addCriterion("departmentId not like", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIn(List<String> values) {
            addCriterion("departmentId in", values, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotIn(List<String> values) {
            addCriterion("departmentId not in", values, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidBetween(String value1, String value2) {
            addCriterion("departmentId between", value1, value2, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotBetween(String value1, String value2) {
            addCriterion("departmentId not between", value1, value2, "departmentid");
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

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andEthnicgroupIsNull() {
            addCriterion("ethnicGroup is null");
            return (Criteria) this;
        }

        public Criteria andEthnicgroupIsNotNull() {
            addCriterion("ethnicGroup is not null");
            return (Criteria) this;
        }

        public Criteria andEthnicgroupEqualTo(String value) {
            addCriterion("ethnicGroup =", value, "ethnicgroup");
            return (Criteria) this;
        }

        public Criteria andEthnicgroupNotEqualTo(String value) {
            addCriterion("ethnicGroup <>", value, "ethnicgroup");
            return (Criteria) this;
        }

        public Criteria andEthnicgroupGreaterThan(String value) {
            addCriterion("ethnicGroup >", value, "ethnicgroup");
            return (Criteria) this;
        }

        public Criteria andEthnicgroupGreaterThanOrEqualTo(String value) {
            addCriterion("ethnicGroup >=", value, "ethnicgroup");
            return (Criteria) this;
        }

        public Criteria andEthnicgroupLessThan(String value) {
            addCriterion("ethnicGroup <", value, "ethnicgroup");
            return (Criteria) this;
        }

        public Criteria andEthnicgroupLessThanOrEqualTo(String value) {
            addCriterion("ethnicGroup <=", value, "ethnicgroup");
            return (Criteria) this;
        }

        public Criteria andEthnicgroupLike(String value) {
            addCriterion("ethnicGroup like", value, "ethnicgroup");
            return (Criteria) this;
        }

        public Criteria andEthnicgroupNotLike(String value) {
            addCriterion("ethnicGroup not like", value, "ethnicgroup");
            return (Criteria) this;
        }

        public Criteria andEthnicgroupIn(List<String> values) {
            addCriterion("ethnicGroup in", values, "ethnicgroup");
            return (Criteria) this;
        }

        public Criteria andEthnicgroupNotIn(List<String> values) {
            addCriterion("ethnicGroup not in", values, "ethnicgroup");
            return (Criteria) this;
        }

        public Criteria andEthnicgroupBetween(String value1, String value2) {
            addCriterion("ethnicGroup between", value1, value2, "ethnicgroup");
            return (Criteria) this;
        }

        public Criteria andEthnicgroupNotBetween(String value1, String value2) {
            addCriterion("ethnicGroup not between", value1, value2, "ethnicgroup");
            return (Criteria) this;
        }

        public Criteria andBirthplaceIsNull() {
            addCriterion("birthPlace is null");
            return (Criteria) this;
        }

        public Criteria andBirthplaceIsNotNull() {
            addCriterion("birthPlace is not null");
            return (Criteria) this;
        }

        public Criteria andBirthplaceEqualTo(String value) {
            addCriterion("birthPlace =", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceNotEqualTo(String value) {
            addCriterion("birthPlace <>", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceGreaterThan(String value) {
            addCriterion("birthPlace >", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceGreaterThanOrEqualTo(String value) {
            addCriterion("birthPlace >=", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceLessThan(String value) {
            addCriterion("birthPlace <", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceLessThanOrEqualTo(String value) {
            addCriterion("birthPlace <=", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceLike(String value) {
            addCriterion("birthPlace like", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceNotLike(String value) {
            addCriterion("birthPlace not like", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceIn(List<String> values) {
            addCriterion("birthPlace in", values, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceNotIn(List<String> values) {
            addCriterion("birthPlace not in", values, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceBetween(String value1, String value2) {
            addCriterion("birthPlace between", value1, value2, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceNotBetween(String value1, String value2) {
            addCriterion("birthPlace not between", value1, value2, "birthplace");
            return (Criteria) this;
        }

        public Criteria andMarryIsNull() {
            addCriterion("Marry is null");
            return (Criteria) this;
        }

        public Criteria andMarryIsNotNull() {
            addCriterion("Marry is not null");
            return (Criteria) this;
        }

        public Criteria andMarryEqualTo(String value) {
            addCriterion("Marry =", value, "marry");
            return (Criteria) this;
        }

        public Criteria andMarryNotEqualTo(String value) {
            addCriterion("Marry <>", value, "marry");
            return (Criteria) this;
        }

        public Criteria andMarryGreaterThan(String value) {
            addCriterion("Marry >", value, "marry");
            return (Criteria) this;
        }

        public Criteria andMarryGreaterThanOrEqualTo(String value) {
            addCriterion("Marry >=", value, "marry");
            return (Criteria) this;
        }

        public Criteria andMarryLessThan(String value) {
            addCriterion("Marry <", value, "marry");
            return (Criteria) this;
        }

        public Criteria andMarryLessThanOrEqualTo(String value) {
            addCriterion("Marry <=", value, "marry");
            return (Criteria) this;
        }

        public Criteria andMarryLike(String value) {
            addCriterion("Marry like", value, "marry");
            return (Criteria) this;
        }

        public Criteria andMarryNotLike(String value) {
            addCriterion("Marry not like", value, "marry");
            return (Criteria) this;
        }

        public Criteria andMarryIn(List<String> values) {
            addCriterion("Marry in", values, "marry");
            return (Criteria) this;
        }

        public Criteria andMarryNotIn(List<String> values) {
            addCriterion("Marry not in", values, "marry");
            return (Criteria) this;
        }

        public Criteria andMarryBetween(String value1, String value2) {
            addCriterion("Marry between", value1, value2, "marry");
            return (Criteria) this;
        }

        public Criteria andMarryNotBetween(String value1, String value2) {
            addCriterion("Marry not between", value1, value2, "marry");
            return (Criteria) this;
        }

        public Criteria andEducationIsNull() {
            addCriterion("education is null");
            return (Criteria) this;
        }

        public Criteria andEducationIsNotNull() {
            addCriterion("education is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEqualTo(String value) {
            addCriterion("education =", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotEqualTo(String value) {
            addCriterion("education <>", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThan(String value) {
            addCriterion("education >", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThanOrEqualTo(String value) {
            addCriterion("education >=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThan(String value) {
            addCriterion("education <", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThanOrEqualTo(String value) {
            addCriterion("education <=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLike(String value) {
            addCriterion("education like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotLike(String value) {
            addCriterion("education not like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationIn(List<String> values) {
            addCriterion("education in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotIn(List<String> values) {
            addCriterion("education not in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationBetween(String value1, String value2) {
            addCriterion("education between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotBetween(String value1, String value2) {
            addCriterion("education not between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNull() {
            addCriterion("school is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNotNull() {
            addCriterion("school is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolEqualTo(String value) {
            addCriterion("school =", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotEqualTo(String value) {
            addCriterion("school <>", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThan(String value) {
            addCriterion("school >", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("school >=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThan(String value) {
            addCriterion("school <", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThanOrEqualTo(String value) {
            addCriterion("school <=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLike(String value) {
            addCriterion("school like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotLike(String value) {
            addCriterion("school not like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolIn(List<String> values) {
            addCriterion("school in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotIn(List<String> values) {
            addCriterion("school not in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolBetween(String value1, String value2) {
            addCriterion("school between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotBetween(String value1, String value2) {
            addCriterion("school not between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andJoinpartytimeIsNull() {
            addCriterion("joinPartyTime is null");
            return (Criteria) this;
        }

        public Criteria andJoinpartytimeIsNotNull() {
            addCriterion("joinPartyTime is not null");
            return (Criteria) this;
        }

        public Criteria andJoinpartytimeEqualTo(Date value) {
            addCriterionForJDBCDate("joinPartyTime =", value, "joinpartytime");
            return (Criteria) this;
        }

        public Criteria andJoinpartytimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("joinPartyTime <>", value, "joinpartytime");
            return (Criteria) this;
        }

        public Criteria andJoinpartytimeGreaterThan(Date value) {
            addCriterionForJDBCDate("joinPartyTime >", value, "joinpartytime");
            return (Criteria) this;
        }

        public Criteria andJoinpartytimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("joinPartyTime >=", value, "joinpartytime");
            return (Criteria) this;
        }

        public Criteria andJoinpartytimeLessThan(Date value) {
            addCriterionForJDBCDate("joinPartyTime <", value, "joinpartytime");
            return (Criteria) this;
        }

        public Criteria andJoinpartytimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("joinPartyTime <=", value, "joinpartytime");
            return (Criteria) this;
        }

        public Criteria andJoinpartytimeIn(List<Date> values) {
            addCriterionForJDBCDate("joinPartyTime in", values, "joinpartytime");
            return (Criteria) this;
        }

        public Criteria andJoinpartytimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("joinPartyTime not in", values, "joinpartytime");
            return (Criteria) this;
        }

        public Criteria andJoinpartytimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("joinPartyTime between", value1, value2, "joinpartytime");
            return (Criteria) this;
        }

        public Criteria andJoinpartytimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("joinPartyTime not between", value1, value2, "joinpartytime");
            return (Criteria) this;
        }

        public Criteria andRealjoinpartytimeIsNull() {
            addCriterion("realJoinPartyTime is null");
            return (Criteria) this;
        }

        public Criteria andRealjoinpartytimeIsNotNull() {
            addCriterion("realJoinPartyTime is not null");
            return (Criteria) this;
        }

        public Criteria andRealjoinpartytimeEqualTo(Date value) {
            addCriterionForJDBCDate("realJoinPartyTime =", value, "realjoinpartytime");
            return (Criteria) this;
        }

        public Criteria andRealjoinpartytimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("realJoinPartyTime <>", value, "realjoinpartytime");
            return (Criteria) this;
        }

        public Criteria andRealjoinpartytimeGreaterThan(Date value) {
            addCriterionForJDBCDate("realJoinPartyTime >", value, "realjoinpartytime");
            return (Criteria) this;
        }

        public Criteria andRealjoinpartytimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("realJoinPartyTime >=", value, "realjoinpartytime");
            return (Criteria) this;
        }

        public Criteria andRealjoinpartytimeLessThan(Date value) {
            addCriterionForJDBCDate("realJoinPartyTime <", value, "realjoinpartytime");
            return (Criteria) this;
        }

        public Criteria andRealjoinpartytimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("realJoinPartyTime <=", value, "realjoinpartytime");
            return (Criteria) this;
        }

        public Criteria andRealjoinpartytimeIn(List<Date> values) {
            addCriterionForJDBCDate("realJoinPartyTime in", values, "realjoinpartytime");
            return (Criteria) this;
        }

        public Criteria andRealjoinpartytimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("realJoinPartyTime not in", values, "realjoinpartytime");
            return (Criteria) this;
        }

        public Criteria andRealjoinpartytimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("realJoinPartyTime between", value1, value2, "realjoinpartytime");
            return (Criteria) this;
        }

        public Criteria andRealjoinpartytimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("realJoinPartyTime not between", value1, value2, "realjoinpartytime");
            return (Criteria) this;
        }

        public Criteria andPartymemberjobIsNull() {
            addCriterion("partyMemberJob is null");
            return (Criteria) this;
        }

        public Criteria andPartymemberjobIsNotNull() {
            addCriterion("partyMemberJob is not null");
            return (Criteria) this;
        }

        public Criteria andPartymemberjobEqualTo(String value) {
            addCriterion("partyMemberJob =", value, "partymemberjob");
            return (Criteria) this;
        }

        public Criteria andPartymemberjobNotEqualTo(String value) {
            addCriterion("partyMemberJob <>", value, "partymemberjob");
            return (Criteria) this;
        }

        public Criteria andPartymemberjobGreaterThan(String value) {
            addCriterion("partyMemberJob >", value, "partymemberjob");
            return (Criteria) this;
        }

        public Criteria andPartymemberjobGreaterThanOrEqualTo(String value) {
            addCriterion("partyMemberJob >=", value, "partymemberjob");
            return (Criteria) this;
        }

        public Criteria andPartymemberjobLessThan(String value) {
            addCriterion("partyMemberJob <", value, "partymemberjob");
            return (Criteria) this;
        }

        public Criteria andPartymemberjobLessThanOrEqualTo(String value) {
            addCriterion("partyMemberJob <=", value, "partymemberjob");
            return (Criteria) this;
        }

        public Criteria andPartymemberjobLike(String value) {
            addCriterion("partyMemberJob like", value, "partymemberjob");
            return (Criteria) this;
        }

        public Criteria andPartymemberjobNotLike(String value) {
            addCriterion("partyMemberJob not like", value, "partymemberjob");
            return (Criteria) this;
        }

        public Criteria andPartymemberjobIn(List<String> values) {
            addCriterion("partyMemberJob in", values, "partymemberjob");
            return (Criteria) this;
        }

        public Criteria andPartymemberjobNotIn(List<String> values) {
            addCriterion("partyMemberJob not in", values, "partymemberjob");
            return (Criteria) this;
        }

        public Criteria andPartymemberjobBetween(String value1, String value2) {
            addCriterion("partyMemberJob between", value1, value2, "partymemberjob");
            return (Criteria) this;
        }

        public Criteria andPartymemberjobNotBetween(String value1, String value2) {
            addCriterion("partyMemberJob not between", value1, value2, "partymemberjob");
            return (Criteria) this;
        }

        public Criteria andWorktimeIsNull() {
            addCriterion("workTime is null");
            return (Criteria) this;
        }

        public Criteria andWorktimeIsNotNull() {
            addCriterion("workTime is not null");
            return (Criteria) this;
        }

        public Criteria andWorktimeEqualTo(Date value) {
            addCriterionForJDBCDate("workTime =", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("workTime <>", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeGreaterThan(Date value) {
            addCriterionForJDBCDate("workTime >", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("workTime >=", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeLessThan(Date value) {
            addCriterionForJDBCDate("workTime <", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("workTime <=", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeIn(List<Date> values) {
            addCriterionForJDBCDate("workTime in", values, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("workTime not in", values, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("workTime between", value1, value2, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("workTime not between", value1, value2, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorkjobIsNull() {
            addCriterion("workJob is null");
            return (Criteria) this;
        }

        public Criteria andWorkjobIsNotNull() {
            addCriterion("workJob is not null");
            return (Criteria) this;
        }

        public Criteria andWorkjobEqualTo(String value) {
            addCriterion("workJob =", value, "workjob");
            return (Criteria) this;
        }

        public Criteria andWorkjobNotEqualTo(String value) {
            addCriterion("workJob <>", value, "workjob");
            return (Criteria) this;
        }

        public Criteria andWorkjobGreaterThan(String value) {
            addCriterion("workJob >", value, "workjob");
            return (Criteria) this;
        }

        public Criteria andWorkjobGreaterThanOrEqualTo(String value) {
            addCriterion("workJob >=", value, "workjob");
            return (Criteria) this;
        }

        public Criteria andWorkjobLessThan(String value) {
            addCriterion("workJob <", value, "workjob");
            return (Criteria) this;
        }

        public Criteria andWorkjobLessThanOrEqualTo(String value) {
            addCriterion("workJob <=", value, "workjob");
            return (Criteria) this;
        }

        public Criteria andWorkjobLike(String value) {
            addCriterion("workJob like", value, "workjob");
            return (Criteria) this;
        }

        public Criteria andWorkjobNotLike(String value) {
            addCriterion("workJob not like", value, "workjob");
            return (Criteria) this;
        }

        public Criteria andWorkjobIn(List<String> values) {
            addCriterion("workJob in", values, "workjob");
            return (Criteria) this;
        }

        public Criteria andWorkjobNotIn(List<String> values) {
            addCriterion("workJob not in", values, "workjob");
            return (Criteria) this;
        }

        public Criteria andWorkjobBetween(String value1, String value2) {
            addCriterion("workJob between", value1, value2, "workjob");
            return (Criteria) this;
        }

        public Criteria andWorkjobNotBetween(String value1, String value2) {
            addCriterion("workJob not between", value1, value2, "workjob");
            return (Criteria) this;
        }

        public Criteria andHujiaddressIsNull() {
            addCriterion("hujiAddress is null");
            return (Criteria) this;
        }

        public Criteria andHujiaddressIsNotNull() {
            addCriterion("hujiAddress is not null");
            return (Criteria) this;
        }

        public Criteria andHujiaddressEqualTo(String value) {
            addCriterion("hujiAddress =", value, "hujiaddress");
            return (Criteria) this;
        }

        public Criteria andHujiaddressNotEqualTo(String value) {
            addCriterion("hujiAddress <>", value, "hujiaddress");
            return (Criteria) this;
        }

        public Criteria andHujiaddressGreaterThan(String value) {
            addCriterion("hujiAddress >", value, "hujiaddress");
            return (Criteria) this;
        }

        public Criteria andHujiaddressGreaterThanOrEqualTo(String value) {
            addCriterion("hujiAddress >=", value, "hujiaddress");
            return (Criteria) this;
        }

        public Criteria andHujiaddressLessThan(String value) {
            addCriterion("hujiAddress <", value, "hujiaddress");
            return (Criteria) this;
        }

        public Criteria andHujiaddressLessThanOrEqualTo(String value) {
            addCriterion("hujiAddress <=", value, "hujiaddress");
            return (Criteria) this;
        }

        public Criteria andHujiaddressLike(String value) {
            addCriterion("hujiAddress like", value, "hujiaddress");
            return (Criteria) this;
        }

        public Criteria andHujiaddressNotLike(String value) {
            addCriterion("hujiAddress not like", value, "hujiaddress");
            return (Criteria) this;
        }

        public Criteria andHujiaddressIn(List<String> values) {
            addCriterion("hujiAddress in", values, "hujiaddress");
            return (Criteria) this;
        }

        public Criteria andHujiaddressNotIn(List<String> values) {
            addCriterion("hujiAddress not in", values, "hujiaddress");
            return (Criteria) this;
        }

        public Criteria andHujiaddressBetween(String value1, String value2) {
            addCriterion("hujiAddress between", value1, value2, "hujiaddress");
            return (Criteria) this;
        }

        public Criteria andHujiaddressNotBetween(String value1, String value2) {
            addCriterion("hujiAddress not between", value1, value2, "hujiaddress");
            return (Criteria) this;
        }

        public Criteria andCardnumIsNull() {
            addCriterion("cardNum is null");
            return (Criteria) this;
        }

        public Criteria andCardnumIsNotNull() {
            addCriterion("cardNum is not null");
            return (Criteria) this;
        }

        public Criteria andCardnumEqualTo(String value) {
            addCriterion("cardNum =", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumNotEqualTo(String value) {
            addCriterion("cardNum <>", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumGreaterThan(String value) {
            addCriterion("cardNum >", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumGreaterThanOrEqualTo(String value) {
            addCriterion("cardNum >=", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumLessThan(String value) {
            addCriterion("cardNum <", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumLessThanOrEqualTo(String value) {
            addCriterion("cardNum <=", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumLike(String value) {
            addCriterion("cardNum like", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumNotLike(String value) {
            addCriterion("cardNum not like", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumIn(List<String> values) {
            addCriterion("cardNum in", values, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumNotIn(List<String> values) {
            addCriterion("cardNum not in", values, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumBetween(String value1, String value2) {
            addCriterion("cardNum between", value1, value2, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumNotBetween(String value1, String value2) {
            addCriterion("cardNum not between", value1, value2, "cardnum");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
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

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
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

        public Criteria andRemale2IsNull() {
            addCriterion("remale2 is null");
            return (Criteria) this;
        }

        public Criteria andRemale2IsNotNull() {
            addCriterion("remale2 is not null");
            return (Criteria) this;
        }

        public Criteria andRemale2EqualTo(String value) {
            addCriterion("remale2 =", value, "remale2");
            return (Criteria) this;
        }

        public Criteria andRemale2NotEqualTo(String value) {
            addCriterion("remale2 <>", value, "remale2");
            return (Criteria) this;
        }

        public Criteria andRemale2GreaterThan(String value) {
            addCriterion("remale2 >", value, "remale2");
            return (Criteria) this;
        }

        public Criteria andRemale2GreaterThanOrEqualTo(String value) {
            addCriterion("remale2 >=", value, "remale2");
            return (Criteria) this;
        }

        public Criteria andRemale2LessThan(String value) {
            addCriterion("remale2 <", value, "remale2");
            return (Criteria) this;
        }

        public Criteria andRemale2LessThanOrEqualTo(String value) {
            addCriterion("remale2 <=", value, "remale2");
            return (Criteria) this;
        }

        public Criteria andRemale2Like(String value) {
            addCriterion("remale2 like", value, "remale2");
            return (Criteria) this;
        }

        public Criteria andRemale2NotLike(String value) {
            addCriterion("remale2 not like", value, "remale2");
            return (Criteria) this;
        }

        public Criteria andRemale2In(List<String> values) {
            addCriterion("remale2 in", values, "remale2");
            return (Criteria) this;
        }

        public Criteria andRemale2NotIn(List<String> values) {
            addCriterion("remale2 not in", values, "remale2");
            return (Criteria) this;
        }

        public Criteria andRemale2Between(String value1, String value2) {
            addCriterion("remale2 between", value1, value2, "remale2");
            return (Criteria) this;
        }

        public Criteria andRemale2NotBetween(String value1, String value2) {
            addCriterion("remale2 not between", value1, value2, "remale2");
            return (Criteria) this;
        }

        public Criteria andPartymembergroupIsNull() {
            addCriterion("partyMemberGroup is null");
            return (Criteria) this;
        }

        public Criteria andPartymembergroupIsNotNull() {
            addCriterion("partyMemberGroup is not null");
            return (Criteria) this;
        }

        public Criteria andPartymembergroupEqualTo(String value) {
            addCriterion("partyMemberGroup =", value, "partymembergroup");
            return (Criteria) this;
        }

        public Criteria andPartymembergroupNotEqualTo(String value) {
            addCriterion("partyMemberGroup <>", value, "partymembergroup");
            return (Criteria) this;
        }

        public Criteria andPartymembergroupGreaterThan(String value) {
            addCriterion("partyMemberGroup >", value, "partymembergroup");
            return (Criteria) this;
        }

        public Criteria andPartymembergroupGreaterThanOrEqualTo(String value) {
            addCriterion("partyMemberGroup >=", value, "partymembergroup");
            return (Criteria) this;
        }

        public Criteria andPartymembergroupLessThan(String value) {
            addCriterion("partyMemberGroup <", value, "partymembergroup");
            return (Criteria) this;
        }

        public Criteria andPartymembergroupLessThanOrEqualTo(String value) {
            addCriterion("partyMemberGroup <=", value, "partymembergroup");
            return (Criteria) this;
        }

        public Criteria andPartymembergroupLike(String value) {
            addCriterion("partyMemberGroup like", value, "partymembergroup");
            return (Criteria) this;
        }

        public Criteria andPartymembergroupNotLike(String value) {
            addCriterion("partyMemberGroup not like", value, "partymembergroup");
            return (Criteria) this;
        }

        public Criteria andPartymembergroupIn(List<String> values) {
            addCriterion("partyMemberGroup in", values, "partymembergroup");
            return (Criteria) this;
        }

        public Criteria andPartymembergroupNotIn(List<String> values) {
            addCriterion("partyMemberGroup not in", values, "partymembergroup");
            return (Criteria) this;
        }

        public Criteria andPartymembergroupBetween(String value1, String value2) {
            addCriterion("partyMemberGroup between", value1, value2, "partymembergroup");
            return (Criteria) this;
        }

        public Criteria andPartymembergroupNotBetween(String value1, String value2) {
            addCriterion("partyMemberGroup not between", value1, value2, "partymembergroup");
            return (Criteria) this;
        }

        public Criteria andIsleaderIsNull() {
            addCriterion("isLeader is null");
            return (Criteria) this;
        }

        public Criteria andIsleaderIsNotNull() {
            addCriterion("isLeader is not null");
            return (Criteria) this;
        }

        public Criteria andIsleaderEqualTo(String value) {
            addCriterion("isLeader =", value, "isleader");
            return (Criteria) this;
        }

        public Criteria andIsleaderNotEqualTo(String value) {
            addCriterion("isLeader <>", value, "isleader");
            return (Criteria) this;
        }

        public Criteria andIsleaderGreaterThan(String value) {
            addCriterion("isLeader >", value, "isleader");
            return (Criteria) this;
        }

        public Criteria andIsleaderGreaterThanOrEqualTo(String value) {
            addCriterion("isLeader >=", value, "isleader");
            return (Criteria) this;
        }

        public Criteria andIsleaderLessThan(String value) {
            addCriterion("isLeader <", value, "isleader");
            return (Criteria) this;
        }

        public Criteria andIsleaderLessThanOrEqualTo(String value) {
            addCriterion("isLeader <=", value, "isleader");
            return (Criteria) this;
        }

        public Criteria andIsleaderLike(String value) {
            addCriterion("isLeader like", value, "isleader");
            return (Criteria) this;
        }

        public Criteria andIsleaderNotLike(String value) {
            addCriterion("isLeader not like", value, "isleader");
            return (Criteria) this;
        }

        public Criteria andIsleaderIn(List<String> values) {
            addCriterion("isLeader in", values, "isleader");
            return (Criteria) this;
        }

        public Criteria andIsleaderNotIn(List<String> values) {
            addCriterion("isLeader not in", values, "isleader");
            return (Criteria) this;
        }

        public Criteria andIsleaderBetween(String value1, String value2) {
            addCriterion("isLeader between", value1, value2, "isleader");
            return (Criteria) this;
        }

        public Criteria andIsleaderNotBetween(String value1, String value2) {
            addCriterion("isLeader not between", value1, value2, "isleader");
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