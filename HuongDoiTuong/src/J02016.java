
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class J02016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt =0;
        for(int i=0; i<n; i++){
            int dem1 =0, dem0 =0;
            for(int j=0; j<3; j++){
               int x = sc.nextInt();
               if(x ==1) dem1++;
               else dem0++;
            }
            if(dem1 > dem0) cnt++;
        }
        System.out.println(cnt);
     }
}
