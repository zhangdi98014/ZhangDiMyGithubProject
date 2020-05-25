package com.tdd.controller;

import com.tdd.controller.LoginModel;

import com.tdd.dao.*;

import com.tdd.model.*;

import com.tdd.util.*;
import com.tdd.util.CommonVal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/commonapi")
public class RegistController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    UserInfoMapper userInfoMapper;

    /**
      用户进入注册页面接口
    */
    @RequestMapping(value = "user_info_regist")
    public String user_info_regist(ModelMap modelMap, String msg) {
        modelMap.addAttribute("msg", msg);

        return "user_info_regist";
    }

    /**
      提交用户注册信息接口
    */
    @RequestMapping("userInfoRegistSubmit")
    @ResponseBody
    public Object userInfoRegistSubmit(String imgCode, String name,
        String password, ModelMap modelMap, HttpServletRequest request,
        HttpServletResponse response) {
        Map<String, Object> rs = new HashMap<String, Object>();
        HttpSession session = request.getSession();

        if ((imgCode != null) &&
                !imgCode.toLowerCase()
                            .equals(request.getSession()
                                               .getAttribute(CommonVal.code)
                                               .toString().toLowerCase())) {
            rs.put("code", 0);
            rs.put("msg",
                "图片验证码错误");

            return rs;
        }

        if (name != null) {
            UserInfoExample te = new UserInfoExample();
            UserInfoExample.Criteria tc = te.createCriteria();
            tc.andNameEqualTo(name);

            int count = (int) userInfoMapper.countByExample(te);

            if (count > 0) {
                rs.put("code", 0);
                rs.put("msg",
                    "该账号已被注册,请用该账号登录");

                return rs;
            }
        }

        UserInfo model = new UserInfo();
        model.setName(name);
        model.setPassWord(password);
        model.setCreateTime(sdf1.format(new Date())); //当前时间格式
        userInfoMapper.insertSelective(model); //注册成功,插入该账号进数据库,并返回提示
        rs.put("code", 1);
        rs.put("msg",
            "注册成功,请使用该账号密码登录");

        return rs;
    }
}

