/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */

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
class HoaDon {
    private String ma;
    private String loai;
    private double soCu;
    private double soMoi;

    public HoaDon() {
       
    }

    public HoaDon(String loai, double soCu, double soMoi, int x) {
        
        this.loai = loai;
        this.soCu = soCu;
        this.soMoi = soMoi;
        this.ma = chuanHoaMa(x);
    }

    public String chuanHoaMa(int id) {
        String s = String.valueOf(id);
        while (s.length() < 2) {
            s = "0" + s;
        }
        return "KH" + s;
    }

    public int heSo() {
        if (this.loai.equals("KD")) {
            return 3;
        } else if (this.loai.equals("NN")) {
            return 5;
        } else if (this.loai.equals("TT")) {
            return 4;
        } else return 2;
    }
    
    
    public double thanhTien(){
        return Math.round((this.soMoi - this.soCu)*550 * this.heSo());
    }
    
    public double phuTroi(){
        double res = this.soMoi - this.soCu;
        if(res <50) return 0;
        else if(res >=50 && res <=100) return Math.round(this.thanhTien()/100*35);
        else return this.thanhTien();
    }
    
    public double tongTien(){
        return this.thanhTien() + this.phuTroi();
    }

    @Override
    public String toString() {
        return this.ma +" "+this.heSo() +" "+String.format("%.0f %.0f %.0f",this.thanhTien(), this.phuTroi(), this.tongTien());
    }
    
    
}

public class J05051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<HoaDon> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            String loai = sc.nextLine();
            double soCu = Double.parseDouble(sc.nextLine());
            double soMoi  = Double.parseDouble(sc.nextLine());
            int x = i+1;
            HoaDon hoadon = new HoaDon(loai, soCu, soMoi, x);
            list.add(hoadon);
        }
        
        Collections.sort(list, new Comparator<HoaDon>(){
            @Override
            public int compare(HoaDon o1, HoaDon o2) {
                if(o1.tongTien() > o2.tongTien()) return -1;
                else return 1;
            } 
        });
        list.forEach(x -> System.out.println(x.toString()));
    }
}
