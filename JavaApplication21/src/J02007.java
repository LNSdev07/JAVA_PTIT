
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class J02007 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int j=1; j<=t ;j++){
        int n = sc.nextInt();
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
              int x = sc.nextInt();
              if(map.containsKey(x)){
                  int tanSuat = map.get(x);
                  ++tanSuat;
                  map.put(x, tanSuat);
              }
              else{
                  int tanSuat =1;
                  map.put(x, tanSuat);
              }
        }
        Set<Integer> set = map.keySet();
            System.out.println("Test "+j+":");
        for(Integer key : set){
            System.out.println(key+ " xuat hien "+ map.get(key) +" lan");
        }
    }
   }
}
