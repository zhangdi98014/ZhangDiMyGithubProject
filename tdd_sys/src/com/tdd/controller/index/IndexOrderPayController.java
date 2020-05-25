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
@RequestMapping("/commonapi/index/order_pay")
public class IndexOrderPayController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    ProOrderInfoMapper proOrderInfoMapper;
    @Autowired
    ProInfoMapper proInfoMapper;
    DecimalFormat df = new DecimalFormat("#.00");

    @RequestMapping(value = "")
    public Object index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        modelMap.addAttribute("login", login);

        if (login == null) {
            return "redirect:/commonapi/user_login";
        }

        ProOrderInfoExample proOrderInfoE = new ProOrderInfoExample();
        ProOrderInfoExample.Criteria proOrderInfoC = proOrderInfoE.createCriteria();
        proOrderInfoC.andOrderStatusEqualTo(1);
        proOrderInfoC.andUserIdEqualTo(login.getId());

        List<ProOrderInfo> ol = proOrderInfoMapper.selectByExample(proOrderInfoE);
        Double totalAmount = 0.0;
        Integer totalNum = 0;
        List<Map<String, Object>> olist = new ArrayList<Map<String, Object>>();

        for (ProOrderInfo o : ol) {
            Map<String, Object> omap = new HashMap<String, Object>();
            omap.put("id", o.getId());
            omap.put("price", o.getProPrice());
            omap.put("num", o.getNum());
            totalNum += o.getNum();
            totalAmount += o.getTotalAmount();
            omap.put("totalAmount", df.format(o.getTotalAmount()));

            ProInfo pro = proInfoMapper.selectByPrimaryKey(o.getProId());
            omap.put("img", pro.getProImg());
            omap.put("title", pro.getTitle());
            olist.add(omap);
        }

        modelMap.addAttribute("ol", olist);
        modelMap.addAttribute("totalAmount", df.format(totalAmount));
        modelMap.addAttribute("totalNum", totalNum);

        return "index/order_pay";
    }

    @RequestMapping(value = "goPayOrderPage")
    public Object goPayOrderPage(ModelMap modelMap, Double amount,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        modelMap.addAttribute("login", login);
        modelMap.addAttribute("amount", df.format(amount));

        return "index/order_pay_act";
    }

    @RequestMapping(value = "paySuccess")
    public Object paySuccess(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        modelMap.addAttribute("login", login);

        return "index/order_pay_success";
    }

    @RequestMapping(value = "submitOrder")
    @ResponseBody
    public Object submitOrder(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        ProOrderInfoExample oe = new ProOrderInfoExample();
        ProOrderInfoExample.Criteria oc = oe.createCriteria();
        oc.andOrderStatusEqualTo(1);
        oc.andUserIdEqualTo(login.getId());

        List<ProOrderInfo> ol = proOrderInfoMapper.selectByExample(oe);

        if (ol.size() == 0) {
            rs.put("code", 0);
            rs.put("msg",
                "无可提交订单");

            return rs;
        }

        for (ProOrderInfo o : ol) {
            ProInfo proInfo = proInfoMapper.selectByPrimaryKey(o.getProId());

            if (proInfo.getSctockNum() < o.getNum()) {
                rs.put("code", 0);
                rs.put("msg",
                    "商品:" + proInfo.getTitle() +
                    ",库存不足");

                return rs;
            }
        }

        for (ProOrderInfo o : ol) {
            o.setOrderStatus(2);
            proOrderInfoMapper.updateByPrimaryKeySelective(o);

            ProInfo proInfo2 = proInfoMapper.selectByPrimaryKey(o.getProId());
            proInfo2.setSctockNum(proInfo2.getSctockNum() - o.getNum());
            proInfo2.setSaleNum(proInfo2.getSaleNum() + o.getNum());
            proInfoMapper.updateByPrimaryKeySelective(proInfo2);
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

        proOrderInfoMapper.deleteByPrimaryKey(id);

        rs.put("code", 1);
        rs.put("msg",
            "删除成功");

        return rs;
    }
}

