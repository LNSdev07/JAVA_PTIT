import java.util.ArrayList;
import java.util.Collection;
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
class Hang {
     private String maHang;
     private int soLuongNhap;

    public Hang() {
    }

    public Hang(String maHang, int soLuongNhap) {
        this.maHang = maHang;
        this.soLuongNhap = soLuongNhap;
    }
     
     public double soLuongXuat(){
         if(this.maHang.charAt(0) == 'A') return Math.round(soLuongNhap * 0.6/1.0)*1.0;
         else return Math.round(soLuongNhap * 0.7/1.0)*1.0;
     }
     
     public String sql(){
         return this.maHang.substring(0, 1);
     }
     
     public int getDonGia(){
         int n = this.maHang.length();
         if(this.maHang.charAt(n-1) =='Y') return 110000;
         else return 135000;                         
     }
     
     public double getTien(){
         return this.getDonGia() * this.soLuongXuat();
     }
     
     public double getThue(){
         int n = this.maHang.length();
         if(this.maHang.charAt(0) =='A' && this.maHang.charAt(n-1) =='Y') return Math.round(getTien()*2/25/1.0)*1.0;
         else if(this.maHang.charAt(0) =='A' && this.maHang.charAt(n-1) =='N') return Math.round(getTien()*11/100/1.0)*1.0;
         else if(this.maHang.charAt(0) =='B' && this.maHang.charAt(n-1) =='Y') return Math.round(getTien()*17/100/1.0)*1.0;
         else return Math.round(getTien()*11/50/1.0)*1.0;
     }

    @Override
    public String toString() {
        return this.maHang +" "+ this.soLuongNhap+" "+ String.format("%.0f", this.soLuongXuat())+" "+this.getDonGia()+
                " "+ String.format("%.0f", this.getTien())+" "+ String.format("%.0f", this.getThue());
    }
     
   
}
    


public class J05049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Hang> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0; i<n; i++){
            String ma = sc.nextLine();
            int soLuongNhap = Integer.parseInt(sc.nextLine());
            Hang hang = new Hang(ma, soLuongNhap);
            list.add(hang);
        }
        Collections.sort(list, new Comparator<Hang>(){
            @Override
            public int compare(Hang o1, Hang o2) {
              if(o1.getThue() >= o2.getThue()) return -1;
              else return 1;
            }          
        });
        String s = sc.nextLine();
        list.stream().filter(x -> x.sql().equals(s)).forEach(x -> System.out.println(x.toString()));
    }
}