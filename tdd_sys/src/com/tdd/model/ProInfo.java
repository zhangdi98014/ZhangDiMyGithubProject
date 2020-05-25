package com.tdd.model;

public class ProInfo {
    private Integer id;
    private String createTime;
    private String title;
    private Integer proTypeId;
    private Double proPrice;
    private Integer sctockNum;
    private Integer saleNum;
    private String proDetail;
    private String proImg;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = (title == null) ? null : title.trim();
    }

    public Integer getProTypeId() {
        return proTypeId;
    }

    public void setProTypeId(Integer proTypeId) {
        this.proTypeId = proTypeId;
    }

    public Double getProPrice() {
        return proPrice;
    }

    public void setProPrice(Double proPrice) {
        this.proPrice = proPrice;
    }

    public Integer getSctockNum() {
        return sctockNum;
    }

    public void setSctockNum(Integer sctockNum) {
        this.sctockNum = sctockNum;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public String getProDetail() {
        return proDetail;
    }

    public void setProDetail(String proDetail) {
        this.proDetail = (proDetail == null) ? null : proDetail.trim();
    }

    public String getProImg() {
        return proImg;
    }

    public void setProImg(String proImg) {
        this.proImg = (proImg == null) ? null : proImg.trim();
    }
}

