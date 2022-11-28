
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private static int count =1;
    private int ma = count;
    private String ten;
    private int soLuong;
    private int donGia;
    
    private static Map<String, Integer> map = new HashMap<>();

    public DonHang() {
        count++;
    }

    public DonHang(String ten, int soLuong, int donGia) {
        count++;
        this.ten = ten;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
    public long tienChietKhau(){
        long chietKhau = 0;
		if(soLuong > 10)
			chietKhau = 5;
		else if(soLuong >= 8)
			chietKhau = 2;
		else if(soLuong >=5)
			chietKhau = 1;
		return  donGia * soLuong / 100 * chietKhau;
		
    }
    
    public long thanhTien(){
        return this.soLuong * this.donGia - this.tienChietKhau();
    }
    
    public String chuanHoaSo(int n){
        String s = String.valueOf(n);
        while(s.length() <2){
            s = "0"+s;
        }
        return s;
    }
    
    public String chuanHoaMa(){
        String[] arr = this.ten.split("\\s+");
        StringBuilder sb = new StringBuilder("");
        sb.append(String.valueOf(arr[0].charAt(0)) + String.valueOf(arr[1].charAt(0)));      
        String s = sb.toString().toUpperCase();
        if(map.containsKey(s)){
            int tanSuat = map.get(s);
            ++tanSuat;
            map.put(s, tanSuat);
            return s+chuanHoaSo(tanSuat);
        }
        else{
            int tanSuat =1;
            map.put(s, tanSuat);
            return s+chuanHoaSo(1);
        }
    }

    @Override
    public String toString() {
        return this.chuanHoaMa() +" "+ this.ten +" "+ this.tienChietKhau()+" "+ this.thanhTien();
    }
    
}
public class J05047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        List<DonHang> list = new ArrayList<>();
        while(t-- >0){
            String ten = sc.nextLine();
            int soLuong = Integer.parseInt(sc.nextLine());
            int donGia = Integer.parseInt(sc.nextLine());
            DonHang donhang = new DonHang(ten, soLuong, donGia);
            list.add(donhang);
        }
        Collections.sort(list, new Comparator<DonHang>(){
            @Override
            public int compare(DonHang o1, DonHang o2) {
               if( o1.tienChietKhau()< o2.tienChietKhau())
					return 1;
		return -1;
            }
            
        });
        list.forEach(x -> System.out.println(x.toString()));
    }
}
