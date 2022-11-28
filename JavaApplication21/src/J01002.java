
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class J01002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while( t-- >0){
          long n = sc.nextLong();
          long s = (long)(n*(n+1)/2);
          System.out.println(s);
      }
   }
}
