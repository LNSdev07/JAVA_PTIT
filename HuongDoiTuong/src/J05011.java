
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
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
class Time{
    private String ma, ten, batDau, ketThuc;

    public Time() {
    }

    public Time(String ma, String ten, String batDau, String ketThuc) {
        this.ma = ma;
        this.ten = ten;
        this.batDau = batDau;
        this.ketThuc = ketThuc;
    }
    public long thoiGianChoi() throws ParseException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
        Date date1 = simpleDateFormat.parse(this.batDau);
        Date date2 = simpleDateFormat.parse(this.ketThuc);
        
        long distance = Math.abs(date1.getTime() - date2.getTime());
        return distance;
    }
    
    public String thongBao() throws ParseException{
        long h =  (this.thoiGianChoi())/(60*60*1000);
        long p = ((this.thoiGianChoi())%(60*60*1000))/(60*1000);
        return h +" "+ "gio"+" "+p+" "+ "phut";
    }

    @Override
    public String toString() {
        try {
            return this.ma +" "+ this.ten +" "+ this.thongBao();
        } catch (ParseException ex) {
            Logger.getLogger(Time.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
public class J05011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Time> list = new ArrayList<>();
        int n= Integer.parseInt(sc.nextLine());     
        for(int i=0; i<n; i++){
            String ma= sc.nextLine();
            String ten= sc.nextLine();
            String batDau= sc.nextLine();
            String ketThuc= sc.nextLine();
            Time time = new Time(ma, ten, batDau, ketThuc);
            list.add(time);
        }
        
        Collections.sort(list, new Comparator<Time>(){
            @Override
            public int compare(Time o1, Time o2) {
                try {
                    if(o1.thoiGianChoi() >= o2.thoiGianChoi()) return -1;
                    else return 1;
                } catch (ParseException ex) {
                    Logger.getLogger(J05011.class.getName()).log(Level.SEVERE, null, ex);
                }
                return 0;
            }
            
        });
        list.forEach(x -> System.out.println(x.toString()));
    }
}
