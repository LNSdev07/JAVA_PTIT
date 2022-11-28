
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
class Person {

    private String name;
    private String age;

    public Person() {

    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public int getYear() {
        int year = Integer.parseInt(this.age.substring(6, 10));
        return year;
    }

    public int getMonth() {
        return Integer.parseInt(this.age.substring(3, 5));
    }

    public int getDay() {
        return Integer.parseInt(this.age.substring(0, 2));
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name + " " + this.getYear() + " " + this.getMonth() + " " + this.getDay();
    }

}

class sortByAge implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getYear() != o2.getYear()) {
            return o2.getYear() - o1.getYear();
        } else {
            if (o1.getMonth() != o2.getMonth()) {
                return o2.getMonth() - o1.getMonth();
            } else {
                return o2.getDay() - o1.getDay();
            }
        }
    }

}

public class J05032 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] arr = s.split("\\s+");
            String name = arr[0];
            String age = arr[1];
            Person person = new Person(name, age);
            list.add(person);
        }
        Collections.sort(list, new sortByAge());
        System.out.println(list.get(0).getName());
        System.out.println(list.get(list.size()-1).getName());

    }
}
