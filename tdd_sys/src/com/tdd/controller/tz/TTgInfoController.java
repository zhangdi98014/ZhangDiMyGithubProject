package com.tdd.controller.tz;

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
@RequestMapping("/tz/tg_info")
public class TTgInfoController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    TgInfoService tgInfoService;
    @Autowired
    TzInfoMapper tzInfoMapper;
    @Autowired
    ProInfoMapper proInfoMapper;
    @Autowired
    TgInfoMapper tgInfoMapper;
    @Autowired
    TgOrderInfoService tgOrderInfoService;

    public void getList(ModelMap modelMap, LoginModel login) { //获取数据列表并返回给前台

        ProInfoExample proInfoE = new ProInfoExample();
        ProInfoExample.Criteria proInfoC = proInfoE.createCriteria();
        List<ProInfo> proInfoList = proInfoMapper.selectByExample(proInfoE);
        List<Map<String, Object>> proInfoList2 = new ArrayList<Map<String, Object>>();

        for (ProInfo m : proInfoList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", m.getId());
            map.put("name", m.getTitle());
            proInfoList2.add(map);
        }

        modelMap.addAttribute("proInfoList", proInfoList2);
        modelMap.addAttribute("tgStatusList", DataListUtils.getTgStatusList()); //返回tg_status数据列表
    }

    /**
     * 返回团购活动列表jsp页面
    */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //获取当前登录账号信息
        TzInfo tzInfo = tzInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", tzInfo);
        getList(modelMap, login); //获取数据列表并返回给前台

        return "tz/tg_info/list";
    }

    /**
     * 根据查询条件分页查询团购活动数据,然后返回给前台渲染
    */
    @RequestMapping(value = "queryList")
    @ResponseBody
    public Object toList(TgInfo model, Integer page, String createTimeOrder,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        model.setTzId(login.getId()); //团长等于当前登录id

        return tgInfoService.getDataList(createTimeOrder, model, page,
            CommonVal.pageSize, login); //分页查询数据
    }

    /**
     进入发起团购页面
    */
    @RequestMapping("add")
    public String add(ModelMap modelMap, TgInfo model,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //从session中获取当前登录账号	
        getList(modelMap, login); //获取前台需要用到的数据列表并返回给前台
        modelMap.addAttribute("data", model);

        return "tz/tg_info/add_page";
    }

    /**
     发起团购提交信息接口
    */
    @RequestMapping("add_submit")
    @ResponseBody
    public Object add_submit(TgInfo model, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = tgInfoService.add(model, login); //执行添加操作

        if (msg.equals("")) {
            rs.put("code", 1);
            rs.put("msg",
                "添加成功");

            return rs;
        }

        rs.put("code", 0);
        rs.put("msg", msg);

        return rs;
    }

    /**
     进入修改页面
    */
    @RequestMapping("update")
    public String update(ModelMap modelMap, TgInfo model,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //从session中获取当前登录账号	
        getList(modelMap, login); //获取前台需要用到的数据列表并返回给前台

        TgInfo data = tgInfoMapper.selectByPrimaryKey(model.getId());
        modelMap.addAttribute("data", data);

        return "tz/tg_info/update_page";
    }

    /**
     修改提交信息接口
    */
    @RequestMapping("update_submit")
    @ResponseBody
    public Object update_submit(TgInfo model, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = tgInfoService.update(model, login); //执行修改操作

        if (msg.equals("")) {
            rs.put("code", 1);
            rs.put("msg",
                "修改成功");

            return rs;
        }

        rs.put("code", 0);
        rs.put("msg", msg);

        return rs;
    }

    /**
     删除数据接口
    */
    @RequestMapping("del")
    @ResponseBody
    public Object del(Integer id, ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        tgInfoService.delete(id);
        rs.put("code", 1);
        rs.put("msg",
            "删除成功");

        return rs;
    }

    /**
     * 结束活动,操作
    */
    @RequestMapping(value = "updateByDefault")
    @ResponseBody
    public Object updateByDefault(Integer id, ModelMap modelMap,
        HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> rs = new HashMap<String, Object>();
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        TgInfo model = tgInfoMapper.selectByPrimaryKey(id);
        model.setTgStatus(6);
        tgInfoMapper.updateByPrimaryKey(model);
        tgOrderInfoService.updateOrderStatusWithEndTg(id);
        rs.put("code", 1);
        rs.put("msg",
            "操作成功");

        return rs;
    }
}

