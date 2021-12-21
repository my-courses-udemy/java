package org.shuanacu.api.stream.examples;

import org.shuanacu.api.stream.examples.models.User;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExampleStreamDistinctUserSum {

    public static void main(String[] args) {
        IntStream namesLength = Stream
                .of("Paco Guzman", "Pepe Gutierrez", "Santi Mena", "Pepe Garcia", "Paco Guzman")
                .map(name -> new User(name.split(" ")[0], name.split(" ")[1]))
                .distinct()
                .mapToInt(user -> user.toString().length())
                .peek(System.out::println);

//        namesLength.forEach(System.out::println);
        IntSummaryStatistics stats = namesLength.summaryStatistics();
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Min: " + stats.getMin());

    }

}
