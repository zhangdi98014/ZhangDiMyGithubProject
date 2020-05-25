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
public class TgOrderInfoServiceImpl implements TgOrderInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    TgOrderInfoMapper tgOrderInfoMapper;
    @Autowired
    TgInfoMapper tgInfoMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    TzInfoMapper tzInfoMapper;
    @Autowired
    ProInfoMapper proInfoMapper;

    /**
      发货
    */
    @Override
    public String fh(TgOrderInfo model, LoginModel login) {
        TgOrderInfo preModel = tgOrderInfoMapper.selectByPrimaryKey(model.getId());
        preModel.setTgOrderStatus(3); //团购订单状态设置为已发货
        preModel.setTrainMsg(model.getTrainMsg());
        tgOrderInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }
    
    /**
     * 团购结束，要判断是否组团成功
     */
    public void updateOrderStatusWithEndTg(Integer tgId){
    	
    	TgOrderInfoExample te2 = new TgOrderInfoExample();
    	TgOrderInfoExample.Criteria tc2 = te2.createCriteria();
    	tc2.andTgIdEqualTo(tgId);
    	tc2.andTgOrderStatusEqualTo(1);//待付款
    	List<TgOrderInfo> tl2 = tgOrderInfoMapper.selectByExample(te2);
    	for(TgOrderInfo t2:tl2){
    		t2.setTgOrderStatus(7);//待付款直接取消订单
    		tgOrderInfoMapper.updateByPrimaryKeySelective(t2);
    	}
    	
    	TgOrderInfoExample te = new TgOrderInfoExample();
    	TgOrderInfoExample.Criteria tc = te.createCriteria();
    	tc.andTgIdEqualTo(tgId);
    	tc.andTgOrderStatusEqualTo(2);//已付款
    	List<TgOrderInfo> tl = tgOrderInfoMapper.selectByExample(te);
    	TgInfo tg = tgInfoMapper.selectByPrimaryKey(tgId);
    	if(tg.getTgNum()<=tl.size()){
    		//达到人数
    		for(TgOrderInfo o:tl){
    			o.setTgOrderStatus(6);//团购成功
    			tgOrderInfoMapper.updateByPrimaryKeySelective(o);
    		}
    	}else{//未达到人数
    		for(TgOrderInfo o:tl){
    			o.setTgOrderStatus(5);//已退款
    			tgOrderInfoMapper.updateByPrimaryKeySelective(o);
    		}
    		
    		ProInfo pro = proInfoMapper.selectByPrimaryKey(tg.getProId());
    		pro.setSctockNum(pro.getSctockNum()+tg.getTgNum());
    		proInfoMapper.updateByPrimaryKeySelective(pro);//将商品库存退回去
    		
    	}
    
    }

    /**
    *根据参数查询团购订单列表数据
    */
    @Override
    public Map<String, Object> getDataList(String createTimeOrder,
        TgOrderInfo queryModel, Integer page, Integer pageSize, LoginModel login) {
        TgOrderInfoExample se = new TgOrderInfoExample();
        TgOrderInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if (queryModel.getId() != null) {
            sc.andIdEqualTo(queryModel.getId());
        }

        if ((queryModel.getOrderNo() != null) &&
                (queryModel.getOrderNo().equals("") == false)) {
            sc.andOrderNoLike("%" + queryModel.getOrderNo() + "%"); //模糊查询
        }

        if ((queryModel.getTgTitle() != null) &&
                (queryModel.getTgTitle().equals("") == false)) {
            sc.andTgTitleLike("%" + queryModel.getTgTitle() + "%"); //模糊查询
        }

        if (queryModel.getTgOrderStatus() != null) {
            sc.andTgOrderStatusEqualTo(queryModel.getTgOrderStatus()); //查询团购订单状态等于指定值
        }

        if ((queryModel.getUserContactName() != null) &&
                (queryModel.getUserContactName().equals("") == false)) {
            sc.andUserContactNameLike("%" + queryModel.getUserContactName() +
                "%"); //模糊查询
        }

        if ((queryModel.getContactCel() != null) &&
                (queryModel.getContactCel().equals("") == false)) {
            sc.andContactCelLike("%" + queryModel.getContactCel() + "%"); //模糊查询
        }

        if (queryModel.getTzId() != null) {
            sc.andTzIdEqualTo(queryModel.getTzId()); //查询团长等于指定值
        }

        if (queryModel.getUserId() != null) {
            sc.andUserIdEqualTo(queryModel.getUserId());
        }

        if ((createTimeOrder != null) && (createTimeOrder.equals("") == false)) {
            se.setOrderByClause(createTimeOrder); //按照创建时间排序
        }

        int count = (int) tgOrderInfoMapper.countByExample(se);
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

        List<TgOrderInfo> list = tgOrderInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (TgOrderInfo model : list) {
            list2.add(getTgOrderInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装团购订单为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getTgOrderInfoModel(TgOrderInfo model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tgOrderInfo", model);

        if (model.getTgId() != null) {
            TgInfo tgInfo = tgInfoMapper.selectByPrimaryKey(model.getTgId()); //团购活动为外接字段,需要关联团购活动来解释该字段

            if (tgInfo != null) {
                map.put("tgIdStr", tgInfo.getId());
            }
        }

        map.put("tgOrderStatusStr",
            DataListUtils.getTgOrderStatusNameById(model.getTgOrderStatus() +
                "")); //解释团购订单状态字段

        if (model.getUserId() != null) {
            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(model.getUserId()); //购买用户为外接字段,需要关联用户来解释该字段

            if (userInfo != null) {
                map.put("userIdStr", userInfo.getName());
            }
        }

        if (model.getTzId() != null) {
            TzInfo tzInfo = tzInfoMapper.selectByPrimaryKey(model.getTzId()); //团长为外接字段,需要关联团长来解释该字段

            if (tzInfo != null) {
                map.put("tzIdStr", tzInfo.getName());
            }
        }

        return map;
    }
}

