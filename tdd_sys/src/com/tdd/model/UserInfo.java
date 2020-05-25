package com.tdd.model;

public class UserInfo {
    private Integer id;
    private String name;
    private String passWord;
    private String createTime;
    private String contactName;
    private String contactCelPhone;
    private String contactCity;
    private String detailAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = (name == null) ? null : name.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = (passWord == null) ? null : passWord.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = (createTime == null) ? null : createTime.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = (contactName == null) ? null : contactName.trim();
    }

    public String getContactCelPhone() {
        return contactCelPhone;
    }

    public void setContactCelPhone(String contactCelPhone) {
        this.contactCelPhone = (contactCelPhone == null) ? null
                                                         : contactCelPhone.trim();
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

