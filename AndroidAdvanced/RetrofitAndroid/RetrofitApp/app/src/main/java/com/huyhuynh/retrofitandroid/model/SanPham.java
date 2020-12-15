package com.huyhuynh.retrofitandroid.model;

public class SanPham {
    private int idsp;
    private String tensp;
    private String giasp;
    private String thuonghieu;
    private String tinhtrang;
    private String nguongoc;
    private String khoiluong;
    private String chitiet;
    private String hinhanh;


    public SanPham(int idsp, String tensp, String giasp, String thuonghieu, String tinhtrang, String nguongoc, String khoiluong, String chitiet, String hinhanh) {
        this.idsp = idsp;
        this.tensp = tensp;
        this.giasp = giasp;
        this.thuonghieu = thuonghieu;
        this.tinhtrang = tinhtrang;
        this.nguongoc = nguongoc;
        this.khoiluong = khoiluong;
        this.chitiet = chitiet;
        this.hinhanh = hinhanh;
    }

    public SanPham(String tensp, String giasp, String hinhanh) {
        this.tensp = tensp;
        this.giasp = giasp;
        this.hinhanh = hinhanh;
    }

    public int getIdsp() {
        return idsp;
    }

    public void setIdsp(int idsp) {
        this.idsp = idsp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getGiasp() {
        return giasp;
    }

    public void setGiasp(String giasp) {
        this.giasp = giasp;
    }

    public String getThuonghieu() {
        return thuonghieu;
    }

    public void setThuonghieu(String thuonghieu) {
        this.thuonghieu = thuonghieu;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String getNguongoc() {
        return nguongoc;
    }

    public void setNguongoc(String nguongoc) {
        this.nguongoc = nguongoc;
    }

    public String getKhoiluong() {
        return khoiluong;
    }

    public void setKhoiluong(String khoiluong) {
        this.khoiluong = khoiluong;
    }

    public String getChitiet() {
        return chitiet;
    }

    public void setChitiet(String chitiet) {
        this.chitiet = chitiet;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }
}
