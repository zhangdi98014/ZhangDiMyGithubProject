package com.tdd.controller.admin;

import com.tdd.controller.LoginModel;

import com.tdd.dao.*;

import com.tdd.model.*;

import com.tdd.service.*;

import com.tdd.util.CommonVal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin/index")
public class ADIndexController {
    @Autowired
    AdminInfoMapper adminInfoMapper;

    /**
      管理员角色进入管理首页接口
    */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        AdminInfo user = adminInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", user);

        modelMap.addAttribute("roleName",
            "管理员");
        modelMap.addAttribute("login", login);

        return "admin/index";
    }
}

