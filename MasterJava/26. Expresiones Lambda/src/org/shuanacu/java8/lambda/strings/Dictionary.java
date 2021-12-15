package org.shuanacu.java8.lambda.strings;

public class Dictionary {

    public String verifyPhase(String phrase, Language lambda) {
        return lambda.deleteSpaces(phrase);
    }

}
