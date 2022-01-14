package org.bo.datetime.example;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class ExampleDuration2 {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println("instant = " + instant);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant instant2 = Instant.now();
        System.out.println("instant2 = " + instant2);

        Duration duration = Duration.between(instant, instant2);
        System.out.println("duration = " + duration);
    }

}
