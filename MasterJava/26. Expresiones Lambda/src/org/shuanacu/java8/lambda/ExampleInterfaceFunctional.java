package org.shuanacu.java8.lambda;

import org.shuanacu.java8.lambda.arithmetic.Arithmetic;
import org.shuanacu.java8.lambda.arithmetic.Calculator;

public class ExampleInterfaceFunctional {

    public static void main(String[] args) {
//        Arithmetic plus = (a, b) -> a + b;
        Arithmetic plus = Double::sum;
        Arithmetic subtract = (a, b) -> a - b;
        Calculator calculator = new Calculator();

        System.out.println(calculator.calculate(5, 5, plus));
        System.out.println(calculator.calculate(5, 6, subtract));
        System.out.println(calculator.calculate(5, 6, (a, b) -> a * b));

        System.out.println(calculator.calculate(10, 6, Double::sum));

    }

}
