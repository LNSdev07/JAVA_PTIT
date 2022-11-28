
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


class HocPhan{
    private String maMonHoc, tenMonHoc, tenGiangVien;
    private String nhomLop;

    public HocPhan() {
    }

    public HocPhan(String maMonHoc, String tenMonHoc, String nhomLop, String tenGiangVien) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.nhomLop = nhomLop;
        this.tenGiangVien = tenGiangVien;
    }
    
    public int getNhomLop(){
        return Integer.parseInt(this.nhomLop);
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public String getTenGiangVien() {
        return tenGiangVien;
    }
    

    @Override
    public String toString() {
        return this.maMonHoc +" "+ this.tenMonHoc +" "+ this.nhomLop;
    }
    
    
}
public class J05079 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<HocPhan> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0; i<n; i++){
            String maMonHoc = sc.nextLine();
            String tenMonHoc = sc.nextLine();
            String nhomLop = sc.nextLine();
            String tenGiangVien = sc.nextLine();
            HocPhan hp = new HocPhan(maMonHoc, tenMonHoc, nhomLop, tenGiangVien);
            list.add(hp);
        }
        Collections.sort(list, new Comparator<HocPhan>(){
            @Override
            public int compare(HocPhan o1, HocPhan o2) {
                if(!o1.getMaMonHoc().equals(o2.getMaMonHoc())) return o1.getMaMonHoc().compareTo(o2.getMaMonHoc());
                else return o1.getNhomLop() - o2.getNhomLop();
            }
        });
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            String sql = sc.nextLine();
            List<HocPhan> newList = list.stream().filter(x -> x.getTenGiangVien().equals(sql)).collect(Collectors.toList());
            System.out.println("Danh sach cho giang vien " + newList.get(0).getTenGiangVien()+":");
            newList.forEach(x -> System.out.println(x.toString()));
        }
    }
}
