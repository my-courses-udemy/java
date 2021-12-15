package org.santihs.examples.map;

import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;

public class ExampleHashMap {

    public static void main(String[] args) {
        Map<String, String> person = new HashMap<>();

        // Map does not allow key duplicates, but if it allows values
        person.put(null, "1234");
        person.put(null, "12344");
        person.put("name", "Jhon");
        person.put("last name", "Doe");
        person.put("last name", "Roe");
        person.put("lastname", "Roe");
        person.put("email", "jhon@doe.com");
        person.put("age", "12");

        System.out.println("person = " + person);

        person.put(null, "hola");
        String date = person.put("name", "adios");
        System.out.println("date = " + date);
        
        String name = person.get("name");
        String lastName = person.get("last name");
        System.out.println("name = " + name);
        System.out.println("lastName = " + lastName);

    }

}
