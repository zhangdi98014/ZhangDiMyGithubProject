package com.tdd.controller.index;

import com.tdd.controller.*;
import com.tdd.dao.*;
import com.tdd.model.*;
import com.tdd.service.*;
import com.tdd.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/commonapi/index/tg/detail")
public class IndexTgDetailController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    TgInfoMapper tgInfoMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    TgOrderInfoMapper tgOrderInfoMapper;
    @Autowired
    ProInfoMapper proInfoMapper;

    /**
            详情页入口
    **/
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, Integer id,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        modelMap.addAttribute("login", login);

        TgInfo pro = tgInfoMapper.selectByPrimaryKey(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", pro.getId());
        map.put("title", pro.getTgTitle());
        map.put("price", pro.getProPrice());
        map.put("img", pro.getTgImg());
        map.put("stockNum", pro.getTgNum());
        map.put("pStatus", pro.getTgStatus());
        map.put("tgStatus",DataListUtils.getTgStatusNameById(pro.getTgStatus()+""));
        map.put("tgStartTime", pro.getTgStartTime());
        map.put("tgEndTime", pro.getTgEndTime());      
        modelMap.addAttribute("pro", map);
        ProInfo p = proInfoMapper.selectByPrimaryKey(pro.getProId());
        modelMap.addAttribute("p", p);
        TgOrderInfoExample te = new TgOrderInfoExample();
    	TgOrderInfoExample.Criteria tc = te.createCriteria();
    	tc.andTgIdEqualTo(id);
    	tc.andTgOrderStatusEqualTo(2);//已付款
    	List<TgOrderInfo> tl= tgOrderInfoMapper.selectByExample(te);
    	int count = 0;
    	for(TgOrderInfo o:tl){
    		count+=o.getNum();
    	}
    	   modelMap.addAttribute("buyNum", count);//已团购数量
    	   
    	   
        return "index/tg_detail";
    }

    @RequestMapping(value = "submitBuy")
    @ResponseBody
    public Object submitBuy(Integer proId, Integer num,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();

        if (login == null) {
            rs.put("code", 0);
            rs.put("msg",
                "尚未登录");

            return rs;
        }

        if ((proId == null) || (num == null)) {
            rs.put("code", 0);
            rs.put("msg",
                "非法操作");

            return rs;
        }

        TgInfo pro = tgInfoMapper.selectByPrimaryKey(proId);

        if (pro == null) {
            rs.put("code", 0);
            rs.put("msg",
                "非法操作");

            return rs;
        }

        if (pro.getTgNum() < num) {
            rs.put("code", 0);
            rs.put("msg",
                "库存不足");

            return rs;
        }

        TgOrderInfo order = new TgOrderInfo();
        order.setCreateTime(sdf1.format(new Date())); //当前时间格式
        order.setOrderNo(sdf3.format(new Date()) +
            RandomCodeUtils.getRandomCode()); //随机码(当前时间+6位随机码)
        order.setTgOrderStatus(1); //默认待付款,
        order.setTgId(proId);
        order.setTgTitle(pro.getTgTitle());
        order.setTgPrice(pro.getProPrice());
        order.setNum(num);
        order.setTotalAmount(pro.getProPrice() * num);
        order.setUserId(login.getId());

        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(order.getUserId());
        order.setTgTitle(pro.getTgTitle());
        order.setTgPrice(pro.getTgPrice());
        order.setUserContactName(userInfo.getContactName());
        order.setContactCel(userInfo.getContactCelPhone());
        order.setContactCity(userInfo.getContactCity());
        order.setContactAddress(userInfo.getDetailAddress());
        order.setTzId(pro.getTzId());
        tgOrderInfoMapper.insertSelective(order);
        rs.put("code", 1);
        rs.put("msg",
            "购买成功");

        return rs;
    }
}

