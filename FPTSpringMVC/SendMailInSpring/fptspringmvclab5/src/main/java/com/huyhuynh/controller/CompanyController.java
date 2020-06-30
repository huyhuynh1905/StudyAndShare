package com.huyhuynh.controller;

import com.huyhuynh.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @project: fptspringmvclab5
 * @author: HuyHuynh on 15/05/2020
 */
@Controller
public class CompanyController {
    //Cách 1: Tiêm vào feild
    @Autowired
    Company companyKMA;
    //Cách 2: thông qua Constructor
    Company companyFPT;
    @Autowired
    public CompanyController(Company companyFPT) {
        this.companyFPT=companyFPT;
    }
    //Cách 3: Tiêm vào setter
    Company companyLab;
    @Autowired
    public void setCompanyLab(Company companyLab){
        this.companyLab = companyLab;
    }
    //Khi có nhiều bean trùng Class. thêm @Qualifier("<id-bean>")
    @Autowired @Qualifier("companyFPT")
    Company companyFPT2;

    @RequestMapping("/")
    public String showDemoBean(ModelMap modelMap){
        modelMap.addAttribute("companyKMA",companyKMA);
        modelMap.addAttribute("companyFPT",companyFPT2);
        return "/demobean";
    }

    @RequestMapping("/uploadpage")
    public String loadUploadPage(){
        return "/demoupload";
    }

    @RequestMapping("/formmail")
    public String goSendMailForm(){
        return "/formmail";
    }
}
