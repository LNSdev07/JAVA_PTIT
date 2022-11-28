
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
class Sophuc {

    private int phanThuc;
    private int phanAo;

    public Sophuc(int phanThuc, int phanAo) {
        this.phanThuc = phanThuc;
        this.phanAo = phanAo;
    }

    public Sophuc() {
    }

    public static Sophuc tong(Sophuc A, Sophuc B) {
        Sophuc tong = new Sophuc();
        tong.phanThuc = A.phanThuc + B.phanThuc;
        tong.phanAo = A.phanAo + B.phanAo;
        return tong;
    }

    public static Sophuc phep1(Sophuc A, Sophuc B) {
        Sophuc tong = tong(A, B);
        int x = tong.phanThuc * A.phanThuc - tong.phanAo * A.phanAo;
        int y = tong.phanThuc * A.phanAo + tong.phanAo * A.phanThuc;
        Sophuc New = new Sophuc(x, y);
        return New;
    }
    public static Sophuc phep2(Sophuc A, Sophuc B){
        Sophuc tong = tong(A, B);
        int x = tong.phanThuc * tong.phanThuc - tong.phanAo * tong.phanAo;
        int y = 2 * tong.phanAo * tong.phanThuc;
         Sophuc New = new Sophuc(x, y);
        return New;
    }

    public static void display1(Sophuc p) {
        String dau = null;
        if (p.phanAo <0){
            dau =" - ";
            p.phanAo = (-1)*p.phanAo;
        }
        else dau =" + ";
        System.out.print(p.phanThuc+" " +dau+" "+p.phanAo + "i, ");
    }
    public static void display2(Sophuc p) {
        String dau = null;
        if (p.phanAo <0){
            dau =" - ";
            p.phanAo = (-1)*p.phanAo;
        }
        else dau =" + ";
        System.out.println(p.phanThuc+" " +dau+" "+p.phanAo + "i");
    }
}

public class J04018 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- >0){
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        Sophuc p1 = new Sophuc(a, b);
        Sophuc p2 = new Sophuc(c, d);
        Sophuc tong = Sophuc.phep1(p1, p2);
        Sophuc tich = Sophuc.phep2(p1, p2);
        Sophuc.display1(tong);
        Sophuc.display2(tich);
        }
    }
}
