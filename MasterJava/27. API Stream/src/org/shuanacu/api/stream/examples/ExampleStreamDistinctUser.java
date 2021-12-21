package org.shuanacu.api.stream.examples;

import org.shuanacu.api.stream.examples.models.User;

import java.util.Optional;
import java.util.stream.Stream;

public class ExampleStreamDistinctUser {

    public static void main(String[] args) {
        Stream<User> names = Stream
                .of("Paco Guzman", "Pepe Gutierrez", "Santi Mena", "Pepe Garcia", "Paco Guzman")
                .map(name -> new User(name.split(" ")[0], name.split(" ")[1]))
                .distinct();
//                .peek(System.out::println);

        names.forEach(System.out::println);

    }

}
