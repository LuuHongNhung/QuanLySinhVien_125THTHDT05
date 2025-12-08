package com.quanly.model;

import java.util.List;

public class SinhVien extends Nguoi {
    private double diemTK;
    private List<MonHoc> monHocDangKy;

    public SinhVien(String maID, String hoTen, String ngaySinh, String diaChi, 
                   Nguoi monitor, double diemTK, List<MonHoc> monHocDangKy) {
        super(maID, hoTen, ngaySinh, diaChi, monitor);
        this.diemTK = diemTK;
        this.monHocDangKy = monHocDangKy;
    }

    public double getDiemTK() { return diemTK; }
    public void setDiemTK(double diemTK) { this.diemTK = diemTK; }

    public List<MonHoc> getMonHocDangKy() { return monHocDangKy; }
    public void setMonHocDangKy(List<MonHoc> monHocDangKy) { this.monHocDangKy = monHocDangKy; }
}