
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
class ThucTap {

    private static int count = 1;
    private int id = count;
    private String msv;
    private String ten, lop, email, doanhNghiep;

    public ThucTap() {
        count++;
    }

    public ThucTap(String msv, String ten, String lop, String email, String doanhNghiep) {
        count++;
        this.msv = msv;
        this.ten = ten;
        this.lop = lop;
        this.email = email;
        this.doanhNghiep = doanhNghiep;
    }

    public String getTen() {
        return this.ten;
    }

    public String getDoanhNghiep() {
        return doanhNghiep;
    }

    public String getMsv() {
        return msv;
    }
    

    @Override
    public String toString() {
        return this.id +" "+ this.msv +" "+ this.ten +" "+ this.lop+" " + this.email+" " + this.doanhNghiep;
    }

}

public class J05034 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<ThucTap> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String msv = sc.nextLine();
            String ten = sc.nextLine();
            String lop = sc.nextLine();
            String email = sc.nextLine();
            String doanhNghiep = sc.nextLine();
            ThucTap thuctap = new ThucTap(msv, ten, lop, email, doanhNghiep);
            list.add(thuctap);
        }
        Collections.sort(list, (ThucTap o1, ThucTap o2) -> o1.getMsv().compareTo(o2.getMsv()));
        int q = Integer.parseInt(sc.nextLine());
        while( q-- >0){
            String sql = sc.nextLine();
            list.stream().filter(x -> x.getDoanhNghiep().equals(sql)).collect(Collectors.toList()).forEach(x -> System.out.println(x.toString()));
        }   
    }
}
