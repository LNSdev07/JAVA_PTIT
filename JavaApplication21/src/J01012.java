
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class J01012 {
    public static int Uoc(int n){
        int cnt =0;
        for(int i=1; i<= Math.sqrt(n); i++){
            if(n % i==0){
                if( i%2==0) cnt++;
                if(n/i != i && (n/i) %2 ==0) cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=  sc.nextInt();
        while( t-- >0){
            int n =sc.nextInt();
            System.out.println(Uoc(n));
        }
    }
}
