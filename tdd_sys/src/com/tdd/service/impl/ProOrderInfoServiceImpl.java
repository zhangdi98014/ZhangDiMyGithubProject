package com.tdd.service.impl;

import com.tdd.controller.LoginModel;

import com.tdd.dao.*;

import com.tdd.model.*;

import com.tdd.service.*;

import com.tdd.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.ui.ModelMap;

import java.io.IOException;
import java.io.InputStream;

import java.text.SimpleDateFormat;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
public class ProOrderInfoServiceImpl implements ProOrderInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    ProOrderInfoMapper proOrderInfoMapper;
    @Autowired
    ProInfoMapper proInfoMapper;
    @Autowired
    UserInfoMapper userInfoMapper;

    /**
      发货
    */
    @Override
    public String fh(ProOrderInfo model, LoginModel login) {
        ProOrderInfo preModel = proOrderInfoMapper.selectByPrimaryKey(model.getId());
        preModel.setOrderStatus(3); //订单状态设置为已发货
        preModel.setTrainMsg(model.getTrainMsg());
        proOrderInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
      评价
    */
    @Override
    public String eval(ProOrderInfo model, LoginModel login) {
        ProOrderInfo preModel = proOrderInfoMapper.selectByPrimaryKey(model.getId());
        preModel.setOrderStatus(5); //订单状态设置为已评价
        preModel.setEvalStar(model.getEvalStar());
        preModel.setEvalDetail(model.getEvalDetail());
        proOrderInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
    *根据参数查询普通商品订单列表数据
    */
    @Override
    public Map<String, Object> getDataList(String createTimeOrder,
        ProOrderInfo queryModel, Integer page, Integer pageSize,
        LoginModel login) {
        ProOrderInfoExample se = new ProOrderInfoExample();
        ProOrderInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if (queryModel.getId() != null) {
            sc.andIdEqualTo(queryModel.getId());
        }

        if ((queryModel.getOrderNo() != null) &&
                (queryModel.getOrderNo().equals("") == false)) {
            sc.andOrderNoLike("%" + queryModel.getOrderNo() + "%"); //模糊查询
        }

        if ((queryModel.getProName() != null) &&
                (queryModel.getProName().equals("") == false)) {
            sc.andProNameLike("%" + queryModel.getProName() + "%"); //模糊查询
        }

        if (queryModel.getOrderStatus() != null) {
            sc.andOrderStatusEqualTo(queryModel.getOrderStatus()); //查询订单状态等于指定值
        }

        if ((queryModel.getContactTel() != null) &&
                (queryModel.getContactTel().equals("") == false)) {
            sc.andContactTelLike("%" + queryModel.getContactTel() + "%"); //模糊查询
        }

        if (queryModel.getUserId() != null) {
            sc.andUserIdEqualTo(queryModel.getUserId());
        }

        if ((createTimeOrder != null) && (createTimeOrder.equals("") == false)) {
            se.setOrderByClause(createTimeOrder); //按照创建时间排序
        }

        int count = (int) proOrderInfoMapper.countByExample(se);
        int totalPage = 0;

        if ((page != null) && (pageSize != null)) { //分页

            if ((count > 0) && ((count % pageSize) == 0)) {
                totalPage = count / pageSize;
            } else {
                totalPage = (count / pageSize) + 1;
            }

            se.setPageRows(pageSize);
            se.setStartRow((page - 1) * pageSize);
        }

        List<ProOrderInfo> list = proOrderInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (ProOrderInfo model : list) {
            list2.add(getProOrderInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装普通商品订单为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getProOrderInfoModel(ProOrderInfo model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("proOrderInfo", model);

        if (model.getProId() != null) {
            ProInfo proInfo = proInfoMapper.selectByPrimaryKey(model.getProId()); //商品id为外接字段,需要关联商品来解释该字段

            if (proInfo != null) {
                map.put("proIdStr", proInfo.getTitle());
            }
        }

        map.put("orderStatusStr",
            DataListUtils.getOrderStatusNameById(model.getOrderStatus() + "")); //解释订单状态字段

        if (model.getUserId() != null) {
            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(model.getUserId()); //购买用户为外接字段,需要关联用户来解释该字段

            if (userInfo != null) {
                map.put("userIdStr", userInfo.getName());
            }
        }

        return map;
    }
}

