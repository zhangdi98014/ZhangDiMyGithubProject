package com.tdd.service;

import com.tdd.controller.LoginModel;

import com.tdd.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface TzInfoService {
    /**
      分页查询团长数据列表
    */
    public Map<String, Object> getDataList(String nameOrder, TzInfo queryModel,
        Integer page, Integer pageSize, LoginModel login);

    /**
      封装团长为前台展示的数据形式
    */
    public Map<String, Object> getTzInfoModel(TzInfo model, LoginModel login);

    /**
    * 删除数据
    */
    public void delete(Integer id);

    /**
      新增
    */
    public String add(TzInfo model, LoginModel login);

    /**
      修改
    */
    public String update(TzInfo model, LoginModel login);
}

