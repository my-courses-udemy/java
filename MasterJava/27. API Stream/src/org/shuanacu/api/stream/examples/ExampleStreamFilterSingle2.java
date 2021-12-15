package org.shuanacu.api.stream.examples;

import org.shuanacu.api.stream.examples.models.User;

import java.util.Optional;
import java.util.stream.Stream;

public class ExampleStreamFilterSingle2 {

    public static void main(String[] args) {
//        return a object
        User user2 = Stream
                .of("Paco Guzman", "Pepe Gutierrez", "Santi Mena", "Pepe Garcia")
                .map(name -> new User(name.split(" ")[0], name.split(" ")[1]))
                .peek(System.out::println)
                .filter(u -> u.getId().equals(2))
                .findFirst().get();
//                .peek(System.out::println);

        System.out.println(user2);
//        names.forEach(System.out::println);

    }

}
