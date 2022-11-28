
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
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
    
    public TreeMap<Long, Integer> map = new TreeMap<>();
    public int[] nguoiXepTruoc;

    private static int count = 1;
    private int ma = count;
    String name, dateOfBirth, start, finish;
    public int thuTu;

    public VanDongVien() {
        count++;
    }

    public VanDongVien(String name, String dateOfBirth, String start, String finish) {
        count++;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.start = start;
        this.finish = finish;
    }

    public static final String formatTime(long millis) {
        long secs = millis / 1000;
        LocalTime timeOfDay = LocalTime.ofSecondOfDay(secs);
        return timeOfDay.toString();
    }

    public String chuanHoa() {
        String s = String.valueOf(this.ma);
        while (s.length() < 2) {
            s = "0" + s;
        }
        return "VDV" + s;
    }

    public int diemUuTien() {
        String ns = this.dateOfBirth.substring(6, 10);
        int tuoi = 2021 - Integer.parseInt(ns);
        if (tuoi >= 18 && tuoi < 25) {
            return 1;
        } else if (tuoi >= 25 && tuoi < 32) {
            return 2;
        } else if (tuoi >= 32) {
            return 3;
        }
        return 0;
    }

    public String thanhTichThucTe() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        Date date1 = simpleDateFormat.parse(start);
        Date date2 = simpleDateFormat.parse(finish);

        long distance = Math.abs(date2.getTime() - date1.getTime());
        return formatTime(distance);
    }

    public String thoiGianUuTien() throws ParseException {
        LocalTime timeOfDay = LocalTime.ofSecondOfDay(this.diemUuTien());
        return timeOfDay.toString();
    }

    public  String thanhTich() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        Date date1 = simpleDateFormat.parse(start);
        Date date2 = simpleDateFormat.parse(finish);

       long result = Math.abs(date2.getTime() - date1.getTime() - this.diemUuTien()*1000);
       if(!map.containsKey(result)){
           map.put(result, 1);
       }
       else{
           map.put(result, map.get(result)+1);
       }
       return formatTime(result);        
    }

    @Override
    public String toString() {
        try {
            return this.chuanHoa() + " " + this.thanhTichThucTe() + " " + this.thoiGianUuTien() + " " + this.thanhTich();
        } catch (ParseException ex) {
            Logger.getLogger(VanDongVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

public class J05055 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<VanDongVien> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String dateOfBirth = sc.nextLine();
            String start = sc.nextLine();
            String finish = sc.nextLine();
            VanDongVien vdv = new VanDongVien(name, dateOfBirth, start, finish);
            list.add(vdv);
        }
        list.forEach(x -> System.out.println(x.toString()));
    }
}
