
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
class MatHang {

    private static int count = 1;
    private int id = count;
    private String ten;
    private String donViTinh;
    private long donGiaNhap;
    private int soLuong;

    public MatHang() {
        count++;
    }

    public MatHang(String ten, String donViTinh, long donGiaNhap, int soLuong) {
        count++;
        this.ten = ten;
        this.donViTinh = donViTinh;
        this.donGiaNhap = donGiaNhap;
        this.soLuong = soLuong;
    }

    private double phiVanChuyen() {
        return Math.ceil(this.donGiaNhap * this.soLuong /20/1.0)*1.0;
    }

    private double thanhTien() {
        return Math.ceil(this.donGiaNhap * this.soLuong + this.phiVanChuyen()/1.0)*1.0;
    }

    public double giaBan() {
        return Math.ceil( (this.thanhTien() + thanhTien() / 50) / soLuong / 100 ) * 100;
    }

    public String chuanHoaId() {
        String s = String.valueOf(id);
        while (s.length() < 2) {
            s = "0" + s;
        }
        return "MH" + s;
    }
    
    
    @Override
    public String toString() {
        return this.chuanHoaId() +" "+ this.ten +" "+ this.donViTinh +" "+ String.format("%.0f", this.phiVanChuyen())+" "+
                 String.format("%.0f", this.thanhTien()) +" "+ String.format("%.0f", this.giaBan());
               

}
}

public class J05037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<MatHang> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            String ten = sc.nextLine();
            String donViTinh = sc.nextLine();
            long giaNhap = Long.parseLong(sc.nextLine());
            int soLuong = Integer.parseInt(sc.nextLine());
            MatHang mathang = new MatHang(ten, donViTinh, giaNhap, soLuong);
            list.add(mathang);
        }
        Collections.sort(list, new Comparator<MatHang>(){
            @Override
            public int compare(MatHang o1, MatHang o2) {
               if(o1.giaBan() >= o2.giaBan()) return -1;
               else return 1;
            } 
        });
        list.forEach(x -> System.out.println(x.toString()));
    }
}

