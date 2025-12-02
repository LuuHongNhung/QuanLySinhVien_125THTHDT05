package com.quanly.model;

import java.util.List;

public class SinhVien extends Nguoi {
    private double diemTK;
    private List<MonHoc> monHocDangKy;

    public SinhVien(String maID, String hoTen, String ngaySinh, String diaChi, List<Nguoi> danhSachMonHoc, Nguoi monitor, double diemTK, List<MonHoc> monHocDangKy) {
        super(maID, hoTen, ngaySinh, diaChi, danhSachMonHoc, monitor);
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

    public void themSinhVien() {
        // Code thêm sinh viên
    }

    public void themMonHocVaoList() {
        // Code thêm môn học vào danh sách đăng ký
    }
}