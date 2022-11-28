
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class J01005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while( t-- >0){
        int n = sc.nextInt();
        int h = sc.nextInt();
        for(int i=1; i<=n-1; i++){
            double result = (h * Math.sqrt((double)i/n));
            System.out.printf("%.6f ",result );
        }
            System.out.println("");
        }
    }
}
