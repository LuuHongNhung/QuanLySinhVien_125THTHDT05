package com.quanly.main;

import com.quanly.model.*; 
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- Project Quan Ly Sinh Vien ---");

        GiangVien gvCN = new GiangVien("GV001", "PGS.TS Nguyen Van A", "1/1/1970", "Ha Noi", new ArrayList<>(), null, "Cong Nghe Thong Tin", "Tien Si", new ArrayList<>());

        MonHoc mhJava = new MonHoc("MH01", "Lap trinh Java", 3, new ArrayList<>(Arrays.asList(gvCN)));

        gvCN.getMonHocPhuTrach().add(mhJava);
        
        SinhVien svMonitor = new SinhVien("SV001", "Tran Thi B", "1/1/2000", "Đa Nang", new ArrayList<>(), null, 8.5, new ArrayList<>(Arrays.asList(mhJava)));

        SinhVien svThuong = new SinhVien("SV002", "Le Van C", "2/2/2000", "Ho Chi Minh", new ArrayList<>(), svMonitor, 7.8, new ArrayList<>(Arrays.asList(mhJava)));

        LopHoc lhK20 = new LopHoc("LH_K20_A", "Lop K20 CNTT A", svMonitor, gvCN, new ArrayList<>(Arrays.asList(svMonitor, svThuong)));
        
        Khoa khoaCNTT = new Khoa("K01", "Khoa Cong Nghe Thong Tin", new ArrayList<>(Arrays.asList(lhK20)));

        System.out.println("\nThong tin Lop Hoc: " + lhK20.getTenLop() + " (" + lhK20.getMaLH() + ")");
        System.out.println("Giao vien Co van: " + lhK20.getGiangVien().getHoTen());
        System.out.println("Lop truong: " + lhK20.getMonitor().getHoTen());
        System.out.println("Tong so sinh vien: " + lhK20.getDanhSachSinhVien().size());
        System.out.println("Mon hoc duoc dang ky (cua SV001): " + svMonitor.getMonHocDangKy().get(0).getTenMonHoc());
    }
}