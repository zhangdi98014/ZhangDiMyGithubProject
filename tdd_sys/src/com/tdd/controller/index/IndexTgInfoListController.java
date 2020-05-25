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
@RequestMapping("/commonapi/index/tg")
public class IndexTgInfoListController {
    @Autowired
    TgInfoMapper tgInfoMapper;

    /**
            进入搜索列表接口
    **/
    @RequestMapping(value = "query_list")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        modelMap.addAttribute("login", login);

        return "index/tg_info_list";
    }

    @RequestMapping(value = "search")
    @ResponseBody
    public Object searchPro(String searchWord, Integer page,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        int pageSize = 9;

        if (page == null) {
            page = 1;
        }

        TgInfoExample tgInfoE = new TgInfoExample();
        TgInfoExample.Criteria tgInfoC = tgInfoE.createCriteria();
        tgInfoC.andTgStatusNotEqualTo(1);
        tgInfoC.andTgStatusNotEqualTo(2);
        tgInfoC.andTgStatusNotEqualTo(3);
        tgInfoC.andTgStatusNotEqualTo(6);

        if ((searchWord != null) && (searchWord.trim().equals("") == false)) {
            tgInfoC.andTgTitleLike("%" + searchWord + "%");
        }

        int count = (int) tgInfoMapper.countByExample(tgInfoE);
        int totalPage = 0;

        if ((count > 0) && ((count % pageSize) == 0)) {
            totalPage = count / pageSize;
        } else {
            totalPage = (count / pageSize) + 1;
        }

        tgInfoE.setPageRows(pageSize);
        tgInfoE.setStartRow((page - 1) * pageSize);

        List<TgInfo> proList = tgInfoMapper.selectByExample(tgInfoE);
        List<Map<String, Object>> proList3 = new ArrayList<Map<String, Object>>();

        for (TgInfo pro : proList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", pro.getId());
            map.put("title", pro.getTgTitle());
            map.put("img", pro.getTgImg());
            map.put("price", pro.getProPrice());
            map.put("tgNum", pro.getTgNum());
            map.put("pStatus", pro.getTgStatus());
            map.put("tgStartTime", pro.getTgStartTime());
            map.put("tgEndTime", pro.getTgEndTime());
            map.put("tgStatus",DataListUtils.getTgStatusNameById(pro.getTgStatus()+""));
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

