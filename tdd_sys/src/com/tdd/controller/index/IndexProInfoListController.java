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
public class IndexProInfoListController {
    @Autowired
    ProTypeInfoMapper proTypeInfoMapper;
    @Autowired
    ProInfoMapper proInfoMapper;

    /**
            进入搜索列表接口
    **/
    @RequestMapping(value = "query_list")
    public String index(ModelMap modelMap, Integer type,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        modelMap.addAttribute("login", login);
        modelMap.addAttribute("type", type);

        ProTypeInfoExample proTypeInfoE = new ProTypeInfoExample();
        List<ProTypeInfo> proTypeInfoList = proTypeInfoMapper.selectByExample(proTypeInfoE);
        List<Map<String, String>> proTypeInfoList2 = new ArrayList<Map<String, String>>();

        for (ProTypeInfo proTypeInfo : proTypeInfoList) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("id", proTypeInfo.getId() + "");
            map.put("name", proTypeInfo.getName());
            proTypeInfoList2.add(map);
        }

        modelMap.addAttribute("pl", proTypeInfoList2);

        return "index/pro_info_list";
    }

    @RequestMapping(value = "search")
    @ResponseBody
    public Object searchPro(String searchWord, Integer type, Integer page,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        int pageSize = 9;

        if (page == null) {
            page = 1;
        }

        ProInfoExample proInfoE = new ProInfoExample();
        ProInfoExample.Criteria proInfoC = proInfoE.createCriteria();

        if ((searchWord != null) && (searchWord.trim().equals("") == false)) {
            proInfoC.andTitleLike("%" + searchWord + "%");//and title like '%xxx%'
        }

        if (type != null) {
            proInfoC.andProTypeIdEqualTo(type);//and pro_type_id=#{type}
        }

        int count = (int) proInfoMapper.countByExample(proInfoE);
        int totalPage = 0;

        if ((count > 0) && ((count % pageSize) == 0)) {
            totalPage = count / pageSize;
        } else {
            totalPage = (count / pageSize) + 1;
        }

        proInfoE.setPageRows(pageSize);
        proInfoE.setStartRow((page - 1) * pageSize);

        List<ProInfo> proList = proInfoMapper.selectByExample(proInfoE);
        List<Map<String, Object>> proList3 = new ArrayList<Map<String, Object>>();

        for (ProInfo pro : proList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", pro.getId());
            map.put("title", pro.getTitle());
            map.put("img", pro.getProImg());
            map.put("price", pro.getProPrice());
            map.put("saleNum", pro.getSaleNum());

            ProTypeInfo typeT = proTypeInfoMapper.selectByPrimaryKey(pro.getProTypeId());

            if (typeT != null) {
                map.put("type", typeT.getName());
            }

            proList3.add(map);
        }

        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("data", proList3);
        rs.put("count", count);
        rs.put("totalPage", totalPage);
        rs.put("pageSize", pageSize);

        return rs;
    }
}

