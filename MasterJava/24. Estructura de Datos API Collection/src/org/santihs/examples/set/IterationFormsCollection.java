package org.santihs.examples.set;

import org.santihs.examples.model.Student;

import java.util.*;

public class IterationFormsCollection {

    public static void main(String[] args) {
        // Set<Student> sa = new HashSet<>();
        List<Student>sa = new ArrayList<>();
        // List<Student>sa = new LinkedList<>();
        // Set<Student> sa = new TreeSet<>(Comparator.comparing(Student::getName));
        sa.add(new Student("santi", 12));
        sa.add(new Student("jose", 4));
        sa.add(new Student("ruben", 1));

        // object with different references but with the same values
        sa.add(new Student("marco", 8));
        sa.add(new Student("marco", 4));

        System.out.println("sa = " + sa);

        System.out.println("iterating using for each");
        for (Student student : sa) {
            System.out.println("student = " + student.getName());
        }

        System.out.println("iterating using while and Iterator");
        Iterator<Student> it = sa.iterator();
        while (it.hasNext()){
            Student student = it.next();
            System.out.println("student = " + student.getName());
        }

        System.out.println("iterating using method for each");
        // sa.forEach(a -> System.out.println("a = " + a.getName()));
        sa.forEach(System.out::println);

        System.out.println("iterating using classic for");
        for (int index = 0; index < sa.size(); index++) {
            System.out.println(sa.get(index));
        }

    }

}
