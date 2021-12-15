package org.shuanacu.java8.lambda;

import java.util.function.Predicate;

public class ExamplePredicate {

    public static void main(String[] args) {
        Predicate<Integer> test = number -> number > 10;
        boolean result = test.test(11);

        System.out.println(result);

//        Predicate<String> test2 = role -> role.equals("ROLE_ADMIN");
        Predicate<String> test2 = role -> role.equals("ROLE_ADMIN");
        System.out.println(test2.test("ROLE_ADMIN"));
    }

}
