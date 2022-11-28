
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
class ThiSinh {

    private String ma;
    private String hoTen;
    double toan, ly, hoa;

    public ThiSinh() {
    }

    public ThiSinh(String ma, String hoTen, double toan, double ly, double hoa) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
    }

    public String getMa() {
        return ma;
    }
    

    public double diemUuTien() {
        String kv = this.ma.substring(0, 3);
        if (kv.equals("KV1")) {
            return 0.5;
        } else if (kv.equals("KV2")) {
            return 1.0;
        } else {
            return 2.5;
        }
    }

    public String ketQua() {
        double tong = this.toan*2 + this.hoa + this.ly + this.diemUuTien();
        if (tong >= 24) {
            return "TRUNG TUYEN";
        } else {
            return "TRUOT";
        }
    }

    public double tongDiem() {
        return this.toan*2 + this.hoa + this.ly + this.diemUuTien() ;
    }

    public void display() {
        System.out.print(this.ma + " " + this.hoTen + " ");
        if (this.diemUuTien() == (int) this.diemUuTien()) {
            System.out.printf("%.0f ", this.diemUuTien());
        } else {
            System.out.printf("%.1f ", this.diemUuTien());
        }
        if (this.tongDiem() == (int) this.tongDiem()) {
            System.out.printf("%.0f ", this.tongDiem());
        } else {
            System.out.printf("%.1f ", this.tongDiem());
        }
        System.out.println(this.ketQua());
    }

}

class sortByTongdiem implements Comparator<ThiSinh>{

    @Override
    public int compare(ThiSinh o1, ThiSinh o2) {
       if(o1.tongDiem() > o2.tongDiem()) return -1;
       else if(o1.tongDiem() < o2.tongDiem()) return 1;
       else{
           return o1.getMa().compareTo(o2.getMa());
       }
    }
    
}

public class J05057 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<ThiSinh> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String hoTen = sc.nextLine();
            double toan = Double.parseDouble(sc.nextLine());
            double ly = Double.parseDouble(sc.nextLine());
            double hoa = Double.parseDouble(sc.nextLine());
            ThiSinh thisinh = new ThiSinh(ma, hoTen, toan, ly, hoa);
            list.add(thisinh);
        }
        Collections.sort(list, new sortByTongdiem());
        list.forEach(x -> x.display());
    }
}
