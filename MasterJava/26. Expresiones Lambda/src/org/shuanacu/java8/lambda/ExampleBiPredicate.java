package org.shuanacu.java8.lambda;

import org.shuanacu.java8.lambda.models.User;

import java.util.function.BiPredicate;

public class ExampleBiPredicate {

    public static void main(String[] args) {
//        BiPredicate<String, String> test = (a,b) -> a.equals(b);
        BiPredicate<String, String> test = String::equals;
        System.out.println(test.test("a", "b"));

        BiPredicate<Integer, Integer> test2 = (a, b) -> a > b;
        System.out.println(test2.test(4, 6));

        User a = new User();
        User b = new User();
        a.setName("Maria");
        b.setName("Maria");

        BiPredicate<User, User> predicate = (ua, ub) -> ua.getName().equals(ub.getName());
        System.out.println(predicate.test(a, b));

    }

}