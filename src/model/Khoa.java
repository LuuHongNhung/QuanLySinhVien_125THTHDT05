package com.quanly.model;

import java.util.List;

public class Khoa {
    private String maKhoa;
    private String tenKhoa;
    private List<LopHoc> danhSachLopHoc;

    public Khoa(String maKhoa, String tenKhoa, List<LopHoc> danhSachLopHoc) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.danhSachLopHoc = danhSachLopHoc;
    }

    public String getMaKhoa() { return maKhoa; }
    public void setMaKhoa(String maKhoa) { this.maKhoa = maKhoa; }

    public String getTenKhoa() { return tenKhoa; }
    public void setTenKhoa(String tenKhoa) { this.tenKhoa = tenKhoa; }

    public List<LopHoc> getDanhSachLopHoc() { return danhSachLopHoc; }
    public void setDanhSachLopHoc(List<LopHoc> danhSachLopHoc) { this.danhSachLopHoc = danhSachLopHoc; }

    public void themLopHoc(LopHoc lh) {
        this.danhSachLopHoc.add(lh);
    }
}