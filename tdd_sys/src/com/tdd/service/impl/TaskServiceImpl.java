package com.tdd.service.impl;

import com.tdd.controller.LoginModel;

import com.tdd.dao.*;

import com.tdd.model.*;

import com.tdd.service.*;

import com.tdd.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.ui.ModelMap;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStream;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TgInfoMapper tgInfoMapper;
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    TgOrderInfoMapper tgOrderInfoMapper;
    @Autowired
    TgOrderInfoService tgOrderInfoService;
    @Override
    public void dataUpdate() {
        Map<String, Object> rs = new HashMap<String, Object>();
        TgInfoExample queryE = new TgInfoExample();
        TgInfoExample.Criteria queryC = queryE.createCriteria();
        queryC.andTgStatusNotEqualTo(1);
        queryC.andTgStatusNotEqualTo(3);
        queryC.andTgStatusNotEqualTo(6);
        List<TgInfo> list = tgInfoMapper.selectByExample(queryE); //查询所有团购
        String now = sdf1.format(new Date());
        for (TgInfo tg:list) {
        	if(tg.getTgStatus()==2&&tg.getTgStartTime().compareTo(now)<0){
        		tg.setTgStatus(4);//变为未开始
        	}
        	if(tg.getTgStatus()==4&&tg.getTgStartTime().compareTo(now)<0){
        		tg.setTgStatus(5);//开始中活动
        	}
        	if(tg.getTgStatus()==5&&tg.getTgEndTime().compareTo(now)<0){
        		tg.setTgStatus(6);//活动结束
        		//活动结束需要统计人数，判断是否成功组团
        		tgOrderInfoService.updateOrderStatusWithEndTg(tg.getId());
        	}
        	tgInfoMapper.updateByPrimaryKeySelective(tg);
        	
        }
    }
}

