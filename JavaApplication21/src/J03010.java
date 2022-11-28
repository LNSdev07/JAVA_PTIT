
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class J03010 {
    public static Map<String, Integer> map = new HashMap<>();
    public static String demTanSuat(String s){
        if(map.containsKey(s)){
            int tanSuat = map.get(s);
            ++tanSuat;
            map.put(s, tanSuat);
            return ""+tanSuat;
        }
        else{
            int tanSuat =1;
            map.put(s, tanSuat);
            return "";
        }
    }
    public static String chuanHoa(String s){
        s = s.trim();
        String[] arr = s.split("\\s+");
        for(int i=0; i<arr.length; i++){
            arr[i] = arr[i].toLowerCase();
        }
        String res = arr[arr.length-1];
        for(int i=0; i<arr.length-1; i++){
            res += arr[i].charAt(0);
        }
        return res+=demTanSuat(res)+"@ptit.edu.vn";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t -- >0){
            String s = sc.nextLine();
            System.out.println(chuanHoa(s));
        }
    }
}
