package org.shuanacu.api.stream.examples;

import java.util.stream.Stream;

public class ExampleStreamReduce {

    public static void main(String[] args) {
        Stream<String> names = Stream
                .of("Paco Guzman", "Pepe Gutierrez", "Pepe Gutierrez", "Pepe Garcia", "Pepe Gutierrez")
                .distinct();

        String result = names.reduce("Hello:", (a, b) -> a + ", " + b);
        System.out.println(result);

    }

}
