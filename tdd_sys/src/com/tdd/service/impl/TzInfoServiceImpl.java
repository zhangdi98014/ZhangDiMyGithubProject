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
public class TzInfoServiceImpl implements TzInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    TzInfoMapper tzInfoMapper;

    /**
      新增
    */
    @Override
    public String add(TzInfo model, LoginModel login) {
        model.setCreateTime(sdf1.format(new Date())); //当前时间格式
        tzInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
      修改
    */
    @Override
    public String update(TzInfo model, LoginModel login) {
        TzInfo preModel = tzInfoMapper.selectByPrimaryKey(model.getId());
        preModel.setName(model.getName());
        preModel.setPassWord(model.getPassWord());
        tzInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
    *根据参数查询团长列表数据
    */
    @Override
    public Map<String, Object> getDataList(String nameOrder, TzInfo queryModel,
        Integer page, Integer pageSize, LoginModel login) {
        TzInfoExample se = new TzInfoExample();
        TzInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if (queryModel.getId() != null) {
            sc.andIdEqualTo(queryModel.getId());
        }

        if ((queryModel.getName() != null) &&
                (queryModel.getName().equals("") == false)) {
            sc.andNameLike("%" + queryModel.getName() + "%"); //模糊查询
        }

        if (queryModel.getId() != null) {
            sc.andIdEqualTo(queryModel.getId());
        }

        if ((nameOrder != null) && (nameOrder.equals("") == false)) {
            se.setOrderByClause(nameOrder); //按照登录名排序
        }

        int count = (int) tzInfoMapper.countByExample(se);
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

        List<TzInfo> list = tzInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (TzInfo model : list) {
            list2.add(getTzInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装团长为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getTzInfoModel(TzInfo model, LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tzInfo", model);

        return map;
    }

    /**
    * 删除数据
    */
    @Override
    public void delete(Integer id) {
        tzInfoMapper.deleteByPrimaryKey(id);
    }
}

