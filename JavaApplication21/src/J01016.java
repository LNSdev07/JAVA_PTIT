
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class J01016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int cnt =0;
        for(int i=0; i<s.length(); i++){
            int t = Integer.parseInt(String.valueOf(s.charAt(i)));
            if( t== 4 || t ==7) cnt++;
        }
        if(cnt ==4 || cnt ==7) System.out.println("YES");
        else System.out.println("NO");
    }
}
