
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class J04014 {
    private long tuSo;
    private long mauSo;

    public J04014() {
    }

    public J04014(long tuSo, long mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }
    public static long gcd(long a, long b){
        if(b ==0) return a;
        else return gcd(b, a%b);
    }
    public void rutGon(){
        long x = gcd(tuSo, mauSo);
        tuSo /= x;
        mauSo /=x;
    }
    public  static J04014 tongBinhPhuong(J04014 ps1, J04014 ps2){
        J04014 p = new J04014();
        ps1.rutGon(); ps2.rutGon();
        long x = ps1.tuSo * ps2.mauSo + ps2.tuSo * ps1.mauSo;
        long y = ps1.mauSo * ps2.mauSo;
        long z = gcd(x, y);
        p.tuSo = x/z;
        p.mauSo = y/z;
        p.tuSo *= p.tuSo;
        p.mauSo*=p.mauSo;
        return p;
    }
    public static J04014 Tich(J04014 ps1, J04014 ps2){
        J04014 ps3 = tongBinhPhuong(ps1, ps2);
        long x = ps1.tuSo * ps2.tuSo * ps3.tuSo;
        long y = ps1.mauSo * ps2.mauSo * ps3.mauSo;
        long z = gcd(x, y);
        J04014 p = new J04014();
        p.tuSo = x/z;
        p.mauSo = y/z;
        return p;
    }
    public  static void display(J04014 p){
        System.out.print(p.tuSo + "/" + p.mauSo +" ");
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while(q-- >0){
        long x = sc.nextInt();
        long y = sc.nextInt();
        long z = sc.nextInt();
        long t = sc.nextInt();
        J04014 A = new J04014(x, y);
        J04014 B = new J04014(z, t);
        J04014 sum = tongBinhPhuong(A, B);
        display(sum);
        J04014 mul = Tich(A,B);
        display(mul);
        System.out.println("");
        }
   }
}
