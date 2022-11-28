
import java.util.ArrayList;

import java.util.Scanner;

import java.util.TreeMap;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
class HocSinh{
    private static int count =1;
    private int id = count;
    private String name;
    private  double TB;
    public static TreeMap<Double, Integer> map = new TreeMap<>();
    public static int[] nguoiXepTruoc;
    public int thuTu;
    

    public HocSinh() {
        count++;
    }

    public HocSinh(String name, double TB) {
        count++;
        this.name = name;
        this.TB = TB;
        if(!map.containsKey(TB)){
            map.put(TB, 1);
        }
        else{
            map.put(TB, map.get(TB)+1);
        }
    }
    
    public String chuanHoa(){
        String s = String.valueOf(this.id);
        while(s.length() <2){
            s = "0"+s;
        }
        return "HS"+s;
    }

    public double getTB() {
        return TB;
    }
    
    public String xepLoai(){
        if(this.TB <5) return "Yeu";
        else if(this.TB >=5 && this.TB <7) return "Trung Binh";
        else if(this.TB >=7 && this.TB <9) return "Kha";
        else return "Gioi";
        
    }
    
    public static void tinhXepHang(){
        nguoiXepTruoc = new int[map.size()+1];
        nguoiXepTruoc[0] =1;
        int index =1;
        for(double x : map.descendingKeySet()){
            nguoiXepTruoc[index] = nguoiXepTruoc[index-1]+map.get(x);
            index++;
        }
    }

    @Override
    public String toString() {
        return this.chuanHoa()+" "+this.name +" "+ this.TB +" "+ this.xepLoai()+" " + this.thuTu;
    }
    
    
    
}
public class J05054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<HocSinh> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            String name = sc.nextLine();
            double TB = Double.parseDouble(sc.nextLine());
            HocSinh hs = new HocSinh(name, TB);
            list.add(hs);
        }
        HocSinh.tinhXepHang();
        for(HocSinh i : list){
            int index = 1;
            for(double j : HocSinh.map.descendingKeySet()){
                if(i.getTB() == j){
                    i.thuTu = HocSinh.nguoiXepTruoc[index-1];
                    System.out.println(i);
                    break;
                }
                index++;
            }
        }
    }
}
