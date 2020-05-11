package com.huyhuynh.models;

/**
 * @project: fptspringmvclab3
 * @author: HuyHuynh on 11/05/2020
 */
public class Level {
    private String id;
    private String name;

    public Level() {
    }

    public Level(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
