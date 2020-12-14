package com.huyhuynh.recycleviewandretrofit;

public class MultiUser {
    private String name;
    private int resoureImg;
    private boolean isFeature;

    public MultiUser(String name, int resoureImg, boolean isFeature) {
        this.name = name;
        this.resoureImg = resoureImg;
        this.isFeature = isFeature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResoureImg() {
        return resoureImg;
    }

    public void setResoureImg(int resoureImg) {
        this.resoureImg = resoureImg;
    }

    public boolean isFeature() {
        return isFeature;
    }

    public void setFeature(boolean feature) {
        isFeature = feature;
    }
}
