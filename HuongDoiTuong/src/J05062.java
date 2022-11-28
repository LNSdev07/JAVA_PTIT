
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
class SinhVien{
    String ten;
    double Gpa;
    int RL;

    public SinhVien() {
    }

    public SinhVien(String ten, double Gpa, int RL) {
        this.ten = ten;
        this.Gpa = Gpa;
        this.RL = RL;
    }
    
    public String ketQua(){
        if(this.Gpa >=3.6 && this.RL >=90) return "XUAT SAC";
        else if(this.Gpa >=3.2  && this.RL >=80) return "GIOI";
        else if(this.Gpa >=2.5 && this.RL >=70 ) return "KHA";
        else return "KHONG";
    }

    @Override
    public String toString() {
        return this.ten +": "+ this.ketQua();
    }
    
    
}
public class J05062 {
    public static void main(String[] args) {
        ArrayList<SinhVien> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr = s.split("\\s+");
        int n = Integer.parseInt(arr[0]); int m = Integer.parseInt(arr[1]);
        for(int i=0; i<n; i++){
            String ten = sc.nextLine();
            String tmp = sc.nextLine();
            String[] arr1 = tmp.split("\\s+");
            double Gpa = Double.parseDouble(arr1[0]);
            int RL = Integer.parseInt(arr1[1]);
            SinhVien sv = new SinhVien(ten, Gpa, RL);
            list.add(sv);
        }
        list.forEach(x -> System.out.println(x));
    }
}
