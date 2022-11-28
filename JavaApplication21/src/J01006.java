
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class J01006 {

    public static long[] F = new long[94];

    public static long[] fibonaci() {
        F[1] = F[2] = 1;
        for (int i = 3; i <= 93; i++) {
            F[i] = F[i - 1] + F[i - 2];
        }
        return F;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        fibonaci();
        int t = sc.nextInt();
        while(t -- >0){
            boolean ok = false;
            long n = sc.nextLong();
            for(int i=0; i< F.length; i++){
                if(n == F[i]){
                    System.out.println("YES");
                    break;
                }
                else if( n< F[i]){
                    ok = true;
                    break;
                }
            }
            if(ok) System.out.println("NO");
        }
    }
}
