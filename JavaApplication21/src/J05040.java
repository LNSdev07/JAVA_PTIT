
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
class NhanVien {

    private  static int count = 1;
    private int id = count;
    private String ten;
    private long luongCoBan;
    private int soNgayCong;
    private String chucVu;

    public NhanVien() {
        count++;
    }

    public NhanVien(String ten, long luongCoBan, int soNgayCong, String chucVu) {
        count++;
        this.ten = ten;
        this.luongCoBan = luongCoBan;
        this.soNgayCong = soNgayCong;
        this.chucVu = chucVu;
    }

    public long tienLuong() {
        return this.luongCoBan * this.soNgayCong;
    }

    public long tienThuong() {
        if (this.soNgayCong >= 25) {
            return (long) (0.2 * this.tienLuong());
        } else if (this.soNgayCong >= 22 && this.soNgayCong < 25) {
            return (long) (0.1 * this.tienLuong());
        } else {
            return 0;
        }
    }

    public long phuCap() {
        switch (this.chucVu) {
            case "GD":
                return 250000;
            case "PGD":
                return 200000;
            case "TP":
                return 180000;
            default:
                return 150000;
        }
    }

    public String chuanHoaId() {
        String s = String.valueOf(id);
        while (s.length() < 2) {
            s = "0" + s;
        }
        return "NV" + s;
    }

    public long thuNhap() {
        return this.tienLuong() + this.tienThuong() + this.phuCap();
    }

    @Override
    public String toString() {
        return this.chuanHoaId() + " " + this.ten + " " + this.tienLuong() + " "
                + this.tienThuong() + " " + this.phuCap() + " " + this.thuNhap();
    }

}

public class J05040 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<NhanVien> list = new ArrayList<>();
        int n = Integer.parseInt((sc.nextLine()));
        for(int i=0; i<n; i++){
            String ten = sc.nextLine();
            long luongCoBan = Long.parseLong(sc.nextLine());
            int soNgayCong = Integer.parseInt(sc.nextLine());
            String chucVu = sc.nextLine();
            NhanVien nhanvien = new NhanVien(ten, luongCoBan, soNgayCong, chucVu);
            list.add(nhanvien);
        }
       // Collections.sort(list, (NhanVien o1, NhanVien o2) -> (int) (o2.thuNhap() - o1.thuNhap()));
        list.forEach(x -> System.out.println(x.toString()));
        List<Long> sumLuong = list.stream().map(x -> x.thuNhap()).collect(Collectors.toList());
        long sum = sumLuong.stream().mapToLong(Long::longValue).sum();
        System.out.println("Tong chi phi tien luong: "+sum);
    }
}
