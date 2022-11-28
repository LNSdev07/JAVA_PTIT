
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
class Employee {

    private static int count = 1;
    private int id = count;
    private String name;
    private long luongCoBan;
    private int soNgayCong;
    private String chucVu;

    public Employee() {
        count++;
    }

    public Employee(String name, long luongCoBan, int soNgayCong, String chucVu) {
        count++;
        this.name = name;
        this.luongCoBan = luongCoBan;
        this.soNgayCong = soNgayCong;
        this.chucVu = chucVu;
    }

    public long luongThang() {
        return this.luongCoBan * this.soNgayCong;
    }

    public long phuCap() {
        if (this.chucVu.compareTo("GD") == 0) {
            return 250000;
        } else if (this.chucVu.compareTo("PGD") == 0) {
            return 200000;
        } else if (this.chucVu.compareTo("TP") == 0) {
            return 180000;
        } else {
            return 150000;
        }
    }

    public long thuong() {
        if (this.soNgayCong >= 25) {
            return (long) (0.2 * this.luongThang());
        } else if (this.soNgayCong >= 22 && this.soNgayCong < 25) {
            return (long) (0.1 * this.luongThang());
        } else {
            return 0;
        }
    }

    public long thuNhap() {
        return this.luongThang() + this.phuCap() + this.thuong();
    }

    @Override
    public String toString() {
        return "NV01" +" "+ this.name +" "+ this.luongThang()+ " "+ this.thuong() + " "+ this.phuCap() +" "+ this.thuNhap() ;
    }
   
}

public class J04012 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        long luongCoBan = Long.parseLong(sc.nextLine());
        int soNgayCong = Integer.parseInt(sc.nextLine());
        String chucVu = sc.nextLine();
        Employee employee = new Employee(name, luongCoBan, soNgayCong, chucVu);
         System.out.println(employee.toString());
     
    }
}
