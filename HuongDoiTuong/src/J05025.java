
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
class GiangVien{
    private static int count =1;
    private int id = count;
    private String name;
    private String boMon;

    public GiangVien() {
        count++;
    }

    public int getId() {
        return id;
    }
    
    public GiangVien(String name, String boMon) {
        count++;
        this.name = name;
        this.boMon = boMon;
    }
    public String chuanHoaId(int id){
        String s = String.valueOf(id);
        while(s.length() <2){
            s = "0"+ s;
        }
        return "GV"+s;
    }
    public String getName(){
        String[] arr = this.name.split("\\s+");
        return arr[arr.length -1];
    }
    
    public String getKhoa(){
        StringBuilder sb = new StringBuilder("");
        String[] arr = this.boMon.split("\\s+");
        for(int i =0; i<arr.length ;i++){
            sb.append(arr[i].charAt(0));
        }
        String s = sb.toString();
        return s.toUpperCase();
    }

    @Override
    public String toString() {
       return this.chuanHoaId(this.id) + " " + this.name +" " + this.getKhoa();
    }
    
}
public class J05025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<GiangVien> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0; i<n; i++){
            String name = sc.nextLine();
            String boMon = sc.nextLine();
            GiangVien giangvien = new GiangVien(name, boMon);
            list.add(giangvien);
        }
        Collections.sort(list, new Comparator<GiangVien>(){
            @Override
            public int compare(GiangVien o1, GiangVien o2) {
               if(o1.getName().compareTo(o2.getName()) < 0) return -1;
               else if(o1.getName().compareTo(o2.getName()) > 0) return 1;
               else {
                   return o1.getId() - o2.getId();
               }
            }          
        });
        list.forEach(x -> System.out.println(x.toString()));
    }
}
