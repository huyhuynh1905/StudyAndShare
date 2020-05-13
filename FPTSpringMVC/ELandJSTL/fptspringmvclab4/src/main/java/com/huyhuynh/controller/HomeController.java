package com.huyhuynh.controller;

import com.huyhuynh.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project: fptspringmvclab4
 * @author: HuyHuynh on 13/05/2020
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String showHomePage(){
        return "homepage";
    }

    @RequestMapping("/demo1")
    public String showDemo1(ModelMap modelMap, HttpSession session){
        modelMap.addAttribute("name", "Huy");
        session.setAttribute("age",21);
        return "demo1";
    }

    @RequestMapping("/demo2")
    public String showDemo2(ModelMap modelMap){
        //Một đối tượng
        Student st = new Student("Huy",10);
        modelMap.addAttribute("student",st);
        //Danh sách
        List<String> strArr = new ArrayList<String>();
        strArr.add("Item Số 1");
        strArr.add("Item số 2");
        modelMap.addAttribute("list",strArr);
        //Map
        Map<String,String> map = new HashMap<String, String>();
        map.put("name","Map Huy");
        map.put("point","10 điểm");
        modelMap.addAttribute("mapST",map);
        return "demo2";
    }

    @RequestMapping("/demo3")
    public String showDemo3(ModelMap modelMap){
        Student st = new Student("Huy",9);
        modelMap.addAttribute("student",st);
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("Hao",8));
        studentList.add(new Student("Mai",6));
        studentList.add(new Student("Hương",4));
        modelMap.addAttribute("students",studentList);
        return "demo3";
    }

    @RequestMapping("/demo4")
    public String showDemo4(){
        return "demo4";
    }

    @RequestMapping("/demo5")
    public String showDemo5(ModelMap modelMap){
        String str = "Xin Chào Các Bạn";
        modelMap.addAttribute("mess",str);
        return "demo5";
    }
}
