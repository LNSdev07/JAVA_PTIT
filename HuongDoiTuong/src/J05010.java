
import java.util.ArrayList;
import java.util.Collections;
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
class Product{
    private static int count =1;
    private int id = count;
    private String name;
    private String type;
    private double giaBan, giaMua;

    public Product() {
        count++;
    }

    public Product(String name, String type, double giaBan, double giaMua) {
        count++;
        this.name = name;
        this.type = type;
        this.giaBan = giaBan;
        this.giaMua = giaMua;
    }
    public double loiNhuan(){
        return this.giaBan - this.giaMua;
    }

    @Override
    public String toString() {
        return this.id +" "+ this.name +" "+ this.type +" "+ String.format("%.2f", this.loiNhuan());
    }
    
}
public class J05010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Product> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            String name = sc.nextLine();
            String type = sc.nextLine();
            double giaMua = Double.parseDouble(sc.nextLine());
            double giaBan = Double.parseDouble(sc.nextLine());
            Product product = new Product(name, type, giaBan, giaMua);
            list.add(product);
        }
        Collections.sort(list, (Product o1, Product o2) -> {
            if(o1.loiNhuan() >= o2.loiNhuan()) return -1;
            else return 1;           
        });
        list.forEach(x->System.out.println(x.toString()));
     
    }
}
