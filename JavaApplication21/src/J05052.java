
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
class DonHang{
    private String ten;
    private String ma;
    private long donGia;
    private int soLuong;

    public DonHang() {
    }

    public DonHang(String ten, String ma, long donGia, int soLuong) {
        this.ten = ten;
        this.ma = ma;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }
    
    public String getSttDonHang(){
        return this.ma.substring(1, 4);
    }
    
    public int getLoai(){
        return Integer.parseInt(String.valueOf(this.ma.charAt(4)));
    }
    
    public long giamGia(){
        if(this.getLoai() ==1) return (long) (0.5 * this.donGia * this.soLuong);
        else  return (long) (0.3 * this.donGia * this.soLuong);
    }
    
    public long thanhTien(){
        return this.donGia * this.soLuong - this.giamGia();
    }
    public int getThuTu(){
        return Integer.parseInt(this.getSttDonHang());
    }

    @Override
    public String toString() {
        return this.ten +" "+ this.ma+" "+ this.getSttDonHang() +" "+ this.giamGia() +" " + this.thanhTien();
    }
    
}
public class J05052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<DonHang> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0; i<n; i++){
            String ten = sc.nextLine();
            String ma = sc.nextLine();
            long donGia = Long.parseLong(sc.nextLine());
            int soLuong  = Integer.parseInt(sc.nextLine());
            DonHang donhang = new DonHang(ten, ma, donGia, soLuong);
            list.add(donhang);
        }
        Collections.sort(list, (DonHang o1, DonHang o2) -> o1.getThuTu() - o2.getThuTu());
        list.forEach(x -> System.out.println(x));
    }
}
