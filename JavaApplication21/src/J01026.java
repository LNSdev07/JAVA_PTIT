
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class J01026 {
    public static boolean check(long n){
        double sq = Math.sqrt(n);
        return ((sq - Math.floor(sq)) == 0);
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
