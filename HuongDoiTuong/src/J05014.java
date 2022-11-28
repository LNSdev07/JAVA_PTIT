
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
class GiaoVien {

    private static int count = 1;
    private int ma = count;
    private String ten, maXetTuyen;
    double tinHoc, chuyenMon;

    public GiaoVien() {
        count++;
    }

    public GiaoVien(String ten, String maXetTuyen, double tinHoc, double chuyenMon) {
        count++;
        this.ten = ten;
        this.maXetTuyen = maXetTuyen;
        this.tinHoc = tinHoc;
        this.chuyenMon = chuyenMon;
    }

    public String chuanHoa() {
        String s = String.valueOf(ma);
        while (s.length() < 2) {
            s = "0" + s;
        }
        return "GV" + s;
    }

    public String monHoc() {
        String c = this.maXetTuyen.substring(0, 1);
        if (c.equals("A")) {
            return "TOAN";
        } else if (c.equals("B")) {
            return "LY";
        } else {
            return "HOA";
        }
    }

    public double diemUuTien() {
        String c = this.maXetTuyen.substring(1, 2);
        if (c.equals("1")) {
            return 2;
        } else if (c.equals("2")) {
            return 1.5;
        } else if (c.equals("3")) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public double tongDiem(){
        return this.tinHoc*2 + this.chuyenMon + this.diemUuTien();
    }

    public String ketQua() {
        double tong = this.tongDiem();
        if (tong >= 18) {
            return "TRUNG TUYEN";
        } else {
            return "LOAI";
        }
    }

    public int getMa() {
        return ma;
    }
    

    @Override
    public String toString() {
        return this.chuanHoa() + " " + this.ten + " "+ String.format("%.1f", this.tongDiem())  + " " + this.ketQua();
    }

}

public class J05014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<GiaoVien> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String ten = sc.nextLine().trim();
            String maXetTuyen = sc.nextLine().trim();
            double tinHoc = Double.parseDouble(sc.nextLine().trim());
            double chuyenMon = Double.parseDouble(sc.nextLine().trim());
            GiaoVien gv = new GiaoVien(ten, maXetTuyen, tinHoc, chuyenMon);
            list.add(gv);
        }
        Collections.sort(list, new Comparator<GiaoVien>(){
            @Override
            public int compare(GiaoVien o1, GiaoVien o2) {
                 if(o1.tongDiem() > o2.tongDiem()) return -1;
                 else  return 1;
               
            }
            
        });
        list.forEach(x -> System.out.println(x.toString()));
    }
}
