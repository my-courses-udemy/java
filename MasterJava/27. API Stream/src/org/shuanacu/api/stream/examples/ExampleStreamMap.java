package org.shuanacu.api.stream.examples;

import org.shuanacu.api.stream.examples.models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleStreamMap {

    public static void main(String[] args) {
        Stream<User> names = Stream
                .of("Paco Guzman", "Pepe Gutierrez", "Santi Mena")
                .map(name -> new User(name.split(" ")[0], name.split(" ")[1]))
                .peek(System.out::println)
                .map(user -> {
                    user.setName(user.getName().toUpperCase());
                    user.setLastName(user.getLastName().toLowerCase());
                    return user;
                });
        List<User> list = names.collect(Collectors.toList());
        list.forEach(System.out::println);
//        names.forEach(System.out::println);

    }

}
