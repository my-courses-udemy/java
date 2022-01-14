package org.bo.datetime.example;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleZonedDateTime2 {

    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.parse("2021-09-23 14:45",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

//        ZoneId newYork = ZoneId.of("America/New_York");
//        ZonedDateTime newYorkArea = ZonedDateTime.of(dateTime, newYork);
        ZonedDateTime newYorkArea = ZonedDateTime.of(dateTime, ZoneOffset.of("-04:00"));
        System.out.println("NewYorkArea = " + newYorkArea);

//        ZoneId madrid = ZoneId.of("Europe/Madrid");
//        ZonedDateTime madridArea = newYorkArea.withZoneSameInstant(madrid).plusHours(10);
        ZonedDateTime madridArea = newYorkArea.withZoneSameInstant(ZoneOffset.of("+02:00")).plusHours(10);
        System.out.println("madridArea = " + madridArea);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm, dd-MMM-yyyy");
        System.out.println("Departure from New York: " + dateTimeFormatter.format(newYorkArea));
        System.out.println("Arrival in Madrid: " + dateTimeFormatter.format(madridArea));

        Set<String> zones = ZoneId.getAvailableZoneIds();
//        System.out.println("zones = " + zones);
        List<String> list = zones.stream()
                .filter(zone -> zone.contains("America"))
                .collect(Collectors.toList());
//                .peek(System.out::println);
        System.out.println(list);

    }

}
