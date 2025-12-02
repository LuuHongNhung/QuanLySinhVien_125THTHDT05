package com.quanly.model;

import java.util.List;

public class Nguoi {
    protected String maID;
    protected String hoTen;
    protected String ngaySinh;
    protected String diaChi;
    protected List<Nguoi> danhSachMonHoc;
    protected Nguoi monitor;

    public Nguoi(String maID, String hoTen, String ngaySinh, String diaChi, List<Nguoi> danhSachMonHoc, Nguoi monitor) {
        this.maID = maID;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.danhSachMonHoc = danhSachMonHoc;
        this.monitor = monitor;
    }

    public String getMaID() {
        return maID;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public List<Nguoi> getDanhSachMonHoc() {
        return danhSachMonHoc;
    }

    public Nguoi getMonitor() {
        return monitor;
    }

    public void setMaID(String maID) {
        this.maID = maID;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setDanhSachMonHoc(List<Nguoi> danhSachMonHoc) {
        this.danhSachMonHoc = danhSachMonHoc;
    }

    public void setMonitor(Nguoi monitor) {
        this.monitor = monitor;
    }

    public void dangNhap() {}
    public void doiMatKhau() {}
    public void dangKy() {}
    public void themNguoi() {}
}