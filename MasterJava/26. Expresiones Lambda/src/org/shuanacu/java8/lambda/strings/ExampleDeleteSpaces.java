package org.shuanacu.java8.lambda.strings;

public class ExampleDeleteSpaces {

    public static void main(String[] args) {
        Language lambda = phrase -> phrase.replace(" ", "").toUpperCase();

        Dictionary dictionary = new Dictionary();
        String result = dictionary.verifyPhase("Hi my name is Santiago", lambda);
        System.out.println(result);

    }

}
