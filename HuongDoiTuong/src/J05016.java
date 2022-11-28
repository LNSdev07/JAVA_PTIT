
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
class KhachHang{
    private static int count =1;
    private int id = count;
    private String ten, soPhong, ngayNhanPhong, ngayTraPhong;
    private int tienPhatSinh;

    public KhachHang() {
        count++;
    }

    public KhachHang(String ten, String soPhong, String ngayNhanPhong, String ngayTraPhong, int tienPhatSinh) {
        count++;
        this.ten = ten;
        this.soPhong = soPhong;
        this.ngayNhanPhong = ngayNhanPhong;
        this.ngayTraPhong = ngayTraPhong;
        this.tienPhatSinh = tienPhatSinh;
    }
    
    public String chuanHoaMa(){
        String s = String.valueOf(this.id);
        while( s.length() <2){
            s = "0"+ s;
        }
        return "KH"+s;
    }
    
    public String chuanHoaTen(){
        String s = this.ten.trim();
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder("");
        String[] arr = s.split("\\s+");
        for(int i=0; i< arr.length; i++){
            sb.append(Character.toUpperCase(arr[i].charAt(0)));
            for(int j=1; j<arr[i].length(); j++){
                sb.append(arr[i].charAt(j));
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    
    public String chuanHoaNgay(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(2) != '/') sb.insert(0, '0');
        if(sb.charAt(5) != '/') sb.insert(3, '0');
        return sb.toString();
    }
    
    public long soNgayO(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date startDate = simpleDateFormat.parse(this.chuanHoaNgay(this.ngayNhanPhong));
            Date endDate = simpleDateFormat.parse(this.chuanHoaNgay(this.ngayTraPhong));
            
            long startValue = startDate.getTime();
            long endValue = endDate.getTime();
            
            long result = Math.abs(endValue - startValue)/(24 * 60 * 60 * 1000);
            return result+1;
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    public long thanhTien(){
        char c = this.soPhong.charAt(0);
        if(c =='1') return 25 * this.soNgayO() + this.tienPhatSinh;
        else if(c =='1') return 25 * this.soNgayO() + this.tienPhatSinh;
        else if(c =='2') return 34 * this.soNgayO() + this.tienPhatSinh;
        else if(c =='3') return 50 * this.soNgayO() + this.tienPhatSinh;
        else  return 80 * this.soNgayO() + this.tienPhatSinh;
    }

    @Override
    public String toString() {
        return this.chuanHoaMa() +" "+ this.chuanHoaTen() +" "+ this.soPhong+" " + this.soNgayO() +" "+ this.thanhTien();
               
    }
    
    
}
public class J05016 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
       ArrayList<KhachHang> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        while(n -->0){
            String ten = sc.nextLine();
            String soPhong = sc.nextLine().trim();
            String ngayNhanPhong  = sc.nextLine().trim();
            String ngayTraPhong = sc.nextLine().trim();
            int tienPhatSinh = Integer.parseInt(sc.nextLine().trim());
            KhachHang kh = new KhachHang(ten, soPhong, ngayNhanPhong, ngayTraPhong, tienPhatSinh);
            list.add(kh);
        }
        Collections.sort(list, (KhachHang o1, KhachHang o2) -> (int) (o2.thanhTien() - o1.thanhTien()));
        list.forEach(x -> System.out.println(x.toString()));
    }
}
