package com.huyhuynh.controller;

import com.huyhuynh.components.Mailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @project: fptspringmvclab5
 * @author: HuyHuynh on 15/05/2020
 */
@Controller
@RequestMapping("/mail")
public class MailController {
    @Autowired
    Mailer mailer;

    @RequestMapping("/send")
    public String sendMail(ModelMap modelMap){
        String from = "huy@gmail.com";
        String to = "springmvc@gmail.com";
        String subject = "Hello Mail";
        String body = "Happy birthday!";
        mailer.send(from,to,subject,body);
        return "/demomail";
    }
}
