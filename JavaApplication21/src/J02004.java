
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class J02004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] a = new int[n+1];
            for(int i=0; i<n; i++){
                a[i] = sc.nextInt();
            }
            boolean check = true;
            for(int i=0; i<n; i++){
                if(a[i] != a[n-i-1]){
                    System.out.println("NO");
                    check = false;
                    break;
                }
            }
            if(check) System.out.println("YES");
        }
    }
}
