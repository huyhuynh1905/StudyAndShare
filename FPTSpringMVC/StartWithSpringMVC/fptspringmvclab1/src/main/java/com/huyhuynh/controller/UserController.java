package com.huyhuynh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @project: fptspringmvclab1
 * @author: HuyHuynh on 07/05/2020
 */

@Controller
public class UserController {

    @RequestMapping("/")
    public String showForm(){
        return "/userform";
    }

    @RequestMapping("/user-login")
    public String showLogin(HttpServletRequest req, ModelMap modelMap){
        String user = req.getParameter("user");
        String pass = req.getParameter("pass");
        if (user.equals("huy")&&pass.equals("123")){
            req.setAttribute("user",user);
            req.setAttribute("pass",pass);
            return "/loginsuccess";
        } else {
            modelMap.addAttribute("message","Đăng nhập thất bại! Nhập lại");
            return "/loginfailed";
        }
    }

}
