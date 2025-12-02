package com.quanly.manager;

import com.quanly.model.*;
import java.util.ArrayList;
import java.util.List;

public class QuanLy implements IQuanLy {
    private List<SinhVien> danhSachSinhVien;
    private List<GiangVien> danhSachGiangVien;
    private List<Khoa> danhSachKhoa;
    private List<LopHoc> danhSachLopHoc;
    private List<MonHoc> danhSachMonHoc;

    public QuanLy() {
        this.danhSachSinhVien = new ArrayList<>();
        this.danhSachGiangVien = new ArrayList<>();
        this.danhSachKhoa = new ArrayList<>();
        this.danhSachLopHoc = new ArrayList<>();
        this.danhSachMonHoc = new ArrayList<>();
    }

    @Override
    public void themSinhVien(SinhVien sv) {
        if (timSinhVienTheoMa(sv.getMaID()) == null) {
            danhSachSinhVien.add(sv);
            System.out.println("Da them sinh vien " + sv.getHoTen());
        } else {
            System.out.println("Loi: Ma sinh vien da ton tai.");
        }
    }

    @Override
    public SinhVien timSinhVienTheoMa(String maID) {
        for (SinhVien sv : danhSachSinhVien) {
            if (sv.getMaID().equals(maID)) {
                return sv;
            }
        }
        return null;
    }

    @Override
    public boolean suaSinhVien(String maID, SinhVien svMoi) {
        for (int i = 0; i < danhSachSinhVien.size(); i++) {
            if (danhSachSinhVien.get(i).getMaID().equals(maID)) {
                danhSachSinhVien.set(i, svMoi);
                System.out.println("Cap nhat sinh vien thanh cong.");
                return true;
            }
        }
        System.out.println("Loi: Khong tim thay ma sinh vien de sua.");
        return false;
    }

    @Override
    public boolean xoaSinhVien(String maID) {
        SinhVien sv = timSinhVienTheoMa(maID);
        if (sv != null) {
            danhSachSinhVien.remove(sv);
            System.out.println("Da xoa sinh vien có ma ID: " + maID);
            return true;
        }
        System.out.println("Loi: Khong tim thay ma sinh vien de xoa.");
        return false;
    }

    @Override
    public void themGiangVien(GiangVien gv) {
        if (timGiangVienTheoMa(gv.getMaID()) == null) {
             danhSachGiangVien.add(gv);
        }
    }

    @Override
    public GiangVien timGiangVienTheoMa(String maID) {
        return null;
    }
    
    @Override
    public boolean suaGiangVien(String maID, GiangVien gvMoi) {
        return false;
    }

    @Override
    public boolean xoaGiangVien(String maID) {
        return false;
    }
    
    @Override
    public void themKhoa(Khoa khoa) {}
    @Override
    public boolean suaKhoa(String maKhoa, Khoa khoaMoi) { return false; }
    @Override
    public boolean xoaKhoa(String maKhoa) { return false; }
    @Override
    public Khoa timKhoaTheoMa(String maKhoa) { return null; }

    @Override
    public void themLopHoc(LopHoc lh) {}
    @Override
    public boolean suaLopHoc(String maLH, LopHoc lhMoi) { return false; }
    @Override
    public boolean xoaLopHoc(String maLH) { return false; }
    @Override
    public LopHoc timLopHocTheoMa(String maLH) { return null; }

    @Override
    public void themMonHoc(MonHoc mh) {}
    @Override
    public boolean suaMonHoc(String maMH, MonHoc mhMoi) { return false; }
    @Override
    public boolean xoaMonHoc(String maMH) { return false; }
    @Override
    public MonHoc timMonHocTheoMa(String maMH) { return null; }

    @Override
    public List<SinhVien> getDanhSachSinhVien() {
        return danhSachSinhVien;
    }
    @Override
    public List<GiangVien> getDanhSachGiangVien() {
        return danhSachGiangVien;
    }
    @Override
    public List<Khoa> getDanhSachKhoa() {
        return danhSachKhoa;
    }
    @Override
    public List<LopHoc> getDanhSachLopHoc() {
        return danhSachLopHoc;
    }
    @Override
    public List<MonHoc> getDanhSachMonHoc() {
        return danhSachMonHoc;
    }
}