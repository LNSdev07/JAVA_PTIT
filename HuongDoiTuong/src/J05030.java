
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
class SinhVien {

    private String ma, ten, lop;
    private double d1, d2, d3;

    public SinhVien() {
    }

    public SinhVien(String ma, String ten, String lop, double d1, double d2, double d3) {
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }
    

    @Override
    public String toString() {
        return ma + " " + ten + " " + lop + " " + String.format("%.1f", d1) + " " + String.format("%.1f", d2) + " " + String.format("%.1f", d3);
    }
}

public class J05030 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<SinhVien> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String lop = sc.nextLine();
            double d1 = Double.parseDouble(sc.nextLine());
            double d2 = Double.parseDouble(sc.nextLine());
            double d3 = Double.parseDouble(sc.nextLine());
            SinhVien sinhvien = new SinhVien(ma, ten, lop, d1, d2, d3);
            list.add(sinhvien);
        }
        Collections.sort(list, new Comparator<SinhVien>(){
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
              return o1.getTen().compareTo(o2.getTen());
            }          
        });
        for (int i=0; i<list.size(); i++){
            System.out.print(i+1 +" ");
            System.out.println(list.get(i).toString());
        }
    }
}
