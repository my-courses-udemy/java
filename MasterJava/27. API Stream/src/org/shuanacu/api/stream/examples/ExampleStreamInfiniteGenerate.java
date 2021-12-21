package org.shuanacu.api.stream.examples;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ExampleStreamInfiniteGenerate {

    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(0);
        Stream.generate(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return counter.incrementAndGet();
                })
                .limit(7)
                .forEach(System.out::println);
    }

}