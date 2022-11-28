
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
class Employee {

    private final static String mnv = "00001";
    private String fullName;
    private String gender;
    private String birth;
    private String address;
    private String rent, ngayKi;

    public Employee() {

    }

    public Employee(String fullName, String gender, String birth, String address, String rent, String ngayKi) {
        this.fullName = fullName;
        this.gender = gender;
        this.birth = birth;
        this.address = address;
        this.rent = rent;
        this.ngayKi = ngayKi;
    }

    @Override
    public String toString() {
        return mnv + " " + this.fullName + " " + this.gender + " " + this.birth + " "
                + this.address + " " + this.rent + " " + this.ngayKi;
    }

}

public class J04007 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fullName = sc.nextLine();
        String gender = sc.nextLine();
        String birth = sc.nextLine();
        String address = sc.nextLine();
        String rent = sc.nextLine();
        String ngayKi = sc.nextLine();
        Employee employee = new Employee(fullName, gender, birth, address, rent, ngayKi);
        System.out.println(employee.toString());
    }
}
