package com.chingkwok.bean.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andSaltIsNull() {
            addCriterion("salt is null");
            return (Criteria) this;
        }

        public Criteria andSaltIsNotNull() {
            addCriterion("salt is not null");
            return (Criteria) this;
        }

        public Criteria andSaltEqualTo(String value) {
            addCriterion("salt =", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotEqualTo(String value) {
            addCriterion("salt <>", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThan(String value) {
            addCriterion("salt >", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThanOrEqualTo(String value) {
            addCriterion("salt >=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThan(String value) {
            addCriterion("salt <", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThanOrEqualTo(String value) {
            addCriterion("salt <=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLike(String value) {
            addCriterion("salt like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotLike(String value) {
            addCriterion("salt not like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltIn(List<String> values) {
            addCriterion("salt in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotIn(List<String> values) {
            addCriterion("salt not in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltBetween(String value1, String value2) {
            addCriterion("salt between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotBetween(String value1, String value2) {
            addCriterion("salt not between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andLastModifierUserIdIsNull() {
            addCriterion("last_modifier_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLastModifierUserIdIsNotNull() {
            addCriterion("last_modifier_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifierUserIdEqualTo(Long value) {
            addCriterion("last_modifier_user_id =", value, "lastModifierUserId");
            return (Criteria) this;
        }

        public Criteria andLastModifierUserIdNotEqualTo(Long value) {
            addCriterion("last_modifier_user_id <>", value, "lastModifierUserId");
            return (Criteria) this;
        }

        public Criteria andLastModifierUserIdGreaterThan(Long value) {
            addCriterion("last_modifier_user_id >", value, "lastModifierUserId");
            return (Criteria) this;
        }

        public Criteria andLastModifierUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("last_modifier_user_id >=", value, "lastModifierUserId");
            return (Criteria) this;
        }

        public Criteria andLastModifierUserIdLessThan(Long value) {
            addCriterion("last_modifier_user_id <", value, "lastModifierUserId");
            return (Criteria) this;
        }

        public Criteria andLastModifierUserIdLessThanOrEqualTo(Long value) {
            addCriterion("last_modifier_user_id <=", value, "lastModifierUserId");
            return (Criteria) this;
        }

        public Criteria andLastModifierUserIdIn(List<Long> values) {
            addCriterion("last_modifier_user_id in", values, "lastModifierUserId");
            return (Criteria) this;
        }

        public Criteria andLastModifierUserIdNotIn(List<Long> values) {
            addCriterion("last_modifier_user_id not in", values, "lastModifierUserId");
            return (Criteria) this;
        }

        public Criteria andLastModifierUserIdBetween(Long value1, Long value2) {
            addCriterion("last_modifier_user_id between", value1, value2, "lastModifierUserId");
            return (Criteria) this;
        }

        public Criteria andLastModifierUserIdNotBetween(Long value1, Long value2) {
            addCriterion("last_modifier_user_id not between", value1, value2, "lastModifierUserId");
            return (Criteria) this;
        }

        public Criteria andLastModificationTimeIsNull() {
            addCriterion("last_modification_time is null");
            return (Criteria) this;
        }

        public Criteria andLastModificationTimeIsNotNull() {
            addCriterion("last_modification_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastModificationTimeEqualTo(Date value) {
            addCriterion("last_modification_time =", value, "lastModificationTime");
            return (Criteria) this;
        }

        public Criteria andLastModificationTimeNotEqualTo(Date value) {
            addCriterion("last_modification_time <>", value, "lastModificationTime");
            return (Criteria) this;
        }

        public Criteria andLastModificationTimeGreaterThan(Date value) {
            addCriterion("last_modification_time >", value, "lastModificationTime");
            return (Criteria) this;
        }

        public Criteria andLastModificationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_modification_time >=", value, "lastModificationTime");
            return (Criteria) this;
        }

        public Criteria andLastModificationTimeLessThan(Date value) {
            addCriterion("last_modification_time <", value, "lastModificationTime");
            return (Criteria) this;
        }

        public Criteria andLastModificationTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_modification_time <=", value, "lastModificationTime");
            return (Criteria) this;
        }

        public Criteria andLastModificationTimeIn(List<Date> values) {
            addCriterion("last_modification_time in", values, "lastModificationTime");
            return (Criteria) this;
        }

        public Criteria andLastModificationTimeNotIn(List<Date> values) {
            addCriterion("last_modification_time not in", values, "lastModificationTime");
            return (Criteria) this;
        }

        public Criteria andLastModificationTimeBetween(Date value1, Date value2) {
            addCriterion("last_modification_time between", value1, value2, "lastModificationTime");
            return (Criteria) this;
        }

        public Criteria andLastModificationTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_modification_time not between", value1, value2, "lastModificationTime");
            return (Criteria) this;
        }

        public Criteria andCreatorUserNameIsNull() {
            addCriterion("creator_user_name is null");
            return (Criteria) this;
        }

        public Criteria andCreatorUserNameIsNotNull() {
            addCriterion("creator_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorUserNameEqualTo(String value) {
            addCriterion("creator_user_name =", value, "creatorUserName");
            return (Criteria) this;
        }

        public Criteria andCreatorUserNameNotEqualTo(String value) {
            addCriterion("creator_user_name <>", value, "creatorUserName");
            return (Criteria) this;
        }

        public Criteria andCreatorUserNameGreaterThan(String value) {
            addCriterion("creator_user_name >", value, "creatorUserName");
            return (Criteria) this;
        }

        public Criteria andCreatorUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("creator_user_name >=", value, "creatorUserName");
            return (Criteria) this;
        }

        public Criteria andCreatorUserNameLessThan(String value) {
            addCriterion("creator_user_name <", value, "creatorUserName");
            return (Criteria) this;
        }

        public Criteria andCreatorUserNameLessThanOrEqualTo(String value) {
            addCriterion("creator_user_name <=", value, "creatorUserName");
            return (Criteria) this;
        }

        public Criteria andCreatorUserNameLike(String value) {
            addCriterion("creator_user_name like", value, "creatorUserName");
            return (Criteria) this;
        }

        public Criteria andCreatorUserNameNotLike(String value) {
            addCriterion("creator_user_name not like", value, "creatorUserName");
            return (Criteria) this;
        }

        public Criteria andCreatorUserNameIn(List<String> values) {
            addCriterion("creator_user_name in", values, "creatorUserName");
            return (Criteria) this;
        }

        public Criteria andCreatorUserNameNotIn(List<String> values) {
            addCriterion("creator_user_name not in", values, "creatorUserName");
            return (Criteria) this;
        }

        public Criteria andCreatorUserNameBetween(String value1, String value2) {
            addCriterion("creator_user_name between", value1, value2, "creatorUserName");
            return (Criteria) this;
        }

        public Criteria andCreatorUserNameNotBetween(String value1, String value2) {
            addCriterion("creator_user_name not between", value1, value2, "creatorUserName");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdIsNull() {
            addCriterion("creator_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdIsNotNull() {
            addCriterion("creator_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdEqualTo(Long value) {
            addCriterion("creator_user_id =", value, "creatorUserId");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdNotEqualTo(Long value) {
            addCriterion("creator_user_id <>", value, "creatorUserId");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdGreaterThan(Long value) {
            addCriterion("creator_user_id >", value, "creatorUserId");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("creator_user_id >=", value, "creatorUserId");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdLessThan(Long value) {
            addCriterion("creator_user_id <", value, "creatorUserId");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdLessThanOrEqualTo(Long value) {
            addCriterion("creator_user_id <=", value, "creatorUserId");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdIn(List<Long> values) {
            addCriterion("creator_user_id in", values, "creatorUserId");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdNotIn(List<Long> values) {
            addCriterion("creator_user_id not in", values, "creatorUserId");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdBetween(Long value1, Long value2) {
            addCriterion("creator_user_id between", value1, value2, "creatorUserId");
            return (Criteria) this;
        }

        public Criteria andCreatorUserIdNotBetween(Long value1, Long value2) {
            addCriterion("creator_user_id not between", value1, value2, "creatorUserId");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIsNull() {
            addCriterion("creation_time is null");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIsNotNull() {
            addCriterion("creation_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreationTimeEqualTo(Date value) {
            addCriterion("creation_time =", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotEqualTo(Date value) {
            addCriterion("creation_time <>", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeGreaterThan(Date value) {
            addCriterion("creation_time >", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creation_time >=", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLessThan(Date value) {
            addCriterion("creation_time <", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLessThanOrEqualTo(Date value) {
            addCriterion("creation_time <=", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIn(List<Date> values) {
            addCriterion("creation_time in", values, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotIn(List<Date> values) {
            addCriterion("creation_time not in", values, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeBetween(Date value1, Date value2) {
            addCriterion("creation_time between", value1, value2, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotBetween(Date value1, Date value2) {
            addCriterion("creation_time not between", value1, value2, "creationTime");
            return (Criteria) this;
        }

        public Criteria andDeletionTimeIsNull() {
            addCriterion("deletion_time is null");
            return (Criteria) this;
        }

        public Criteria andDeletionTimeIsNotNull() {
            addCriterion("deletion_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeletionTimeEqualTo(Date value) {
            addCriterion("deletion_time =", value, "deletionTime");
            return (Criteria) this;
        }

        public Criteria andDeletionTimeNotEqualTo(Date value) {
            addCriterion("deletion_time <>", value, "deletionTime");
            return (Criteria) this;
        }

        public Criteria andDeletionTimeGreaterThan(Date value) {
            addCriterion("deletion_time >", value, "deletionTime");
            return (Criteria) this;
        }

        public Criteria andDeletionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deletion_time >=", value, "deletionTime");
            return (Criteria) this;
        }

        public Criteria andDeletionTimeLessThan(Date value) {
            addCriterion("deletion_time <", value, "deletionTime");
            return (Criteria) this;
        }

        public Criteria andDeletionTimeLessThanOrEqualTo(Date value) {
            addCriterion("deletion_time <=", value, "deletionTime");
            return (Criteria) this;
        }

        public Criteria andDeletionTimeIn(List<Date> values) {
            addCriterion("deletion_time in", values, "deletionTime");
            return (Criteria) this;
        }

        public Criteria andDeletionTimeNotIn(List<Date> values) {
            addCriterion("deletion_time not in", values, "deletionTime");
            return (Criteria) this;
        }

        public Criteria andDeletionTimeBetween(Date value1, Date value2) {
            addCriterion("deletion_time between", value1, value2, "deletionTime");
            return (Criteria) this;
        }

        public Criteria andDeletionTimeNotBetween(Date value1, Date value2) {
            addCriterion("deletion_time not between", value1, value2, "deletionTime");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Boolean value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Boolean value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Boolean value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Boolean value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Boolean> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Boolean> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andDeleterUserIdIsNull() {
            addCriterion("deleter_user_id is null");
            return (Criteria) this;
        }

        public Criteria andDeleterUserIdIsNotNull() {
            addCriterion("deleter_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeleterUserIdEqualTo(Long value) {
            addCriterion("deleter_user_id =", value, "deleterUserId");
            return (Criteria) this;
        }

        public Criteria andDeleterUserIdNotEqualTo(Long value) {
            addCriterion("deleter_user_id <>", value, "deleterUserId");
            return (Criteria) this;
        }

        public Criteria andDeleterUserIdGreaterThan(Long value) {
            addCriterion("deleter_user_id >", value, "deleterUserId");
            return (Criteria) this;
        }

        public Criteria andDeleterUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("deleter_user_id >=", value, "deleterUserId");
            return (Criteria) this;
        }

        public Criteria andDeleterUserIdLessThan(Long value) {
            addCriterion("deleter_user_id <", value, "deleterUserId");
            return (Criteria) this;
        }

        public Criteria andDeleterUserIdLessThanOrEqualTo(Long value) {
            addCriterion("deleter_user_id <=", value, "deleterUserId");
            return (Criteria) this;
        }

        public Criteria andDeleterUserIdIn(List<Long> values) {
            addCriterion("deleter_user_id in", values, "deleterUserId");
            return (Criteria) this;
        }

        public Criteria andDeleterUserIdNotIn(List<Long> values) {
            addCriterion("deleter_user_id not in", values, "deleterUserId");
            return (Criteria) this;
        }

        public Criteria andDeleterUserIdBetween(Long value1, Long value2) {
            addCriterion("deleter_user_id between", value1, value2, "deleterUserId");
            return (Criteria) this;
        }

        public Criteria andDeleterUserIdNotBetween(Long value1, Long value2) {
            addCriterion("deleter_user_id not between", value1, value2, "deleterUserId");
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