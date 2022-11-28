
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
class CLB{
    private String ma;
    private String ten;
    private int giaVe;

    public CLB() {
    }

    public CLB(String ma, String ten, int giaVe) {
        this.ma = ma;
        this.ten = ten;
        this.giaVe = giaVe;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public int getGiaVe() {
        return giaVe;
    }
    
}
class TranDau{
    private String ma;
    private int soLuong;

    public TranDau() {
    }

    public TranDau(String ma, int soLuong) {
        this.ma = ma;
        this.soLuong = soLuong;
    }
    public long doanhThu( List<CLB> list){
        String sql = this.ma.substring(1, 3);
        List<CLB> x = list.stream().filter(y -> y.getMa().equals(sql)).collect(Collectors.toList());
        return this.soLuong * x.get(0).getGiaVe();
    }
    
    public String toString(List<CLB> list) {
         String sql = this.ma.substring(1, 3);
         List<CLB> x = list.stream().filter(y -> y.getMa().equals(sql)).collect(Collectors.toList());
         return this.ma +" "+ x.get(0).getTen() +" "+ this.soLuong * x.get(0).getGiaVe();
    }
    public String getTenCLB(List<CLB> list){
         String sql = this.ma.substring(1, 3);
         List<CLB> x = list.stream().filter(y -> y.getMa().equals(sql)).collect(Collectors.toList());
         return x.get(0).getTen();
    }
}

public class J05069 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<CLB> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0; i<n; i++){
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            int giaVe = Integer.parseInt(sc.nextLine());
            CLB  clb = new CLB(ma, ten, giaVe);
            list.add(clb);
        }
        int q = Integer.parseInt(sc.nextLine());
        List<TranDau> ds = new ArrayList<>();
        while(q -- >0){
            String s = sc.nextLine();
            String arr[] = s.split("\\s+");
            String ma = arr[0]; int soLuong = Integer.parseInt(arr[1]);
            TranDau trandau = new TranDau(ma, soLuong);
            ds.add(trandau);
        }
        Collections.sort(ds, new Comparator<TranDau>(){
            @Override
            public int compare(TranDau o1, TranDau o2) {
                if(o1.doanhThu(list) > o2.doanhThu(list)) return -1;
                else if(o1.doanhThu(list) < o2.doanhThu(list)) return 1;
                else{
                    return o1.getTenCLB(list).compareTo(o2.getTenCLB(list));
                }
            }
            
        });
        ds.forEach(x -> System.out.println(x.toString(list)));
    }
}
