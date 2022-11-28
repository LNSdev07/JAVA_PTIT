
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
class Product{
    private static int count =1;
    private int id = count;
    private String name;
    private String donViTinh;
    private long giaMua;
    private long giaBan;

    public Product() {
        count++;
    }

    public Product(String name, String donViTinh, long giaMua, long giaBan) {
        count++;
        this.name = name;
        this.donViTinh = donViTinh;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }
    public long loiNhuan(){
        return this.giaBan - this.giaMua;
    }
    public String chuanHoaId(int n){
        String s = String.valueOf(n);
        while(s.length()<3){
            s = '0' + s;
        }
        s = "MH"+s;
        return s;
    }

    @Override
    public String toString() {
       return chuanHoaId(id) +" "+ this.name +" "+ this.donViTinh+ " "+ this.giaMua +" "+ this.giaBan+" " + this.loiNhuan();
    }
    
}
public class J05081 {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i=0; i<n; i++){
            String name = sc.nextLine();
            String donViTinh = sc.nextLine();
            long giaMua = Long.parseLong(sc.nextLine());
            long giaBan = Long.parseLong(sc.nextLine());
            Product product = new Product(name, donViTinh, giaMua, giaBan);
            list.add(product);
        }
        Collections.sort(list, new Comparator<Product>(){
            @Override
            public int compare(Product o1, Product o2) {
               return (int) (o2.loiNhuan() - o1.loiNhuan());
            }
        });
        for(Product x:list){
            System.out.println(x.toString());
        }
    }
}
