
import java.util.Scanner;
import java.util.TreeSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class J02006 {

    public static void main(String[] args) {
        TreeSet<Integer> hop = new TreeSet<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            hop.add(x);
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            hop.add(x);
        }

        for (int x : hop) {
            System.out.print(x + " ");
        }
    }
}
