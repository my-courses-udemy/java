package org.shuanacu.java8.lambda;

import java.util.Locale;
import java.util.function.Function;

public class ExampleFunction {

    public static void main(String[] args) {
        Function<String, String> function = param -> "Hi what's up " + param;

        String result = function.apply("Andres");
        System.out.println(result);

//        Function<String, String> funcion2 = param -> param.toUpperCase();
        Function<String, String> funcion2 = String::toUpperCase;
        System.out.println(funcion2.apply("Malcolm"));

    }

}
