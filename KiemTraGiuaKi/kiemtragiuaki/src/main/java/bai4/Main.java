package bai4;

import java.util.*;

class KhachHang{
    private String maKH, tenKH, gioiTinh, ngaySinh, diaChi;

    public KhachHang(int maKH, String tenKH, String gioiTinh, String ngaySinh, String diaChi) {
        this.maKH = chuanHoaMa(maKH);
        this.tenKH = tenKH;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public static String chuanHoaMa(int id){
        String s = String.valueOf(id);
        while(s.length() <3){
            s = "0"+s;
        }
        return "KH"+s;
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
}

class MatHang{
    private String maMH, tenMH, donViTinh;
    private int giaMua, giaBan;

    public MatHang(int maMH, String tenMH, String donViTinh, int giaMua, int giaBan) {
        this.maMH = chuanHoaMaMH(maMH);
        this.tenMH = tenMH;
        this.donViTinh = donViTinh;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }



    public static String chuanHoaMaMH(int id){
        String s = String.valueOf(id);
        while(s.length() <3){
            s = "0"+s;
        }
        return "MH"+s;
    }

    public String getMaMH() {
        return maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public int getGiaMua() {
        return giaMua;
    }

    public int getGiaBan() {
        return giaBan;
    }
}

class HoaDon{
    private String maHD;
    private String maKH, maMH;
    private int soLuong;

    public HoaDon(int maHD, String maKH, String maMH, int soLuong) {
        this.maHD = chuanHoaMa(maHD);
        this.maKH = maKH;
        this.maMH = maMH;
        this.soLuong = soLuong;
    }

    public String chuanHoaMa(int id){
        String s = String.valueOf(id);
        while(s.length() <3){
            s = "0"+s;
        }
        return "HD"+s;
    }

    public String getMaHD() {
        return maHD;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getMaMH() {
        return maMH;
    }

    public int getSoLuong() {
        return soLuong;
    }
}

class Data{
    private String maHD, tenKh, diaChi, tenMh;
    private int soLuong;
    long thanhTien, loiNhuan;

    public Data(String maHD, String tenKh, String
            diaChi, String tenMh, int soLuong, long thanhTien, long loiNhuan) {
        this.maHD = maHD;
        this.tenKh = tenKh;
        this.diaChi = diaChi;
        this.tenMh = tenMh;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.loiNhuan = loiNhuan;
    }

    public long getLoiNhuan() {
        return loiNhuan;
    }
    @Override
    public String toString() {
        return this.maHD +" "+ this.tenKh +" "+ this.diaChi+" " + this.tenMh+" " + this.soLuong +" "+ this.thanhTien +" "+ this.loiNhuan;
    }


}


public class Main {
    public static void main(String[] args) {
        HashMap<String, KhachHang> mapKH = new HashMap<>();
        HashMap<String, MatHang> mapMH = new HashMap<>();
        List<HoaDon> listHD = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        for(int i=1; i<=n ;i++){
            String tenKh = sc.nextLine();
            String gioiTinh = sc.nextLine();
            String ngaySinh = sc.nextLine();
            String diaChi = sc.nextLine();

            KhachHang kh = new KhachHang(i, tenKh, gioiTinh, ngaySinh, diaChi);
            mapKH.put(KhachHang.chuanHoaMa(i), kh);
        }

        int m = Integer.parseInt(sc.nextLine());
        for(int i =1; i<=m ;i++){
            String tenMh = sc.nextLine();
            String donViTinh = sc.nextLine();
            int giaMua = Integer.parseInt(sc.nextLine());
            int giaBan = Integer.parseInt(sc.nextLine());

            MatHang mh = new MatHang(i, tenMh, donViTinh, giaMua, giaBan);

            mapMH.put(MatHang.chuanHoaMaMH(i), mh);

        }

        int k = Integer.parseInt(sc.nextLine());
        for(int i= 1; i<=k; i++){
            String[] arr = sc.nextLine().split("\\s+");
            HoaDon hd = new HoaDon(i, arr[0], arr[1], Integer.parseInt(arr[2]));
            listHD.add(hd);
        }

        List<Data> listData = new ArrayList<>();

        for(HoaDon x : listHD){
               KhachHang kh = mapKH.get(x.getMaKH());
               MatHang mh = mapMH.get(x.getMaMH());


               long tongTien = x.getSoLuong() * mh.getGiaBan();

               long loiNhuan = tongTien - x.getSoLuong() * mh.getGiaMua();

               Data data = new Data(x.getMaHD(), kh.getTenKH(), kh.getDiaChi(), mh.getTenMH(), x.getSoLuong(), tongTien, loiNhuan);


               listData.add(data);
        }

        Collections.sort(listData, (o1, o2) -> {
            if(o1.getLoiNhuan() > o2.getLoiNhuan()) return -1;
            else return 1;
        });

        for (Data x : listData){
            System.out.println(x.toString());
        }
    }
}
