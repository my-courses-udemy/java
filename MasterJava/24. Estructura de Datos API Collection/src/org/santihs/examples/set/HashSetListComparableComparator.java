package org.santihs.examples.set;

import org.santihs.examples.model.Student;

import java.util.*;

public class HashSetListComparableComparator {

    public static void main(String[] args) {

        List<Student> sa = new ArrayList<>();

        sa.add(new Student("santi", 12));
        sa.add(new Student("jose", 4));
        sa.add(new Student("ruben", 1));

        // object with different references but with the same values
        sa.add(new Student("marco", 8));
        sa.add(new Student("marco", 4));

        // Collections.sort(sa, (a,b) -> b.getNota().compareTo(a.getNota()));
        // sa.sort((a, b) -> b.getNota().compareTo(a.getNota()));
        // sa.sort(Comparator.comparing((Student c) -> c.getNota()));
        // sa.sort(Comparator.comparing((Student c) -> c.getNota()).reversed());
        sa.sort(Comparator.comparing(Student::getName));

        System.out.println("sa = " + sa);

        System.out.println("iterating using method for each");
        // sa.forEach(a -> System.out.println("a = " + a.getName()));
        sa.forEach(System.out::println);

        System.out.println("iterating using classic for");
        for (int index = 0; index < sa.size(); index++) {
            System.out.println(sa.get(index));
        }

    }

}
