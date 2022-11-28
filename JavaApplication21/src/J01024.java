
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class J01024 {
    public static boolean check(int n){
            while(n >0){
                int m = n%10;
                n/=10;
                if(m !=0 & m!=2 & m!= 1) return false;
            }
            return true;
        }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while (t-- >0){
            int n  = sc.nextInt();
            if( check(n)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
