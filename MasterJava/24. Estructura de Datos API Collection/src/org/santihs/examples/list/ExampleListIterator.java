package org.santihs.examples.list;

import org.santihs.examples.model.Student;

import java.util.LinkedList;
import java.util.ListIterator;

public class ExampleListIterator {

    public static void main(String[] args) {

        LinkedList<Student> enlazada = new LinkedList<>();

        System.out.println(enlazada.size() + " elements");
        System.out.println("The list is  empty: " + enlazada.isEmpty());
        enlazada.add(new Student("santi", 12));
        enlazada.add(new Student("jose", 4));
        enlazada.add(new Student("ruben", 1));

        // object with different references but with the same values
        enlazada.add(new Student("marco", 8));
        // method set replace the value in position index
        enlazada.add(new Student("marco", 4));

        System.out.println(enlazada + ", size: " + enlazada.size());

        enlazada.addFirst(new Student("alvaro", 10));
        enlazada.addLast(new Student("yess", 2));

        System.out.println(enlazada + ", size: " + enlazada.size());

        // throw an exception
        System.out.println("First: " + enlazada.getFirst());
        System.out.println("Last: " + enlazada.getLast());
        // does not throw an exception, return null if is empty
        System.out.println("First: " + enlazada.peekFirst());
        System.out.println("Last: " + enlazada.peekLast());

        // throw an exception
        Student first = enlazada.removeFirst();
        Student last = enlazada.removeLast();
        // does not throw an exception, return null if is empty
        // enlazada.pollFirst();
        // enlazada.pollLast();

        System.out.println(enlazada + ", size: " + enlazada.size());

        Student newStudent = new Student("Lucas", 2);
        enlazada.add(newStudent);

        System.out.println(enlazada + ", size: " + enlazada.size());
        System.out.println("Indice de Lucas:" + enlazada.indexOf(newStudent));

        enlazada.removeLast();
        System.out.println(enlazada + ", size: " + enlazada.size());

        enlazada.set(4, new Student("Alex", 10));
        System.out.println(enlazada + ", size: " + enlazada.size());

        enlazada.clear();
        ListIterator<Student> li = enlazada.listIterator();

        System.out.println("===== Next ====="); // [12,3,4,5]
        while (li.hasNext()) {
            System.out.println(li.next());
        }
        System.out.println("===== Previous =====");
        while (li.hasPrevious()){
            System.out.println(li.previous());
        }


    }

}
