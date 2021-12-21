package org.shuanacu.api.stream.examples.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ModifiedFlow {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        int i = 1;
        while (i < 101) {
            numbers.add(i++);
        }

        Stream<Double> newNumbers = numbers.stream()
                .filter(number -> number % 10 != 0)
                .map(number -> Double.valueOf(number) / 2);

        double result = newNumbers.reduce((double) 0, Double::sum);
        System.out.println(result);
    }

}
