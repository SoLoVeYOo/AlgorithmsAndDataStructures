package lesson4;

import java.security.Key;
import java.util.*;
import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        Employee e11 = new Employee("BBBBB", 33);
        System.out.println(e11.hashCode());

        Employee e22 =new Employee("AAA", 22);
        System.out.println(e22.hashCode());

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(2, "AAA");
        hashMap.put(2, "BBB");
        hashMap.put(null, "BBB");
        String s = hashMap.put(null, "CCC");

        for (Map.Entry<Integer, String > item : hashMap.entrySet()){

        }

        lesson4.HashMap<String, Employee> hashMap1 = new lesson4.HashMap<>();
        Employee e1 = hashMap1.put("abc", new Employee("Employee1", 34));
        Employee e2 = hashMap1.put("abcd", new Employee("Employee2", 31));
        Employee e3 = hashMap1.put("abc", new Employee("Employee3", 44));
        Employee e4 = hashMap1.put("abcde", new Employee("Employee4", 35));

        Employee e5 = hashMap1.remove("abc");
        Employee e6 = hashMap1.remove("abc");

        Employee e7 = hashMap1.get("abc");
        Employee e8 = hashMap1.get("abcde");
    }

}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
