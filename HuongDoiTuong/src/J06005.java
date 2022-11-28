
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
class KhachHang {

    private static int count = 1;
    private String maKH, tenKH, gioiTinh, ngaySinh, diaChi;

    public KhachHang() {

    }

    public KhachHang(String ten, String gioiTinh, String ngaySinh, String diaChi) {
        this.maKH = chuanHoa(count++).trim();
        this.tenKH = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public String chuanHoa(int n) {
        String s = String.valueOf(n);
        while (s.length() < 3) {
            s = "0" + s;
        }
        return "KH" + s;
    }

    public static int getCount() {
        return count;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    @Override
    public String toString() {
        return this.tenKH + " " + this.diaChi + " ";
    }

}

class MatHang {

    private static int cnt = 1;
    private String tenMH, denViTinh, maMH;
    private int giaMua, giaBan;

    public MatHang() {

    }

    public MatHang(String tenMH, String denViTinh, int giaMua, int giaBan) {
        this.maMH = chuanHoa(cnt++);
        this.tenMH = tenMH;
        this.denViTinh = denViTinh;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }

    public String chuanHoa(int n) {
        String s = String.valueOf(n);
        while (s.length() < 3) {
            s = "0" + s;
        }
        return "MH" + s;
    }

    public String getMaMH() {
        return maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public String getDenViTinh() {
        return denViTinh;
    }

    public int getGiaMua() {
        return giaMua;
    }

    public int getGiaBan() {
        return giaBan;
    }

    @Override
    public String toString() {
        return this.tenMH + " " + this.denViTinh + " " + this.getGiaMua() + " " + this.giaBan + " ";
    }

}

class HoaDon extends MatHang{

    private static int res = 1;
    private String maKH, maMH, maHD;
    private int soLuong;

    public HoaDon() {

    }

    public HoaDon(String maKH, String maMH, int soLuong, String tenMH, String denViTinh, int giaMua, int giaBan) {
        super(tenMH, denViTinh, giaMua, giaBan);
        this.maKH = maKH;
        this.maMH = maMH;
        this.maHD = chuanHoaHD(res++);
        this.soLuong = soLuong;
    }

    public String chuanHoaHD(int n) {
        String s = String.valueOf(n);
        while (s.length() < 3) {
            s = "0" + s;
        }
        return "HD" + s;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getMaHD() {
        return maHD;
    }

    public int getSoLuong() {
        return soLuong;
    }
    public long thanhTien(){
        return this.getGiaBan()*this.soLuong;
    }
    
    public long loiNhuan(){
        return (this.getGiaBan() - this.getGiaMua())*this.soLuong;
    }

    @Override
    public String toString() {
        return  this.getTenMH()+" " + this.soLuong +" "+this.thanhTien()+" " + this.loiNhuan();
    }

}

public class J06005 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<KhachHang> listKH = new ArrayList<>();
        ArrayList<MatHang> listMH = new ArrayList<>();
        ArrayList<HoaDon> listHD = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String tenKH = sc.nextLine();
            String gioiTinh = sc.nextLine();
            String ngaySinh = sc.nextLine();
            String diaChi = sc.nextLine();
            KhachHang kh = new KhachHang(tenKH, gioiTinh, ngaySinh, diaChi);
            listKH.add(kh);
        }
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String tenMH = sc.nextLine();
            String donVi = sc.nextLine();
            int giaMua = Integer.parseInt(sc.nextLine());
            int giaBan = Integer.parseInt(sc.nextLine());
            MatHang mh = new MatHang(tenMH, donVi, giaMua, giaBan);
            listMH.add(mh);
        }
        int k = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < k; i++) {
            String s = sc.nextLine().trim();
            String[] arr = s.split("\\s+");
            String maKH = arr[0];
            String maMH = arr[1];
            int soLuong = Integer.parseInt(arr[2]);
            for(MatHang mh: listMH){
                if(mh.getMaMH().equals(arr[1])){
                    HoaDon hoadon = new HoaDon(maKH, maMH, soLuong, mh.getTenMH(), mh.getDenViTinh(), mh.getGiaMua(), mh.getGiaBan());
                    listHD.add(hoadon);
                    break;
                }
            }
        }
        Collections.sort(listHD, (HoaDon o1, HoaDon o2) -> {
            if(o1.loiNhuan() > o2.loiNhuan()) return -1;
            else if(o1.loiNhuan() < o2.loiNhuan()) return 1;
            else return o1.getMaHD().compareTo(o2.getMaHD());        
        });
        
        for(HoaDon hoadon : listHD){
            System.out.print(hoadon.getMaHD()+" ");
            for(KhachHang kh : listKH){
                if(kh.getMaKH().equals(hoadon.getMaKH())){
                    System.out.print(" "+ kh.toString());
                    break;
                }
            }
            System.out.println(hoadon.toString());
        }

    }
}
