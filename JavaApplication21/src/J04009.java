
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
class Point {

    private double x;
    private double y;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(Point secondPoint) {
        double distance = Math.sqrt((this.x - secondPoint.x) * (this.x - secondPoint.x) + (this.y - secondPoint.y) * (this.y - secondPoint.y));
        return distance;
    }

    public double distance(Point p1, Point p2) {
        double distance = Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
        return distance;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }

}


public class J04009 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();
        Point point1 = new Point(x1, y1);
        Point point2 = new Point(x2, y2);
        Point point3 = new Point(x3, y3);
        double c = point1.distance(point2);
        double a = point2.distance(point3);
        double b = point1.distance(point3);
        if (a + b <= c || a + c <= b || b + c <= a){
            System.out.println("INVALID");
        }
        else {
            double CV = a + b + c;
            double p = CV/2;
            double S = Math.sqrt(p*(p-a)*(p-b)*(p-c));
            System.out.printf("%.2f", S);
            System.out.println("");
        }
      }
    }
}
