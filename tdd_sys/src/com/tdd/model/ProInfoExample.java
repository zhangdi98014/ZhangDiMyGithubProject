package com.tdd.model;
import java.util.ArrayList;
import java.util.List;
public class ProInfoExample {
    protected String orderByClause;
    protected boolean distinct;
    protected int startRow;
    protected int pageRows;
    protected List<Criteria> oredCriteria;
    public ProInfoExample() {
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
 public Criteria andTitleIsNull() {
		 addCriterion("title is null");
		return (Criteria) this;
		}
  public Criteria andTitleIsNotNull(){
		addCriterion("title is not null");
		return (Criteria) this;
		}
  public Criteria andTitleEqualTo(String value) {
		  addCriterion("title =", value, "title");
		return (Criteria) this;
		}
   public Criteria andTitleNotEqualTo(String value) {
		  addCriterion("title <>", value, "title");
		return (Criteria) this;
		}
    public Criteria andTitleGreaterThan(String value) {
		 addCriterion("title >", value, "title");
		return (Criteria) this;
		}
  public Criteria andTitleGreaterThanOrEqualTo(String value) {
		  addCriterion("title >=", value, "Title");
		return (Criteria) this;
		}
   public Criteria andTitleLessThan(String value) {
		  addCriterion("title <", value, "title");
		return (Criteria) this;
		}
    public Criteria andTitleLessThanOrEqualTo(String value) {
		  addCriterion("title <=", value, "title");
		return (Criteria) this;
		}
    public Criteria andTitleIn(List<String> values) {
		  addCriterion("title in", values, "title");
		return (Criteria) this;
		}
    public Criteria andTitleNotIn(List<String> values) {
		  addCriterion("title not in", values, "title");
		return (Criteria) this;
		}
     public Criteria andTitleBetween(String value1, String value2) {
		   addCriterion("title between", value1, value2, "title");
		return (Criteria) this;
		}
     public Criteria andTitleNotBetween(String value1, String value2) {
		   addCriterion("title not between", value1, value2, "title");
		return (Criteria) this;
		}
    public Criteria andTitleLike(String value) {
		  addCriterion("title like", value, "title");
		return (Criteria) this;
		}
    public Criteria andTitleNotLike(String value) {
		  addCriterion("title not like", value, "title");
		return (Criteria) this;
		}
 public Criteria andProTypeIdIsNull() {
		 addCriterion("pro_type_id is null");
		return (Criteria) this;
		}
  public Criteria andProTypeIdIsNotNull(){
		addCriterion("pro_type_id is not null");
		return (Criteria) this;
		}
  public Criteria andProTypeIdEqualTo(Integer value) {
		  addCriterion("pro_type_id =", value, "proTypeId");
		return (Criteria) this;
		}
   public Criteria andProTypeIdNotEqualTo(Integer value) {
		  addCriterion("pro_type_id <>", value, "proTypeId");
		return (Criteria) this;
		}
    public Criteria andProTypeIdGreaterThan(Integer value) {
		 addCriterion("pro_type_id >", value, "proTypeId");
		return (Criteria) this;
		}
  public Criteria andProTypeIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("pro_type_id >=", value, "ProTypeId");
		return (Criteria) this;
		}
   public Criteria andProTypeIdLessThan(Integer value) {
		  addCriterion("pro_type_id <", value, "proTypeId");
		return (Criteria) this;
		}
    public Criteria andProTypeIdLessThanOrEqualTo(Integer value) {
		  addCriterion("pro_type_id <=", value, "proTypeId");
		return (Criteria) this;
		}
    public Criteria andProTypeIdIn(List<Integer> values) {
		  addCriterion("pro_type_id in", values, "proTypeId");
		return (Criteria) this;
		}
    public Criteria andProTypeIdNotIn(List<Integer> values) {
		  addCriterion("pro_type_id not in", values, "proTypeId");
		return (Criteria) this;
		}
     public Criteria andProTypeIdBetween(Integer value1, Integer value2) {
		   addCriterion("pro_type_id between", value1, value2, "proTypeId");
		return (Criteria) this;
		}
     public Criteria andProTypeIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("pro_type_id not between", value1, value2, "proTypeId");
		return (Criteria) this;
		}
    public Criteria andProTypeIdLike(Integer value) {
		  addCriterion("pro_type_id like", value, "proTypeId");
		return (Criteria) this;
		}
    public Criteria andProTypeIdNotLike(Integer value) {
		  addCriterion("pro_type_id not like", value, "proTypeId");
		return (Criteria) this;
		}
 public Criteria andProPriceIsNull() {
		 addCriterion("pro_price is null");
		return (Criteria) this;
		}
  public Criteria andProPriceIsNotNull(){
		addCriterion("pro_price is not null");
		return (Criteria) this;
		}
  public Criteria andProPriceEqualTo(Double value) {
		  addCriterion("pro_price =", value, "proPrice");
		return (Criteria) this;
		}
   public Criteria andProPriceNotEqualTo(Double value) {
		  addCriterion("pro_price <>", value, "proPrice");
		return (Criteria) this;
		}
    public Criteria andProPriceGreaterThan(Double value) {
		 addCriterion("pro_price >", value, "proPrice");
		return (Criteria) this;
		}
  public Criteria andProPriceGreaterThanOrEqualTo(Double value) {
		  addCriterion("pro_price >=", value, "ProPrice");
		return (Criteria) this;
		}
   public Criteria andProPriceLessThan(Double value) {
		  addCriterion("pro_price <", value, "proPrice");
		return (Criteria) this;
		}
    public Criteria andProPriceLessThanOrEqualTo(Double value) {
		  addCriterion("pro_price <=", value, "proPrice");
		return (Criteria) this;
		}
    public Criteria andProPriceIn(List<Double> values) {
		  addCriterion("pro_price in", values, "proPrice");
		return (Criteria) this;
		}
    public Criteria andProPriceNotIn(List<Double> values) {
		  addCriterion("pro_price not in", values, "proPrice");
		return (Criteria) this;
		}
     public Criteria andProPriceBetween(Double value1, Double value2) {
		   addCriterion("pro_price between", value1, value2, "proPrice");
		return (Criteria) this;
		}
     public Criteria andProPriceNotBetween(Double value1, Double value2) {
		   addCriterion("pro_price not between", value1, value2, "proPrice");
		return (Criteria) this;
		}
    public Criteria andProPriceLike(Double value) {
		  addCriterion("pro_price like", value, "proPrice");
		return (Criteria) this;
		}
    public Criteria andProPriceNotLike(Double value) {
		  addCriterion("pro_price not like", value, "proPrice");
		return (Criteria) this;
		}
 public Criteria andSctockNumIsNull() {
		 addCriterion("sctock_num is null");
		return (Criteria) this;
		}
  public Criteria andSctockNumIsNotNull(){
		addCriterion("sctock_num is not null");
		return (Criteria) this;
		}
  public Criteria andSctockNumEqualTo(Integer value) {
		  addCriterion("sctock_num =", value, "sctockNum");
		return (Criteria) this;
		}
   public Criteria andSctockNumNotEqualTo(Integer value) {
		  addCriterion("sctock_num <>", value, "sctockNum");
		return (Criteria) this;
		}
    public Criteria andSctockNumGreaterThan(Integer value) {
		 addCriterion("sctock_num >", value, "sctockNum");
		return (Criteria) this;
		}
  public Criteria andSctockNumGreaterThanOrEqualTo(Integer value) {
		  addCriterion("sctock_num >=", value, "SctockNum");
		return (Criteria) this;
		}
   public Criteria andSctockNumLessThan(Integer value) {
		  addCriterion("sctock_num <", value, "sctockNum");
		return (Criteria) this;
		}
    public Criteria andSctockNumLessThanOrEqualTo(Integer value) {
		  addCriterion("sctock_num <=", value, "sctockNum");
		return (Criteria) this;
		}
    public Criteria andSctockNumIn(List<Integer> values) {
		  addCriterion("sctock_num in", values, "sctockNum");
		return (Criteria) this;
		}
    public Criteria andSctockNumNotIn(List<Integer> values) {
		  addCriterion("sctock_num not in", values, "sctockNum");
		return (Criteria) this;
		}
     public Criteria andSctockNumBetween(Integer value1, Integer value2) {
		   addCriterion("sctock_num between", value1, value2, "sctockNum");
		return (Criteria) this;
		}
     public Criteria andSctockNumNotBetween(Integer value1, Integer value2) {
		   addCriterion("sctock_num not between", value1, value2, "sctockNum");
		return (Criteria) this;
		}
    public Criteria andSctockNumLike(Integer value) {
		  addCriterion("sctock_num like", value, "sctockNum");
		return (Criteria) this;
		}
    public Criteria andSctockNumNotLike(Integer value) {
		  addCriterion("sctock_num not like", value, "sctockNum");
		return (Criteria) this;
		}
 public Criteria andSaleNumIsNull() {
		 addCriterion("sale_num is null");
		return (Criteria) this;
		}
  public Criteria andSaleNumIsNotNull(){
		addCriterion("sale_num is not null");
		return (Criteria) this;
		}
  public Criteria andSaleNumEqualTo(Integer value) {
		  addCriterion("sale_num =", value, "saleNum");
		return (Criteria) this;
		}
   public Criteria andSaleNumNotEqualTo(Integer value) {
		  addCriterion("sale_num <>", value, "saleNum");
		return (Criteria) this;
		}
    public Criteria andSaleNumGreaterThan(Integer value) {
		 addCriterion("sale_num >", value, "saleNum");
		return (Criteria) this;
		}
  public Criteria andSaleNumGreaterThanOrEqualTo(Integer value) {
		  addCriterion("sale_num >=", value, "SaleNum");
		return (Criteria) this;
		}
   public Criteria andSaleNumLessThan(Integer value) {
		  addCriterion("sale_num <", value, "saleNum");
		return (Criteria) this;
		}
    public Criteria andSaleNumLessThanOrEqualTo(Integer value) {
		  addCriterion("sale_num <=", value, "saleNum");
		return (Criteria) this;
		}
    public Criteria andSaleNumIn(List<Integer> values) {
		  addCriterion("sale_num in", values, "saleNum");
		return (Criteria) this;
		}
    public Criteria andSaleNumNotIn(List<Integer> values) {
		  addCriterion("sale_num not in", values, "saleNum");
		return (Criteria) this;
		}
     public Criteria andSaleNumBetween(Integer value1, Integer value2) {
		   addCriterion("sale_num between", value1, value2, "saleNum");
		return (Criteria) this;
		}
     public Criteria andSaleNumNotBetween(Integer value1, Integer value2) {
		   addCriterion("sale_num not between", value1, value2, "saleNum");
		return (Criteria) this;
		}
    public Criteria andSaleNumLike(Integer value) {
		  addCriterion("sale_num like", value, "saleNum");
		return (Criteria) this;
		}
    public Criteria andSaleNumNotLike(Integer value) {
		  addCriterion("sale_num not like", value, "saleNum");
		return (Criteria) this;
		}
 public Criteria andProDetailIsNull() {
		 addCriterion("pro_detail is null");
		return (Criteria) this;
		}
  public Criteria andProDetailIsNotNull(){
		addCriterion("pro_detail is not null");
		return (Criteria) this;
		}
  public Criteria andProDetailEqualTo(String value) {
		  addCriterion("pro_detail =", value, "proDetail");
		return (Criteria) this;
		}
   public Criteria andProDetailNotEqualTo(String value) {
		  addCriterion("pro_detail <>", value, "proDetail");
		return (Criteria) this;
		}
    public Criteria andProDetailGreaterThan(String value) {
		 addCriterion("pro_detail >", value, "proDetail");
		return (Criteria) this;
		}
  public Criteria andProDetailGreaterThanOrEqualTo(String value) {
		  addCriterion("pro_detail >=", value, "ProDetail");
		return (Criteria) this;
		}
   public Criteria andProDetailLessThan(String value) {
		  addCriterion("pro_detail <", value, "proDetail");
		return (Criteria) this;
		}
    public Criteria andProDetailLessThanOrEqualTo(String value) {
		  addCriterion("pro_detail <=", value, "proDetail");
		return (Criteria) this;
		}
    public Criteria andProDetailIn(List<String> values) {
		  addCriterion("pro_detail in", values, "proDetail");
		return (Criteria) this;
		}
    public Criteria andProDetailNotIn(List<String> values) {
		  addCriterion("pro_detail not in", values, "proDetail");
		return (Criteria) this;
		}
     public Criteria andProDetailBetween(String value1, String value2) {
		   addCriterion("pro_detail between", value1, value2, "proDetail");
		return (Criteria) this;
		}
     public Criteria andProDetailNotBetween(String value1, String value2) {
		   addCriterion("pro_detail not between", value1, value2, "proDetail");
		return (Criteria) this;
		}
    public Criteria andProDetailLike(String value) {
		  addCriterion("pro_detail like", value, "proDetail");
		return (Criteria) this;
		}
    public Criteria andProDetailNotLike(String value) {
		  addCriterion("pro_detail not like", value, "proDetail");
		return (Criteria) this;
		}
 public Criteria andProImgIsNull() {
		 addCriterion("pro_img is null");
		return (Criteria) this;
		}
  public Criteria andProImgIsNotNull(){
		addCriterion("pro_img is not null");
		return (Criteria) this;
		}
  public Criteria andProImgEqualTo(String value) {
		  addCriterion("pro_img =", value, "proImg");
		return (Criteria) this;
		}
   public Criteria andProImgNotEqualTo(String value) {
		  addCriterion("pro_img <>", value, "proImg");
		return (Criteria) this;
		}
    public Criteria andProImgGreaterThan(String value) {
		 addCriterion("pro_img >", value, "proImg");
		return (Criteria) this;
		}
  public Criteria andProImgGreaterThanOrEqualTo(String value) {
		  addCriterion("pro_img >=", value, "ProImg");
		return (Criteria) this;
		}
   public Criteria andProImgLessThan(String value) {
		  addCriterion("pro_img <", value, "proImg");
		return (Criteria) this;
		}
    public Criteria andProImgLessThanOrEqualTo(String value) {
		  addCriterion("pro_img <=", value, "proImg");
		return (Criteria) this;
		}
    public Criteria andProImgIn(List<String> values) {
		  addCriterion("pro_img in", values, "proImg");
		return (Criteria) this;
		}
    public Criteria andProImgNotIn(List<String> values) {
		  addCriterion("pro_img not in", values, "proImg");
		return (Criteria) this;
		}
     public Criteria andProImgBetween(String value1, String value2) {
		   addCriterion("pro_img between", value1, value2, "proImg");
		return (Criteria) this;
		}
     public Criteria andProImgNotBetween(String value1, String value2) {
		   addCriterion("pro_img not between", value1, value2, "proImg");
		return (Criteria) this;
		}
    public Criteria andProImgLike(String value) {
		  addCriterion("pro_img like", value, "proImg");
		return (Criteria) this;
		}
    public Criteria andProImgNotLike(String value) {
		  addCriterion("pro_img not like", value, "proImg");
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
