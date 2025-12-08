package com.quanly.model;

import java.util.List;

public class MonHoc {
    private String maMH;
    private String tenMonHoc;
    private int soTinChi;
    private List<GiangVien> danhSachGiangVien;

    public MonHoc(String maMH, String tenMonHoc, int soTinChi, List<GiangVien> danhSachGiangVien) {
        this.maMH = maMH;
        this.tenMonHoc = tenMonHoc;
        this.soTinChi = soTinChi;
        this.danhSachGiangVien = danhSachGiangVien;
    }

    public String getMaMH() { return maMH; }
    public void setMaMH(String maMH) { this.maMH = maMH; }

    public String getTenMonHoc() { return tenMonHoc; }
    public void setTenMonHoc(String tenMonHoc) { this.tenMonHoc = tenMonHoc; }

    public int getSoTinChi() { return soTinChi; }
    public void setSoTinChi(int soTinChi) { this.soTinChi = soTinChi; }

    public List<GiangVien> getDanhSachGiangVien() { return danhSachGiangVien; }
    public void setDanhSachGiangVien(List<GiangVien> danhSachGiangVien) { this.danhSachGiangVien = danhSachGiangVien; }

    public void themGiangVien(GiangVien gv) { this.danhSachGiangVien.add(gv); }
}