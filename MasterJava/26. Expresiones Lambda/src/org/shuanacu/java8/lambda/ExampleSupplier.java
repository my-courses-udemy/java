package org.shuanacu.java8.lambda;

import org.shuanacu.java8.lambda.models.User;

import java.util.function.Supplier;

public class ExampleSupplier {

    public static void main(String[] args) {
        /*Supplier<String> supplier = () -> {
            return "Hello world";
        };*/
        Supplier<String> supplier = () -> "Hello world";

//        Supplier<User> createUser = () -> new User();
        Supplier<User> createUser = User::new;

        System.out.println(supplier.get());
        User user = createUser.get();
        System.out.println(user);
    }

}
