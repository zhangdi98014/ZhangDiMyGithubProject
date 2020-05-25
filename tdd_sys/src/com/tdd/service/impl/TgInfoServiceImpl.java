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
public class TgInfoServiceImpl implements TgInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    TgInfoMapper tgInfoMapper;
    @Autowired
    ProInfoMapper proInfoMapper;
    @Autowired
    TzInfoMapper tzInfoMapper;

    /**
      发起团购
    */
    @Override
    public String add(TgInfo model, LoginModel login) {
        String check = checkData(model, 1); //检查数据是否符合要求

        if (check.equals("") == false) {
            return check;
        }

        model.setTgStatus(1); //默认待审核,
        model.setTzId(login.getId()); //登录id
        model.setCreateTime(sdf1.format(new Date())); //当前时间格式

        ProInfo proInfo = proInfoMapper.selectByPrimaryKey(model.getProId()); //查询商品供以下填入其他字段

        if (proInfo != null) {
            model.setProPrice(proInfo.getProPrice());
        }

        tgInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
      修改
    */
    @Override
    public String update(TgInfo model, LoginModel login) {
        TgInfo preModel = tgInfoMapper.selectByPrimaryKey(model.getId());
        String check1 = checkData(model, 2); //检查数据是否合法

        if (check1.equals("") == false) {
            return check1;
        }

        preModel.setProId(model.getProId());
        preModel.setTgImg(model.getTgImg());
        preModel.setTgTitle(model.getTgTitle());
        preModel.setTgPrice(model.getTgPrice());
        preModel.setTgNum(model.getTgNum());
        preModel.setTgStartTime(model.getTgStartTime());
        preModel.setTgEndTime(model.getTgEndTime());

        ProInfo proInfo = proInfoMapper.selectByPrimaryKey(model.getProId()); //查询商品供以下填入其他字段
        preModel.setProPrice(proInfo.getProPrice());
        tgInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
    *根据参数查询团购活动列表数据
    */
    @Override
    public Map<String, Object> getDataList(String createTimeOrder,
        TgInfo queryModel, Integer page, Integer pageSize, LoginModel login) {
        TgInfoExample se = new TgInfoExample();
        TgInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if (queryModel.getId() != null) {
            sc.andIdEqualTo(queryModel.getId());
        }

        if ((queryModel.getTgTitle() != null) &&
                (queryModel.getTgTitle().equals("") == false)) {
            sc.andTgTitleLike("%" + queryModel.getTgTitle() + "%"); //模糊查询
        }

        if (queryModel.getTgStatus() != null) {
            sc.andTgStatusEqualTo(queryModel.getTgStatus()); //查询团购状态等于指定值
        }

        if (queryModel.getTzId() != null) {
            sc.andTzIdEqualTo(queryModel.getTzId()); //查询团长等于指定值
        }

        if ((createTimeOrder != null) && (createTimeOrder.equals("") == false)) {
            se.setOrderByClause(createTimeOrder); //按照创建时间排序
        }

        int count = (int) tgInfoMapper.countByExample(se);
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

        List<TgInfo> list = tgInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (TgInfo model : list) {
            list2.add(getTgInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装团购活动为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getTgInfoModel(TgInfo model, LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tgInfo", model);

        if (model.getProId() != null) {
            ProInfo proInfo = proInfoMapper.selectByPrimaryKey(model.getProId()); //原商品为外接字段,需要关联商品来解释该字段

            if (proInfo != null) {
                map.put("proIdStr", proInfo.getTitle());
            }
        }

        map.put("tgStatusStr",
            DataListUtils.getTgStatusNameById(model.getTgStatus() + "")); //解释团购状态字段

        if (model.getTzId() != null) {
            TzInfo tzInfo = tzInfoMapper.selectByPrimaryKey(model.getTzId()); //团长为外接字段,需要关联团长来解释该字段

            if (tzInfo != null) {
                map.put("tzIdStr", tzInfo.getName());
            }
        }

        return map;
    }

    /**
    * 删除数据
    */
    @Override
    public void delete(Integer id) {
        tgInfoMapper.deleteByPrimaryKey(id);
    }

    public String checkData(TgInfo model, Integer type) { //type=1 表示发起团购操作,type=2 表示修改操作,

        if ((type == 1) || (type == 2)) {
            if (model.getTgImg() != null) {
                String[] fileSplit = model.getTgImg().split(";");

                if (fileSplit.length > 1) {
                    return "团购宣传图的图片数量不能大于1";
                }
            }
        }

        return "";
    }
}

