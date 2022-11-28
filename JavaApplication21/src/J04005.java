
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
class thiSinh {

    private String fullName;
    private String dateOfBirth;
    private double sb1, sb2, sb3;

    public thiSinh() {
    }

    public thiSinh(String fullName, String dateOfBirth, double sb1, double sb2, double sb3) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.sb1 = sb1;
        this.sb2 = sb2;
        this.sb3 = sb3;
    }
    public double getSum(){
        return this.sb1 + this.sb2 + this.sb3;
    }

    @Override
    public String toString() {
       return this.fullName +" "+ this.dateOfBirth + " "+ String.format("%.1f", this.getSum());
    }
    
}

public class J04005 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fullName = sc.nextLine();
        String dateOfBirth = sc.next();
        double sb1 = sc.nextDouble();
        double sb2 = sc.nextDouble();
        double sb3 = sc.nextDouble();
        thiSinh thisinh  = new thiSinh(fullName, dateOfBirth, sb1, sb2, sb3);
        System.out.println(thisinh.toString());
    }
}
