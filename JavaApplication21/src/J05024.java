
import java.util.ArrayList;
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
class SinhVien {

    private String ma;
    private String hoTen;
    private String lop;
    private String email;

    public SinhVien() {
    }
  
    public SinhVien(String ma, String hoTen, String lop, String email) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.lop = lop;
        this.email = email;
    }

    public String getMa() {
        return ma;
    }

    public String getLop() {
        return lop;
    }
    
    
    

    @Override
    public String toString() {
        return this.ma + " " + this.hoTen + " " + this.lop + " " + this.email;
    }

}

public class J05024 {

    public static String chuanHoa(String s) {
        StringBuilder sb = new StringBuilder("");
        String[] arr = s.split("\\s+");
        sb.append(Character.toUpperCase(arr[0].charAt(0)));
        sb.append(Character.toUpperCase(arr[1].charAt(0)));
        return "DC"+sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<SinhVien> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String hoTen = sc.nextLine();
            String lop = sc.nextLine();
            String email = sc.nextLine();
            SinhVien sinhvien = new SinhVien(ma, hoTen, lop, email);
            list.add(sinhvien);
        }
        int q = Integer.parseInt(sc.nextLine());
        while (q-- > 0) {
            String sql = sc.nextLine();
            String s = chuanHoa(sql);
            if(s.equals("DCKT")) System.out.println("DANH SACH SINH VIEN NGANH KE TOAN:"); 
            else if(s.equals("DCCN")) System.out.println("DANH SACH SINH VIEN NGANH CONG NGHE THONG TIN:");
            else if(s.equals("DCAT")) System.out.println("DANH SACH SINH VIEN NGANH AN TOAN THONG TIN:");
            else if(s.equals("DCVT")) System.out.println("DANH SACH SINH VIEN NGANH VIEN THONG:");
            else System.out.println("DANH SACH SINH VIEN NGANH DIEN TU:");
            for(int i=0; i<list.size(); i++){
                if(list.get(i).getMa().contains(s) && (list.get(i).getLop().charAt(0) != 'E' && ((s.equals("DCCN") || s.equals("DCAT"))))){
                    System.out.println(list.get(i).toString());
                }
            }
        }
    }
}
