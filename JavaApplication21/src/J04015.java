
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
class giaoVien {

    private String maNghach;
    private String fullName;
    private long salary;

    public giaoVien() {
    }

    public giaoVien(String maNghach, String fullName, long salary) {
        this.maNghach = maNghach;
        this.fullName = fullName;
        this.salary = salary;
    }

    public int getBacLuong() {
        String sb = this.maNghach.substring(2, 4);
        return Integer.parseInt(sb);
    }

    public long getPhuCap() {
        String cv = this.maNghach.substring(0, 2);
        if (cv.equals("HT")) {
            return 2000000;
        } else if (cv.equals("HP")) {
            return 900000;
        } else {
            return 500000;
        }
    }

    public String getName() {
        return this.maNghach.substring(0, 2);
    }

    public long thuNhap() {
        return this.salary * this.getBacLuong() + this.getPhuCap();
    }

    @Override
    public String toString() {
        return this.maNghach + " " + this.fullName + " " + this.getBacLuong() + " " + this.getPhuCap() + " " + this.thuNhap();
    }

}

public class J04015 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String maNgach = sc.nextLine();
        String fullName = sc.nextLine();
        long salary = sc.nextLong();
        giaoVien giaovien = new giaoVien(maNgach, fullName, salary);
        System.out.println(giaovien.toString());
       
    }
}
