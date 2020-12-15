package com.huyhuynh.retrofitandroid.model;

import android.text.TextUtils;
import android.util.Patterns;

public class TaiKhoan {

    private int idtk;
    private String tentk;
    private String email;
    private String phone;
    private String pass;
    private int phanquyen;
    private String jwt;

    public TaiKhoan(int idtk, String tentk, String email, String phone, int phanquyen, String jwt) {
        this.idtk = idtk;
        this.tentk = tentk;
        this.email = email;
        this.phone = phone;
        this.phanquyen = phanquyen;
        this.jwt = jwt;
    }

    public TaiKhoan(int idtk, String tentk, String email, String phone, String pass, int phanquyen, String jwt) {
        this.idtk = idtk;
        this.tentk = tentk;
        this.email = email;
        this.phone = phone;
        this.pass = pass;
        this.phanquyen = phanquyen;
        this.jwt = jwt;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getIdtk() {
        return idtk;
    }

    public void setIdtk(int idtk) {
        this.idtk = idtk;
    }

    public String getTentk() {
        return tentk;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPhanquyen() {
        return phanquyen;
    }

    public void setPhanquyen(int phanquyen) {
        this.phanquyen = phanquyen;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
