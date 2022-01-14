package org.bo.datetime.example;

import java.time.Duration;
import java.time.LocalDateTime;

public class ExampleDuration {

    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime dateTime2 = LocalDateTime.now().plusHours(3).plusMinutes(36).plusDays(3);
        Duration lapse = Duration.between(dateTime, dateTime2);
        System.out.println("lapse = " + lapse);
        System.out.println(lapse.getSeconds());
        System.out.println(lapse.toHours());
        System.out.println("lapse.plusHours(5) = " + lapse.plusHours(5));
    }

}
