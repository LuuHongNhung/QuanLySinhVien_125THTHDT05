package com.quanly.model;

import java.util.List;

public class Nguoi {
    protected String maID;
    protected String hoTen;
    protected String ngaySinh;
    protected String diaChi;
    protected Nguoi monitor;

    public Nguoi(String maID, String hoTen, String ngaySinh, String diaChi, Nguoi monitor) {
        this.maID = maID;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.monitor = monitor;
    }

    // Getter và Setter
    public String getMaID() { return maID; }
    public void setMaID(String maID) { this.maID = maID; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public String getNgaySinh() { return ngaySinh; }
    public void setNgaySinh(String ngaySinh) { this.ngaySinh = ngaySinh; }

    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    public Nguoi getMonitor() { return monitor; }
    public void setMonitor(Nguoi monitor) { this.monitor = monitor; }

    // Các phương thức chung
    public void dangNhap() { System.out.println(hoTen + " da dang nhap."); }
    public void doiMatKhau() { System.out.println(hoTen + " da doi mat khau."); }
}