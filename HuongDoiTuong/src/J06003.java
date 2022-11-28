
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
class Nhom {

    private String ma, ten, sdt, tenBaiTapNhom;
    private int stt;

    public Nhom() {
    }
    
    

    public Nhom(String ma, String ten, String sdt, int stt) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.stt = stt;
    }

    public String getMa() {
        return ma;
    }
    
    

    public void setTenBaiTapNhom(String tenBaiTapNhom) {
        this.tenBaiTapNhom = tenBaiTapNhom;
    }
    
    

    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + this.sdt+" "+ this.stt +" "+ this.tenBaiTapNhom;
    }

    public int getStt() {
        return stt;
    }
    
}

public class J06003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Nhom> list = new ArrayList<>();
        String s = sc.nextLine().trim();
        String[] arr = s.split("\\s+");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        for(int i=0; i<n; i++){
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String sdt = sc.nextLine();
            int stt = Integer.parseInt(sc.nextLine());
            Nhom nhom = new Nhom(ma, ten, sdt, stt);
            list.add(nhom);
        }
        for(int i=1; i<=m; i++){
            String nd = sc.nextLine();
            for(Nhom x : list){
                if(x.getStt()==i){
                    x.setTenBaiTapNhom(nd);
                }
            }
        }
        Collections.sort(list, new Comparator<Nhom>(){
            @Override
            public int compare(Nhom o1, Nhom o2) {
               return o1.getMa().compareTo(o2.getMa());
            }
            
        });
        list.forEach(x -> System.out.println(x.toString()));  
    }
}
