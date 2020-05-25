package com.tdd.model;
import java.util.ArrayList;
import java.util.List;
public class UserInfoExample {
    protected String orderByClause;
    protected boolean distinct;
    protected int startRow;
    protected int pageRows;
    protected List<Criteria> oredCriteria;
    public UserInfoExample() {
        oredCriteria = new ArrayList<>();
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
    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }
    public int getStartRow() {
        return startRow;
    }
    public void setPageRows(int pageRows) {
        this.pageRows = pageRows;
    }
    public int getPageRows() {
        return pageRows;
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
            criteria = new ArrayList<>();
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
  public Criteria andIdIsNotNull(){
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
		  addCriterion("id >=", value, "Id");
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
    public Criteria andIdLike(Integer value) {
		  addCriterion("id like", value, "id");
		return (Criteria) this;
		}
    public Criteria andIdNotLike(Integer value) {
		  addCriterion("id not like", value, "id");
		return (Criteria) this;
		}
 public Criteria andNameIsNull() {
		 addCriterion("name is null");
		return (Criteria) this;
		}
  public Criteria andNameIsNotNull(){
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
		  addCriterion("name >=", value, "Name");
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
    public Criteria andNameLike(String value) {
		  addCriterion("name like", value, "name");
		return (Criteria) this;
		}
    public Criteria andNameNotLike(String value) {
		  addCriterion("name not like", value, "name");
		return (Criteria) this;
		}
 public Criteria andPassWordIsNull() {
		 addCriterion("pass_word is null");
		return (Criteria) this;
		}
  public Criteria andPassWordIsNotNull(){
		addCriterion("pass_word is not null");
		return (Criteria) this;
		}
  public Criteria andPassWordEqualTo(String value) {
		  addCriterion("pass_word =", value, "passWord");
		return (Criteria) this;
		}
   public Criteria andPassWordNotEqualTo(String value) {
		  addCriterion("pass_word <>", value, "passWord");
		return (Criteria) this;
		}
    public Criteria andPassWordGreaterThan(String value) {
		 addCriterion("pass_word >", value, "passWord");
		return (Criteria) this;
		}
  public Criteria andPassWordGreaterThanOrEqualTo(String value) {
		  addCriterion("pass_word >=", value, "PassWord");
		return (Criteria) this;
		}
   public Criteria andPassWordLessThan(String value) {
		  addCriterion("pass_word <", value, "passWord");
		return (Criteria) this;
		}
    public Criteria andPassWordLessThanOrEqualTo(String value) {
		  addCriterion("pass_word <=", value, "passWord");
		return (Criteria) this;
		}
    public Criteria andPassWordIn(List<String> values) {
		  addCriterion("pass_word in", values, "passWord");
		return (Criteria) this;
		}
    public Criteria andPassWordNotIn(List<String> values) {
		  addCriterion("pass_word not in", values, "passWord");
		return (Criteria) this;
		}
     public Criteria andPassWordBetween(String value1, String value2) {
		   addCriterion("pass_word between", value1, value2, "passWord");
		return (Criteria) this;
		}
     public Criteria andPassWordNotBetween(String value1, String value2) {
		   addCriterion("pass_word not between", value1, value2, "passWord");
		return (Criteria) this;
		}
    public Criteria andPassWordLike(String value) {
		  addCriterion("pass_word like", value, "passWord");
		return (Criteria) this;
		}
    public Criteria andPassWordNotLike(String value) {
		  addCriterion("pass_word not like", value, "passWord");
		return (Criteria) this;
		}
 public Criteria andCreateTimeIsNull() {
		 addCriterion("create_time is null");
		return (Criteria) this;
		}
  public Criteria andCreateTimeIsNotNull(){
		addCriterion("create_time is not null");
		return (Criteria) this;
		}
  public Criteria andCreateTimeEqualTo(String value) {
		  addCriterion("create_time =", value, "createTime");
		return (Criteria) this;
		}
   public Criteria andCreateTimeNotEqualTo(String value) {
		  addCriterion("create_time <>", value, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeGreaterThan(String value) {
		 addCriterion("create_time >", value, "createTime");
		return (Criteria) this;
		}
  public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
		  addCriterion("create_time >=", value, "CreateTime");
		return (Criteria) this;
		}
   public Criteria andCreateTimeLessThan(String value) {
		  addCriterion("create_time <", value, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeLessThanOrEqualTo(String value) {
		  addCriterion("create_time <=", value, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeIn(List<String> values) {
		  addCriterion("create_time in", values, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeNotIn(List<String> values) {
		  addCriterion("create_time not in", values, "createTime");
		return (Criteria) this;
		}
     public Criteria andCreateTimeBetween(String value1, String value2) {
		   addCriterion("create_time between", value1, value2, "createTime");
		return (Criteria) this;
		}
     public Criteria andCreateTimeNotBetween(String value1, String value2) {
		   addCriterion("create_time not between", value1, value2, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeLike(String value) {
		  addCriterion("create_time like", value, "createTime");
		return (Criteria) this;
		}
    public Criteria andCreateTimeNotLike(String value) {
		  addCriterion("create_time not like", value, "createTime");
		return (Criteria) this;
		}
 public Criteria andContactNameIsNull() {
		 addCriterion("contact_name is null");
		return (Criteria) this;
		}
  public Criteria andContactNameIsNotNull(){
		addCriterion("contact_name is not null");
		return (Criteria) this;
		}
  public Criteria andContactNameEqualTo(String value) {
		  addCriterion("contact_name =", value, "contactName");
		return (Criteria) this;
		}
   public Criteria andContactNameNotEqualTo(String value) {
		  addCriterion("contact_name <>", value, "contactName");
		return (Criteria) this;
		}
    public Criteria andContactNameGreaterThan(String value) {
		 addCriterion("contact_name >", value, "contactName");
		return (Criteria) this;
		}
  public Criteria andContactNameGreaterThanOrEqualTo(String value) {
		  addCriterion("contact_name >=", value, "ContactName");
		return (Criteria) this;
		}
   public Criteria andContactNameLessThan(String value) {
		  addCriterion("contact_name <", value, "contactName");
		return (Criteria) this;
		}
    public Criteria andContactNameLessThanOrEqualTo(String value) {
		  addCriterion("contact_name <=", value, "contactName");
		return (Criteria) this;
		}
    public Criteria andContactNameIn(List<String> values) {
		  addCriterion("contact_name in", values, "contactName");
		return (Criteria) this;
		}
    public Criteria andContactNameNotIn(List<String> values) {
		  addCriterion("contact_name not in", values, "contactName");
		return (Criteria) this;
		}
     public Criteria andContactNameBetween(String value1, String value2) {
		   addCriterion("contact_name between", value1, value2, "contactName");
		return (Criteria) this;
		}
     public Criteria andContactNameNotBetween(String value1, String value2) {
		   addCriterion("contact_name not between", value1, value2, "contactName");
		return (Criteria) this;
		}
    public Criteria andContactNameLike(String value) {
		  addCriterion("contact_name like", value, "contactName");
		return (Criteria) this;
		}
    public Criteria andContactNameNotLike(String value) {
		  addCriterion("contact_name not like", value, "contactName");
		return (Criteria) this;
		}
 public Criteria andContactCelPhoneIsNull() {
		 addCriterion("contact_cel_phone is null");
		return (Criteria) this;
		}
  public Criteria andContactCelPhoneIsNotNull(){
		addCriterion("contact_cel_phone is not null");
		return (Criteria) this;
		}
  public Criteria andContactCelPhoneEqualTo(String value) {
		  addCriterion("contact_cel_phone =", value, "contactCelPhone");
		return (Criteria) this;
		}
   public Criteria andContactCelPhoneNotEqualTo(String value) {
		  addCriterion("contact_cel_phone <>", value, "contactCelPhone");
		return (Criteria) this;
		}
    public Criteria andContactCelPhoneGreaterThan(String value) {
		 addCriterion("contact_cel_phone >", value, "contactCelPhone");
		return (Criteria) this;
		}
  public Criteria andContactCelPhoneGreaterThanOrEqualTo(String value) {
		  addCriterion("contact_cel_phone >=", value, "ContactCelPhone");
		return (Criteria) this;
		}
   public Criteria andContactCelPhoneLessThan(String value) {
		  addCriterion("contact_cel_phone <", value, "contactCelPhone");
		return (Criteria) this;
		}
    public Criteria andContactCelPhoneLessThanOrEqualTo(String value) {
		  addCriterion("contact_cel_phone <=", value, "contactCelPhone");
		return (Criteria) this;
		}
    public Criteria andContactCelPhoneIn(List<String> values) {
		  addCriterion("contact_cel_phone in", values, "contactCelPhone");
		return (Criteria) this;
		}
    public Criteria andContactCelPhoneNotIn(List<String> values) {
		  addCriterion("contact_cel_phone not in", values, "contactCelPhone");
		return (Criteria) this;
		}
     public Criteria andContactCelPhoneBetween(String value1, String value2) {
		   addCriterion("contact_cel_phone between", value1, value2, "contactCelPhone");
		return (Criteria) this;
		}
     public Criteria andContactCelPhoneNotBetween(String value1, String value2) {
		   addCriterion("contact_cel_phone not between", value1, value2, "contactCelPhone");
		return (Criteria) this;
		}
    public Criteria andContactCelPhoneLike(String value) {
		  addCriterion("contact_cel_phone like", value, "contactCelPhone");
		return (Criteria) this;
		}
    public Criteria andContactCelPhoneNotLike(String value) {
		  addCriterion("contact_cel_phone not like", value, "contactCelPhone");
		return (Criteria) this;
		}
 public Criteria andContactCityIsNull() {
		 addCriterion("contact_city is null");
		return (Criteria) this;
		}
  public Criteria andContactCityIsNotNull(){
		addCriterion("contact_city is not null");
		return (Criteria) this;
		}
  public Criteria andContactCityEqualTo(String value) {
		  addCriterion("contact_city =", value, "contactCity");
		return (Criteria) this;
		}
   public Criteria andContactCityNotEqualTo(String value) {
		  addCriterion("contact_city <>", value, "contactCity");
		return (Criteria) this;
		}
    public Criteria andContactCityGreaterThan(String value) {
		 addCriterion("contact_city >", value, "contactCity");
		return (Criteria) this;
		}
  public Criteria andContactCityGreaterThanOrEqualTo(String value) {
		  addCriterion("contact_city >=", value, "ContactCity");
		return (Criteria) this;
		}
   public Criteria andContactCityLessThan(String value) {
		  addCriterion("contact_city <", value, "contactCity");
		return (Criteria) this;
		}
    public Criteria andContactCityLessThanOrEqualTo(String value) {
		  addCriterion("contact_city <=", value, "contactCity");
		return (Criteria) this;
		}
    public Criteria andContactCityIn(List<String> values) {
		  addCriterion("contact_city in", values, "contactCity");
		return (Criteria) this;
		}
    public Criteria andContactCityNotIn(List<String> values) {
		  addCriterion("contact_city not in", values, "contactCity");
		return (Criteria) this;
		}
     public Criteria andContactCityBetween(String value1, String value2) {
		   addCriterion("contact_city between", value1, value2, "contactCity");
		return (Criteria) this;
		}
     public Criteria andContactCityNotBetween(String value1, String value2) {
		   addCriterion("contact_city not between", value1, value2, "contactCity");
		return (Criteria) this;
		}
    public Criteria andContactCityLike(String value) {
		  addCriterion("contact_city like", value, "contactCity");
		return (Criteria) this;
		}
    public Criteria andContactCityNotLike(String value) {
		  addCriterion("contact_city not like", value, "contactCity");
		return (Criteria) this;
		}
 public Criteria andDetailAddressIsNull() {
		 addCriterion("detail_address is null");
		return (Criteria) this;
		}
  public Criteria andDetailAddressIsNotNull(){
		addCriterion("detail_address is not null");
		return (Criteria) this;
		}
  public Criteria andDetailAddressEqualTo(String value) {
		  addCriterion("detail_address =", value, "detailAddress");
		return (Criteria) this;
		}
   public Criteria andDetailAddressNotEqualTo(String value) {
		  addCriterion("detail_address <>", value, "detailAddress");
		return (Criteria) this;
		}
    public Criteria andDetailAddressGreaterThan(String value) {
		 addCriterion("detail_address >", value, "detailAddress");
		return (Criteria) this;
		}
  public Criteria andDetailAddressGreaterThanOrEqualTo(String value) {
		  addCriterion("detail_address >=", value, "DetailAddress");
		return (Criteria) this;
		}
   public Criteria andDetailAddressLessThan(String value) {
		  addCriterion("detail_address <", value, "detailAddress");
		return (Criteria) this;
		}
    public Criteria andDetailAddressLessThanOrEqualTo(String value) {
		  addCriterion("detail_address <=", value, "detailAddress");
		return (Criteria) this;
		}
    public Criteria andDetailAddressIn(List<String> values) {
		  addCriterion("detail_address in", values, "detailAddress");
		return (Criteria) this;
		}
    public Criteria andDetailAddressNotIn(List<String> values) {
		  addCriterion("detail_address not in", values, "detailAddress");
		return (Criteria) this;
		}
     public Criteria andDetailAddressBetween(String value1, String value2) {
		   addCriterion("detail_address between", value1, value2, "detailAddress");
		return (Criteria) this;
		}
     public Criteria andDetailAddressNotBetween(String value1, String value2) {
		   addCriterion("detail_address not between", value1, value2, "detailAddress");
		return (Criteria) this;
		}
    public Criteria andDetailAddressLike(String value) {
		  addCriterion("detail_address like", value, "detailAddress");
		return (Criteria) this;
		}
    public Criteria andDetailAddressNotLike(String value) {
		  addCriterion("detail_address not like", value, "detailAddress");
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
