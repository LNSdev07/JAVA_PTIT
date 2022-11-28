
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class J01003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if ( a ==0 && b !=0 ) System.out.println("VN");
        else if (a ==0 && b ==0) System.out.println("VSN");
        else{
            String s = String.format("%.2f", (double)b/-a);
            System.out.println(s);
        }
    }
}
