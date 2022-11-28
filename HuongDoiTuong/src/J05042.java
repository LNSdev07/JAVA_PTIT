
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
class Submit {

    private String ten;
    private long a, b;

    public Submit() {
    }

    public Submit(String ten, long a, long b) {
        this.ten = ten;
        this.a = a;
        this.b = b;
    }

    public String getTen() {
        return ten;
    }

    public long getA() {
        return a;
    }

    public long getB() {
        return b;
    }

    @Override
    public String toString() {
        return this.ten + " " + this.a + " " + this.b;
    }

}

public class J05042 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Submit> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String ten = sc.nextLine();
            String s = sc.nextLine();
            String[] arr = s.split("\\s+");
            long a = Long.parseLong(arr[0]);
            long b = Long.parseLong(arr[1]);
            Submit submit = new Submit(ten, a, b);
            list.add(submit);
        }
        Collections.sort(list, (Submit o1, Submit o2) -> {
            if(o1.getA() != o2.getA()) return (int) (o2.getA()-o1.getA());
            else{
                if(o1.getB() != o2.getB()) return (int) (o1.getB() - o2.getB());
                else return o1.getTen().compareTo(o2.getTen());
            }            
        });
        list.forEach(x -> System.out.println(x.toString()));
    }
}
