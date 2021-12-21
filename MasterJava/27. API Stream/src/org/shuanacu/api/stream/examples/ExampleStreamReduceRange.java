package org.shuanacu.api.stream.examples;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class ExampleStreamReduceRange {

    public static void main(String[] args) {
//        Allows to create a range of integers, rangeClosed() includes a last argument
//        Exist also to LongStream, DoubleStream
        IntStream number = IntStream
                .range(5, 20)
                .peek(System.out::println);

//        int result = names.reduce(0, (a, b) -> a + b);
//        int result = names.reduce(0, Integer::sum);
//        int result = number.sum();
        IntSummaryStatistics statistics = number.summaryStatistics();
        System.out.println("Max: " + statistics.getMax());
        System.out.println("Min: " + statistics.getMin());
        System.out.println("Sum: " + statistics.getSum());
        System.out.println("Average: " + statistics.getAverage());
        System.out.println("Total: " + statistics.getCount());

    }

}
