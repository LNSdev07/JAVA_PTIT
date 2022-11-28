
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
public class J02005 {

    public static void main(String[] args) {
        TreeSet<Integer> st1 = new TreeSet<>();
        TreeSet<Integer> st2 = new TreeSet<>();
        TreeSet<Integer> giao = new TreeSet<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i =0; i<n; i++){
            int x = sc.nextInt();
            st1.add(x);
        }
        
        for(int i =0; i<m; i++){
            int x = sc.nextInt();
            st2.add(x);
        }
        for(int x : st1){
            if(st2.contains(x)) giao.add(x);
        }
        for(int x : giao){
            System.out.print(x+" ");
        }
    }
}
