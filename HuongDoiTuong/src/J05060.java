
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
class PhuHo{
    private static  int count =1;
    private int id = count;
    private String name;
    private String ngaySinh;
    private double lyThuyet;
    private double thucHanh;

    public PhuHo() {
        count++;
    }

    public PhuHo(String name, String ngaySinh, double lyThuyet, double thucHanh) {
        count++;
        this.name = name;
        this.ngaySinh = ngaySinh;
        this.lyThuyet = lyThuyet;
        this.thucHanh = thucHanh;
    }

    public int getId() {
        return id;
    }
    
    
    public String chuanHoaId(int id){
        String s = String.valueOf(id);
        while(s.length() <2){
            s = "0"+ s;
        }
        return "PH"+s;
    }
    public int getTuoi(){
        int ns = Integer.parseInt(this.ngaySinh.substring(6, 10));
        return 2021 - ns;
    }
    public double getThuong(){
        if(this.lyThuyet >=8 && this.thucHanh >=8) return 1.0;
        else if(this.lyThuyet >=7.5 && this.thucHanh >=7.5) return 0.5;
        else return 0;
    }
    public int getDiem(){
        double TB = (this.lyThuyet + this.thucHanh)/2;
        int tongDiem= (int) Math.round(TB+this.getThuong());
        if(tongDiem >=10) return 10;
        else return tongDiem;
    }
    public String getXepLoai(){
        int tmp = this.getDiem();
        if(tmp <5) return "Truot";
        else if(tmp ==5 || tmp ==6) return "Trung binh";
        else if(tmp == 7) return "Kha";
        else if(tmp == 8) return "Gioi";
        else return "Xuat sac";
    }

    @Override
    public String toString() {
        return this.chuanHoaId(this.id) +" "+ this.name +" "+ this.getTuoi() +" "+ this.getDiem()+" " + this.getXepLoai();
    }
    
    
}
public class J05060 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<PhuHo> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0; i <n; i++){
            String name = sc.nextLine();
            String ngaySinh = sc.nextLine();
            double lyThuyet = Double.parseDouble(sc.nextLine());
            double thucHanh = Double.parseDouble(sc.nextLine());
            PhuHo phuho = new PhuHo(name, ngaySinh, lyThuyet, thucHanh);
            list.add(phuho);
        }
        Collections.sort(list, (PhuHo o1, PhuHo o2) -> {
            if(o1.getDiem() != o2.getDiem()) return o2.getDiem() - o1.getDiem();
            else return o1.getId() - o2.getId();
        });
        list.forEach(x -> System.out.println(x.toString()));
    }
}
