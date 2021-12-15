package org.shuanacu.api.stream.examples;

import org.shuanacu.api.stream.examples.models.User;

import java.util.Optional;
import java.util.stream.Stream;

public class ExampleStreamDistinct {

    public static void main(String[] args) {
        Stream<String> names = Stream
                .of("Paco Guzman", "Pepe Gutierrez", "Pepe Gutierrez", "Pepe Garcia", "Pepe Gutierrez")
                .distinct();

        names.forEach(System.out::println);

    }

}
