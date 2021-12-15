package org.shuanacu.api.stream.examples;

import org.shuanacu.api.stream.examples.models.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleStreamFilterSingle {

    public static void main(String[] args) {
        Stream<User> names = Stream
                .of("Paco Guzman", "Pepe Gutierrez", "Santi Mena", "Pepe Garcia")
                .map(name -> new User(name.split(" ")[0], name.split(" ")[1]))
                .filter(user -> user.getName().equals("Pepe"));
//                .peek(System.out::println);

        Optional<User> user = names.findFirst();
//        orElse() and orElseGet() return a default user
//        System.out.println(user.orElse(new User("Jhon", "Dow")));
//        System.out.println(user.orElseGet(() -> new User("Jhon", "Dow")));

//        orElseThrow() return an exception
//        System.out.println(user.orElseThrow());

        /*if (user.isPresent()) {
            System.out.println(user.get());
        }*/
        user.ifPresent(System.out::println);

//        names.forEach(System.out::println);

    }

}
