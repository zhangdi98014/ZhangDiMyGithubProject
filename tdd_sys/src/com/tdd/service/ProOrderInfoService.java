package com.tdd.service;

import com.tdd.controller.LoginModel;

import com.tdd.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface ProOrderInfoService {
    /**
      分页查询普通商品订单数据列表
    */
    public Map<String, Object> getDataList(String createTimeOrder,
        ProOrderInfo queryModel, Integer page, Integer pageSize,
        LoginModel login);

    /**
      封装普通商品订单为前台展示的数据形式
    */
    public Map<String, Object> getProOrderInfoModel(ProOrderInfo model,
        LoginModel login);

    /**
      发货
    */
    public String fh(ProOrderInfo model, LoginModel login);

    /**
      评价
    */
    public String eval(ProOrderInfo model, LoginModel login);
}

