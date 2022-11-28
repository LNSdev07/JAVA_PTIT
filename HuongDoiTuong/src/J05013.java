
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
class ThiSinh{
    private static  int count =1;
    private int id = count;
    String ten;
    double LT, TH;

    public ThiSinh() {
        count++;
    }

    public ThiSinh(String ten, double LT, double TH) {
        count++;
        this.ten = ten;
        this.LT = LT;
        this.TH = TH;
    }
    
    public double diemTB(){
        return Math.round((this.LT + this.TH)/2*100.0)/100.0;
    }
    
    public String xepLoai(){
        if(this.diemTB() <5) return "TRUOT";
        else if(this.diemTB() >=5 && this.diemTB() <8) return "CAN NHAC";
        else if(this.diemTB()>=8 && this.diemTB() <9.5) return "DAT";
        else return "XUAT SAC";
    }
    public String chuanHoaId(){
        String s = String.valueOf(id);
        while(s.length() <2){
            s = "0"+s;
        }
        return "TS"+s;
    }
    

    @Override
    public String toString() {
        return this.chuanHoaId()+" "+ this.ten +" "+ String.format("%.2f", this.diemTB()) +" "+ this.xepLoai();
    }
    
    
    
    
    
}
public class J05013 {
    public static String chuanHoa(String s){
        if(s.equals("10")) return "10";
        StringBuilder sb = new StringBuilder(s);
        if(sb.length() <3){
            sb.append("0");
        }
        if(sb.charAt(1) !='.') sb.insert(1, ".");
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        ArrayList<ThiSinh> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            String ten = sc.nextLine();
            double LT = Double.parseDouble(chuanHoa(sc.nextLine().trim()));
            double TH = Double.parseDouble(chuanHoa(sc.nextLine().trim()));
            ThiSinh thisinh = new ThiSinh(ten, LT, TH);
            list.add(thisinh);
        }
        Collections.sort(list, (ThiSinh o1, ThiSinh o2) -> {
            if(o1.diemTB() >= o2.diemTB()) return -1;
            return 1;
        });
        list.forEach(x -> System.out.println(x.toString()));
    }
}
