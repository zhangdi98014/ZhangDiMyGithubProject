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

import java.text.DecimalFormat;
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
@RequestMapping("/commonapi/index/tg/order_pay")
public class IndexTgOrderPayController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    TgOrderInfoMapper tgOrderInfoMapper;
    @Autowired
    TgInfoMapper tgInfoMapper;
    DecimalFormat df = new DecimalFormat("#.00");

    @RequestMapping(value = "")
    public Object index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        modelMap.addAttribute("login", login);

        if (login == null) {
            return "redirect:/commonapi/user_login";
        }

        TgOrderInfoExample tgOrderInfoE = new TgOrderInfoExample();
        TgOrderInfoExample.Criteria tgOrderInfoC = tgOrderInfoE.createCriteria();
        tgOrderInfoC.andTgOrderStatusEqualTo(1);
        tgOrderInfoC.andUserIdEqualTo(login.getId());

        List<TgOrderInfo> ol = tgOrderInfoMapper.selectByExample(tgOrderInfoE);
        Double totalAmount = 0.0;
        Integer totalNum = 0;
        List<Map<String, Object>> olist = new ArrayList<Map<String, Object>>();

        for (TgOrderInfo o : ol) {
            Map<String, Object> omap = new HashMap<String, Object>();
            omap.put("id", o.getId());
            omap.put("price", o.getTgPrice());
            omap.put("num", o.getNum());
            totalNum += o.getNum();
            totalAmount += o.getTotalAmount();
            omap.put("totalAmount", df.format(o.getTotalAmount()));

            TgInfo pro = tgInfoMapper.selectByPrimaryKey(o.getTgId());
            omap.put("img", pro.getTgImg());
            omap.put("title", pro.getTgTitle());
            olist.add(omap);
        }

        modelMap.addAttribute("ol", olist);
        modelMap.addAttribute("totalAmount", df.format(totalAmount));
        modelMap.addAttribute("totalNum", totalNum);

        return "index/tg_order_pay";
    }

    @RequestMapping(value = "goPayOrderPage")
    public Object goPayOrderPage(ModelMap modelMap, Double amount,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        modelMap.addAttribute("login", login);
        modelMap.addAttribute("amount", df.format(amount));

        return "index/tg_order_pay_act";
    }

    @RequestMapping(value = "paySuccess")
    public Object paySuccess(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        modelMap.addAttribute("login", login);

        return "index/tg_order_pay_success";
    }

    @RequestMapping(value = "submitOrder")
    @ResponseBody
    public Object submitOrder(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        TgOrderInfoExample oe = new TgOrderInfoExample();
        TgOrderInfoExample.Criteria oc = oe.createCriteria();
        oc.andTgOrderStatusEqualTo(1);
        oc.andUserIdEqualTo(login.getId());

        List<TgOrderInfo> ol = tgOrderInfoMapper.selectByExample(oe);

        if (ol.size() == 0) {
            rs.put("code", 0);
            rs.put("msg",
                "无可提交订单");

            return rs;
        }

        for (TgOrderInfo o : ol) {
            TgInfo tgInfo = tgInfoMapper.selectByPrimaryKey(o.getTgId());

            if (tgInfo.getTgNum() < o.getNum()) {
                rs.put("code", 0);
                rs.put("msg",
                    "商品:" + tgInfo.getTgTitle() +
                    ",库存不足");

                return rs;
            }
        }

        for (TgOrderInfo o : ol) {
            o.setTgOrderStatus(2);
            tgOrderInfoMapper.updateByPrimaryKeySelective(o);

            TgInfo tgInfo2 = tgInfoMapper.selectByPrimaryKey(o.getTgId());
            tgInfo2.setTgNum(tgInfo2.getTgNum() - o.getNum());
            tgInfoMapper.updateByPrimaryKeySelective(tgInfo2);
        }

        rs.put("code", 1);
        rs.put("msg",
            "结算成功,请返回个人中心查看");

        return rs;
    }

    @RequestMapping(value = "delOrder")
    @ResponseBody
    public Object delOrder(ModelMap modelMap, HttpServletRequest request,
        Integer id) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();

        if (login == null) {
            rs.put("code", 0);
            rs.put("msg",
                "尚未登录");

            return rs;
        }

        tgOrderInfoMapper.deleteByPrimaryKey(id);

        rs.put("code", 1);
        rs.put("msg",
            "删除成功");

        return rs;
    }
}

