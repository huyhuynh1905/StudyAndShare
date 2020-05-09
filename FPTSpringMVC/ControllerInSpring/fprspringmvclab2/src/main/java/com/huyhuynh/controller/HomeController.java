package com.huyhuynh.controller;

import com.huyhuynh.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @project: fprspringmvclab2
 * @author: HuyHuynh on 09/05/2020
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    //Trang chủ:
    @RequestMapping("/home-page")
    public String showTrangChu(){
        return "/home";
    }

    @RequestMapping(value = "/home-form",params = "btnThem")
    public String themSinhVien(HttpServletRequest req){
        String id = req.getParameter("id");
        String pass = req.getParameter("pass");
        req.setAttribute("id",id);
        req.setAttribute("pass",pass);
        return "/them-sinhvien";
    }
    @RequestMapping(value = "home-form",params = "btnLogin")
    public String loginSinhVien(@RequestParam("id") String id,
                                @RequestParam(value = "pass",defaultValue = "111",required = false) String pass,
                                ModelMap modelMap){
        if (id.equals("huy")&&pass.equals("123")){
            modelMap.addAttribute("id",id);
            return "/login-thanhcong";
        } else {
            modelMap.addAttribute("mess","Đăng nhập thất bại");
            return "/home";
        }
    }

    @RequestMapping(value = "/login-from-them",method = RequestMethod.GET)
    public String goLogin(ModelMap modelMap, User user){
        modelMap.addAttribute("id",user.getId());
        modelMap.addAttribute("pass",user.getPass());
        return "/login-thanhcong";
    }

    @RequestMapping(value = "/login-from-them",params = "btnBackHome")
    public String backToHome(ModelMap modelMap, User user){
        modelMap.addAttribute("user",user);
        return "redirect:/home/home-page";
    }

}
