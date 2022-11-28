
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class J03016 {
    public static int sovle(String s){
        int chan =0, le =0;
        for(int i=0; i<s.length(); i++){
            if(i %2 ==0) chan += Integer.parseInt(String.valueOf(s.charAt(i)));
            else le += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        if(Math.abs(le - chan) % 11 ==0) return 1;
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while( t-- >0){
            String s = sc.nextLine();
            System.out.println(sovle(s));
        }
    }
}
