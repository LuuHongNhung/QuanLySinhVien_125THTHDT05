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
            System.out.println("Da xoa sinh vien co ma ID: " + maID);
            return true;
        }
        System.out.println("Loi: Khong tim thay ma sinh vien de xoa.");
        return false;
    }

    @Override
    public void themGiangVien(GiangVien gv) {
        if (timGiangVienTheoMa(gv.getMaID()) == null) {
            danhSachGiangVien.add(gv);
            System.out.println("Da them giang vien " + gv.getHoTen());
        } else {
            System.out.println("Loi: Ma giang vien da ton tai.");
        }
    }

    @Override
    public GiangVien timGiangVienTheoMa(String maID) {
        for (GiangVien gv : danhSachGiangVien) {
            if (gv.getMaID().equals(maID)) {
                return gv;
            }
        }
        return null;
    }
    
    @Override
    public boolean suaGiangVien(String maID, GiangVien gvMoi) {
        for (int i = 0; i < danhSachGiangVien.size(); i++) {
            if (danhSachGiangVien.get(i).getMaID().equals(maID)) {
                danhSachGiangVien.set(i, gvMoi);
                System.out.println("Cap nhat giang vien thanh cong.");
                return true;
            }
        }
        System.out.println("Loi: Khong tim thay ma giang vien de sua.");
        return false;
    }

    @Override
    public boolean xoaGiangVien(String maID) {
        GiangVien gv = timGiangVienTheoMa(maID);
        if (gv != null) {
            danhSachGiangVien.remove(gv);
            System.out.println("Da xoa giang vien co ma ID: " + maID);
            return true;
        }
        System.out.println("Loi: Khong tim thay ma giang vien de xoa.");
        return false;
    }
    
    @Override
    public void themKhoa(Khoa khoa) {
        if (timKhoaTheoMa(khoa.getMaKhoa()) == null) {
            danhSachKhoa.add(khoa);
            System.out.println("Da them khoa " + khoa.getTenKhoa());
        } else {
            System.out.println("Loi: Ma khoa da ton tai.");
        }
    }
    
    @Override
    public boolean suaKhoa(String maKhoa, Khoa khoaMoi) {
        for (int i = 0; i < danhSachKhoa.size(); i++) {
            if (danhSachKhoa.get(i).getMaKhoa().equals(maKhoa)) {
                danhSachKhoa.set(i, khoaMoi);
                System.out.println("Cap nhat khoa thanh cong.");
                return true;
            }
        }
        System.out.println("Loi: Khong tim thay ma khoa de sua.");
        return false;
    }
    
    @Override
    public boolean xoaKhoa(String maKhoa) {
        Khoa khoa = timKhoaTheoMa(maKhoa);
        if (khoa != null) {
            danhSachKhoa.remove(khoa);
            System.out.println("Da xoa khoa co ma: " + maKhoa);
            return true;
        }
        System.out.println("Loi: Khong tim thay ma khoa de xoa.");
        return false;
    }
    
    @Override
    public Khoa timKhoaTheoMa(String maKhoa) {
        for (Khoa khoa : danhSachKhoa) {
            if (khoa.getMaKhoa().equals(maKhoa)) {
                return khoa;
            }
        }
        return null;
    }

    @Override
    public void themLopHoc(LopHoc lh) {
        if (timLopHocTheoMa(lh.getMaLH()) == null) {
            danhSachLopHoc.add(lh);
            System.out.println("Da them lop hoc " + lh.getTenLop());
        } else {
            System.out.println("Loi: Ma lop hoc da ton tai.");
        }
    }
    
    @Override
    public boolean suaLopHoc(String maLH, LopHoc lhMoi) {
        for (int i = 0; i < danhSachLopHoc.size(); i++) {
            if (danhSachLopHoc.get(i).getMaLH().equals(maLH)) {
                danhSachLopHoc.set(i, lhMoi);
                System.out.println("Cap nhat lop hoc thanh cong.");
                return true;
            }
        }
        System.out.println("Loi: Khong tim thay ma lop hoc de sua.");
        return false;
    }
    
    @Override
    public boolean xoaLopHoc(String maLH) {
        LopHoc lh = timLopHocTheoMa(maLH);
        if (lh != null) {
            danhSachLopHoc.remove(lh);
            System.out.println("Da xoa lop hoc co ma: " + maLH);
            return true;
        }
        System.out.println("Loi: Khong tim thay ma lop hoc de xoa.");
        return false;
    }
    
    @Override
    public LopHoc timLopHocTheoMa(String maLH) {
        for (LopHoc lh : danhSachLopHoc) {
            if (lh.getMaLH().equals(maLH)) {
                return lh;
            }
        }
        return null;
    }

    @Override
    public void themMonHoc(MonHoc mh) {
        if (timMonHocTheoMa(mh.getMaMH()) == null) {
            danhSachMonHoc.add(mh);
            System.out.println("Da them mon hoc " + mh.getTenMonHoc());
        } else {
            System.out.println("Loi: Ma mon hoc da ton tai.");
        }
    }
    
    @Override
    public boolean suaMonHoc(String maMH, MonHoc mhMoi) {
        for (int i = 0; i < danhSachMonHoc.size(); i++) {
            if (danhSachMonHoc.get(i).getMaMH().equals(maMH)) {
                danhSachMonHoc.set(i, mhMoi);
                System.out.println("Cap nhat mon hoc thanh cong.");
                return true;
            }
        }
        System.out.println("Loi: Khong tim thay ma mon hoc de sua.");
        return false;
    }
    
    @Override
    public boolean xoaMonHoc(String maMH) {
        MonHoc mh = timMonHocTheoMa(maMH);
        if (mh != null) {
            danhSachMonHoc.remove(mh);
            System.out.println("Da xoa mon hoc co ma: " + maMH);
            return true;
        }
        System.out.println("Loi: Khong tim thay ma mon hoc de xoa.");
        return false;
    }
    
    @Override
    public MonHoc timMonHocTheoMa(String maMH) {
        for (MonHoc mh : danhSachMonHoc) {
            if (mh.getMaMH().equals(maMH)) {
                return mh;
            }
        }
        return null;
    }

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