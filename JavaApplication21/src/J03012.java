
import java.math.BigInteger;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class J03012 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
       
            BigInteger n, m, res;
            String a = sc.next();
            String b = sc.next();
            n = new BigInteger(a);
            m = new BigInteger(b);
            res = n.subtract(m);
            System.out.println(res.abs());
        
    }
}
