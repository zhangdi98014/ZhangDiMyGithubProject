package com.tdd.controller.index;

import com.tdd.controller.*;

import com.tdd.dao.*;

import com.tdd.model.*;

import com.tdd.service.*;

import com.tdd.util.*;
import com.tdd.util.PageUtils;

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
@RequestMapping("/commonapi/index/detail")
public class IndexDetailController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    ProTypeInfoMapper proTypeInfoMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    ProOrderInfoMapper proOrderInfoMapper;
    @Autowired
    ProInfoMapper proInfoMapper;
    @Autowired
    TgInfoMapper tgInfoMapper;

    /**
            详情页入口
    **/
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, Integer id,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        modelMap.addAttribute("login", login);

        ProOrderInfoExample proOrderInfoE = new ProOrderInfoExample();
        ProOrderInfoExample.Criteria proOrderInfoC = proOrderInfoE.createCriteria();
        proOrderInfoC.andEvalStarIsNotNull();
        proOrderInfoC.andEvalStarNotEqualTo(0);
        proOrderInfoC.andProIdEqualTo(id);

        List<ProOrderInfo> proOrderInfoList = proOrderInfoMapper.selectByExample(proOrderInfoE);
        List<Map<String, Object>> el = new ArrayList<Map<String, Object>>();

        for (ProOrderInfo o : proOrderInfoList) {
            Map<String, Object> map3 = new HashMap<String, Object>();
            map3.put("evalStar", o.getEvalStar());
            map3.put("eid", o.getId());
            map3.put("evalDetail", o.getEvalDetail());

            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(o.getUserId());

            if (userInfo != null) {
                map3.put("userName", userInfo.getName());
            }

            el.add(map3);
        }

        modelMap.addAttribute("el", el);

        ProInfo pro = proInfoMapper.selectByPrimaryKey(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", pro.getId());
        map.put("title", pro.getTitle());
        map.put("price", pro.getProPrice());
        map.put("img", pro.getProImg());
        map.put("stockNum", pro.getSctockNum());
        map.put("saleNum", pro.getSaleNum());
        map.put("itemDesc", pro.getProDetail());

        ProTypeInfo typeT = proTypeInfoMapper.selectByPrimaryKey(pro.getProTypeId());

        if (typeT != null) {
            map.put("type", typeT.getName());
        }

        modelMap.addAttribute("pro", map);
        
        TgInfoExample te = new TgInfoExample();
        TgInfoExample.Criteria tc = te.createCriteria();
        tc.andProIdEqualTo(pro.getId());
        tc.andTgStatusEqualTo(5);//筛选活动中的团购活动
        List< TgInfo> tl= tgInfoMapper.selectByExample(te);
        modelMap.addAttribute("tl", tl);
        return "index/detail";
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

        ProInfo pro = proInfoMapper.selectByPrimaryKey(proId);

        if (pro == null) {
            rs.put("code", 0);
            rs.put("msg",
                "非法操作");

            return rs;
        }

        if (pro.getSctockNum() < num) {
            rs.put("code", 0);
            rs.put("msg",
                "库存不足");

            return rs;
        }

        ProOrderInfo order = new ProOrderInfo();
        order.setCreateTime(sdf1.format(new Date())); //当前时间格式
        order.setOrderNo(sdf3.format(new Date()) +
            RandomCodeUtils.getRandomCode()); //随机码(当前时间+6位随机码)
        order.setOrderStatus(1); //默认待付款,
        order.setProId(proId);
        order.setProName(pro.getTitle());
        order.setProPrice(pro.getProPrice());
        order.setNum(num);
        order.setTotalAmount(pro.getProPrice() * num);
        order.setUserId(login.getId());

        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(order.getUserId());
        order.setProName(pro.getTitle());
        order.setProPrice(pro.getProPrice());
        order.setContactName(userInfo.getContactName());
        order.setContactTel(userInfo.getContactCelPhone());
        order.setContactCity(userInfo.getContactCity());
        order.setDetailAddress(userInfo.getDetailAddress());
        proOrderInfoMapper.insertSelective(order);
        rs.put("code", 1);
        rs.put("msg",
            "购买成功");

        return rs;
    }
}

