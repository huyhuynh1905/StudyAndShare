package com.huyhuynh.models;

/**
 * @project: fptspringmvclab4
 * @author: HuyHuynh on 13/05/2020
 */
public class Student {
    private String name;
    private int point;

    public Student() {
    }

    public Student(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
