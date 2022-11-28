
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
class Rectange{
    private double width;
    private double height;
    private String color;

    public Rectange() {
    }

    public Rectange(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
    public String chuanHoa(String s){
        StringBuilder sb = new StringBuilder("");
        for ( int i =0; i<s.length(); i++){
            if (i == 0){
                sb.append(Character.toUpperCase(s.charAt(i)));
            }
            else sb.append(Character.toLowerCase(s.charAt(i)));
        }
        return sb.toString();
    }

    public String getColor() {
        return chuanHoa(this.color);
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double findArea(){
        double area = this.height * this.width;
        return area;
    }
    public double findPerimeter(){
        double perimeter = (this.height + this.width) * 2;
        return perimeter;
    }
    @Override
    public String toString() {
        return  String.format("%.0f",findPerimeter()) +" "+ String.format("%.0f",findArea()) +" "+this.chuanHoa(color);
    }
}
public class J04002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double width = sc.nextDouble();
        double height =sc.nextDouble();
        String color = sc.next();
        Rectange rectange = new Rectange(width, height, color);
        if(width >0 && height >0){
            System.out.println(rectange.toString());
        }
        else System.out.println("INVALID");
    }
}
