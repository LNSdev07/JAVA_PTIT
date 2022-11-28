/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
class Person{
    protected String name, address;
    protected int age;

    public Person() {
    }

    public Person(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }
    
}
class Student extends Person{
    private String msv;
    private double  Gpa;

    public Student() {
    }

    public Student(String msv, double Gpa, String name, String address, int age) {
        super(name, address, age);
        this.msv = msv;
        this.Gpa = Gpa;
    }

    @Override
    public String toString() {
        return this.name+" "+ this.msv +" "+ this.Gpa;
    }
    
}
public class test {
    public static void main(String[] args) {
        Student st = new Student("B20DCCN575", 3.46 , "Lai Ngoc Son", "Thanh Hoa", 20);
        System.out.println(st);
    }
}
