package org.shuanacu.api.stream.examples;

import org.shuanacu.api.stream.examples.models.User;

import java.util.Optional;
import java.util.stream.Stream;

public class ExampleStreamFilterEmpty {

    public static void main(String[] args) {
        long count = Stream
                .of("Paco Guzman", "Pepe Gutierrez", "Santi Mena", "")
//                .filter(n -> n.isEmpty());
                .filter(String::isEmpty)
                .peek(System.out::println)
                .count();
        System.out.println("count = " + count);
    }

}
