package com.quanly.main;

import com.quanly.manager.QuanLy;
import com.quanly.model.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class Main {
    private static QuanLy ql = new QuanLy();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        khoiTaoDuLieuMau(); // Khởi tạo dữ liệu mẫu
        hienThiMenuChinh();
    }

    private static void khoiTaoDuLieuMau() {
        // Tạo dữ liệu mẫu để test
        GiangVien gv1 = new GiangVien("GV001", "Nguyen Van A", "1/1/1970", 
                                      "Ha Noi", null, "Cong Nghe Thong Tin", 
                                      "Tien Si", new ArrayList<>());

        MonHoc mh1 = new MonHoc("MH01", "Lap trinh Java", 3, new ArrayList<>());
        MonHoc mh2 = new MonHoc("MH02", "Co so du lieu", 3, new ArrayList<>());

        mh1.themGiangVien(gv1);
        gv1.getMonHocPhuTrach().add(mh1);

        SinhVien sv1 = new SinhVien("SV001", "Tran Thi B", "1/1/2000", 
                                   "Da Nang", null, 8.5, 
                                   new ArrayList<>(Arrays.asList(mh1)));

        SinhVien sv2 = new SinhVien("SV002", "Le Van C", "2/2/2000", 
                                   "Ho Chi Minh", sv1, 7.8, 
                                   new ArrayList<>(Arrays.asList(mh1, mh2)));

        LopHoc lop1 = new LopHoc("LH01", "Lop K20 CNTT A", sv1, gv1, 
                                new ArrayList<>(Arrays.asList(sv1, sv2)));

        Khoa khoa1 = new Khoa("K01", "Khoa Cong Nghe Thong Tin", 
                             new ArrayList<>(Arrays.asList(lop1)));

        // Thêm vào hệ thống
        ql.themGiangVien(gv1);
        ql.themMonHoc(mh1);
        ql.themMonHoc(mh2);
        ql.themSinhVien(sv1);
        ql.themSinhVien(sv2);
        ql.themLopHoc(lop1);
        ql.themKhoa(khoa1);
    }

    private static void hienThiMenuChinh() {
        while (true) {
            System.out.println("\n========== HE THONG QUAN LY ==========");
            System.out.println("1. Quan ly Sinh vien");
            System.out.println("2. Quan ly Giang vien");
            System.out.println("3. Quan ly Khoa");
            System.out.println("4. Quan ly Lop hoc");
            System.out.println("5. Quan ly Mon hoc");
            System.out.println("6. Hien thi tong quan");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");

            int chon = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng mới

            switch (chon) {
                case 1:
                    menuQuanLySinhVien();
                    break;
                case 2:
                    menuQuanLyGiangVien();
                    break;
                case 3:
                    menuQuanLyKhoa();
                    break;
                case 4:
                    menuQuanLyLopHoc();
                    break;
                case 5:
                    menuQuanLyMonHoc();
                    break;
                case 6:
                    hienThiTongQuan();
                    break;
                case 0:
                    System.out.println("Cam on ban da su dung he thong!");
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    // ========== MENU SINH VIEN ==========
    private static void menuQuanLySinhVien() {
        while (true) {
            System.out.println("\n========== QUAN LY SINH VIEN ==========");
            System.out.println("1. Them sinh vien");
            System.out.println("2. Sua sinh vien");
            System.out.println("3. Xoa sinh vien");
            System.out.println("4. Tim kiem sinh vien");
            System.out.println("5. Hien thi danh sach");
            System.out.println("0. Quay lai");
            System.out.print("Chon chuc nang: ");

            int chon = scanner.nextInt();
            scanner.nextLine();

            switch (chon) {
                case 1:
                    themSinhVien();
                    break;
                case 2:
                    suaSinhVien();
                    break;
                case 3:
                    xoaSinhVien();
                    break;
                case 4:
                    timSinhVien();
                    break;
                case 5:
                    hienThiDanhSachSinhVien();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    private static void themSinhVien() {
        System.out.println("\n--- THEM SINH VIEN ---");
        System.out.print("Nhap ma sinh vien: ");
        String maID = scanner.nextLine();
        
        // Kiểm tra trùng mã
        if (ql.timSinhVienTheoMa(maID) != null) {
            System.out.println("Ma sinh vien da ton tai!");
            return;
        }

        System.out.print("Nhap ho ten: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhap ngay sinh (dd/mm/yyyy): ");
        String ngaySinh = scanner.nextLine();
        System.out.print("Nhap dia chi: ");
        String diaChi = scanner.nextLine();
        System.out.print("Nhap diem tong ket: ");
        double diemTK = scanner.nextDouble();
        scanner.nextLine();

        // Tạo sinh viên mới (chưa có môn học đăng ký)
        SinhVien sv = new SinhVien(maID, hoTen, ngaySinh, diaChi, null, diemTK, new ArrayList<>());
        ql.themSinhVien(sv);
    }

    private static void suaSinhVien() {
        System.out.println("\n--- SUA SINH VIEN ---");
        System.out.print("Nhap ma sinh vien can sua: ");
        String maID = scanner.nextLine();

        SinhVien svCu = ql.timSinhVienTheoMa(maID);
        if (svCu == null) {
            System.out.println("Khong tim thay sinh vien!");
            return;
        }

        System.out.println("Thong tin hien tai:");
        System.out.println("Ho ten: " + svCu.getHoTen());
        System.out.println("Ngay sinh: " + svCu.getNgaySinh());
        System.out.println("Dia chi: " + svCu.getDiaChi());
        System.out.println("Diem TK: " + svCu.getDiemTK());

        System.out.print("Nhap ho ten moi (Enter de giu nguyen): ");
        String hoTen = scanner.nextLine();
        if (!hoTen.isEmpty()) svCu.setHoTen(hoTen);

        System.out.print("Nhap ngay sinh moi (Enter de giu nguyen): ");
        String ngaySinh = scanner.nextLine();
        if (!ngaySinh.isEmpty()) svCu.setNgaySinh(ngaySinh);

        System.out.print("Nhap dia chi moi (Enter de giu nguyen): ");
        String diaChi = scanner.nextLine();
        if (!diaChi.isEmpty()) svCu.setDiaChi(diaChi);

        System.out.print("Nhap diem TK moi (-1 de giu nguyen): ");
        String diemStr = scanner.nextLine();
        if (!diemStr.isEmpty() && !diemStr.equals("-1")) {
            svCu.setDiemTK(Double.parseDouble(diemStr));
        }

        // Cập nhật
        ql.suaSinhVien(maID, svCu);
    }

    private static void xoaSinhVien() {
        System.out.println("\n--- XOA SINH VIEN ---");
        System.out.print("Nhap ma sinh vien can xoa: ");
        String maID = scanner.nextLine();
        ql.xoaSinhVien(maID);
    }

    private static void timSinhVien() {
        System.out.println("\n--- TIM KIEM SINH VIEN ---");
        System.out.print("Nhap ma sinh vien: ");
        String maID = scanner.nextLine();
        
        SinhVien sv = ql.timSinhVienTheoMa(maID);
        if (sv != null) {
            System.out.println("\nThong tin sinh vien:");
            System.out.println("Ma: " + sv.getMaID());
            System.out.println("Ho ten: " + sv.getHoTen());
            System.out.println("Ngay sinh: " + sv.getNgaySinh());
            System.out.println("Dia chi: " + sv.getDiaChi());
            System.out.println("Diem TK: " + sv.getDiemTK());
        } else {
            System.out.println("Khong tim thay sinh vien!");
        }
    }

    private static void hienThiDanhSachSinhVien() {
        List<SinhVien> ds = ql.getDanhSachSinhVien();
        System.out.println("\n--- DANH SACH SINH VIEN (" + ds.size() + ") ---");
        for (SinhVien sv : ds) {
            System.out.println("Ma: " + sv.getMaID() + " | Ten: " + sv.getHoTen() + 
                             " | Ngay sinh: " + sv.getNgaySinh() + " | Diem: " + sv.getDiemTK());
        }
    }

    // ========== MENU GIANG VIEN ==========
    private static void menuQuanLyGiangVien() {
        while (true) {
            System.out.println("\n========== QUAN LY GIANG VIEN ==========");
            System.out.println("1. Them giang vien");
            System.out.println("2. Sua giang vien");
            System.out.println("3. Xoa giang vien");
            System.out.println("4. Tim kiem giang vien");
            System.out.println("5. Hien thi danh sach");
            System.out.println("0. Quay lai");
            System.out.print("Chon chuc nang: ");

            int chon = scanner.nextInt();
            scanner.nextLine();

            switch (chon) {
                case 1:
                    themGiangVien();
                    break;
                case 2:
                    suaGiangVien();
                    break;
                case 3:
                    xoaGiangVien();
                    break;
                case 4:
                    timGiangVien();
                    break;
                case 5:
                    hienThiDanhSachGiangVien();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    private static void themGiangVien() {
        System.out.println("\n--- THEM GIANG VIEN ---");
        System.out.print("Nhap ma giang vien: ");
        String maID = scanner.nextLine();
        
        if (ql.timGiangVienTheoMa(maID) != null) {
            System.out.println("Ma giang vien da ton tai!");
            return;
        }

        System.out.print("Nhap ho ten: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhap ngay sinh: ");
        String ngaySinh = scanner.nextLine();
        System.out.print("Nhap dia chi: ");
        String diaChi = scanner.nextLine();
        System.out.print("Nhap ten khoa: ");
        String tenKhoa = scanner.nextLine();
        System.out.print("Nhap hoc vi: ");
        String hocVi = scanner.nextLine();

        GiangVien gv = new GiangVien(maID, hoTen, ngaySinh, diaChi, null, tenKhoa, hocVi, new ArrayList<>());
        ql.themGiangVien(gv);
    }

    private static void suaGiangVien() {
        System.out.println("\n--- SUA GIANG VIEN ---");
        System.out.print("Nhap ma giang vien can sua: ");
        String maID = scanner.nextLine();

        GiangVien gvCu = ql.timGiangVienTheoMa(maID);
        if (gvCu == null) {
            System.out.println("Khong tim thay giang vien!");
            return;
        }

        System.out.println("Thong tin hien tai:");
        System.out.println("Ho ten: " + gvCu.getHoTen());
        System.out.println("Ten khoa: " + gvCu.getTenKhoa());
        System.out.println("Hoc vi: " + gvCu.getHocVi());

        System.out.print("Nhap ho ten moi (Enter de giu nguyen): ");
        String hoTen = scanner.nextLine();
        if (!hoTen.isEmpty()) gvCu.setHoTen(hoTen);

        System.out.print("Nhap ten khoa moi (Enter de giu nguyen): ");
        String tenKhoa = scanner.nextLine();
        if (!tenKhoa.isEmpty()) gvCu.setTenKhoa(tenKhoa);

        System.out.print("Nhap hoc vi moi (Enter de giu nguyen): ");
        String hocVi = scanner.nextLine();
        if (!hocVi.isEmpty()) gvCu.setHocVi(hocVi);

        ql.suaGiangVien(maID, gvCu);
    }

    private static void xoaGiangVien() {
        System.out.println("\n--- XOA GIANG VIEN ---");
        System.out.print("Nhap ma giang vien can xoa: ");
        String maID = scanner.nextLine();
        ql.xoaGiangVien(maID);
    }

    private static void timGiangVien() {
        System.out.println("\n--- TIM KIEM GIANG VIEN ---");
        System.out.print("Nhap ma giang vien: ");
        String maID = scanner.nextLine();
        
        GiangVien gv = ql.timGiangVienTheoMa(maID);
        if (gv != null) {
            System.out.println("\nThong tin giang vien:");
            System.out.println("Ma: " + gv.getMaID());
            System.out.println("Ho ten: " + gv.getHoTen());
            System.out.println("Ten khoa: " + gv.getTenKhoa());
            System.out.println("Hoc vi: " + gv.getHocVi());
        } else {
            System.out.println("Khong tim thay giang vien!");
        }
    }

    private static void hienThiDanhSachGiangVien() {
        List<GiangVien> ds = ql.getDanhSachGiangVien();
        System.out.println("\n--- DANH SACH GIANG VIEN (" + ds.size() + ") ---");
        for (GiangVien gv : ds) {
            System.out.println("Ma: " + gv.getMaID() + " | Ten: " + gv.getHoTen() + 
                             " | Khoa: " + gv.getTenKhoa() + " | Hoc vi: " + gv.getHocVi());
        }
    }

    // ========== MENU KHOA ==========
    private static void menuQuanLyKhoa() {
        while (true) {
            System.out.println("\n========== QUAN LY KHOA ==========");
            System.out.println("1. Them khoa");
            System.out.println("2. Sua khoa");
            System.out.println("3. Xoa khoa");
            System.out.println("4. Tim kiem khoa");
            System.out.println("5. Hien thi danh sach");
            System.out.println("0. Quay lai");
            System.out.print("Chon chuc nang: ");

            int chon = scanner.nextInt();
            scanner.nextLine();

            switch (chon) {
                case 1:
                    themKhoa();
                    break;
                case 2:
                    suaKhoa();
                    break;
                case 3:
                    xoaKhoa();
                    break;
                case 4:
                    timKhoa();
                    break;
                case 5:
                    hienThiDanhSachKhoa();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    private static void themKhoa() {
        System.out.println("\n--- THEM KHOA ---");
        System.out.print("Nhap ma khoa: ");
        String maKhoa = scanner.nextLine();
        
        if (ql.timKhoaTheoMa(maKhoa) != null) {
            System.out.println("Ma khoa da ton tai!");
            return;
        }

        System.out.print("Nhap ten khoa: ");
        String tenKhoa = scanner.nextLine();

        Khoa khoa = new Khoa(maKhoa, tenKhoa, new ArrayList<>());
        ql.themKhoa(khoa);
    }

    private static void suaKhoa() {
        System.out.println("\n--- SUA KHOA ---");
        System.out.print("Nhap ma khoa can sua: ");
        String maKhoa = scanner.nextLine();

        Khoa khoaCu = ql.timKhoaTheoMa(maKhoa);
        if (khoaCu == null) {
            System.out.println("Khong tim thay khoa!");
            return;
        }

        System.out.print("Nhap ten khoa moi: ");
        String tenKhoa = scanner.nextLine();
        
        Khoa khoaMoi = new Khoa(maKhoa, tenKhoa, khoaCu.getDanhSachLopHoc());
        ql.suaKhoa(maKhoa, khoaMoi);
    }

    private static void xoaKhoa() {
        System.out.println("\n--- XOA KHOA ---");
        System.out.print("Nhap ma khoa can xoa: ");
        String maKhoa = scanner.nextLine();
        ql.xoaKhoa(maKhoa);
    }

    private static void timKhoa() {
        System.out.println("\n--- TIM KIEM KHOA ---");
        System.out.print("Nhap ma khoa: ");
        String maKhoa = scanner.nextLine();
        
        Khoa khoa = ql.timKhoaTheoMa(maKhoa);
        if (khoa != null) {
            System.out.println("\nThong tin khoa:");
            System.out.println("Ma: " + khoa.getMaKhoa());
            System.out.println("Ten: " + khoa.getTenKhoa());
            System.out.println("So lop hoc: " + khoa.getDanhSachLopHoc().size());
        } else {
            System.out.println("Khong tim thay khoa!");
        }
    }

    private static void hienThiDanhSachKhoa() {
        List<Khoa> ds = ql.getDanhSachKhoa();
        System.out.println("\n--- DANH SACH KHOA (" + ds.size() + ") ---");
        for (Khoa khoa : ds) {
            System.out.println("Ma: " + khoa.getMaKhoa() + " | Ten: " + khoa.getTenKhoa() + 
                             " | So lop: " + khoa.getDanhSachLopHoc().size());
        }
    }

    // ========== MENU LOP HOC ==========
    private static void menuQuanLyLopHoc() {
        while (true) {
            System.out.println("\n========== QUAN LY LOP HOC ==========");
            System.out.println("1. Them lop hoc");
            System.out.println("2. Sua lop hoc");
            System.out.println("3. Xoa lop hoc");
            System.out.println("4. Tim kiem lop hoc");
            System.out.println("5. Hien thi danh sach");
            System.out.println("0. Quay lai");
            System.out.print("Chon chuc nang: ");

            int chon = scanner.nextInt();
            scanner.nextLine();

            switch (chon) {
                case 1:
                    themLopHoc();
                    break;
                case 2:
                    suaLopHoc();
                    break;
                case 3:
                    xoaLopHoc();
                    break;
                case 4:
                    timLopHoc();
                    break;
                case 5:
                    hienThiDanhSachLopHoc();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    private static void themLopHoc() {
        System.out.println("\n--- THEM LOP HOC ---");
        System.out.print("Nhap ma lop hoc: ");
        String maLH = scanner.nextLine();
        
        if (ql.timLopHocTheoMa(maLH) != null) {
            System.out.println("Ma lop hoc da ton tai!");
            return;
        }

        System.out.print("Nhap ten lop: ");
        String tenLop = scanner.nextLine();

        // Tạo lớp học mới (chưa có sinh viên, lớp trưởng, giảng viên)
        LopHoc lop = new LopHoc(maLH, tenLop, null, null, new ArrayList<>());
        ql.themLopHoc(lop);
        System.out.println("Da tao lop hoc. Ban can cap nhat thong tin lop truong va giang vien sau.");
    }

    private static void suaLopHoc() {
        System.out.println("\n--- SUA LOP HOC ---");
        System.out.print("Nhap ma lop hoc can sua: ");
        String maLH = scanner.nextLine();

        LopHoc lopCu = ql.timLopHocTheoMa(maLH);
        if (lopCu == null) {
            System.out.println("Khong tim thay lop hoc!");
            return;
        }

        System.out.print("Nhap ten lop moi: ");
        String tenLop = scanner.nextLine();
        
        LopHoc lopMoi = new LopHoc(maLH, tenLop, lopCu.getMonitor(), lopCu.getGiangVien(), lopCu.getDanhSachSinhVien());
        ql.suaLopHoc(maLH, lopMoi);
    }

    private static void xoaLopHoc() {
        System.out.println("\n--- XOA LOP HOC ---");
        System.out.print("Nhap ma lop hoc can xoa: ");
        String maLH = scanner.nextLine();
        ql.xoaLopHoc(maLH);
    }

    private static void timLopHoc() {
        System.out.println("\n--- TIM KIEM LOP HOC ---");
        System.out.print("Nhap ma lop hoc: ");
        String maLH = scanner.nextLine();
        
        LopHoc lop = ql.timLopHocTheoMa(maLH);
        if (lop != null) {
            System.out.println("\nThong tin lop hoc:");
            System.out.println("Ma: " + lop.getMaLH());
            System.out.println("Ten: " + lop.getTenLop());
            System.out.println("Giang vien: " + (lop.getGiangVien() != null ? lop.getGiangVien().getHoTen() : "Chua co"));
            System.out.println("Lop truong: " + (lop.getMonitor() != null ? lop.getMonitor().getHoTen() : "Chua co"));
            System.out.println("So sinh vien: " + lop.getDanhSachSinhVien().size());
        } else {
            System.out.println("Khong tim thay lop hoc!");
        }
    }

    private static void hienThiDanhSachLopHoc() {
        List<LopHoc> ds = ql.getDanhSachLopHoc();
        System.out.println("\n--- DANH SACH LOP HOC (" + ds.size() + ") ---");
        for (LopHoc lop : ds) {
            System.out.println("Ma: " + lop.getMaLH() + " | Ten: " + lop.getTenLop() + 
                             " | So SV: " + lop.getDanhSachSinhVien().size());
        }
    }

    // ========== MENU MON HOC ==========
    private static void menuQuanLyMonHoc() {
        while (true) {
            System.out.println("\n========== QUAN LY MON HOC ==========");
            System.out.println("1. Them mon hoc");
            System.out.println("2. Sua mon hoc");
            System.out.println("3. Xoa mon hoc");
            System.out.println("4. Tim kiem mon hoc");
            System.out.println("5. Hien thi danh sach");
            System.out.println("0. Quay lai");
            System.out.print("Chon chuc nang: ");

            int chon = scanner.nextInt();
            scanner.nextLine();

            switch (chon) {
                case 1:
                    themMonHoc();
                    break;
                case 2:
                    suaMonHoc();
                    break;
                case 3:
                    xoaMonHoc();
                    break;
                case 4:
                    timMonHoc();
                    break;
                case 5:
                    hienThiDanhSachMonHoc();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    private static void themMonHoc() {
        System.out.println("\n--- THEM MON HOC ---");
        System.out.print("Nhap ma mon hoc: ");
        String maMH = scanner.nextLine();
        
        if (ql.timMonHocTheoMa(maMH) != null) {
            System.out.println("Ma mon hoc da ton tai!");
            return;
        }

        System.out.print("Nhap ten mon hoc: ");
        String tenMonHoc = scanner.nextLine();
        System.out.print("Nhap so tin chi: ");
        int soTinChi = scanner.nextInt();
        scanner.nextLine();

        MonHoc mh = new MonHoc(maMH, tenMonHoc, soTinChi, new ArrayList<>());
        ql.themMonHoc(mh);
    }

    private static void suaMonHoc() {
        System.out.println("\n--- SUA MON HOC ---");
        System.out.print("Nhap ma mon hoc can sua: ");
        String maMH = scanner.nextLine();

        MonHoc mhCu = ql.timMonHocTheoMa(maMH);
        if (mhCu == null) {
            System.out.println("Khong tim thay mon hoc!");
            return;
        }

        System.out.print("Nhap ten mon hoc moi: ");
        String tenMonHoc = scanner.nextLine();
        System.out.print("Nhap so tin chi moi: ");
        int soTinChi = scanner.nextInt();
        scanner.nextLine();
        
        MonHoc mhMoi = new MonHoc(maMH, tenMonHoc, soTinChi, mhCu.getDanhSachGiangVien());
        ql.suaMonHoc(maMH, mhMoi);
    }

    private static void xoaMonHoc() {
        System.out.println("\n--- XOA MON HOC ---");
        System.out.print("Nhap ma mon hoc can xoa: ");
        String maMH = scanner.nextLine();
        ql.xoaMonHoc(maMH);
    }

    private static void timMonHoc() {
        System.out.println("\n--- TIM KIEM MON HOC ---");
        System.out.print("Nhap ma mon hoc: ");
        String maMH = scanner.nextLine();
        
        MonHoc mh = ql.timMonHocTheoMa(maMH);
        if (mh != null) {
            System.out.println("\nThong tin mon hoc:");
            System.out.println("Ma: " + mh.getMaMH());
            System.out.println("Ten: " + mh.getTenMonHoc());
            System.out.println("So tin chi: " + mh.getSoTinChi());
            System.out.println("So giang vien: " + mh.getDanhSachGiangVien().size());
        } else {
            System.out.println("Khong tim thay mon hoc!");
        }
    }

    private static void hienThiDanhSachMonHoc() {
        List<MonHoc> ds = ql.getDanhSachMonHoc();
        System.out.println("\n--- DANH SACH MON HOC (" + ds.size() + ") ---");
        for (MonHoc mh : ds) {
            System.out.println("Ma: " + mh.getMaMH() + " | Ten: " + mh.getTenMonHoc() + 
                             " | Tin chi: " + mh.getSoTinChi() + " | So GV: " + mh.getDanhSachGiangVien().size());
        }
    }

    // ========== HIEN THI TONG QUAN ==========
    private static void hienThiTongQuan() {
        System.out.println("\n========== TONG QUAN HE THONG ==========");
        System.out.println("Tong so sinh vien: " + ql.getDanhSachSinhVien().size());
        System.out.println("Tong so giang vien: " + ql.getDanhSachGiangVien().size());
        System.out.println("Tong so khoa: " + ql.getDanhSachKhoa().size());
        System.out.println("Tong so lop hoc: " + ql.getDanhSachLopHoc().size());
        System.out.println("Tong so mon hoc: " + ql.getDanhSachMonHoc().size());
        
        // Hiển thị 3 sinh viên đầu tiên
        List<SinhVien> dsSV = ql.getDanhSachSinhVien();
        if (!dsSV.isEmpty()) {
            System.out.println("\n--- 3 SINH VIEN DAU TIEN ---");
            for (int i = 0; i < Math.min(3, dsSV.size()); i++) {
                SinhVien sv = dsSV.get(i);
                System.out.println((i+1) + ". " + sv.getMaID() + " - " + sv.getHoTen() + " - Diem: " + sv.getDiemTK());
            }
        }
    }
}