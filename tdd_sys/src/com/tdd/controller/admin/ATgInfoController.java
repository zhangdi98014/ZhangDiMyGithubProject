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
@RequestMapping("/admin/tg_info")
public class ATgInfoController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    TgInfoService tgInfoService;
    @Autowired
    TzInfoMapper tzInfoMapper;
    @Autowired
    AdminInfoMapper adminInfoMapper;
    @Autowired
    ProInfoMapper proInfoMapper;
    @Autowired
    TgInfoMapper tgInfoMapper;

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
     * 返回团购活动列表jsp页面
    */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //获取当前登录账号信息
        AdminInfo adminInfo = adminInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", adminInfo);
        getList(modelMap, login); //获取数据列表并返回给前台

        return "admin/tg_info/list";
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

        return tgInfoService.getDataList(createTimeOrder, model, page,
            CommonVal.pageSize, login); //分页查询数据
    }

    /**
     * 审核通过,审核不通过,操作
    */
    @RequestMapping(value = "updateByDefault")
    @ResponseBody
    public Object updateByDefault(Integer id, Integer type, ModelMap modelMap,
        HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> rs = new HashMap<String, Object>();
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        TgInfo model = tgInfoMapper.selectByPrimaryKey(id);
        ProInfo pro = proInfoMapper.selectByPrimaryKey(model.getProId());
       

        if (type == 1) { //type=1表示审核通过操作
        	 if(pro.getSctockNum()<model.getTgNum()){
            	 rs.put("code", 1);
                 rs.put("msg",
                     "该商品库存不足，不能参加该团购");
                 return rs;
            }
            model.setTgStatus(4);//未开始状态
            tgInfoMapper.updateByPrimaryKey(model);
            pro.setSctockNum(pro.getSctockNum()-model.getTgNum());
            proInfoMapper.updateByPrimaryKeySelective(pro);
        }

        if (type == 2) { //type=2表示审核不通过操作
            model.setTgStatus(3);
            tgInfoMapper.updateByPrimaryKey(model);
        }

        rs.put("code", 1);
        rs.put("msg",
            "操作成功");

        return rs;
    }
}

