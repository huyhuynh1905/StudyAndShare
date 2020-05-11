package com.huyhuynh.controller;

import com.huyhuynh.models.Level;
import com.huyhuynh.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * @project: fptspringmvclab3
 * @author: HuyHuynh on 10/05/2020
 */
@Controller
public class StudentController {
    @RequestMapping("/")
    public String homePage(){
        return "/homepage";
    }

    //Chuyển tới trang đăng nhập:
    @RequestMapping(value = "/login-page")
    public String showLogin(@ModelAttribute("student") Student student){
        return "/loginpage";
    }

    //Xử lí action login
    @RequestMapping("/login")
    public String checkLogin(@ModelAttribute("student")Student student, ModelMap modelMap){
        if (student.getUser().equals("huy")&&student.getPass().equals("123")) {
            student.setName("Huỳnh Bảo Huy");
            student.setAge(22);
            student.setMajor("CNTT");
            student.setLevel("3");
            return "/studentpage";
        } else {
            modelMap.addAttribute("mess","Đăng nhập thất bại");
            return "/loginpage";
        }
    }


    @ModelAttribute("majors")
    public String[] getMajors(){
        String[] majors = {"ATTT","KTMT","KTPM"};
        return majors;
    }

    @ModelAttribute("levels")
    public ArrayList<Level> getLevels(){
        ArrayList<Level> levels = new ArrayList<Level>();
        levels.add(new Level("1","Lớp Trưởng"));
        levels.add(new Level("2","Lớp Phó"));
        levels.add(new Level("3","Bí Thư"));
        return levels;
    }

    @RequestMapping("/update")
    public String updateStudent(@ModelAttribute("student") Student student){
        Student st = new Student();
        st.setName(student.getName());
        st.setAge(student.getAge());
        st.setMajor(student.getMajor());
        st.setLevel(student.getLevel());
        //modelMap.addAttribute("student",st);
        return "/studentpage";
    }

}
