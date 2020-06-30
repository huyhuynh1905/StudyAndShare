package com.huyhuynh.controller;

import com.huyhuynh.components.Mailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

/**
 * @project: fptspringmvclab5
 * @author: HuyHuynh on 15/05/2020
 */
@Controller
@RequestMapping("/mail")
public class MailController {
    @Autowired
    JavaMailSender mailer;
    
    @RequestMapping("/send")
    public String sendMail(ModelMap modelMap, @RequestParam("from") String from, @RequestParam("to") String to,
                           @RequestParam("subject") String subject, @RequestParam("body") String body){

        try {
            //tạo mail
            MimeMessage mail = mailer.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail);
            helper.setFrom(from,from);
            helper.setTo(to);
            helper.setReplyTo(from,from);
            helper.setSubject(subject);
            helper.setText(body,true);
            //gửi mail
            mailer.send(mail);
            modelMap.addAttribute("message","Gửi mail thành công!");
        } catch (MessagingException e) {
            e.printStackTrace();
            modelMap.addAttribute("message","Gửi mail không thành công!");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            modelMap.addAttribute("message","Gửi mail không thành công!");
        }
        return "/formmail";
    }


//    @RequestMapping("/send")
//    public String sendMail(ModelMap modelMap){
//        String from = "huy@gmail.com";
//        String to = "springmvc@gmail.com";
//        String subject = "Hello Mail";
//        String body = "Happy birthday!";
//        mailer.send(from,to,subject,body);
//        return "/demomail";
//    }
}
