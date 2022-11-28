
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
public class J03009 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1 = sc.nextLine().split("\\s+");
            String[] arr2 = sc.nextLine().split("\\s+");
            TreeSet<String> st1 = new TreeSet<>();
            TreeSet<String> st2 = new TreeSet<>();
            for(int i=0; i<arr1.length; i++){
                st1.add(arr1[i]);
            }
            for(int i=0; i<arr2.length; i++){
                st2.add(arr2[i]);
            }
            for(String x : st1){
                if(!st2.contains(x)) System.out.print(x +" ");
            }
            System.out.println("");
        }
    }
}
