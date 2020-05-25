package com.tdd.service;

import com.tdd.controller.LoginModel;
import com.tdd.model.*;

import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface TgOrderInfoService {
    /**
      分页查询团购订单数据列表
    */
    public Map<String, Object> getDataList(String createTimeOrder,
        TgOrderInfo queryModel, Integer page, Integer pageSize, LoginModel login);

    /**
      封装团购订单为前台展示的数据形式
    */
    public Map<String, Object> getTgOrderInfoModel(TgOrderInfo model,
        LoginModel login);

    /**
      发货
    */
    public String fh(TgOrderInfo model, LoginModel login);
    /**
     * 团购结束，要判断是否组团成功
     */
    public void updateOrderStatusWithEndTg(Integer tgId);
}

