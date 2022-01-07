package org.bo.optional.example;

import java.util.Optional;

public class ExampleOptional {

    public static void main(String[] args) {

//        Optionar not null created
        String name = "Andres";

        Optional<String> optional = Optional.of(name);
        System.out.println("optional = " + optional);
        System.out.println(optional.isPresent());
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }

        System.out.println(optional.isEmpty());

        optional.ifPresent(value -> System.out.println("Hello " + value));

//        Optionar null created
        name = null;
        optional = Optional.ofNullable(name);
        System.out.println("optional = " + optional);
        System.out.println(optional.isPresent());
        System.out.println(optional.isEmpty());

        optional.ifPresentOrElse(value -> System.out.println("Hello " + value),
                () -> System.out.println("It's not present"));

//        Optionar null created differently
        Optional<String> optionalEmpty = Optional.empty();
        System.out.println("optionalEmpty = " + optionalEmpty);
        System.out.println(optionalEmpty.isPresent());

    }

}
