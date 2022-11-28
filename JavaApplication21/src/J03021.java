
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class J03021 {
    public static int[] a = new int[1000];
    public  static void init(){
        a['a'] = a['b'] = a['c'] =2;
        a['d'] = a['e'] = a['f'] =3;
        a['g'] = a['h'] = a['i'] =4;
        a['j'] = a['l'] = a['k'] = 5;
        a['m'] = a['n'] = a['o'] =6;
        a['p'] = a['q'] =a['r'] = a['s'] = 7;
        a['t'] = a['u'] = a['v'] =8;
        a['w'] = a['x'] = a['y'] = a['z'] =9;
    }
    public static void check(String s, int[] a){
        String res = s.toLowerCase();
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<res.length(); i++){
           sb.append(a[res.charAt(i)]);
        }
        boolean ok = true;
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i) != sb.charAt(sb.length()-i-1)){
                System.out.println("NO");
                ok =  false;
                break;
            }
        }
        if(ok) System.out.println("YES");
   
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        init();
        int t =  Integer.parseInt(sc.nextLine());
        while(t-- >0){
            String s = sc.nextLine();
            check(s,a);
        }
    }
}
