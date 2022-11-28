
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class J03032 {
    public static String check(String s){
        StringBuilder sb = new StringBuilder("");
        String[] arr = s.split("\\s+");
        for(int i=0; i<arr.length; i++){
            StringBuilder sb1 = new StringBuilder(arr[i]);
            sb.append(sb1.reverse());
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while( t-- >0){
            String s = sc.nextLine();
            System.out.println(check(s));
        }
    }
}
