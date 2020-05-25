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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/commonapi/index")
public class IndexIndexController {
    @Autowired
    ProInfoMapper proInfoMapper;

    /**
            进入首页入口
    **/
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        modelMap.addAttribute("login", login);

        ProInfoExample pe = new ProInfoExample();
        ProInfoExample.Criteria pc = pe.createCriteria();
        pe.setOrderByClause("sale_num desc"); //按销量排序
        pe.setPageRows(12);
        pe.setStartRow(0);

        List<ProInfo> pl = proInfoMapper.selectByExample(pe);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        for (ProInfo pro : pl) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", pro.getId());
            map.put("title", pro.getTitle());
            map.put("img", pro.getProImg());
            map.put("price", pro.getProPrice());
            map.put("saleNum", pro.getSaleNum());
            list.add(map);
        }

        modelMap.addAttribute("pl", CommonUtils.splitList(list, 12, 4));

        ProInfoExample pe2 = new ProInfoExample();
        ProInfoExample.Criteria pc2 = pe2.createCriteria();
        pe2.setPageRows(40);
        pe2.setStartRow(0);
        pe2.setOrderByClause("id desc"); //按最新上架排序

        List<ProInfo> pl2 = proInfoMapper.selectByExample(pe2);
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (ProInfo pro : pl2) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", pro.getId());
            map.put("title", pro.getTitle());
            map.put("img", pro.getProImg());
            map.put("price", pro.getProPrice());
            map.put("saleNum", pro.getSaleNum());
            list2.add(map);
        }

        modelMap.addAttribute("pl2", list2);

        return "index/index";
    }
}

