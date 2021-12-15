package org.shuanacu.java8.lambda;

import java.util.function.BiFunction;

public class ExampleBiFunction {

    public static void main(String[] args) {

        BiFunction<String, String, String> function = (a, b) -> a.toUpperCase().concat(b.toLowerCase());

        String result = function.apply("Andres", "Jose");
        System.out.println(result);

//        BiFunction<String, String, Integer> function2 = (a,b) -> a.compareTo(b);
        BiFunction<String, String, Integer> function2 = String::compareTo;
        System.out.println(function2.apply("andres", "andres2"));

    }

}
