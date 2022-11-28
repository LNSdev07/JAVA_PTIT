
import java.util.ArrayList;
import java.util.HashMap;
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

class NhanVien{
    public static HashMap<String, String> map = new HashMap<>();
    private String maNV, ten;
    private long luongCoBan, soNgayCong;

    public NhanVien() {
    }

    public NhanVien(String maNV, String ten, long luongCoBan, long soNgayCong) {
        this.maNV = maNV;
        this.ten = ten;
        this.luongCoBan = luongCoBan;
        this.soNgayCong = soNgayCong;
    }
    
    public int tinhHeSo(){
        String loaiNV = this.maNV.substring(0, 1);
        int namKN = Integer.parseInt(this.maNV.substring(1, 3));
        
        if(loaiNV.equals("A")){
            if(namKN >=1 && namKN <=3) return 10;
            else if(namKN >= 4 && namKN <=8) return 12;
            else if(namKN >=9 && namKN <=15) return 14;
            else return 20;
        }
        else if(loaiNV.equals("B")){
            if(namKN >=1 && namKN <=3) return 10;
            else if(namKN >= 4 && namKN <=8) return 11;
            else if(namKN >=9 && namKN <=15) return 13;
            else return 16;
        }
        else if(loaiNV.equals("C")){
            if(namKN >=1 && namKN <=3) return 9;
            else if(namKN >= 4 && namKN <=8) return 10;
            else if(namKN >=9 && namKN <=15) return 12;
            else return 14;
        }
        else{          
            if(namKN >=1 && namKN <=3) return 8;
            else if(namKN >= 4 && namKN <=8) return 9;
            else if(namKN >=9 && namKN <=15) return 11;
            else return 13;
        }
    }
    public long Luong(){
        return this.luongCoBan * this.soNgayCong * this.tinhHeSo() * 1000;
    }

    public void display(){
        String MP = this.maNV.substring(3, 5);
        String tenPhong = "";
        if(map.containsKey(MP)){
            tenPhong = map.get(MP);
        }
        System.out.println(this.maNV+" "+ this.ten +" "+ tenPhong+" "+ this.Luong());
    }

    public String getMaNV() {
        return maNV;
    }
    
    

    @Override
    public String toString() {
        return this.maNV+" "+ this.ten +" "+ this.Luong();
    }
    
    
    
    
    
}
public class J05078 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0; i<n; i++){
            String s = sc.nextLine();
            String[] arr = s.split("\\s+");
            String ma = arr[0];
            StringBuilder ten  = new StringBuilder("");
            for(int j=1; j< arr.length; j++){
                ten.append(arr[j]).append(" ");
            }
            ten.deleteCharAt(ten.length()-1);
            
            NhanVien.map.put(ma, ten.toString());
        }
        int m = Integer.parseInt(sc.nextLine());
        List<NhanVien> list = new ArrayList<>();
        for(int i=0; i<m; i++){
            String maNV = sc.nextLine();
            String ten = sc.nextLine();
            long luongCoBan = Long.parseLong(sc.nextLine());
            long soNgayCong = Long.parseLong(sc.nextLine());
            NhanVien nv = new NhanVien(maNV, ten, luongCoBan, soNgayCong);
            list.add(nv);
        }
        String sql = sc.nextLine();
        System.out.println("Bang luong phong " + NhanVien.map.get(sql)+":");
        list.stream().filter(x -> x.getMaNV().contains(sql)).forEach(x -> System.out.println(x.toString()));
    }
    
}
