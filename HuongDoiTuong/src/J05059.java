
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
class thiSinh {

    private String id;
    private String name;
    private double toan;
    private double ly;
    private double hoa;

    public thiSinh() {
    }

    public thiSinh(String id, String name, double toan, double ly, double hoa) {
        this.id = id;
        this.name = name;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
    }

    public double diemUuTien() {
        String s = this.id.substring(0, 3);
        if (s.equals("KV1")) {
            return 0.5;
        } else if (s.equals("KV2")) {
            return 1;
        } else {
            return 2.5;
        }
    }

    public double tongDiem() {
        return this.toan * 2 + this.ly + this.hoa + this.diemUuTien();
    }

    public String ketQua() {
        if (this.tongDiem() + this.diemUuTien() >= J05059.diemChuan) {
            return "TRUNG TUYEN";
        } else {
            return "TRUOT";
        }
    }

    public void display() {
        System.out.print(id + " " + this.name + " ");
        if (diemUuTien() == (int) diemUuTien()) {
            System.out.printf("%.0f ", diemUuTien());
        } else {
            System.out.printf("%.1f ", diemUuTien());
        }
        if (tongDiem() == (int) tongDiem()) {
            System.out.printf("%.0f ", tongDiem());
        } else {
            System.out.printf("%.1f ", tongDiem());
        }
        System.out.print(ketQua());
        System.out.println("");
    }

    public String getId() {
        return id;
    }

}

public class J05059 {
        public static double diemChuan;
        public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
         ArrayList<thiSinh> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        while ( n -->0) {
             String id = sc.nextLine().trim();
             String name = sc.nextLine().trim();
             double toan = Double.parseDouble(sc.nextLine().trim());
             double ly = Double.parseDouble(sc.nextLine().trim());
             double hoa = Double.parseDouble(sc.nextLine().trim());
             thiSinh thisinh = new thiSinh(id, name, toan, ly, hoa);
             list.add(thisinh);
        }
        int chiTieu = Integer.parseInt(sc.nextLine().trim());
        Collections.sort(list, (thiSinh o1, thiSinh o2) -> {
            if(o1.tongDiem() > o2.tongDiem()) return -1;
            else if(o1.tongDiem() < o2.tongDiem()) return 1;
            else return o1.getId().compareTo(o2.getId());
        });
        diemChuan = list.get(chiTieu-1).tongDiem();
        System.out.println(String.format("%.1f", list.get(chiTieu-1).tongDiem()));
        list.forEach(x -> x.display());
    }
    
}
