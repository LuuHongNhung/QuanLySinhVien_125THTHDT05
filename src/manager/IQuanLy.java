package com.quanly.manager;

import com.quanly.model.*;
import java.util.List;

public interface IQuanLy {
    void themSinhVien(SinhVien sv);
    boolean suaSinhVien(String maID, SinhVien svMoi);
    boolean xoaSinhVien(String maID);
    SinhVien timSinhVienTheoMa(String maID);

    void themGiangVien(GiangVien gv);
    boolean suaGiangVien(String maID, GiangVien gvMoi);
    boolean xoaGiangVien(String maID);
    GiangVien timGiangVienTheoMa(String maID);

    void themKhoa(Khoa khoa);
    boolean suaKhoa(String maKhoa, Khoa khoaMoi);
    boolean xoaKhoa(String maKhoa);
    Khoa timKhoaTheoMa(String maKhoa);

    void themLopHoc(LopHoc lh);
    boolean suaLopHoc(String maLH, LopHoc lhMoi);
    boolean xoaLopHoc(String maLH);
    LopHoc timLopHocTheoMa(String maLH);

    void themMonHoc(MonHoc mh);
    boolean suaMonHoc(String maMH, MonHoc mhMoi);
    boolean xoaMonHoc(String maMH);
    MonHoc timMonHocTheoMa(String maMH);

    List<SinhVien> getDanhSachSinhVien();
    List<GiangVien> getDanhSachGiangVien();
    List<Khoa> getDanhSachKhoa();
    List<LopHoc> getDanhSachLopHoc();
    List<MonHoc> getDanhSachMonHoc();
}