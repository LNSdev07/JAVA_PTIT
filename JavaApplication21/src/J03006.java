
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class J03006 {
    public static boolean isPrime(int n){
        if( n==2 || n ==5 || n==3 || n==7) return true;
        return false;
    }
    public static boolean check(String s){
        StringBuilder sb = new StringBuilder(s);
        StringBuilder res = sb.reverse();
        res.toString();
        int sum =0;
        for(int i=0; i<s.length(); i++){
            if(!isPrime(Integer.parseInt(String.valueOf(s.charAt(i))))) return false;
        }
        if( s.compareTo(res.toString()) ==0 ) return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- >0){
            String s = sc.nextLine();
            if( check(s)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
