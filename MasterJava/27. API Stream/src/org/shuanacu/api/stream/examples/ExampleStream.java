package org.shuanacu.api.stream.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ExampleStream {

    public static void main(String[] args) {
        Stream<String> names = Stream.of("Paco", "Pepe", "Santi");
//        names.forEach(name -> System.out.println(name));
//        names.forEach(System.out::println);

        String[] keys = {"Paco", "Pepe", "Santi"};
        names = Arrays.stream(keys);
//        names.forEach(System.out::println);

        Stream<String> names2 = Stream.<String>builder().add("Paco")
                .add("Pepe").add("Santi").build();
//        names.forEach(System.out::println);

        List<String> list = new ArrayList<>();
        list.add("Hi");
        list.add("How are you?");
        list.add("Bye");

        Stream<String> nameList = list.stream();
        names.forEach(System.out::println);

    }

}
