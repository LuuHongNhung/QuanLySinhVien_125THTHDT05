package com.quanly.model;

import java.util.List;

public class LopHoc {
    private String maLH;
    private String tenLop;
    private SinhVien monitor;
    private GiangVien giangVien;
    private List<SinhVien> danhSachSinhVien;

    public LopHoc(String maLH, String tenLop, SinhVien monitor, GiangVien giangVien, List<SinhVien> danhSachSinhVien) {
        this.maLH = maLH;
        this.tenLop = tenLop;
        this.monitor = monitor;
        this.giangVien = giangVien;
        this.danhSachSinhVien = danhSachSinhVien;
    }

    public String getMaLH() {
        return maLH;
    }

    public String getTenLop() {
        return tenLop;
    }

    public SinhVien getMonitor() {
        return monitor;
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public List<SinhVien> getDanhSachSinhVien() {
        return danhSachSinhVien;
    }

    public void setMaLH(String maLH) {
        this.maLH = maLH;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public void setMonitor(SinhVien monitor) {
        this.monitor = monitor;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    public void setDanhSachSinhVien(List<SinhVien> danhSachSinhVien) {
        this.danhSachSinhVien = danhSachSinhVien;
    }

    public void themSinhVien(SinhVien sv) {
        this.danhSachSinhVien.add(sv);
    }
    
    public void xoaSinhVien(SinhVien sv) {
        this.danhSachSinhVien.remove(sv);
    }
    
    public void themLopHoc() {}
}