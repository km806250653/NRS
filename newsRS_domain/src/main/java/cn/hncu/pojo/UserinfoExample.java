package cn.hncu.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserinfoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andPhoneNumberIsNull() {
            addCriterion("phone_number is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNotNull() {
            addCriterion("phone_number is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberEqualTo(Long value) {
            addCriterion("phone_number =", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotEqualTo(Long value) {
            addCriterion("phone_number <>", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThan(Long value) {
            addCriterion("phone_number >", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("phone_number >=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThan(Long value) {
            addCriterion("phone_number <", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThanOrEqualTo(Long value) {
            addCriterion("phone_number <=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIn(List<Long> values) {
            addCriterion("phone_number in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotIn(List<Long> values) {
            addCriterion("phone_number not in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberBetween(Long value1, Long value2) {
            addCriterion("phone_number between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotBetween(Long value1, Long value2) {
            addCriterion("phone_number not between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andIsmanagerIsNull() {
            addCriterion("ismanager is null");
            return (Criteria) this;
        }

        public Criteria andIsmanagerIsNotNull() {
            addCriterion("ismanager is not null");
            return (Criteria) this;
        }

        public Criteria andIsmanagerEqualTo(String value) {
            addCriterion("ismanager =", value, "ismanager");
            return (Criteria) this;
        }

        public Criteria andIsmanagerNotEqualTo(String value) {
            addCriterion("ismanager <>", value, "ismanager");
            return (Criteria) this;
        }

        public Criteria andIsmanagerGreaterThan(String value) {
            addCriterion("ismanager >", value, "ismanager");
            return (Criteria) this;
        }

        public Criteria andIsmanagerGreaterThanOrEqualTo(String value) {
            addCriterion("ismanager >=", value, "ismanager");
            return (Criteria) this;
        }

        public Criteria andIsmanagerLessThan(String value) {
            addCriterion("ismanager <", value, "ismanager");
            return (Criteria) this;
        }

        public Criteria andIsmanagerLessThanOrEqualTo(String value) {
            addCriterion("ismanager <=", value, "ismanager");
            return (Criteria) this;
        }

        public Criteria andIsmanagerLike(String value) {
            addCriterion("ismanager like", value, "ismanager");
            return (Criteria) this;
        }

        public Criteria andIsmanagerNotLike(String value) {
            addCriterion("ismanager not like", value, "ismanager");
            return (Criteria) this;
        }

        public Criteria andIsmanagerIn(List<String> values) {
            addCriterion("ismanager in", values, "ismanager");
            return (Criteria) this;
        }

        public Criteria andIsmanagerNotIn(List<String> values) {
            addCriterion("ismanager not in", values, "ismanager");
            return (Criteria) this;
        }

        public Criteria andIsmanagerBetween(String value1, String value2) {
            addCriterion("ismanager between", value1, value2, "ismanager");
            return (Criteria) this;
        }

        public Criteria andIsmanagerNotBetween(String value1, String value2) {
            addCriterion("ismanager not between", value1, value2, "ismanager");
            return (Criteria) this;
        }

        public Criteria andIsactivatedIsNull() {
            addCriterion("isactivated is null");
            return (Criteria) this;
        }

        public Criteria andIsactivatedIsNotNull() {
            addCriterion("isactivated is not null");
            return (Criteria) this;
        }

        public Criteria andIsactivatedEqualTo(String value) {
            addCriterion("isactivated =", value, "isactivated");
            return (Criteria) this;
        }

        public Criteria andIsactivatedNotEqualTo(String value) {
            addCriterion("isactivated <>", value, "isactivated");
            return (Criteria) this;
        }

        public Criteria andIsactivatedGreaterThan(String value) {
            addCriterion("isactivated >", value, "isactivated");
            return (Criteria) this;
        }

        public Criteria andIsactivatedGreaterThanOrEqualTo(String value) {
            addCriterion("isactivated >=", value, "isactivated");
            return (Criteria) this;
        }

        public Criteria andIsactivatedLessThan(String value) {
            addCriterion("isactivated <", value, "isactivated");
            return (Criteria) this;
        }

        public Criteria andIsactivatedLessThanOrEqualTo(String value) {
            addCriterion("isactivated <=", value, "isactivated");
            return (Criteria) this;
        }

        public Criteria andIsactivatedLike(String value) {
            addCriterion("isactivated like", value, "isactivated");
            return (Criteria) this;
        }

        public Criteria andIsactivatedNotLike(String value) {
            addCriterion("isactivated not like", value, "isactivated");
            return (Criteria) this;
        }

        public Criteria andIsactivatedIn(List<String> values) {
            addCriterion("isactivated in", values, "isactivated");
            return (Criteria) this;
        }

        public Criteria andIsactivatedNotIn(List<String> values) {
            addCriterion("isactivated not in", values, "isactivated");
            return (Criteria) this;
        }

        public Criteria andIsactivatedBetween(String value1, String value2) {
            addCriterion("isactivated between", value1, value2, "isactivated");
            return (Criteria) this;
        }

        public Criteria andIsactivatedNotBetween(String value1, String value2) {
            addCriterion("isactivated not between", value1, value2, "isactivated");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andBackgroundIsNull() {
            addCriterion("background is null");
            return (Criteria) this;
        }

        public Criteria andBackgroundIsNotNull() {
            addCriterion("background is not null");
            return (Criteria) this;
        }

        public Criteria andBackgroundEqualTo(String value) {
            addCriterion("background =", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundNotEqualTo(String value) {
            addCriterion("background <>", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundGreaterThan(String value) {
            addCriterion("background >", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundGreaterThanOrEqualTo(String value) {
            addCriterion("background >=", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundLessThan(String value) {
            addCriterion("background <", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundLessThanOrEqualTo(String value) {
            addCriterion("background <=", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundLike(String value) {
            addCriterion("background like", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundNotLike(String value) {
            addCriterion("background not like", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundIn(List<String> values) {
            addCriterion("background in", values, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundNotIn(List<String> values) {
            addCriterion("background not in", values, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundBetween(String value1, String value2) {
            addCriterion("background between", value1, value2, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundNotBetween(String value1, String value2) {
            addCriterion("background not between", value1, value2, "background");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andFollowIsNull() {
            addCriterion("follow is null");
            return (Criteria) this;
        }

        public Criteria andFollowIsNotNull() {
            addCriterion("follow is not null");
            return (Criteria) this;
        }

        public Criteria andFollowEqualTo(Integer value) {
            addCriterion("follow =", value, "follow");
            return (Criteria) this;
        }

        public Criteria andFollowNotEqualTo(Integer value) {
            addCriterion("follow <>", value, "follow");
            return (Criteria) this;
        }

        public Criteria andFollowGreaterThan(Integer value) {
            addCriterion("follow >", value, "follow");
            return (Criteria) this;
        }

        public Criteria andFollowGreaterThanOrEqualTo(Integer value) {
            addCriterion("follow >=", value, "follow");
            return (Criteria) this;
        }

        public Criteria andFollowLessThan(Integer value) {
            addCriterion("follow <", value, "follow");
            return (Criteria) this;
        }

        public Criteria andFollowLessThanOrEqualTo(Integer value) {
            addCriterion("follow <=", value, "follow");
            return (Criteria) this;
        }

        public Criteria andFollowIn(List<Integer> values) {
            addCriterion("follow in", values, "follow");
            return (Criteria) this;
        }

        public Criteria andFollowNotIn(List<Integer> values) {
            addCriterion("follow not in", values, "follow");
            return (Criteria) this;
        }

        public Criteria andFollowBetween(Integer value1, Integer value2) {
            addCriterion("follow between", value1, value2, "follow");
            return (Criteria) this;
        }

        public Criteria andFollowNotBetween(Integer value1, Integer value2) {
            addCriterion("follow not between", value1, value2, "follow");
            return (Criteria) this;
        }

        public Criteria andFollowerIsNull() {
            addCriterion("follower is null");
            return (Criteria) this;
        }

        public Criteria andFollowerIsNotNull() {
            addCriterion("follower is not null");
            return (Criteria) this;
        }

        public Criteria andFollowerEqualTo(Integer value) {
            addCriterion("follower =", value, "follower");
            return (Criteria) this;
        }

        public Criteria andFollowerNotEqualTo(Integer value) {
            addCriterion("follower <>", value, "follower");
            return (Criteria) this;
        }

        public Criteria andFollowerGreaterThan(Integer value) {
            addCriterion("follower >", value, "follower");
            return (Criteria) this;
        }

        public Criteria andFollowerGreaterThanOrEqualTo(Integer value) {
            addCriterion("follower >=", value, "follower");
            return (Criteria) this;
        }

        public Criteria andFollowerLessThan(Integer value) {
            addCriterion("follower <", value, "follower");
            return (Criteria) this;
        }

        public Criteria andFollowerLessThanOrEqualTo(Integer value) {
            addCriterion("follower <=", value, "follower");
            return (Criteria) this;
        }

        public Criteria andFollowerIn(List<Integer> values) {
            addCriterion("follower in", values, "follower");
            return (Criteria) this;
        }

        public Criteria andFollowerNotIn(List<Integer> values) {
            addCriterion("follower not in", values, "follower");
            return (Criteria) this;
        }

        public Criteria andFollowerBetween(Integer value1, Integer value2) {
            addCriterion("follower between", value1, value2, "follower");
            return (Criteria) this;
        }

        public Criteria andFollowerNotBetween(Integer value1, Integer value2) {
            addCriterion("follower not between", value1, value2, "follower");
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