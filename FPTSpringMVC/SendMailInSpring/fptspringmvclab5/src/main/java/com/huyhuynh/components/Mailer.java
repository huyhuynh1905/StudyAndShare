package com.huyhuynh.components;

import org.springframework.stereotype.Component;

/**
 * @project: fptspringmvclab5
 * @author: HuyHuynh on 15/05/2020
 */
@Component("mailer") //Bean tự khai báo với id là mailer
public class Mailer {
    public void send(String from,String to,String subject,String body) {
        //Code send
    }
}
