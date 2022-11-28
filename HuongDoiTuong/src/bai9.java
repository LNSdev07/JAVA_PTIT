
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
class WordSet {

    private String s;

    public WordSet(String s) {
        this.s = s.toLowerCase();
    }

    public String getS() {
        return this.s;
    }

    public String union(WordSet s1) {
        TreeSet<String> set = new TreeSet<>();
        String[] arr1 = s.split("\\s+");
        String[] arr2 = s1.getS().split("\\s+");

        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        String result = "";
        for (String x : set) {
            result += x + " ";
        }
        return result;
    }

    public String intersection(WordSet s1) {
        TreeSet<String> set1 = new TreeSet<>();
        TreeSet<String> set2 = new TreeSet<>();

        String[] arr1 = s.split("\\s+");
        String[] arr2 = s1.getS().split("\\s+");

        for (int i = 0; i < arr1.length; i++) {
            set1.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            set2.add(arr2[i]);
        }
        String result = "";
        for (String x : set1) {
            if(set2.contains(x)){
                result += x +" ";
            }
        }
        return result;
    }

}

public class bai9 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
