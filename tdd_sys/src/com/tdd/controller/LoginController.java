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
public class LoginController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    TzInfoMapper tzInfoMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    AdminInfoMapper adminInfoMapper;
    
    /**
      后台进入登录页面接口
    */
    @RequestMapping(value = "at_login")
    public String at_login(ModelMap modelMap, String msg) {
        modelMap.addAttribute("msg", msg);
        return "at_login";
    }
    
    /**
      后台退出接口
    */
    @RequestMapping(value = "at_logout")
    public String at_logout(ModelMap modelMap, String msg,
        HttpServletRequest request) {
        request.getSession().removeAttribute(CommonVal.sessionName);
        return "redirect:/commonapi/at_login";
    }

    /**
      后台提交登录验证信息接口
    */
    @RequestMapping("atSubmit")
    @ResponseBody
    public Object atSubmit(LoginModel user, String imgCode, ModelMap modelMap,
        HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Map<String, Object> rs = new HashMap<String, Object>();

        //图片验证码验证,从session中查询验证码并校验
        if ((imgCode == null) || imgCode.trim().equals("")) {
            rs.put("code", 0);
            rs.put("msg","请输入图片验证码");
            return rs;
        }

        if (!imgCode.toLowerCase()
                        .equals(request.getSession().getAttribute(CommonVal.code)
                                           .toString().toLowerCase())) {
            rs.put("code", 0);
            rs.put("msg","图片验证码错误");
            return rs;
        }

        if (user.getLoginType() == null) {
            rs.put("code", 0);
            rs.put("msg","请选择登录角色");
            return rs;
        }

        if ((user.getName() == null) || user.getName().equals("")) {
            rs.put("code", 0);
            rs.put("msg","请输入登录名");
            return rs;
        }

        if ((user.getPassword() == null) || user.getPassword().equals("")) {
            rs.put("code", 0);
            rs.put("msg","请输入密码");
            return rs;
        }

        if (user.getLoginType() == 1) {
            AdminInfoExample te = new AdminInfoExample(); //验证管理员账号密码
            AdminInfoExample.Criteria tc = te.createCriteria();
            tc.andNameEqualTo(user.getName());
            tc.andPassWordEqualTo(user.getPassword());

            List<AdminInfo> tl = adminInfoMapper.selectByExample(te);

            if (tl.size() == 0) { //从数据库中查询不到账号
                rs.put("code", 0);
                rs.put("msg","登录名或密码错误");
                return rs;
            } else {
                LoginModel login = new LoginModel();
                login.setId(tl.get(0).getId());
                login.setLoginType(1);
                login.setName(user.getName());
                request.getSession().setAttribute(CommonVal.sessionName, login); //设置登录session,保持会话
                rs.put("code", 1);
                rs.put("msg","登录成功");
                return rs;
            }
        }

        if (user.getLoginType() == 2) {
            TzInfoExample te = new TzInfoExample(); //验证团长账号密码
            TzInfoExample.Criteria tc = te.createCriteria();
            tc.andNameEqualTo(user.getName());
            tc.andPassWordEqualTo(user.getPassword());

            List<TzInfo> tl = tzInfoMapper.selectByExample(te);

            if (tl.size() == 0) { //从数据库中查询不到账号
                rs.put("code", 0);
                rs.put("msg","登录名或密码错误");
                return rs;
            } else {
                LoginModel login = new LoginModel();
                login.setId(tl.get(0).getId());
                login.setLoginType(2);
                login.setName(user.getName());
                request.getSession().setAttribute(CommonVal.sessionName, login); //设置登录session,保持会话
                rs.put("code", 1);
                rs.put("msg","登录成功");
                return rs;
            }
        }

        rs.put("code", 0);
        rs.put("msg","系统出错");
        return rs;
    }

    /**
      用户进入登录页面接口
    */
    @RequestMapping(value = "user_login")
    public String user_login(ModelMap modelMap, String msg) {
        modelMap.addAttribute("msg", msg);

        return "user_login";
    }

    /**
      用户退出接口
    */
    @RequestMapping(value = "user_logout")
    public String user_logout(ModelMap modelMap, String msg,
        HttpServletRequest request) {
        request.getSession().removeAttribute(CommonVal.sessionName);

        return "redirect:/commonapi/user_login";
    }

    /**
      用户提交登录验证信息接口
    */
    @RequestMapping("userSubmit")
    @ResponseBody
    public Object userSubmit(LoginModel user, String imgCode,
        ModelMap modelMap, HttpServletRequest request,
        HttpServletResponse response) {
        HttpSession session = request.getSession();
        Map<String, Object> rs = new HashMap<String, Object>();

        //图片验证码验证,从session中查询验证码并校验
        if ((imgCode == null) || imgCode.trim().equals("")) {
            rs.put("code", 0);
            rs.put("msg",
                "请输入图片验证码");

            return rs;
        }

        if (!imgCode.toLowerCase()
                        .equals(request.getSession().getAttribute(CommonVal.code)
                                           .toString().toLowerCase())) {
            rs.put("code", 0);
            rs.put("msg",
                "图片验证码错误");

            return rs;
        }

        if (user.getLoginType() == null) {
            rs.put("code", 0);
            rs.put("msg",
                "请选择登录角色");

            return rs;
        }

        if ((user.getName() == null) || user.getName().equals("")) {
            rs.put("code", 0);
            rs.put("msg",
                "请输入登录名");

            return rs;
        }

        if ((user.getPassword() == null) || user.getPassword().equals("")) {
            rs.put("code", 0);
            rs.put("msg",
                "请输入密码");

            return rs;
        }

        if (user.getLoginType() == 3) {
            UserInfoExample te = new UserInfoExample(); //验证用户账号密码
            UserInfoExample.Criteria tc = te.createCriteria();
            tc.andNameEqualTo(user.getName());
            tc.andPassWordEqualTo(user.getPassword());

            List<UserInfo> tl = userInfoMapper.selectByExample(te);

            if (tl.size() == 0) { //从数据库中查询不到账号
                rs.put("code", 0);
                rs.put("msg",
                    "登录名或密码错误");

                return rs;
            } else {
                LoginModel login = new LoginModel();
                login.setId(tl.get(0).getId());
                login.setLoginType(3);
                login.setName(user.getName());
                request.getSession().setAttribute(CommonVal.sessionName, login); //设置登录session,保持会话
                rs.put("code", 1);
                rs.put("msg",
                    "登录成功");

                return rs;
            }
        }

        rs.put("code", 0);
        rs.put("msg",
            "系统出错");

        return rs;
    }
}

