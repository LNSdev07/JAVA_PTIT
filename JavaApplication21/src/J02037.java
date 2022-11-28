
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class J02037 {
    public static boolean check( Stream<String> list){
        List<Integer> newList = list.map(x -> Integer.parseInt(x)).collect(Collectors.toList());
        int n = newList.size();
        int chan  = 0, le =0;
        for(int i=0; i<n; i++){
            if(newList.get(i) % 2 ==0) chan ++;
            else le ++;
        }
        if( n %2 ==0 && chan > le) return true;
        else if(n %2 !=0 && le > chan) return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- >0){
            String s = sc.nextLine();
            String[] arr = s.split("\\s+");
            Stream<String> list = Arrays.stream(arr);
            if(check(list)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
