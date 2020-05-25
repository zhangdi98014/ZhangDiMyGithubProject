package com.tdd.service;

import com.tdd.controller.LoginModel;

import com.tdd.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface ProInfoService {
    /**
      分页查询商品数据列表
    */
    public Map<String, Object> getDataList(ProInfo queryModel, Integer page,
        Integer pageSize, LoginModel login);

    /**
      封装商品为前台展示的数据形式
    */
    public Map<String, Object> getProInfoModel(ProInfo model, LoginModel login);

    /**
    * 删除数据
    */
    public void delete(Integer id);

    /**
      新增
    */
    public String add(ProInfo model, LoginModel login);

    /**
      修改
    */
    public String update(ProInfo model, LoginModel login);
}

