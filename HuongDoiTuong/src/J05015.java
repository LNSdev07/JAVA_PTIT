
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

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
class CuaRo {

    private String ten, donVi, ketThuc;

    public CuaRo() {
    }

    public CuaRo(String ten, String donVi, String ketThuc) {
        this.ten = ten;
        this.donVi = donVi;
        this.ketThuc = ketThuc;
    }

    public int Vtb() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm");
        Date date1 = simpleDateFormat.parse("6:00");
        Date date2 = simpleDateFormat.parse(this.ketThuc);
        long dis = Math.abs(date1.getTime() - date2.getTime());
        double hours = (double)dis/(60*60*1000);
        return (int) Math.round((double)(120/hours));
    }
    
    public String ma(){
        StringBuilder sb = new StringBuilder("");
        String[] arr1 = this.donVi.split("\\s+");
        String[] arr2 = this.ten.split("\\s+");
        for(String x : arr1){
            sb.append(x.charAt(0));
        }
        for(String x : arr2){
            sb.append(x.charAt(0));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        try {
            return  this.ma()+" "+this.ten +" "+ this.donVi + " "+ this.Vtb() +" Km/h";
        } catch (ParseException ex) {
            Logger.getLogger(CuaRo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}

public class J05015 {
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        ArrayList<CuaRo> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine().trim());
        for(int i=0; i<n; i++){
            String ten = sc.nextLine().trim();
            String donVi = sc.nextLine().trim();
            String ketThuc = sc.nextLine().trim();
            CuaRo cr = new CuaRo(ten, donVi, ketThuc);
            list.add(cr);
        }
        Collections.sort(list, (CuaRo o1, CuaRo o2) -> {
            try {
                if(o1.Vtb() != o2.Vtb()) return o2.Vtb() - o1.Vtb();
                else return o1.ma().compareTo(o2.ma());
            } catch (ParseException ex) {
                Logger.getLogger(J05015.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
        });
        list.forEach(x -> System.out.println(x.toString()));
    }
}
