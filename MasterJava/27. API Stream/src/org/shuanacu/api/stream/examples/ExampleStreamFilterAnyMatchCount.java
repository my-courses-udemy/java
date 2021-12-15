package org.shuanacu.api.stream.examples;

import org.shuanacu.api.stream.examples.models.User;

import java.util.stream.Stream;

public class ExampleStreamFilterAnyMatchCount {

    public static void main(String[] args) {
//        count() return the number of elementsy
        long count = Stream
                .of("Paco Guzman", "Pepe Gutierrez", "Santi Mena", "Pepe Garcia")
                .map(name -> new User(name.split(" ")[0], name.split(" ")[1]))
                .peek(System.out::println)
                .count();
//                .peek(System.out::println);

        System.out.println(count);
//        names.forEach(System.out::println);

    }

}
