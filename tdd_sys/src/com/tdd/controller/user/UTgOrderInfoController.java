package com.tdd.controller.user;

import com.tdd.controller.LoginModel;

import com.tdd.dao.*;

import com.tdd.model.*;

import com.tdd.service.*;
import com.tdd.service.impl.*;

import com.tdd.util.*;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user/tg_order_info")
public class UTgOrderInfoController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    TgOrderInfoService tgOrderInfoService;
    @Autowired
    TzInfoMapper tzInfoMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    TgInfoMapper tgInfoMapper;
    @Autowired
    TgOrderInfoMapper tgOrderInfoMapper;

    public void getList(ModelMap modelMap, LoginModel login) { //获取数据列表并返回给前台

        TgInfoExample tgInfoE = new TgInfoExample();
        TgInfoExample.Criteria tgInfoC = tgInfoE.createCriteria();
        List<TgInfo> tgInfoList = tgInfoMapper.selectByExample(tgInfoE);
        List<Map<String, Object>> tgInfoList2 = new ArrayList<Map<String, Object>>();

        for (TgInfo m : tgInfoList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", m.getId());
            map.put("name", m.getId());
            tgInfoList2.add(map);
        }

        modelMap.addAttribute("tgInfoList", tgInfoList2);
        modelMap.addAttribute("tgOrderStatusList",
            DataListUtils.getTgOrderStatusList()); //返回tg_order_status数据列表

        UserInfoExample userInfoE = new UserInfoExample();
        UserInfoExample.Criteria userInfoC = userInfoE.createCriteria();
        userInfoC.andIdEqualTo(login.getId()); //ID等于当前登录id

        List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoE);
        List<Map<String, Object>> userInfoList2 = new ArrayList<Map<String, Object>>();

        for (UserInfo m : userInfoList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", m.getId());
            map.put("name", m.getName());
            userInfoList2.add(map);
        }

        modelMap.addAttribute("userInfoList", userInfoList2);

        TzInfoExample tzInfoE = new TzInfoExample();
        TzInfoExample.Criteria tzInfoC = tzInfoE.createCriteria();
        List<TzInfo> tzInfoList = tzInfoMapper.selectByExample(tzInfoE);
        List<Map<String, Object>> tzInfoList2 = new ArrayList<Map<String, Object>>();

        for (TzInfo m : tzInfoList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", m.getId());
            map.put("name", m.getName());
            tzInfoList2.add(map);
        }

        modelMap.addAttribute("tzInfoList", tzInfoList2);
    }

    /**
     * 返回团购订单列表jsp页面
    */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //获取当前登录账号信息
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", userInfo);
        getList(modelMap, login); //获取数据列表并返回给前台

        return "user/tg_order_info/list";
    }

    /**
     * 根据查询条件分页查询团购订单数据,然后返回给前台渲染
    */
    @RequestMapping(value = "queryList")
    @ResponseBody
    public Object toList(TgOrderInfo model, Integer page,
        String createTimeOrder, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        model.setUserId(login.getId()); //购买用户等于当前登录id

        return tgOrderInfoService.getDataList(createTimeOrder, model, page,
            CommonVal.pageSize, login); //分页查询数据
    }

    /**
     * 确认收货,操作
    */
    @RequestMapping(value = "updateByDefault")
    @ResponseBody
    public Object updateByDefault(Integer id, ModelMap modelMap,
        HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> rs = new HashMap<String, Object>();
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        TgOrderInfo model = tgOrderInfoMapper.selectByPrimaryKey(id);
        model.setTgOrderStatus(4);
        tgOrderInfoMapper.updateByPrimaryKey(model);
        rs.put("code", 1);
        rs.put("msg",
            "操作成功");

        return rs;
    }
}

