package org.shuanacu.java8.lambda.arithmetic;

import java.util.function.BiFunction;

public class Calculator {

    public double calculate(double a, double b, Arithmetic lambda) {
        return lambda.operation(a, b);
    }

    public double calculateWithBiFunction(double a, double b, BiFunction<Double, Double, Double> lambda) {
        return lambda.apply(a, b);
    }

}
