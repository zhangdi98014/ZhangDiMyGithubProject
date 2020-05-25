package com.tdd.controller.admin;

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
@RequestMapping("/admin/pro_info")
public class AProInfoController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    ProInfoService proInfoService;
    @Autowired
    AdminInfoMapper adminInfoMapper;
    @Autowired
    ProInfoMapper proInfoMapper;
    @Autowired
    ProTypeInfoMapper proTypeInfoMapper;

    public void getList(ModelMap modelMap, LoginModel login) { //获取数据列表并返回给前台

        ProTypeInfoExample proTypeInfoE = new ProTypeInfoExample();
        ProTypeInfoExample.Criteria proTypeInfoC = proTypeInfoE.createCriteria();
        List<ProTypeInfo> proTypeInfoList = proTypeInfoMapper.selectByExample(proTypeInfoE);
        List<Map<String, Object>> proTypeInfoList2 = new ArrayList<Map<String, Object>>();

        for (ProTypeInfo m : proTypeInfoList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", m.getId());
            map.put("name", m.getName());
            proTypeInfoList2.add(map);
        }

        modelMap.addAttribute("proTypeInfoList", proTypeInfoList2);
    }

    @RequestMapping(value = "queryDataDetail")
    @ResponseBody
    public Object queryDataDetail(Integer id, HttpServletRequest request) {
        ProInfo proInfo = proInfoMapper.selectByPrimaryKey(id);

        return proInfo;
    }

    /**
     * 返回商品列表jsp页面
    */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //获取当前登录账号信息
        AdminInfo adminInfo = adminInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", adminInfo);
        getList(modelMap, login); //获取数据列表并返回给前台

        return "admin/pro_info/list";
    }

    /**
     * 根据查询条件分页查询商品数据,然后返回给前台渲染
    */
    @RequestMapping(value = "queryList")
    @ResponseBody
    public Object toList(ProInfo model, Integer page, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);

        return proInfoService.getDataList(model, page, CommonVal.pageSize, login); //分页查询数据
    }

    /**
     查看详情接口
    */
    @RequestMapping("detail1")
    public Object detail1(Integer id, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        ProInfo model = new ProInfo();
        model.setId(id);

        Map<String, Object> rs = proInfoService.getDataList(model, null, null,
                login);
        List<Map<String, Object>> tmplist = (List<Map<String, Object>>) rs.get(
                "list");

        if ((tmplist != null) && (tmplist.size() > 0)) {
            modelMap.addAttribute("detail", tmplist.get(0));
        } else {
            modelMap.addAttribute("detail", new HashMap<String, Object>());
        }

        return "admin/pro_info/detail";
    }

    /**
     进入新增页面
    */
    @RequestMapping("add")
    public String add(ModelMap modelMap, ProInfo model,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //从session中获取当前登录账号	
        getList(modelMap, login); //获取前台需要用到的数据列表并返回给前台
        modelMap.addAttribute("data", model);

        return "admin/pro_info/add_page";
    }

    /**
     新增提交信息接口
    */
    @RequestMapping("add_submit")
    @ResponseBody
    public Object add_submit(ProInfo model, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = proInfoService.add(model, login); //执行添加操作

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
    public String update(ModelMap modelMap, ProInfo model,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //从session中获取当前登录账号	
        getList(modelMap, login); //获取前台需要用到的数据列表并返回给前台

        ProInfo data = proInfoMapper.selectByPrimaryKey(model.getId());

        if (data.getProDetail() != null) {
            data.setProDetail(data.getProDetail().replaceAll("'", "\\\\'")); //wangeditor需要过滤掉'符号,否则初始化可能报错
        }

        modelMap.addAttribute("data", data);

        return "admin/pro_info/update_page";
    }

    /**
     修改提交信息接口
    */
    @RequestMapping("update_submit")
    @ResponseBody
    public Object update_submit(ProInfo model, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = proInfoService.update(model, login); //执行修改操作

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
        proInfoService.delete(id);
        rs.put("code", 1);
        rs.put("msg",
            "删除成功");

        return rs;
    }
}

