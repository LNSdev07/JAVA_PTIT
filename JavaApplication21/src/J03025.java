
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class J03025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while( t-- >0){
            String s = sc.next();
           StringBuilder sb = new StringBuilder(s);
           if( sb.reverse().equals(s)) System.out.println("YES");
           else System.out.println("NO");
        }
    }
}
