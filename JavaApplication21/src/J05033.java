
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
public class J05033 {
    private int gio;
    private int phut;
    private int giay;

    public J05033() {
    }

    public J05033(int gio, int phut, int giay) {
        this.gio = gio;
        this.phut = phut;
        this.giay = giay;
    }

    public int getGio() {
        return gio;
    }

    public void setGio(int gio) {
        this.gio = gio;
    }

    public int getPhut() {
        return phut;
    }

    public void setPhut(int phut) {
        this.phut = phut;
    }

    public int getGiay() {
        return giay;
    }

    public void setGiay(int giay) {
        this.giay = giay;
    }
    public void display(){
        System.out.println(gio+" "+ phut+ " " + giay);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<J05033> ds = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0; i<n; i++){
            int gio = sc.nextInt();
            int phut = sc.nextInt();
            int giay = sc.nextInt();
            J05033 tmp = new J05033(gio, phut, giay);
            ds.add(tmp);
        }
        Collections.sort(ds, new Comparator<J05033>(){
            @Override
            public int compare(J05033 o1, J05033 o2) {
               if(o1.getGio() != o2.getGio()) return o1.getGio() - o2.getGio();
               else if(o1.getPhut() != o2.getPhut()) {
                   return o1.getPhut() - o2.getPhut();
               }
               else {
                   return o1.getGiay() - o2.getGiay();
               }
            }
        });
        ds.forEach(x -> x.display());
    }
}
