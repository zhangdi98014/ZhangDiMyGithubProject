package com.tdd.model;

public class ProOrderInfo {
    private Integer id;
    private String createTime;
    private String orderNo;
    private Integer proId;
    private String proName;
    private Double proPrice;
    private Integer num;
    private Double totalAmount;
    private Integer orderStatus;
    private String trainMsg;
    private Integer evalStar;
    private String evalDetail;
    private Integer userId;
    private String contactName;
    private String contactTel;
    private String contactCity;
    private String detailAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = (createTime == null) ? null : createTime.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = (orderNo == null) ? null : orderNo.trim();
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = (proName == null) ? null : proName.trim();
    }

    public Double getProPrice() {
        return proPrice;
    }

    public void setProPrice(Double proPrice) {
        this.proPrice = proPrice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getTrainMsg() {
        return trainMsg;
    }

    public void setTrainMsg(String trainMsg) {
        this.trainMsg = (trainMsg == null) ? null : trainMsg.trim();
    }

    public Integer getEvalStar() {
        return evalStar;
    }

    public void setEvalStar(Integer evalStar) {
        this.evalStar = evalStar;
    }

    public String getEvalDetail() {
        return evalDetail;
    }

    public void setEvalDetail(String evalDetail) {
        this.evalDetail = (evalDetail == null) ? null : evalDetail.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = (contactName == null) ? null : contactName.trim();
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = (contactTel == null) ? null : contactTel.trim();
    }

    public String getContactCity() {
        return contactCity;
    }

    public void setContactCity(String contactCity) {
        this.contactCity = (contactCity == null) ? null : contactCity.trim();
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = (detailAddress == null) ? null : detailAddress.trim();
    }
}

