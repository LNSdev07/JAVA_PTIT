
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
        return this.toan *2 + this.ly + this.hoa ;
    }

    public String ketQua() {
        if (this.tongDiem() + this.diemUuTien() >= 24) {
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
    }

}

public class J04013 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        String name = sc.nextLine();
        double toan = sc.nextDouble();
        double ly = sc.nextDouble();
        double hoa = sc.nextDouble();
        thiSinh thisinh = new thiSinh(id, name, toan, ly, hoa);
        thisinh.display();
    }
}
