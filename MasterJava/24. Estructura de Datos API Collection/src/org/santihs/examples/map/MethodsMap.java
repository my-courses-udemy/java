package org.santihs.examples.map;

import java.util.*;

public class MethodsMap {

    public static void main(String[] args) {

        Map<String, String> person = new HashMap<>();

        // Map does not allow key duplicates, but if it allows values
        person.put(null, "1234");
        person.put(null, "12344");
        person.put("name", "Jhon");
        person.put("last name", "Doe");
        person.put("last name", "Roe");
        person.put("lastname", "Ross");
        person.put("email", "jhon@doe.com");
        person.put("age", "12");

        System.out.println("person = " + person);

        String name = person.get("name");
        String lastName = person.get("last name");
        System.out.println("name = " + name);
        System.out.println("lastName = " + lastName);

        lastName = person.remove("lastname");
        System.out.println("deleted = " + lastName);
        System.out.println("person = " + person);

        boolean deleted = person.remove("last name", "Roe");
        System.out.println("deleted = " + deleted);
        System.out.println("person = " + person);

        boolean containKey = person.containsKey("lastname");
        System.out.println("containKey = " + containKey);

        boolean containValue = person.containsValue("Jhon");
        System.out.println("containValue = " + containValue);

        System.out.println("=== Values ===");
        Collection<String> values = person.values();
        values.forEach(System.out::println);

        System.out.println("=== Keys ===");
        Set<String> keys = person.keySet();
        keys.forEach(System.out::println);

        System.out.println("=== Iteration key and value using Map.Entry<T> ===");
        for(Map.Entry<String, String> par: person.entrySet()){
            System.out.println(par.getKey() + " -> " + par.getValue());
        }

        System.out.println("=== Iteration key and value using keySet() ===");
        for(String key : person.keySet()){
            String value = person.get(key);
            System.out.println(key + " -> " + value);
        }

        System.out.println("=== Iteration key and value using forEach ===");
        person.forEach(((key, value) -> System.out.println(key + " -> " + value)));

        System.out.println("Size: "+  person.size());
        
        person.replace("name", "Jose");
        System.out.println("person = " + person);
        person.replace("name", "Jhon", "Marco");

    }

}
