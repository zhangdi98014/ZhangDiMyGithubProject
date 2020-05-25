package com.tdd.model;
import java.util.ArrayList;
import java.util.List;
public class ProOrderInfoExample {
    protected String orderByClause;
    protected boolean distinct;
    protected int startRow;
    protected int pageRows;
    protected List<Criteria> oredCriteria;
    public ProOrderInfoExample() {
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
 public Criteria andProNameIsNull() {
		 addCriterion("pro_name is null");
		return (Criteria) this;
		}
  public Criteria andProNameIsNotNull(){
		addCriterion("pro_name is not null");
		return (Criteria) this;
		}
  public Criteria andProNameEqualTo(String value) {
		  addCriterion("pro_name =", value, "proName");
		return (Criteria) this;
		}
   public Criteria andProNameNotEqualTo(String value) {
		  addCriterion("pro_name <>", value, "proName");
		return (Criteria) this;
		}
    public Criteria andProNameGreaterThan(String value) {
		 addCriterion("pro_name >", value, "proName");
		return (Criteria) this;
		}
  public Criteria andProNameGreaterThanOrEqualTo(String value) {
		  addCriterion("pro_name >=", value, "ProName");
		return (Criteria) this;
		}
   public Criteria andProNameLessThan(String value) {
		  addCriterion("pro_name <", value, "proName");
		return (Criteria) this;
		}
    public Criteria andProNameLessThanOrEqualTo(String value) {
		  addCriterion("pro_name <=", value, "proName");
		return (Criteria) this;
		}
    public Criteria andProNameIn(List<String> values) {
		  addCriterion("pro_name in", values, "proName");
		return (Criteria) this;
		}
    public Criteria andProNameNotIn(List<String> values) {
		  addCriterion("pro_name not in", values, "proName");
		return (Criteria) this;
		}
     public Criteria andProNameBetween(String value1, String value2) {
		   addCriterion("pro_name between", value1, value2, "proName");
		return (Criteria) this;
		}
     public Criteria andProNameNotBetween(String value1, String value2) {
		   addCriterion("pro_name not between", value1, value2, "proName");
		return (Criteria) this;
		}
    public Criteria andProNameLike(String value) {
		  addCriterion("pro_name like", value, "proName");
		return (Criteria) this;
		}
    public Criteria andProNameNotLike(String value) {
		  addCriterion("pro_name not like", value, "proName");
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
 public Criteria andOrderStatusIsNull() {
		 addCriterion("order_status is null");
		return (Criteria) this;
		}
  public Criteria andOrderStatusIsNotNull(){
		addCriterion("order_status is not null");
		return (Criteria) this;
		}
  public Criteria andOrderStatusEqualTo(Integer value) {
		  addCriterion("order_status =", value, "orderStatus");
		return (Criteria) this;
		}
   public Criteria andOrderStatusNotEqualTo(Integer value) {
		  addCriterion("order_status <>", value, "orderStatus");
		return (Criteria) this;
		}
    public Criteria andOrderStatusGreaterThan(Integer value) {
		 addCriterion("order_status >", value, "orderStatus");
		return (Criteria) this;
		}
  public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
		  addCriterion("order_status >=", value, "OrderStatus");
		return (Criteria) this;
		}
   public Criteria andOrderStatusLessThan(Integer value) {
		  addCriterion("order_status <", value, "orderStatus");
		return (Criteria) this;
		}
    public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
		  addCriterion("order_status <=", value, "orderStatus");
		return (Criteria) this;
		}
    public Criteria andOrderStatusIn(List<Integer> values) {
		  addCriterion("order_status in", values, "orderStatus");
		return (Criteria) this;
		}
    public Criteria andOrderStatusNotIn(List<Integer> values) {
		  addCriterion("order_status not in", values, "orderStatus");
		return (Criteria) this;
		}
     public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
		   addCriterion("order_status between", value1, value2, "orderStatus");
		return (Criteria) this;
		}
     public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
		   addCriterion("order_status not between", value1, value2, "orderStatus");
		return (Criteria) this;
		}
    public Criteria andOrderStatusLike(Integer value) {
		  addCriterion("order_status like", value, "orderStatus");
		return (Criteria) this;
		}
    public Criteria andOrderStatusNotLike(Integer value) {
		  addCriterion("order_status not like", value, "orderStatus");
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
 public Criteria andEvalStarIsNull() {
		 addCriterion("eval_star is null");
		return (Criteria) this;
		}
  public Criteria andEvalStarIsNotNull(){
		addCriterion("eval_star is not null");
		return (Criteria) this;
		}
  public Criteria andEvalStarEqualTo(Integer value) {
		  addCriterion("eval_star =", value, "evalStar");
		return (Criteria) this;
		}
   public Criteria andEvalStarNotEqualTo(Integer value) {
		  addCriterion("eval_star <>", value, "evalStar");
		return (Criteria) this;
		}
    public Criteria andEvalStarGreaterThan(Integer value) {
		 addCriterion("eval_star >", value, "evalStar");
		return (Criteria) this;
		}
  public Criteria andEvalStarGreaterThanOrEqualTo(Integer value) {
		  addCriterion("eval_star >=", value, "EvalStar");
		return (Criteria) this;
		}
   public Criteria andEvalStarLessThan(Integer value) {
		  addCriterion("eval_star <", value, "evalStar");
		return (Criteria) this;
		}
    public Criteria andEvalStarLessThanOrEqualTo(Integer value) {
		  addCriterion("eval_star <=", value, "evalStar");
		return (Criteria) this;
		}
    public Criteria andEvalStarIn(List<Integer> values) {
		  addCriterion("eval_star in", values, "evalStar");
		return (Criteria) this;
		}
    public Criteria andEvalStarNotIn(List<Integer> values) {
		  addCriterion("eval_star not in", values, "evalStar");
		return (Criteria) this;
		}
     public Criteria andEvalStarBetween(Integer value1, Integer value2) {
		   addCriterion("eval_star between", value1, value2, "evalStar");
		return (Criteria) this;
		}
     public Criteria andEvalStarNotBetween(Integer value1, Integer value2) {
		   addCriterion("eval_star not between", value1, value2, "evalStar");
		return (Criteria) this;
		}
    public Criteria andEvalStarLike(Integer value) {
		  addCriterion("eval_star like", value, "evalStar");
		return (Criteria) this;
		}
    public Criteria andEvalStarNotLike(Integer value) {
		  addCriterion("eval_star not like", value, "evalStar");
		return (Criteria) this;
		}
 public Criteria andEvalDetailIsNull() {
		 addCriterion("eval_detail is null");
		return (Criteria) this;
		}
  public Criteria andEvalDetailIsNotNull(){
		addCriterion("eval_detail is not null");
		return (Criteria) this;
		}
  public Criteria andEvalDetailEqualTo(String value) {
		  addCriterion("eval_detail =", value, "evalDetail");
		return (Criteria) this;
		}
   public Criteria andEvalDetailNotEqualTo(String value) {
		  addCriterion("eval_detail <>", value, "evalDetail");
		return (Criteria) this;
		}
    public Criteria andEvalDetailGreaterThan(String value) {
		 addCriterion("eval_detail >", value, "evalDetail");
		return (Criteria) this;
		}
  public Criteria andEvalDetailGreaterThanOrEqualTo(String value) {
		  addCriterion("eval_detail >=", value, "EvalDetail");
		return (Criteria) this;
		}
   public Criteria andEvalDetailLessThan(String value) {
		  addCriterion("eval_detail <", value, "evalDetail");
		return (Criteria) this;
		}
    public Criteria andEvalDetailLessThanOrEqualTo(String value) {
		  addCriterion("eval_detail <=", value, "evalDetail");
		return (Criteria) this;
		}
    public Criteria andEvalDetailIn(List<String> values) {
		  addCriterion("eval_detail in", values, "evalDetail");
		return (Criteria) this;
		}
    public Criteria andEvalDetailNotIn(List<String> values) {
		  addCriterion("eval_detail not in", values, "evalDetail");
		return (Criteria) this;
		}
     public Criteria andEvalDetailBetween(String value1, String value2) {
		   addCriterion("eval_detail between", value1, value2, "evalDetail");
		return (Criteria) this;
		}
     public Criteria andEvalDetailNotBetween(String value1, String value2) {
		   addCriterion("eval_detail not between", value1, value2, "evalDetail");
		return (Criteria) this;
		}
    public Criteria andEvalDetailLike(String value) {
		  addCriterion("eval_detail like", value, "evalDetail");
		return (Criteria) this;
		}
    public Criteria andEvalDetailNotLike(String value) {
		  addCriterion("eval_detail not like", value, "evalDetail");
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
 public Criteria andContactTelIsNull() {
		 addCriterion("contact_tel is null");
		return (Criteria) this;
		}
  public Criteria andContactTelIsNotNull(){
		addCriterion("contact_tel is not null");
		return (Criteria) this;
		}
  public Criteria andContactTelEqualTo(String value) {
		  addCriterion("contact_tel =", value, "contactTel");
		return (Criteria) this;
		}
   public Criteria andContactTelNotEqualTo(String value) {
		  addCriterion("contact_tel <>", value, "contactTel");
		return (Criteria) this;
		}
    public Criteria andContactTelGreaterThan(String value) {
		 addCriterion("contact_tel >", value, "contactTel");
		return (Criteria) this;
		}
  public Criteria andContactTelGreaterThanOrEqualTo(String value) {
		  addCriterion("contact_tel >=", value, "ContactTel");
		return (Criteria) this;
		}
   public Criteria andContactTelLessThan(String value) {
		  addCriterion("contact_tel <", value, "contactTel");
		return (Criteria) this;
		}
    public Criteria andContactTelLessThanOrEqualTo(String value) {
		  addCriterion("contact_tel <=", value, "contactTel");
		return (Criteria) this;
		}
    public Criteria andContactTelIn(List<String> values) {
		  addCriterion("contact_tel in", values, "contactTel");
		return (Criteria) this;
		}
    public Criteria andContactTelNotIn(List<String> values) {
		  addCriterion("contact_tel not in", values, "contactTel");
		return (Criteria) this;
		}
     public Criteria andContactTelBetween(String value1, String value2) {
		   addCriterion("contact_tel between", value1, value2, "contactTel");
		return (Criteria) this;
		}
     public Criteria andContactTelNotBetween(String value1, String value2) {
		   addCriterion("contact_tel not between", value1, value2, "contactTel");
		return (Criteria) this;
		}
    public Criteria andContactTelLike(String value) {
		  addCriterion("contact_tel like", value, "contactTel");
		return (Criteria) this;
		}
    public Criteria andContactTelNotLike(String value) {
		  addCriterion("contact_tel not like", value, "contactTel");
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
