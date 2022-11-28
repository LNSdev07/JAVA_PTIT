
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;  
import java.util.stream.Collectors; 

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
class ThiSinh {

    private static int count = 1;
    private int id = count;
    private String name;
    private String ngaySinh;
    double m1, m2, m3;

    public ThiSinh() {
        count++;
    }

    public ThiSinh(String name, String ngaySinh, double m1, double m2, double m3) {
        count++;
        this.name = name;
        this.ngaySinh = ngaySinh;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }

    public double tongDiem() {
        return this.m1 + this.m2 + this.m3;
    }

    @Override
    public String toString() {
        return this.id +" "+ this.name+" "+ this.ngaySinh +" "+ this.tongDiem();
    }
    
}

public class J05009 {

    public static void main(String[] args) {
        List<ThiSinh> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String ngaySinh = sc.nextLine();
            double m1 = Double.parseDouble(sc.nextLine());
            double m2 = Double.parseDouble(sc.nextLine());
            double m3 = Double.parseDouble(sc.nextLine());
            ThiSinh thisinh = new ThiSinh(name, ngaySinh, m1, m2, m3);
            list.add(thisinh);
        }
        List listPoint = list.stream().map(x -> x.tongDiem()).collect(Collectors.toList());
        double max = (double) Collections.max(listPoint);
        List<ThiSinh> result = list.stream().filter(x -> x.tongDiem() == max).collect(Collectors.toList());
        result.forEach(x -> System.out.println(x.toString()));
    }
}
