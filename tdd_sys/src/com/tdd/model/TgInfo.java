package com.tdd.model;

public class TgInfo {
    private Integer id;
    private String createTime;
    private Integer proId;
    private String tgTitle;
    private Double tgPrice;
    private Integer tgNum;
    private String tgStartTime;
    private String tgEndTime;
    private Double proPrice;
    private Integer tgStatus;
    private String tgImg;
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

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
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

    public Integer getTgNum() {
        return tgNum;
    }

    public void setTgNum(Integer tgNum) {
        this.tgNum = tgNum;
    }

    public String getTgStartTime() {
        return tgStartTime;
    }

    public void setTgStartTime(String tgStartTime) {
        this.tgStartTime = (tgStartTime == null) ? null : tgStartTime.trim();
    }

    public String getTgEndTime() {
        return tgEndTime;
    }

    public void setTgEndTime(String tgEndTime) {
        this.tgEndTime = (tgEndTime == null) ? null : tgEndTime.trim();
    }

    public Double getProPrice() {
        return proPrice;
    }

    public void setProPrice(Double proPrice) {
        this.proPrice = proPrice;
    }

    public Integer getTgStatus() {
        return tgStatus;
    }

    public void setTgStatus(Integer tgStatus) {
        this.tgStatus = tgStatus;
    }

    public String getTgImg() {
        return tgImg;
    }

    public void setTgImg(String tgImg) {
        this.tgImg = (tgImg == null) ? null : tgImg.trim();
    }

    public Integer getTzId() {
        return tzId;
    }

    public void setTzId(Integer tzId) {
        this.tzId = tzId;
    }
}

