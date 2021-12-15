package org.shuanacu.java8.lambda;

import org.shuanacu.java8.lambda.models.User;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ExampleConsumer {

    public static void main(String[] args) {
        Consumer<Date> consumer = date -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(simpleDateFormat.format(date));
        };

        BiConsumer<String, Integer> biConsumer = (name, age) -> System.out.printf("Name: %s, Age: %s%n", name, age);

        Consumer<String> consumer2 = System.out::println;

        consumer.accept(new Date());
        biConsumer.accept("Santi", 20);
        consumer2.accept("Hi world");

        List<String> names = Arrays.asList("andres", "pepe", "luz");
        names.forEach(consumer2);

        User user = new User();
        /*BiConsumer<User, String> assignName = (person, name) -> {
            person.setName(name);
        };*/
        BiConsumer<User, String> assignName = User::setName;

        assignName.accept(user, "andres");
        System.out.println(user);
    }

}
