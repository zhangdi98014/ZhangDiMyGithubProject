package com.tdd.model;

public class TgOrderInfo {
    private Integer id;
    private String createTime;
    private String orderNo;
    private Integer tgId;
    private String tgTitle;
    private Double tgPrice;
    private Integer num;
    private Double totalAmount;
    private Integer tgOrderStatus;
    private String trainMsg;
    private Integer userId;
    private String userContactName;
    private String contactCel;
    private String contactCity;
    private String contactAddress;
    private Integer tzId;

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

    public Integer getTgId() {
        return tgId;
    }

    public void setTgId(Integer tgId) {
        this.tgId = tgId;
    }

    public String getTgTitle() {
        return tgTitle;
    }

    public void setTgTitle(String tgTitle) {
        this.tgTitle = (tgTitle == null) ? null : tgTitle.trim();
    }

    public Double getTgPrice() {
        return tgPrice;
    }

    public void setTgPrice(Double tgPrice) {
        this.tgPrice = tgPrice;
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

    public Integer getTgOrderStatus() {
        return tgOrderStatus;
    }

    public void setTgOrderStatus(Integer tgOrderStatus) {
        this.tgOrderStatus = tgOrderStatus;
    }

    public String getTrainMsg() {
        return trainMsg;
    }

    public void setTrainMsg(String trainMsg) {
        this.trainMsg = (trainMsg == null) ? null : trainMsg.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserContactName() {
        return userContactName;
    }

    public void setUserContactName(String userContactName) {
        this.userContactName = (userContactName == null) ? null
                                                         : userContactName.trim();
    }

    public String getContactCel() {
        return contactCel;
    }

    public void setContactCel(String contactCel) {
        this.contactCel = (contactCel == null) ? null : contactCel.trim();
    }

    public String getContactCity() {
        return contactCity;
    }

    public void setContactCity(String contactCity) {
        this.contactCity = (contactCity == null) ? null : contactCity.trim();
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = (contactAddress == null) ? null
                                                       : contactAddress.trim();
    }

    public Integer getTzId() {
        return tzId;
    }

    public void setTzId(Integer tzId) {
        this.tzId = tzId;
    }
}

