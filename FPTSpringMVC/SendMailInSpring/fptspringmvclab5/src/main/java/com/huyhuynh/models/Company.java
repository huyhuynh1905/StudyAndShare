package com.huyhuynh.models;

/**
 * @project: fptspringmvclab5
 * @author: HuyHuynh on 15/05/2020
 */
public class Company {
    private String name;
    private String slogan;
    private String logo;

    public Company() {
    }

    public Company(String name, String slogan, String logo) {
        this.name = name;
        this.slogan = slogan;
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
