

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
public class J02304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            set.add(x);
        }
        boolean check = true;
        int max = set.last();
        TreeSet<Integer> set1 = new TreeSet<>();
        for(int i=1; i<= max; i++){
            set1.add(i);
        }
        for( Integer x : set1){
            if(!set.contains(x)){
                System.out.println(x);
                check = false;
            }
      
        }
        if (check) System.out.println("Excellent!");
    }
}
