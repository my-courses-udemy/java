package org.shuanacu.java8.lambda.strings;

import java.util.HashMap;
import java.util.TreeMap;

public class ExampleWordCounter {

    public static void main(String[] args) {
        WordCounter wordCounter = phrase -> {
            HashMap<String, Integer> counter = new HashMap<>();
            String[] array = phrase.split(" ");
            for (String element : array) {
                if (counter.containsKey(element)) {
                    int lastValue = counter.get(element);
                    counter.put(element, lastValue + 1);
                } else
                    counter.put(element, 1);
            }
            return new TreeMap<>(counter).descendingMap();
        };
        System.out.println(wordCounter.countRepeatedWord("hi how are you I miss you I need more time"));
    }

}
