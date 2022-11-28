
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class J01017 {
    public static boolean check(long n){
        int a = (int) (n%10);
        n/=10;
        int sum =a;
        while(n >0){
            int b = (int) (n%10);
            sum+=b;
            if(Math.abs(a -b) != 2) return false;
            else a = b;
            n/=10;
        }
        if( sum %10 !=0) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while( t-- >0){
            long n = sc.nextLong();
            if(check(n)) System.out.println("YES");
            else System.out.println("NO");        
        }
    }
}
