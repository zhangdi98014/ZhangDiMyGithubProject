package com.tdd.model;
import java.util.ArrayList;
import java.util.List;
public class TgInfoExample {
    protected String orderByClause;
    protected boolean distinct;
    protected int startRow;
    protected int pageRows;
    protected List<Criteria> oredCriteria;
    public TgInfoExample() {
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
 public Criteria andProIdIsNull() {
		 addCriterion("pro_id is null");
		return (Criteria) this;
		}
  public Criteria andProIdIsNotNull(){
		addCriterion("pro_id is not null");
		return (Criteria) this;
		}
  public Criteria andProIdEqualTo(Integer value) {
		  addCriterion("pro_id =", value, "proId");
		return (Criteria) this;
		}
   public Criteria andProIdNotEqualTo(Integer value) {
		  addCriterion("pro_id <>", value, "proId");
		return (Criteria) this;
		}
    public Criteria andProIdGreaterThan(Integer value) {
		 addCriterion("pro_id >", value, "proId");
		return (Criteria) this;
		}
  public Criteria andProIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("pro_id >=", value, "ProId");
		return (Criteria) this;
		}
   public Criteria andProIdLessThan(Integer value) {
		  addCriterion("pro_id <", value, "proId");
		return (Criteria) this;
		}
    public Criteria andProIdLessThanOrEqualTo(Integer value) {
		  addCriterion("pro_id <=", value, "proId");
		return (Criteria) this;
		}
    public Criteria andProIdIn(List<Integer> values) {
		  addCriterion("pro_id in", values, "proId");
		return (Criteria) this;
		}
    public Criteria andProIdNotIn(List<Integer> values) {
		  addCriterion("pro_id not in", values, "proId");
		return (Criteria) this;
		}
     public Criteria andProIdBetween(Integer value1, Integer value2) {
		   addCriterion("pro_id between", value1, value2, "proId");
		return (Criteria) this;
		}
     public Criteria andProIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("pro_id not between", value1, value2, "proId");
		return (Criteria) this;
		}
    public Criteria andProIdLike(Integer value) {
		  addCriterion("pro_id like", value, "proId");
		return (Criteria) this;
		}
    public Criteria andProIdNotLike(Integer value) {
		  addCriterion("pro_id not like", value, "proId");
		return (Criteria) this;
		}
 public Criteria andTgTitleIsNull() {
		 addCriterion("tg_title is null");
		return (Criteria) this;
		}
  public Criteria andTgTitleIsNotNull(){
		addCriterion("tg_title is not null");
		return (Criteria) this;
		}
  public Criteria andTgTitleEqualTo(String value) {
		  addCriterion("tg_title =", value, "tgTitle");
		return (Criteria) this;
		}
   public Criteria andTgTitleNotEqualTo(String value) {
		  addCriterion("tg_title <>", value, "tgTitle");
		return (Criteria) this;
		}
    public Criteria andTgTitleGreaterThan(String value) {
		 addCriterion("tg_title >", value, "tgTitle");
		return (Criteria) this;
		}
  public Criteria andTgTitleGreaterThanOrEqualTo(String value) {
		  addCriterion("tg_title >=", value, "TgTitle");
		return (Criteria) this;
		}
   public Criteria andTgTitleLessThan(String value) {
		  addCriterion("tg_title <", value, "tgTitle");
		return (Criteria) this;
		}
    public Criteria andTgTitleLessThanOrEqualTo(String value) {
		  addCriterion("tg_title <=", value, "tgTitle");
		return (Criteria) this;
		}
    public Criteria andTgTitleIn(List<String> values) {
		  addCriterion("tg_title in", values, "tgTitle");
		return (Criteria) this;
		}
    public Criteria andTgTitleNotIn(List<String> values) {
		  addCriterion("tg_title not in", values, "tgTitle");
		return (Criteria) this;
		}
     public Criteria andTgTitleBetween(String value1, String value2) {
		   addCriterion("tg_title between", value1, value2, "tgTitle");
		return (Criteria) this;
		}
     public Criteria andTgTitleNotBetween(String value1, String value2) {
		   addCriterion("tg_title not between", value1, value2, "tgTitle");
		return (Criteria) this;
		}
    public Criteria andTgTitleLike(String value) {
		  addCriterion("tg_title like", value, "tgTitle");
		return (Criteria) this;
		}
    public Criteria andTgTitleNotLike(String value) {
		  addCriterion("tg_title not like", value, "tgTitle");
		return (Criteria) this;
		}
 public Criteria andTgPriceIsNull() {
		 addCriterion("tg_price is null");
		return (Criteria) this;
		}
  public Criteria andTgPriceIsNotNull(){
		addCriterion("tg_price is not null");
		return (Criteria) this;
		}
  public Criteria andTgPriceEqualTo(Double value) {
		  addCriterion("tg_price =", value, "tgPrice");
		return (Criteria) this;
		}
   public Criteria andTgPriceNotEqualTo(Double value) {
		  addCriterion("tg_price <>", value, "tgPrice");
		return (Criteria) this;
		}
    public Criteria andTgPriceGreaterThan(Double value) {
		 addCriterion("tg_price >", value, "tgPrice");
		return (Criteria) this;
		}
  public Criteria andTgPriceGreaterThanOrEqualTo(Double value) {
		  addCriterion("tg_price >=", value, "TgPrice");
		return (Criteria) this;
		}
   public Criteria andTgPriceLessThan(Double value) {
		  addCriterion("tg_price <", value, "tgPrice");
		return (Criteria) this;
		}
    public Criteria andTgPriceLessThanOrEqualTo(Double value) {
		  addCriterion("tg_price <=", value, "tgPrice");
		return (Criteria) this;
		}
    public Criteria andTgPriceIn(List<Double> values) {
		  addCriterion("tg_price in", values, "tgPrice");
		return (Criteria) this;
		}
    public Criteria andTgPriceNotIn(List<Double> values) {
		  addCriterion("tg_price not in", values, "tgPrice");
		return (Criteria) this;
		}
     public Criteria andTgPriceBetween(Double value1, Double value2) {
		   addCriterion("tg_price between", value1, value2, "tgPrice");
		return (Criteria) this;
		}
     public Criteria andTgPriceNotBetween(Double value1, Double value2) {
		   addCriterion("tg_price not between", value1, value2, "tgPrice");
		return (Criteria) this;
		}
    public Criteria andTgPriceLike(Double value) {
		  addCriterion("tg_price like", value, "tgPrice");
		return (Criteria) this;
		}
    public Criteria andTgPriceNotLike(Double value) {
		  addCriterion("tg_price not like", value, "tgPrice");
		return (Criteria) this;
		}
 public Criteria andTgNumIsNull() {
		 addCriterion("tg_num is null");
		return (Criteria) this;
		}
  public Criteria andTgNumIsNotNull(){
		addCriterion("tg_num is not null");
		return (Criteria) this;
		}
  public Criteria andTgNumEqualTo(Integer value) {
		  addCriterion("tg_num =", value, "tgNum");
		return (Criteria) this;
		}
   public Criteria andTgNumNotEqualTo(Integer value) {
		  addCriterion("tg_num <>", value, "tgNum");
		return (Criteria) this;
		}
    public Criteria andTgNumGreaterThan(Integer value) {
		 addCriterion("tg_num >", value, "tgNum");
		return (Criteria) this;
		}
  public Criteria andTgNumGreaterThanOrEqualTo(Integer value) {
		  addCriterion("tg_num >=", value, "TgNum");
		return (Criteria) this;
		}
   public Criteria andTgNumLessThan(Integer value) {
		  addCriterion("tg_num <", value, "tgNum");
		return (Criteria) this;
		}
    public Criteria andTgNumLessThanOrEqualTo(Integer value) {
		  addCriterion("tg_num <=", value, "tgNum");
		return (Criteria) this;
		}
    public Criteria andTgNumIn(List<Integer> values) {
		  addCriterion("tg_num in", values, "tgNum");
		return (Criteria) this;
		}
    public Criteria andTgNumNotIn(List<Integer> values) {
		  addCriterion("tg_num not in", values, "tgNum");
		return (Criteria) this;
		}
     public Criteria andTgNumBetween(Integer value1, Integer value2) {
		   addCriterion("tg_num between", value1, value2, "tgNum");
		return (Criteria) this;
		}
     public Criteria andTgNumNotBetween(Integer value1, Integer value2) {
		   addCriterion("tg_num not between", value1, value2, "tgNum");
		return (Criteria) this;
		}
    public Criteria andTgNumLike(Integer value) {
		  addCriterion("tg_num like", value, "tgNum");
		return (Criteria) this;
		}
    public Criteria andTgNumNotLike(Integer value) {
		  addCriterion("tg_num not like", value, "tgNum");
		return (Criteria) this;
		}
 public Criteria andTgStartTimeIsNull() {
		 addCriterion("tg_start_time is null");
		return (Criteria) this;
		}
  public Criteria andTgStartTimeIsNotNull(){
		addCriterion("tg_start_time is not null");
		return (Criteria) this;
		}
  public Criteria andTgStartTimeEqualTo(String value) {
		  addCriterion("tg_start_time =", value, "tgStartTime");
		return (Criteria) this;
		}
   public Criteria andTgStartTimeNotEqualTo(String value) {
		  addCriterion("tg_start_time <>", value, "tgStartTime");
		return (Criteria) this;
		}
    public Criteria andTgStartTimeGreaterThan(String value) {
		 addCriterion("tg_start_time >", value, "tgStartTime");
		return (Criteria) this;
		}
  public Criteria andTgStartTimeGreaterThanOrEqualTo(String value) {
		  addCriterion("tg_start_time >=", value, "TgStartTime");
		return (Criteria) this;
		}
   public Criteria andTgStartTimeLessThan(String value) {
		  addCriterion("tg_start_time <", value, "tgStartTime");
		return (Criteria) this;
		}
    public Criteria andTgStartTimeLessThanOrEqualTo(String value) {
		  addCriterion("tg_start_time <=", value, "tgStartTime");
		return (Criteria) this;
		}
    public Criteria andTgStartTimeIn(List<String> values) {
		  addCriterion("tg_start_time in", values, "tgStartTime");
		return (Criteria) this;
		}
    public Criteria andTgStartTimeNotIn(List<String> values) {
		  addCriterion("tg_start_time not in", values, "tgStartTime");
		return (Criteria) this;
		}
     public Criteria andTgStartTimeBetween(String value1, String value2) {
		   addCriterion("tg_start_time between", value1, value2, "tgStartTime");
		return (Criteria) this;
		}
     public Criteria andTgStartTimeNotBetween(String value1, String value2) {
		   addCriterion("tg_start_time not between", value1, value2, "tgStartTime");
		return (Criteria) this;
		}
    public Criteria andTgStartTimeLike(String value) {
		  addCriterion("tg_start_time like", value, "tgStartTime");
		return (Criteria) this;
		}
    public Criteria andTgStartTimeNotLike(String value) {
		  addCriterion("tg_start_time not like", value, "tgStartTime");
		return (Criteria) this;
		}
 public Criteria andTgEndTimeIsNull() {
		 addCriterion("tg_end_time is null");
		return (Criteria) this;
		}
  public Criteria andTgEndTimeIsNotNull(){
		addCriterion("tg_end_time is not null");
		return (Criteria) this;
		}
  public Criteria andTgEndTimeEqualTo(String value) {
		  addCriterion("tg_end_time =", value, "tgEndTime");
		return (Criteria) this;
		}
   public Criteria andTgEndTimeNotEqualTo(String value) {
		  addCriterion("tg_end_time <>", value, "tgEndTime");
		return (Criteria) this;
		}
    public Criteria andTgEndTimeGreaterThan(String value) {
		 addCriterion("tg_end_time >", value, "tgEndTime");
		return (Criteria) this;
		}
  public Criteria andTgEndTimeGreaterThanOrEqualTo(String value) {
		  addCriterion("tg_end_time >=", value, "TgEndTime");
		return (Criteria) this;
		}
   public Criteria andTgEndTimeLessThan(String value) {
		  addCriterion("tg_end_time <", value, "tgEndTime");
		return (Criteria) this;
		}
    public Criteria andTgEndTimeLessThanOrEqualTo(String value) {
		  addCriterion("tg_end_time <=", value, "tgEndTime");
		return (Criteria) this;
		}
    public Criteria andTgEndTimeIn(List<String> values) {
		  addCriterion("tg_end_time in", values, "tgEndTime");
		return (Criteria) this;
		}
    public Criteria andTgEndTimeNotIn(List<String> values) {
		  addCriterion("tg_end_time not in", values, "tgEndTime");
		return (Criteria) this;
		}
     public Criteria andTgEndTimeBetween(String value1, String value2) {
		   addCriterion("tg_end_time between", value1, value2, "tgEndTime");
		return (Criteria) this;
		}
     public Criteria andTgEndTimeNotBetween(String value1, String value2) {
		   addCriterion("tg_end_time not between", value1, value2, "tgEndTime");
		return (Criteria) this;
		}
    public Criteria andTgEndTimeLike(String value) {
		  addCriterion("tg_end_time like", value, "tgEndTime");
		return (Criteria) this;
		}
    public Criteria andTgEndTimeNotLike(String value) {
		  addCriterion("tg_end_time not like", value, "tgEndTime");
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
 public Criteria andTgStatusIsNull() {
		 addCriterion("tg_status is null");
		return (Criteria) this;
		}
  public Criteria andTgStatusIsNotNull(){
		addCriterion("tg_status is not null");
		return (Criteria) this;
		}
  public Criteria andTgStatusEqualTo(Integer value) {
		  addCriterion("tg_status =", value, "tgStatus");
		return (Criteria) this;
		}
   public Criteria andTgStatusNotEqualTo(Integer value) {
		  addCriterion("tg_status <>", value, "tgStatus");
		return (Criteria) this;
		}
    public Criteria andTgStatusGreaterThan(Integer value) {
		 addCriterion("tg_status >", value, "tgStatus");
		return (Criteria) this;
		}
  public Criteria andTgStatusGreaterThanOrEqualTo(Integer value) {
		  addCriterion("tg_status >=", value, "TgStatus");
		return (Criteria) this;
		}
   public Criteria andTgStatusLessThan(Integer value) {
		  addCriterion("tg_status <", value, "tgStatus");
		return (Criteria) this;
		}
    public Criteria andTgStatusLessThanOrEqualTo(Integer value) {
		  addCriterion("tg_status <=", value, "tgStatus");
		return (Criteria) this;
		}
    public Criteria andTgStatusIn(List<Integer> values) {
		  addCriterion("tg_status in", values, "tgStatus");
		return (Criteria) this;
		}
    public Criteria andTgStatusNotIn(List<Integer> values) {
		  addCriterion("tg_status not in", values, "tgStatus");
		return (Criteria) this;
		}
     public Criteria andTgStatusBetween(Integer value1, Integer value2) {
		   addCriterion("tg_status between", value1, value2, "tgStatus");
		return (Criteria) this;
		}
     public Criteria andTgStatusNotBetween(Integer value1, Integer value2) {
		   addCriterion("tg_status not between", value1, value2, "tgStatus");
		return (Criteria) this;
		}
    public Criteria andTgStatusLike(Integer value) {
		  addCriterion("tg_status like", value, "tgStatus");
		return (Criteria) this;
		}
    public Criteria andTgStatusNotLike(Integer value) {
		  addCriterion("tg_status not like", value, "tgStatus");
		return (Criteria) this;
		}
 public Criteria andTgImgIsNull() {
		 addCriterion("tg_img is null");
		return (Criteria) this;
		}
  public Criteria andTgImgIsNotNull(){
		addCriterion("tg_img is not null");
		return (Criteria) this;
		}
  public Criteria andTgImgEqualTo(String value) {
		  addCriterion("tg_img =", value, "tgImg");
		return (Criteria) this;
		}
   public Criteria andTgImgNotEqualTo(String value) {
		  addCriterion("tg_img <>", value, "tgImg");
		return (Criteria) this;
		}
    public Criteria andTgImgGreaterThan(String value) {
		 addCriterion("tg_img >", value, "tgImg");
		return (Criteria) this;
		}
  public Criteria andTgImgGreaterThanOrEqualTo(String value) {
		  addCriterion("tg_img >=", value, "TgImg");
		return (Criteria) this;
		}
   public Criteria andTgImgLessThan(String value) {
		  addCriterion("tg_img <", value, "tgImg");
		return (Criteria) this;
		}
    public Criteria andTgImgLessThanOrEqualTo(String value) {
		  addCriterion("tg_img <=", value, "tgImg");
		return (Criteria) this;
		}
    public Criteria andTgImgIn(List<String> values) {
		  addCriterion("tg_img in", values, "tgImg");
		return (Criteria) this;
		}
    public Criteria andTgImgNotIn(List<String> values) {
		  addCriterion("tg_img not in", values, "tgImg");
		return (Criteria) this;
		}
     public Criteria andTgImgBetween(String value1, String value2) {
		   addCriterion("tg_img between", value1, value2, "tgImg");
		return (Criteria) this;
		}
     public Criteria andTgImgNotBetween(String value1, String value2) {
		   addCriterion("tg_img not between", value1, value2, "tgImg");
		return (Criteria) this;
		}
    public Criteria andTgImgLike(String value) {
		  addCriterion("tg_img like", value, "tgImg");
		return (Criteria) this;
		}
    public Criteria andTgImgNotLike(String value) {
		  addCriterion("tg_img not like", value, "tgImg");
		return (Criteria) this;
		}
 public Criteria andTzIdIsNull() {
		 addCriterion("tz_id is null");
		return (Criteria) this;
		}
  public Criteria andTzIdIsNotNull(){
		addCriterion("tz_id is not null");
		return (Criteria) this;
		}
  public Criteria andTzIdEqualTo(Integer value) {
		  addCriterion("tz_id =", value, "tzId");
		return (Criteria) this;
		}
   public Criteria andTzIdNotEqualTo(Integer value) {
		  addCriterion("tz_id <>", value, "tzId");
		return (Criteria) this;
		}
    public Criteria andTzIdGreaterThan(Integer value) {
		 addCriterion("tz_id >", value, "tzId");
		return (Criteria) this;
		}
  public Criteria andTzIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("tz_id >=", value, "TzId");
		return (Criteria) this;
		}
   public Criteria andTzIdLessThan(Integer value) {
		  addCriterion("tz_id <", value, "tzId");
		return (Criteria) this;
		}
    public Criteria andTzIdLessThanOrEqualTo(Integer value) {
		  addCriterion("tz_id <=", value, "tzId");
		return (Criteria) this;
		}
    public Criteria andTzIdIn(List<Integer> values) {
		  addCriterion("tz_id in", values, "tzId");
		return (Criteria) this;
		}
    public Criteria andTzIdNotIn(List<Integer> values) {
		  addCriterion("tz_id not in", values, "tzId");
		return (Criteria) this;
		}
     public Criteria andTzIdBetween(Integer value1, Integer value2) {
		   addCriterion("tz_id between", value1, value2, "tzId");
		return (Criteria) this;
		}
     public Criteria andTzIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("tz_id not between", value1, value2, "tzId");
		return (Criteria) this;
		}
    public Criteria andTzIdLike(Integer value) {
		  addCriterion("tz_id like", value, "tzId");
		return (Criteria) this;
		}
    public Criteria andTzIdNotLike(Integer value) {
		  addCriterion("tz_id not like", value, "tzId");
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
