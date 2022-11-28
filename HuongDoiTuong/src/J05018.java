
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
class HocSinh{
    private static int count =1;
    private int id = count;
    private String name;
    private double m1,m2,m3,m4,m5,m6,m7,m8,m9,m10;

    public HocSinh() {
        count++;
    }

    public HocSinh(String name, double m1, double m2, double m3, double m4, double m5, double m6, double m7, double m8, double m9, double m10) {
        count++;
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
        this.m5 = m5;
        this.m6 = m6;
        this.m7 = m7;
        this.m8 = m8;
        this.m9 = m9;
        this.m10 = m10;
    }
    public double diemTB(){
        double tong = (double)( m1*2 + m2*2 + m3 + m4 + m5 + m6 + m7 + m8 + m9 + m10)/12;
        return Math.round(tong*10.0)/10.0;
    }
    public String xepLoai(){
        if(this.diemTB() >=9 ) return "XUAT SAC";
        else if(this.diemTB() >=8 && this.diemTB() <9) return "GIOI";
        else if(this.diemTB() >=7 && this.diemTB() <8) return "KHA";
        else if(this.diemTB() >=5 && this.diemTB() <7) return "TB";
        else return "YEU";
    }
    public String chuanHoaId(int id){
        String s = String.valueOf(id);
        while( s.length() <2){
            s ="0"+s;
        }
        return "HS"+s;
    }

    public int getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return this.chuanHoaId(id) +" "+ this.name +" "+ String.format("%.1f", this.diemTB())+" " + this.xepLoai();
    }
    
}
public class J05018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        List<HocSinh> list = new ArrayList<>();
        while( t-- >0){
            String name = sc.nextLine();
            double m1 = sc.nextDouble(); double m2 =sc.nextDouble();
            double m3 = sc.nextDouble(); double m4 = sc.nextDouble();
            double m5= sc.nextDouble(); double m6 = sc.nextDouble();
            double m7 = sc.nextDouble(); double m8 = sc.nextDouble();
            double m9 = sc.nextDouble(); double m10 = sc.nextDouble();
            sc.nextLine();
            HocSinh hocsinh = new HocSinh(name, m1, m2, m3, m4, m5, m6, m7, m8, m9, m10);
            list.add(hocsinh);
        }
        Collections.sort(list, new Comparator<HocSinh>(){
            @Override
            public int compare(HocSinh o1, HocSinh o2) {
               if ( o1.diemTB() > o2.diemTB()) return -1;
               else  return 1;
            }           
        });
        list.forEach(x -> System.out.println(x.toString()));
    }
}
