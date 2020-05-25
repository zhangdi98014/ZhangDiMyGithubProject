package com.tdd.service;

import com.tdd.controller.LoginModel;

import com.tdd.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface TgInfoService {
    /**
      分页查询团购活动数据列表
    */
    public Map<String, Object> getDataList(String createTimeOrder,
        TgInfo queryModel, Integer page, Integer pageSize, LoginModel login);

    /**
      封装团购活动为前台展示的数据形式
    */
    public Map<String, Object> getTgInfoModel(TgInfo model, LoginModel login);

    /**
    * 删除数据
    */
    public void delete(Integer id);

    /**
      发起团购
    */
    public String add(TgInfo model, LoginModel login);

    /**
      修改
    */
    public String update(TgInfo model, LoginModel login);
}

