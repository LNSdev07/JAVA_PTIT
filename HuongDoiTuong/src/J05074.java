
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
class DiemDanh {

    public static TreeMap<String, String> map = new TreeMap<>();

    private String ma, ten, lop;
    private String diemDanh;

    public DiemDanh(String ma, String ten, String lop) {
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
    }

    public String getMa() {
        return ma;
    }

    public String getLop() {
        return lop;
    }
   

    public void setDiemDanh(String diemDanh) {
        this.diemDanh = diemDanh;
    }

    public String tinhDiemCC() {
        long vang = diemDanh.chars().filter(ch -> ch == 'v').count();
        long denMuon = diemDanh.chars().filter(ch -> ch == 'm').count();
        long result = 10 - vang*2 - denMuon*1;
        if(result <=0) return "0 KDDK";
        else return String.valueOf(result);
    }

    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + this.lop + " "+ tinhDiemCC();
    }

}

public class J05074 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<DiemDanh> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String lop = sc.nextLine();
            DiemDanh diemdanh = new DiemDanh(ma, ten, lop);
            list.add(diemdanh);
        }
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine().trim();
            String[] arr = s.split("\\s+");
            for (DiemDanh x : list) {
                if (x.getMa().equals(arr[0])) {
                    x.setDiemDanh(arr[1]);
                    break;
                }
            }
        }
        String sql = sc.nextLine();
        list.stream().filter(x ->x.getLop().equals(sql)).forEach(x -> System.out.println(x.toString()));
    }
}
