package org.santihs.examples.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTypeObject {

    public static void main(String[] args) {

        Map<String, Object> person = new HashMap<>();

        // Map does not allow key duplicates, but if it allows values
        person.put(null, "1234");
        person.put(null, "12344");
        person.put("name", "Jhon");
        person.put("last name", "Doe");
        person.put("last name", "Roe");
        person.put("lastname", "Ross");
        person.put("email", "jhon@doe.com");
        person.put("age", "12");

        Map<String, String> address = new HashMap<>();
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

        Map<String, String> addressPerson = (Map<String, String>) person.get("address");
        String country = addressPerson.get("country");
        String city = addressPerson.get("city");
        String neighborhood = addressPerson.getOrDefault("neighborhood", "beach");
        System.out.println("The country's " + name + " is: " + country + ", your city is: " + city + " and your neighborhood is: " + neighborhood);

        lastName = (String) person.remove("lastname");
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
        Collection<Object> values = person.values();
        values.forEach(System.out::println);

        System.out.println("=== Keys ===");
        Set<String> keys = person.keySet();
        keys.forEach(System.out::println);

        System.out.println("=== Iteration key and value using Map.Entry<T> ===");
        for (Map.Entry<String, Object> par : person.entrySet()) {
            Object value = par.getValue();
            if (value instanceof Map) {
                Map<String, String> addressMap = (Map<String, String>) person.get(par.getKey());
                System.out.println("addressMap = " + addressMap);
            } else {
                System.out.println(par.getKey() + " -> " + value);
            }
        }

        System.out.println("=== Iteration key and value using keySet() ===");
        for (String key : person.keySet()) {
            Object value = person.get(key);
            if (value instanceof Map) {
                Map<String, String> addressMap = (Map<String, String>) person.get(key);
                System.out.println("addressMap = " + addressMap);
            } else {
                System.out.println(key + " -> " + value);
            }
        }

        System.out.println("=== Iteration key and value using forEach ===");
        person.forEach(((key, value) -> System.out.println(key + " -> " + value)));

        System.out.println("Size: " + person.size());

        person.replace("name", "Jose");
        System.out.println("person = " + person);
        person.replace("name", "Jhon", "Marco");

    }

}
