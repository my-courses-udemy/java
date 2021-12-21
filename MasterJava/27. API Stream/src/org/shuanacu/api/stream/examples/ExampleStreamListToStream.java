package org.shuanacu.api.stream.examples;

import org.shuanacu.api.stream.examples.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ExampleStreamListToStream {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("Andres", "Guzman"));
        list.add(new User("Luci", "Martinez"));
        list.add(new User("Pepe", "Fernandez"));
        list.add(new User("Cata", "Perez"));
        list.add(new User("Lalo", "Mena"));
        list.add(new User("Ezequiel", "Doe"));
        list.add(new User("Bruce", "Lee"));
        list.add(new User("Bruce", "Wilson"));

        Stream<String> names = list.stream()
                .map(user -> user.getName().toUpperCase()
                        .concat(" ")
                        .concat(user.getLastName().toUpperCase()))
                .flatMap(name -> {
                    if (name.contains("bruce".toUpperCase())) {
                        return Stream.of(name);
                    }
                    return Stream.empty();
                })
                .peek(System.out::println);

        System.out.println(names.count());
    }

}
