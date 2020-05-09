package com.huyhuynh.model;

import java.io.Serializable;

/**
 * @project: fprspringmvclab2
 * @author: HuyHuynh on 09/05/2020
 */

public class User implements Serializable {
    private String id;
    private String pass;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
