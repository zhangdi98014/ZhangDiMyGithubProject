package com.tdd.model;
import java.util.ArrayList;
import java.util.List;
public class TgOrderInfoExample {
    protected String orderByClause;
    protected boolean distinct;
    protected int startRow;
    protected int pageRows;
    protected List<Criteria> oredCriteria;
    public TgOrderInfoExample() {
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
 public Criteria andOrderNoIsNull() {
		 addCriterion("order_no is null");
		return (Criteria) this;
		}
  public Criteria andOrderNoIsNotNull(){
		addCriterion("order_no is not null");
		return (Criteria) this;
		}
  public Criteria andOrderNoEqualTo(String value) {
		  addCriterion("order_no =", value, "orderNo");
		return (Criteria) this;
		}
   public Criteria andOrderNoNotEqualTo(String value) {
		  addCriterion("order_no <>", value, "orderNo");
		return (Criteria) this;
		}
    public Criteria andOrderNoGreaterThan(String value) {
		 addCriterion("order_no >", value, "orderNo");
		return (Criteria) this;
		}
  public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
		  addCriterion("order_no >=", value, "OrderNo");
		return (Criteria) this;
		}
   public Criteria andOrderNoLessThan(String value) {
		  addCriterion("order_no <", value, "orderNo");
		return (Criteria) this;
		}
    public Criteria andOrderNoLessThanOrEqualTo(String value) {
		  addCriterion("order_no <=", value, "orderNo");
		return (Criteria) this;
		}
    public Criteria andOrderNoIn(List<String> values) {
		  addCriterion("order_no in", values, "orderNo");
		return (Criteria) this;
		}
    public Criteria andOrderNoNotIn(List<String> values) {
		  addCriterion("order_no not in", values, "orderNo");
		return (Criteria) this;
		}
     public Criteria andOrderNoBetween(String value1, String value2) {
		   addCriterion("order_no between", value1, value2, "orderNo");
		return (Criteria) this;
		}
     public Criteria andOrderNoNotBetween(String value1, String value2) {
		   addCriterion("order_no not between", value1, value2, "orderNo");
		return (Criteria) this;
		}
    public Criteria andOrderNoLike(String value) {
		  addCriterion("order_no like", value, "orderNo");
		return (Criteria) this;
		}
    public Criteria andOrderNoNotLike(String value) {
		  addCriterion("order_no not like", value, "orderNo");
		return (Criteria) this;
		}
 public Criteria andTgIdIsNull() {
		 addCriterion("tg_id is null");
		return (Criteria) this;
		}
  public Criteria andTgIdIsNotNull(){
		addCriterion("tg_id is not null");
		return (Criteria) this;
		}
  public Criteria andTgIdEqualTo(Integer value) {
		  addCriterion("tg_id =", value, "tgId");
		return (Criteria) this;
		}
   public Criteria andTgIdNotEqualTo(Integer value) {
		  addCriterion("tg_id <>", value, "tgId");
		return (Criteria) this;
		}
    public Criteria andTgIdGreaterThan(Integer value) {
		 addCriterion("tg_id >", value, "tgId");
		return (Criteria) this;
		}
  public Criteria andTgIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("tg_id >=", value, "TgId");
		return (Criteria) this;
		}
   public Criteria andTgIdLessThan(Integer value) {
		  addCriterion("tg_id <", value, "tgId");
		return (Criteria) this;
		}
    public Criteria andTgIdLessThanOrEqualTo(Integer value) {
		  addCriterion("tg_id <=", value, "tgId");
		return (Criteria) this;
		}
    public Criteria andTgIdIn(List<Integer> values) {
		  addCriterion("tg_id in", values, "tgId");
		return (Criteria) this;
		}
    public Criteria andTgIdNotIn(List<Integer> values) {
		  addCriterion("tg_id not in", values, "tgId");
		return (Criteria) this;
		}
     public Criteria andTgIdBetween(Integer value1, Integer value2) {
		   addCriterion("tg_id between", value1, value2, "tgId");
		return (Criteria) this;
		}
     public Criteria andTgIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("tg_id not between", value1, value2, "tgId");
		return (Criteria) this;
		}
    public Criteria andTgIdLike(Integer value) {
		  addCriterion("tg_id like", value, "tgId");
		return (Criteria) this;
		}
    public Criteria andTgIdNotLike(Integer value) {
		  addCriterion("tg_id not like", value, "tgId");
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
 public Criteria andNumIsNull() {
		 addCriterion("num is null");
		return (Criteria) this;
		}
  public Criteria andNumIsNotNull(){
		addCriterion("num is not null");
		return (Criteria) this;
		}
  public Criteria andNumEqualTo(Integer value) {
		  addCriterion("num =", value, "num");
		return (Criteria) this;
		}
   public Criteria andNumNotEqualTo(Integer value) {
		  addCriterion("num <>", value, "num");
		return (Criteria) this;
		}
    public Criteria andNumGreaterThan(Integer value) {
		 addCriterion("num >", value, "num");
		return (Criteria) this;
		}
  public Criteria andNumGreaterThanOrEqualTo(Integer value) {
		  addCriterion("num >=", value, "Num");
		return (Criteria) this;
		}
   public Criteria andNumLessThan(Integer value) {
		  addCriterion("num <", value, "num");
		return (Criteria) this;
		}
    public Criteria andNumLessThanOrEqualTo(Integer value) {
		  addCriterion("num <=", value, "num");
		return (Criteria) this;
		}
    public Criteria andNumIn(List<Integer> values) {
		  addCriterion("num in", values, "num");
		return (Criteria) this;
		}
    public Criteria andNumNotIn(List<Integer> values) {
		  addCriterion("num not in", values, "num");
		return (Criteria) this;
		}
     public Criteria andNumBetween(Integer value1, Integer value2) {
		   addCriterion("num between", value1, value2, "num");
		return (Criteria) this;
		}
     public Criteria andNumNotBetween(Integer value1, Integer value2) {
		   addCriterion("num not between", value1, value2, "num");
		return (Criteria) this;
		}
    public Criteria andNumLike(Integer value) {
		  addCriterion("num like", value, "num");
		return (Criteria) this;
		}
    public Criteria andNumNotLike(Integer value) {
		  addCriterion("num not like", value, "num");
		return (Criteria) this;
		}
 public Criteria andTotalAmountIsNull() {
		 addCriterion("total_amount is null");
		return (Criteria) this;
		}
  public Criteria andTotalAmountIsNotNull(){
		addCriterion("total_amount is not null");
		return (Criteria) this;
		}
  public Criteria andTotalAmountEqualTo(Double value) {
		  addCriterion("total_amount =", value, "totalAmount");
		return (Criteria) this;
		}
   public Criteria andTotalAmountNotEqualTo(Double value) {
		  addCriterion("total_amount <>", value, "totalAmount");
		return (Criteria) this;
		}
    public Criteria andTotalAmountGreaterThan(Double value) {
		 addCriterion("total_amount >", value, "totalAmount");
		return (Criteria) this;
		}
  public Criteria andTotalAmountGreaterThanOrEqualTo(Double value) {
		  addCriterion("total_amount >=", value, "TotalAmount");
		return (Criteria) this;
		}
   public Criteria andTotalAmountLessThan(Double value) {
		  addCriterion("total_amount <", value, "totalAmount");
		return (Criteria) this;
		}
    public Criteria andTotalAmountLessThanOrEqualTo(Double value) {
		  addCriterion("total_amount <=", value, "totalAmount");
		return (Criteria) this;
		}
    public Criteria andTotalAmountIn(List<Double> values) {
		  addCriterion("total_amount in", values, "totalAmount");
		return (Criteria) this;
		}
    public Criteria andTotalAmountNotIn(List<Double> values) {
		  addCriterion("total_amount not in", values, "totalAmount");
		return (Criteria) this;
		}
     public Criteria andTotalAmountBetween(Double value1, Double value2) {
		   addCriterion("total_amount between", value1, value2, "totalAmount");
		return (Criteria) this;
		}
     public Criteria andTotalAmountNotBetween(Double value1, Double value2) {
		   addCriterion("total_amount not between", value1, value2, "totalAmount");
		return (Criteria) this;
		}
    public Criteria andTotalAmountLike(Double value) {
		  addCriterion("total_amount like", value, "totalAmount");
		return (Criteria) this;
		}
    public Criteria andTotalAmountNotLike(Double value) {
		  addCriterion("total_amount not like", value, "totalAmount");
		return (Criteria) this;
		}
 public Criteria andTgOrderStatusIsNull() {
		 addCriterion("tg_order_status is null");
		return (Criteria) this;
		}
  public Criteria andTgOrderStatusIsNotNull(){
		addCriterion("tg_order_status is not null");
		return (Criteria) this;
		}
  public Criteria andTgOrderStatusEqualTo(Integer value) {
		  addCriterion("tg_order_status =", value, "tgOrderStatus");
		return (Criteria) this;
		}
   public Criteria andTgOrderStatusNotEqualTo(Integer value) {
		  addCriterion("tg_order_status <>", value, "tgOrderStatus");
		return (Criteria) this;
		}
    public Criteria andTgOrderStatusGreaterThan(Integer value) {
		 addCriterion("tg_order_status >", value, "tgOrderStatus");
		return (Criteria) this;
		}
  public Criteria andTgOrderStatusGreaterThanOrEqualTo(Integer value) {
		  addCriterion("tg_order_status >=", value, "TgOrderStatus");
		return (Criteria) this;
		}
   public Criteria andTgOrderStatusLessThan(Integer value) {
		  addCriterion("tg_order_status <", value, "tgOrderStatus");
		return (Criteria) this;
		}
    public Criteria andTgOrderStatusLessThanOrEqualTo(Integer value) {
		  addCriterion("tg_order_status <=", value, "tgOrderStatus");
		return (Criteria) this;
		}
    public Criteria andTgOrderStatusIn(List<Integer> values) {
		  addCriterion("tg_order_status in", values, "tgOrderStatus");
		return (Criteria) this;
		}
    public Criteria andTgOrderStatusNotIn(List<Integer> values) {
		  addCriterion("tg_order_status not in", values, "tgOrderStatus");
		return (Criteria) this;
		}
     public Criteria andTgOrderStatusBetween(Integer value1, Integer value2) {
		   addCriterion("tg_order_status between", value1, value2, "tgOrderStatus");
		return (Criteria) this;
		}
     public Criteria andTgOrderStatusNotBetween(Integer value1, Integer value2) {
		   addCriterion("tg_order_status not between", value1, value2, "tgOrderStatus");
		return (Criteria) this;
		}
    public Criteria andTgOrderStatusLike(Integer value) {
		  addCriterion("tg_order_status like", value, "tgOrderStatus");
		return (Criteria) this;
		}
    public Criteria andTgOrderStatusNotLike(Integer value) {
		  addCriterion("tg_order_status not like", value, "tgOrderStatus");
		return (Criteria) this;
		}
 public Criteria andTrainMsgIsNull() {
		 addCriterion("train_msg is null");
		return (Criteria) this;
		}
  public Criteria andTrainMsgIsNotNull(){
		addCriterion("train_msg is not null");
		return (Criteria) this;
		}
  public Criteria andTrainMsgEqualTo(String value) {
		  addCriterion("train_msg =", value, "trainMsg");
		return (Criteria) this;
		}
   public Criteria andTrainMsgNotEqualTo(String value) {
		  addCriterion("train_msg <>", value, "trainMsg");
		return (Criteria) this;
		}
    public Criteria andTrainMsgGreaterThan(String value) {
		 addCriterion("train_msg >", value, "trainMsg");
		return (Criteria) this;
		}
  public Criteria andTrainMsgGreaterThanOrEqualTo(String value) {
		  addCriterion("train_msg >=", value, "TrainMsg");
		return (Criteria) this;
		}
   public Criteria andTrainMsgLessThan(String value) {
		  addCriterion("train_msg <", value, "trainMsg");
		return (Criteria) this;
		}
    public Criteria andTrainMsgLessThanOrEqualTo(String value) {
		  addCriterion("train_msg <=", value, "trainMsg");
		return (Criteria) this;
		}
    public Criteria andTrainMsgIn(List<String> values) {
		  addCriterion("train_msg in", values, "trainMsg");
		return (Criteria) this;
		}
    public Criteria andTrainMsgNotIn(List<String> values) {
		  addCriterion("train_msg not in", values, "trainMsg");
		return (Criteria) this;
		}
     public Criteria andTrainMsgBetween(String value1, String value2) {
		   addCriterion("train_msg between", value1, value2, "trainMsg");
		return (Criteria) this;
		}
     public Criteria andTrainMsgNotBetween(String value1, String value2) {
		   addCriterion("train_msg not between", value1, value2, "trainMsg");
		return (Criteria) this;
		}
    public Criteria andTrainMsgLike(String value) {
		  addCriterion("train_msg like", value, "trainMsg");
		return (Criteria) this;
		}
    public Criteria andTrainMsgNotLike(String value) {
		  addCriterion("train_msg not like", value, "trainMsg");
		return (Criteria) this;
		}
 public Criteria andUserIdIsNull() {
		 addCriterion("user_id is null");
		return (Criteria) this;
		}
  public Criteria andUserIdIsNotNull(){
		addCriterion("user_id is not null");
		return (Criteria) this;
		}
  public Criteria andUserIdEqualTo(Integer value) {
		  addCriterion("user_id =", value, "userId");
		return (Criteria) this;
		}
   public Criteria andUserIdNotEqualTo(Integer value) {
		  addCriterion("user_id <>", value, "userId");
		return (Criteria) this;
		}
    public Criteria andUserIdGreaterThan(Integer value) {
		 addCriterion("user_id >", value, "userId");
		return (Criteria) this;
		}
  public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("user_id >=", value, "UserId");
		return (Criteria) this;
		}
   public Criteria andUserIdLessThan(Integer value) {
		  addCriterion("user_id <", value, "userId");
		return (Criteria) this;
		}
    public Criteria andUserIdLessThanOrEqualTo(Integer value) {
		  addCriterion("user_id <=", value, "userId");
		return (Criteria) this;
		}
    public Criteria andUserIdIn(List<Integer> values) {
		  addCriterion("user_id in", values, "userId");
		return (Criteria) this;
		}
    public Criteria andUserIdNotIn(List<Integer> values) {
		  addCriterion("user_id not in", values, "userId");
		return (Criteria) this;
		}
     public Criteria andUserIdBetween(Integer value1, Integer value2) {
		   addCriterion("user_id between", value1, value2, "userId");
		return (Criteria) this;
		}
     public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("user_id not between", value1, value2, "userId");
		return (Criteria) this;
		}
    public Criteria andUserIdLike(Integer value) {
		  addCriterion("user_id like", value, "userId");
		return (Criteria) this;
		}
    public Criteria andUserIdNotLike(Integer value) {
		  addCriterion("user_id not like", value, "userId");
		return (Criteria) this;
		}
 public Criteria andUserContactNameIsNull() {
		 addCriterion("user_contact_name is null");
		return (Criteria) this;
		}
  public Criteria andUserContactNameIsNotNull(){
		addCriterion("user_contact_name is not null");
		return (Criteria) this;
		}
  public Criteria andUserContactNameEqualTo(String value) {
		  addCriterion("user_contact_name =", value, "userContactName");
		return (Criteria) this;
		}
   public Criteria andUserContactNameNotEqualTo(String value) {
		  addCriterion("user_contact_name <>", value, "userContactName");
		return (Criteria) this;
		}
    public Criteria andUserContactNameGreaterThan(String value) {
		 addCriterion("user_contact_name >", value, "userContactName");
		return (Criteria) this;
		}
  public Criteria andUserContactNameGreaterThanOrEqualTo(String value) {
		  addCriterion("user_contact_name >=", value, "UserContactName");
		return (Criteria) this;
		}
   public Criteria andUserContactNameLessThan(String value) {
		  addCriterion("user_contact_name <", value, "userContactName");
		return (Criteria) this;
		}
    public Criteria andUserContactNameLessThanOrEqualTo(String value) {
		  addCriterion("user_contact_name <=", value, "userContactName");
		return (Criteria) this;
		}
    public Criteria andUserContactNameIn(List<String> values) {
		  addCriterion("user_contact_name in", values, "userContactName");
		return (Criteria) this;
		}
    public Criteria andUserContactNameNotIn(List<String> values) {
		  addCriterion("user_contact_name not in", values, "userContactName");
		return (Criteria) this;
		}
     public Criteria andUserContactNameBetween(String value1, String value2) {
		   addCriterion("user_contact_name between", value1, value2, "userContactName");
		return (Criteria) this;
		}
     public Criteria andUserContactNameNotBetween(String value1, String value2) {
		   addCriterion("user_contact_name not between", value1, value2, "userContactName");
		return (Criteria) this;
		}
    public Criteria andUserContactNameLike(String value) {
		  addCriterion("user_contact_name like", value, "userContactName");
		return (Criteria) this;
		}
    public Criteria andUserContactNameNotLike(String value) {
		  addCriterion("user_contact_name not like", value, "userContactName");
		return (Criteria) this;
		}
 public Criteria andContactCelIsNull() {
		 addCriterion("contact_cel is null");
		return (Criteria) this;
		}
  public Criteria andContactCelIsNotNull(){
		addCriterion("contact_cel is not null");
		return (Criteria) this;
		}
  public Criteria andContactCelEqualTo(String value) {
		  addCriterion("contact_cel =", value, "contactCel");
		return (Criteria) this;
		}
   public Criteria andContactCelNotEqualTo(String value) {
		  addCriterion("contact_cel <>", value, "contactCel");
		return (Criteria) this;
		}
    public Criteria andContactCelGreaterThan(String value) {
		 addCriterion("contact_cel >", value, "contactCel");
		return (Criteria) this;
		}
  public Criteria andContactCelGreaterThanOrEqualTo(String value) {
		  addCriterion("contact_cel >=", value, "ContactCel");
		return (Criteria) this;
		}
   public Criteria andContactCelLessThan(String value) {
		  addCriterion("contact_cel <", value, "contactCel");
		return (Criteria) this;
		}
    public Criteria andContactCelLessThanOrEqualTo(String value) {
		  addCriterion("contact_cel <=", value, "contactCel");
		return (Criteria) this;
		}
    public Criteria andContactCelIn(List<String> values) {
		  addCriterion("contact_cel in", values, "contactCel");
		return (Criteria) this;
		}
    public Criteria andContactCelNotIn(List<String> values) {
		  addCriterion("contact_cel not in", values, "contactCel");
		return (Criteria) this;
		}
     public Criteria andContactCelBetween(String value1, String value2) {
		   addCriterion("contact_cel between", value1, value2, "contactCel");
		return (Criteria) this;
		}
     public Criteria andContactCelNotBetween(String value1, String value2) {
		   addCriterion("contact_cel not between", value1, value2, "contactCel");
		return (Criteria) this;
		}
    public Criteria andContactCelLike(String value) {
		  addCriterion("contact_cel like", value, "contactCel");
		return (Criteria) this;
		}
    public Criteria andContactCelNotLike(String value) {
		  addCriterion("contact_cel not like", value, "contactCel");
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
 public Criteria andContactAddressIsNull() {
		 addCriterion("contact_address is null");
		return (Criteria) this;
		}
  public Criteria andContactAddressIsNotNull(){
		addCriterion("contact_address is not null");
		return (Criteria) this;
		}
  public Criteria andContactAddressEqualTo(String value) {
		  addCriterion("contact_address =", value, "contactAddress");
		return (Criteria) this;
		}
   public Criteria andContactAddressNotEqualTo(String value) {
		  addCriterion("contact_address <>", value, "contactAddress");
		return (Criteria) this;
		}
    public Criteria andContactAddressGreaterThan(String value) {
		 addCriterion("contact_address >", value, "contactAddress");
		return (Criteria) this;
		}
  public Criteria andContactAddressGreaterThanOrEqualTo(String value) {
		  addCriterion("contact_address >=", value, "ContactAddress");
		return (Criteria) this;
		}
   public Criteria andContactAddressLessThan(String value) {
		  addCriterion("contact_address <", value, "contactAddress");
		return (Criteria) this;
		}
    public Criteria andContactAddressLessThanOrEqualTo(String value) {
		  addCriterion("contact_address <=", value, "contactAddress");
		return (Criteria) this;
		}
    public Criteria andContactAddressIn(List<String> values) {
		  addCriterion("contact_address in", values, "contactAddress");
		return (Criteria) this;
		}
    public Criteria andContactAddressNotIn(List<String> values) {
		  addCriterion("contact_address not in", values, "contactAddress");
		return (Criteria) this;
		}
     public Criteria andContactAddressBetween(String value1, String value2) {
		   addCriterion("contact_address between", value1, value2, "contactAddress");
		return (Criteria) this;
		}
     public Criteria andContactAddressNotBetween(String value1, String value2) {
		   addCriterion("contact_address not between", value1, value2, "contactAddress");
		return (Criteria) this;
		}
    public Criteria andContactAddressLike(String value) {
		  addCriterion("contact_address like", value, "contactAddress");
		return (Criteria) this;
		}
    public Criteria andContactAddressNotLike(String value) {
		  addCriterion("contact_address not like", value, "contactAddress");
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
