package org.shuanacu.api.stream.examples;

import org.shuanacu.api.stream.examples.models.User;

import java.util.stream.Stream;

public class ExampleStreamFilterAnyMatch {

    public static void main(String[] args) {
//        anyMatch return a boolean if the object exist
        boolean exist = Stream
                .of("Paco Guzman", "Pepe Gutierrez", "Santi Mena", "Pepe Garcia")
                .map(name -> new User(name.split(" ")[0], name.split(" ")[1]))
                .peek(System.out::println)
                .anyMatch(u -> u.getId().equals(8));
//                .peek(System.out::println);

        System.out.println(exist);
//        names.forEach(System.out::println);

    }

}
