
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
class sinhVien {
    private final static String msv = "B20DCCN001";
    private String fullName;
    private String lop;
    private String birth;
    private double gpa;

    public sinhVien() {
    }

    public sinhVien(String fullName, String lop, String birth, double gpa) {
        this.fullName = fullName;
        this.lop = lop;
        this.birth = birth;
        this.gpa = gpa;
    }
    public String chuanHoa(String s){
        StringBuilder sb = new StringBuilder(s);
        if (sb.charAt(2) != '/') sb.insert(0, '0');
        if(sb.charAt(5) != '/') sb.insert(3, '0');
        return sb.toString();
    }
    @Override
    public String toString(){
        return msv +" "+ this.fullName + " "+ this.lop +" "+ this.chuanHoa(this.birth) +" "+ String.format("%.2f", this.gpa);
    }
}
public class J04006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fullName = sc.nextLine();
        String lop  = sc.next();
        String bitrh = sc.next();
        double gpa = sc.nextDouble();
        sinhVien sinhvien = new sinhVien(fullName, lop, bitrh, gpa);
        System.out.println(sinhvien.toString());
    }
}
