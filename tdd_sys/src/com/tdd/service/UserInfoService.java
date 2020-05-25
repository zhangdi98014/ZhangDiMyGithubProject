package com.tdd.service;

import com.tdd.controller.LoginModel;

import com.tdd.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface UserInfoService {
    /**
      分页查询用户数据列表
    */
    public Map<String, Object> getDataList(String nameOrder,
        UserInfo queryModel, Integer page, Integer pageSize, LoginModel login);

    /**
      封装用户为前台展示的数据形式
    */
    public Map<String, Object> getUserInfoModel(UserInfo model, LoginModel login);

    /**
    * 删除数据
    */
    public void delete(Integer id);

    /**
      修改收货地址
    */
    public String update(UserInfo model, LoginModel login);
}

