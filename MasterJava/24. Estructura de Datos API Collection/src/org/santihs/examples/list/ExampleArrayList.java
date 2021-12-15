package org.santihs.examples.list;

import org.santihs.examples.model.Student;

import java.util.*;

public class ExampleArrayList {

    public static void main(String[] args) {

        List<Student> al = new ArrayList<>();

        System.out.println(al.size() + " elements");
        System.out.println("The list is  empty: " + al.isEmpty());
        al.add(new Student("santi", 12));
        al.add(new Student("jose", 4));
        al.add(new Student("ruben", 1));

        // object with different references but with the same values
        al.add(2, new Student("marco", 8));
        // method set replace the value in position index
        al.set(3, new Student("marco", 4));

        System.out.println(al + ", size: " + al.size());

        // REMOVE FOR OBJECT
        al.remove(new Student("jose", 4));
        System.out.println(al + ", size: " + al.size());

        // REMOVE FOR INDEX
        al.remove(0);
        System.out.println(al + ", size: " + al.size());

        boolean b = al.contains(new Student("jose", 4));
        System.out.println("b = " + b);

        // convert to array
        Object []a = al.toArray();
        for (Object o : a) {
            System.out.println("o = " + o);
        }

    }

}
