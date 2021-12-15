package org.shuanacu.api.stream.examples;

import org.shuanacu.api.stream.examples.models.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleStreamFilter {

    public static void main(String[] args) {
        Stream<User> names = Stream
                .of("Paco Guzman", "Pepe Gutierrez", "Santi Mena", "Pepe Garcia")
                .map(name -> new User(name.split(" ")[0], name.split(" ")[1]))
                .filter(user -> user.getName().equals("Pepe"));
//                .peek(System.out::println);
        List<User> list = names.collect(Collectors.toList());
        list.forEach(System.out::println);
//        names.forEach(System.out::println);

    }

}
