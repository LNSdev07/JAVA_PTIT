
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
class VanDongVien {

    public static TreeMap<Long, Integer> map = new TreeMap();
    public static int[] nguoiXepTruoc;

    public long layThoiGian(String s) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        return date.getTime();
    }

    public static final String formatTime(long millis) {
        long secs = millis / 1000;
        return String.format("%02d:%02d:%02d", secs / 3600, (secs % 3600) / 60, (secs % 60));
    }

    private static int count = 1;
    private int id = count;
    private String name, ngaySinh, batDau, ketThuc;
    private long thanhTich;
    
    public int thuTu;

    public VanDongVien() {
    }

    public VanDongVien(String name, String ngaySinh, String batDau, String ketThuc) throws ParseException {
        count++;
        this.name = name;
        this.ngaySinh = ngaySinh;
        this.batDau = batDau;
        this.ketThuc = ketThuc;
        
        long time1 = layThoiGian(this.batDau);
        long time2 = layThoiGian(this.ketThuc);
        long tmp = Math.abs(time2-time1) - thoiGianUuTien()*1000;
        if(!map.containsKey(tmp)){
            map.put(tmp, 1);
        }
        else{
            map.put(tmp, map.get(tmp)+1);
        }
        
        this.thanhTich = Math.abs(time2-time1) - thoiGianUuTien()*1000;
    }

    public int thoiGianUuTien() {
        int res = 2021 - Integer.parseInt(this.ngaySinh.substring(6, 10));
        if (res < 18) {
            return 0;
        } else if (res >= 18 && res < 25) {
            return 1;
        } else if (res >= 25 && res < 32) {
            return 2;
        } else {
            return 3;
        }

    }

    public String thanhTichThucTe() throws ParseException {
        long time1 = layThoiGian(this.batDau);
        long time2 = layThoiGian(this.ketThuc);
        return formatTime(Math.abs(time2 - time1));
    }
    
    public String thanhTichUuTien(){
        return formatTime(this.thoiGianUuTien()*1000);
    }
    
    public String thanhTichXepHang() throws ParseException{
        long time1 = layThoiGian(this.batDau);
        long time2 = layThoiGian(this.ketThuc);
        return formatTime(Math.abs(time2 - time1) - this.thoiGianUuTien()*1000);
    }
    
    public String chuanHoa() {
        String s = String.valueOf(this.id);
        while (s.length() < 2) {
            s = "0" + s;
        }
        return "VDV" + s;
    }

    @Override
    public String toString() {
        try {
            return chuanHoa() +" "+this.name +" "+this.thanhTichThucTe() +" "+ this.thanhTichUuTien()+" "+ this.thanhTichXepHang() +" "+ thuTu;
        } catch (ParseException ex) {
           ex.printStackTrace();
        }
        return null;
    }

    public long getThanhTich() {
        return thanhTich;
    }

    public int getThuTu() {
        return thuTu;
    }
    
    
    
    public static void xepHang(){
        nguoiXepTruoc = new int[map.size()+1];
        int index = 1;
        nguoiXepTruoc[0] =1;
        for(long x : map.keySet()){
            nguoiXepTruoc[index] = nguoiXepTruoc[index-1]+map.get(x);
            index++;
        }
    }

}

public class J05056 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        ArrayList<VanDongVien> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0; i<n; i++){
            String name = sc.nextLine();
            String ngaySinh = sc.nextLine();
            String batDau = sc.nextLine();
            String ketThuc = sc.nextLine();
            VanDongVien vdv = new VanDongVien(name, ngaySinh, batDau, ketThuc);
            list.add(vdv);
        }
        
        VanDongVien.xepHang();
        
        for(VanDongVien i : list){
            int index = 1;
            for(long j : VanDongVien.map.keySet()){
                if(i.getThanhTich()== j){
                    i.thuTu = VanDongVien.nguoiXepTruoc[index-1];
                }
                index++;
            }
        }
        Collections.sort(list, new Comparator<VanDongVien>(){
            @Override
            public int compare(VanDongVien o1, VanDongVien o2) {
               return o1.getThuTu() - o2.getThuTu();
            }       
        });
        list.forEach(x -> System.out.println(x.toString()));
    }
}
