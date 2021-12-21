package org.shuanacu.api.stream.examples;

import org.shuanacu.api.stream.examples.models.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleStreamFlatMap {

    public static void main(String[] args) {
        Stream<User> names = Stream
                .of("Paco Guzman", "Pepe Gutierrez", "Santi Mena", "Pepe Garcia")
                .map(name -> new User(name.split(" ")[0], name.split(" ")[1]))
                .flatMap(user -> {
                    if (user.getName().equalsIgnoreCase("Pepe")) {
                        return Stream.of(user);
                    }
                    return Stream.empty();
                })
                .peek(System.out::println);

        System.out.println(names.count());

    }

}
