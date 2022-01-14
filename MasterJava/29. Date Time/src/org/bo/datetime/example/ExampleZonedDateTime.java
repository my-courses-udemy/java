package org.bo.datetime.example;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ExampleZonedDateTime {

    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();

        ZoneId newYork = ZoneId.of("America/New_York");
        ZonedDateTime newYorkArea = ZonedDateTime.of(dateTime, newYork);
        System.out.println("NewYorkArea = " + newYorkArea);

        ZoneId madrid = ZoneId.of("Europe/Madrid");
        ZonedDateTime madridArea = newYorkArea.withZoneSameInstant(madrid);
        System.out.println("madridArea = " + madridArea);
    }

}
