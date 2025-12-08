package com.quanly.model;

import java.util.List;

public class GiangVien extends Nguoi {
    private String tenKhoa;
    private String hocVi;
    private List<MonHoc> monHocPhuTrach;    

    public GiangVien(String maID, String hoTen, String ngaySinh, String diaChi, 
                    Nguoi monitor, String tenKhoa, String hocVi, List<MonHoc> monHocPhuTrach) {
        super(maID, hoTen, ngaySinh, diaChi, monitor);
        this.tenKhoa = tenKhoa;
        this.hocVi = hocVi;
        this.monHocPhuTrach = monHocPhuTrach;
    }

    public String getTenKhoa() { return tenKhoa; }
    public void setTenKhoa(String tenKhoa) { this.tenKhoa = tenKhoa; }

    public String getHocVi() { return hocVi; }
    public void setHocVi(String hocVi) { this.hocVi = hocVi; }

    public List<MonHoc> getMonHocPhuTrach() { return monHocPhuTrach; }
    public void setMonHocPhuTrach(List<MonHoc> monHocPhuTrach) { this.monHocPhuTrach = monHocPhuTrach; }
}