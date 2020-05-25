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
public class ProInfoServiceImpl implements ProInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    ProInfoMapper proInfoMapper;
    @Autowired
    ProTypeInfoMapper proTypeInfoMapper;

    /**
      新增
    */
    @Override
    public String add(ProInfo model, LoginModel login) {
        String check = checkData(model, 1); //检查数据是否符合要求

        if (check.equals("") == false) {
            return check;
        }

        model.setSaleNum(0); //默认0
        model.setCreateTime(sdf1.format(new Date())); //当前时间格式
        proInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
      修改
    */
    @Override
    public String update(ProInfo model, LoginModel login) {
        ProInfo preModel = proInfoMapper.selectByPrimaryKey(model.getId());
        String check1 = checkData(model, 2); //检查数据是否合法

        if (check1.equals("") == false) {
            return check1;
        }

        preModel.setProImg(model.getProImg());
        preModel.setTitle(model.getTitle());
        preModel.setProTypeId(model.getProTypeId());
        preModel.setProPrice(model.getProPrice());
        preModel.setSctockNum(model.getSctockNum());
        preModel.setProDetail(model.getProDetail());
        proInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
    *根据参数查询商品列表数据
    */
    @Override
    public Map<String, Object> getDataList(ProInfo queryModel, Integer page,
        Integer pageSize, LoginModel login) {
        ProInfoExample se = new ProInfoExample();
        ProInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if (queryModel.getId() != null) {
            sc.andIdEqualTo(queryModel.getId());
        }

        if ((queryModel.getTitle() != null) &&
                (queryModel.getTitle().equals("") == false)) {
            sc.andTitleLike("%" + queryModel.getTitle() + "%"); //模糊查询
        }

        if (queryModel.getProTypeId() != null) {
            sc.andProTypeIdEqualTo(queryModel.getProTypeId()); //查询商品类型等于指定值
        }

        int count = (int) proInfoMapper.countByExample(se);
        int totalPage = 0;

        if ((page != null) && (pageSize != null)) { //分页

            if ((count > 0) && ((count % pageSize) == 0)) {
                totalPage = count / pageSize;
            } else {
                totalPage = (count / pageSize) + 1;
            }

            se.setPageRows(pageSize);
            se.setStartRow((page - 1) * pageSize);//limit 0,10    第一页前十条
        }

        List<ProInfo> list = proInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (ProInfo model : list) {
            list2.add(getProInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装商品为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getProInfoModel(ProInfo model, LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("proInfo", model);

        if (model.getProTypeId() != null) {
            ProTypeInfo proTypeInfo = proTypeInfoMapper.selectByPrimaryKey(model.getProTypeId()); //商品类型为外接字段,需要关联商品类型来解释该字段

            if (proTypeInfo != null) {
                map.put("proTypeIdStr", proTypeInfo.getName());
            }
        }

        return map;
    }

    /**
    * 删除数据
    */
    @Override
    public void delete(Integer id) {
        proInfoMapper.deleteByPrimaryKey(id);
    }

    public String checkData(ProInfo model, Integer type) { //type=1 表示新增操作,type=2 表示修改操作,

        if ((type == 1) || (type == 2)) {
            if (model.getProImg() != null) {
                String[] fileSplit = model.getProImg().split(";");

                if (fileSplit.length > 1) {
                    return "商品大图的图片数量不能大于1";
                }
            }
        }

        return "";
    }
}

