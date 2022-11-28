
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
class Point3D{
    private int x, y, z;

    public Point3D() {
    }

    public Point3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Point3D(Scanner sc1, Scanner sc2, Scanner sc3){
        this.x = sc1.nextInt();
        this.y = sc2.nextInt();
        this.x = sc3.nextInt();
    }
    public static Point3D caculate(Point3D p1, Point3D p2){
        
        int x = p1.x - p2.x;
        int y = p1.y - p2.y;
        int z = p1.z - p2.z;
        Point3D newPoint3D = new Point3D(x, y, z);
        return newPoint3D;
    }
    public static Point3D tichCoHuong(Point3D p1, Point3D p2){
        int x = p1.y * p2.z - p1.z * p2.y;
        int y = p1.z * p2.x - p1.x * p2.z;
        int z = p1.x * p2.y - p1.y * p2.x;
        Point3D newPoint3D = new Point3D(x, y, z);
        return newPoint3D;
    }
    public static boolean check(Point3D p1, Point3D p2, Point3D p3, Point3D p4){
        Point3D p1P2 = caculate(p1, p2);
        Point3D p1P3 = caculate(p1, p3);
        Point3D p1P4 = caculate(p1, p4);
        Point3D coHuong = tichCoHuong(p1P2, p1P3);
        int result = coHuong.x * p1P4.x + coHuong.y * p1P4.y + coHuong.z * p1P4.z ;
        if (result ==0) return true;
        else return false;
    }
}
public class J04011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
        Point3D p1 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
        Point3D p2 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
        Point3D p3 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
        Point3D p4 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
        
        if(Point3D.check(p1,p2,p3,p4)){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
        }
    }
}
