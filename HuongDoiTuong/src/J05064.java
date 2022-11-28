
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
class GiaoVien {

    public static TreeMap<String, Integer> map = new TreeMap<>();

    private String ma, ten;
    private long luongCoBan;

    private int HT = 0;
    private int HP = 0;
    private int GV = 0;

    public GiaoVien() {
    }

    public GiaoVien(String ma, String ten, long luongCoBan) {
        this.ma = ma;
        this.ten = ten;
        this.luongCoBan = luongCoBan;

        String cv = ma.substring(0, 2);
        if (!map.containsKey(cv)) {
            map.put(cv, 1);
            if (cv.equals("HT")) {
                this.HT = 1;
            } else if (cv.equals("HP")) {
                this.HP = 1;
            } else {
                this.GV = 1;
            }
        } else {
            map.put(cv, map.get(cv) + 1);
            if (cv.equals("HT")) {
                this.HT = map.get(cv) + 1;
            } else if (cv.equals("HP")) {
                this.HP = map.get(cv) + 1;
            } else {
                this.GV = map.get(cv) + 1;
            }
        }

    }

    public long phuCap() {
        String cv = ma.substring(0, 2);
        if (cv.equals("HT")) {
            return 2000000;
        } else if (cv.equals("HP")) {
            return 900000;
        }
        return 500000;
    }

    public long Luong() {
        int heSoLuong = Integer.parseInt(this.ma.substring(2, 4));
        return this.luongCoBan * heSoLuong + this.phuCap();
    }

    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + Integer.parseInt(this.ma.substring(2, 4)) + " " + this.phuCap() + " " + this.Luong();
    }

    public int getHT() {
        return HT;
    }

    public int getHP() {
        return HP;
    }

}

public class J05064 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<GiaoVien> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            long luongCoBan = Long.parseLong(sc.nextLine());
            GiaoVien gv = new GiaoVien(ma, ten, luongCoBan);
            list.add(gv);
        }
        list.stream().filter(x -> (x.getHT() <=1 && x.getHP() <=3)).forEach(x -> System.out.println(x.toString()));
    }
}
