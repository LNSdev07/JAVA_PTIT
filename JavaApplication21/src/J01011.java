
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class J01011 {
    public static long GCD(long a, long b){
        if ( b ==0) return a;
        return  GCD(b, a%b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while( t--> 0){
            long a = sc.nextInt();
            long b = sc.nextInt();
            long gcd = GCD(a, b);
            long lcm = a*(b/gcd);
            System.out.println(lcm +" "+ gcd);
        }
    }
}
