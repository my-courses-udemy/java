package org.shuanacu.api.stream.examples;

import java.util.stream.Stream;

public class ExampleStreamReduceIntegers {

    public static void main(String[] args) {
        Stream<Integer> names = Stream
                .of(5, 10, 6, 20, 30);

//        int result = names.reduce(0, (a, b) -> a + b);
        int result = names.reduce(0, Integer::sum);
        System.out.println(result);

    }

}
