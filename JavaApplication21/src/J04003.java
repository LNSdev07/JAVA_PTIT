
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
class phanSo {

    private long x;
    private long y;

    public phanSo() {
    }

    public phanSo(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public void toiGian() {
        long a = this.x, b = this.y;
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        this.x /= a;
        this.y /= a;
    }

    @Override
    public String toString() {
        return this.x + "/" + this.y;
    }
}

public class J04003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long y = sc.nextLong();
        phanSo phanso = new phanSo(x, y);
        phanso.toiGian();
        System.out.println(phanso.toString());
    }
}
