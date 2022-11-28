
import java.io.File;
import java.io.IOException;
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
class IntSet{
    private int[] a;

    public IntSet() {
    }

    public IntSet(int[] a) {
        this.a = a;
    }

    public int[] getA() {
        return a;
    }
    
    
    public TreeSet<Integer> getSet(){
        TreeSet<Integer> set = new TreeSet<>();
        for(int x : a){
            set.add(x);
        }
        return set;
    }
    
    public IntSet intersection(IntSet st2){
        TreeSet<Integer> rs = new TreeSet<>();
        for( int x : this.getSet()){
            rs.add(x);
        }
        
        for(int x : st2.getSet()){
            rs.add(x);
        }
        int[] a = new int[1001];
        int k =0;
        for(int x : rs){
           a[k] = x;
           k++;
        }
        IntSet tmp = new IntSet(a);
        return tmp;
    }

    @Override
    public String toString() {
        StringBuilder sb =new StringBuilder("");
        for(int x : this.getA()){
            if(x != 0) sb.append(x).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    
}
public class J04021 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.intersection(s2);
        System.out.println(s3);
    }
}
