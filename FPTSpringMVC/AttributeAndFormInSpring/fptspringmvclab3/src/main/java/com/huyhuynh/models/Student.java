package com.huyhuynh.models;

/**
 * @project: fptspringmvclab3
 * @author: HuyHuynh on 11/05/2020
 */
public class Student {
    private String user;
    private String pass;
    private String name;
    private int age;
    private String major;
    private String level;

    public Student() {
    }

    public Student(String user, String pass, String name, int age, String major, String level) {
        this.user = user;
        this.pass = pass;
        this.name = name;
        this.age = age;
        this.major = major;
        this.level = level;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
