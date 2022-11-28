
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class J03024 {
    public static int check(String s){
        if(s.charAt(0) == '0') return -1; 
        for (int i =0; i<s.length(); i++){
            if(Character.isAlphabetic(s.charAt(i))) return -1;
        }
        int n = s.length();
        int le =0, chan =0;
        for(int i =0; i<n; i++){
           int m = Integer.parseInt(String.valueOf(s.charAt(i)));
           if( m% 2 ==0) chan ++;
           else le ++;
        }
        if(le == chan) return 0;
        if( n % 2 ==0 && chan >le)  return 1;
        else if( n%2 !=0 && le > chan) return 1;
        else return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while( t-->0 ){
            String s = sc.nextLine();
            if(check(s) == -1) System.out.println("INVALID");
            else if(check(s) ==1) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
