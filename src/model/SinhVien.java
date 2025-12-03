package com.quanly.model;

import java.util.List;

public class SinhVien extends Nguoi {
    private double diemTK;
    private List<MonHoc> monHocDangKy;

    public SinhVien(String maID, String hoTen, String ngaySinh, String diaChi, 
                   List<MonHoc> danhSachMonHoc, Nguoi monitor, double diemTK, List<MonHoc> monHocDangKy) {
        super(maID, hoTen, ngaySinh, diaChi, null, monitor);
        this.diemTK = diemTK;
        this.monHocDangKy = monHocDangKy;
    }

    public SinhVien(String maID, String hoTen, String ngaySinh, String diaChi, 
                   double diemTK, List<MonHoc> monHocDangKy) {
        super(maID, hoTen, ngaySinh, diaChi, null, null);
        this.diemTK = diemTK;
        this.monHocDangKy = monHocDangKy;
    }

    public double getDiemTK() {
        return diemTK;
    }

    public List<MonHoc> getMonHocDangKy() {
        return monHocDangKy;
    }

    public void setDiemTK(double diemTK) {
        this.diemTK = diemTK;
    }

    public void setMonHocDangKy(List<MonHoc> monHocDangKy) {
        this.monHocDangKy = monHocDangKy;
    }
}