package org.santihs.examples.map;

import java.util.*;

public class ExampleTreeMap {

    public static void main(String[] args) {

        // Treemap sort by key
        // Map<String, Object> person = new TreeMap<>((a, b) -> b.compareTo(a));
        Map<String, Object> person = new TreeMap<>(Comparator.comparing(String::length).reversed());

        // Does not exist null elements
        person.put("name", "Jhon");
        person.put("last name", "Doe");
        person.put("last name", "Roe");
        person.put("lastname", "Ross");
        person.put("email", "jhon@doe.com");
        person.put("age", "12");

        Map<String, String> address = new TreeMap<>();
        address.put("country", "USA");
        address.put("state", "California");
        address.put("city", "Sta. Barbara");
        address.put("street", "One Street");
        address.put("number", "120");

        String name = (String) person.get("name");
        String lastName = (String) person.get("last name");
        System.out.println("name = " + name);
        System.out.println("lastName = " + lastName);

        person.put("address", address);

        System.out.println("person = " + person);


    }

}
