package org.bo.datetime.example;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ExampleLocalTime {

    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println("now = " + now);
        System.out.println("Hour: " + now.getHour());
        System.out.println("Minute: " + now.getMinute());
        System.out.println("Second: " + now.getSecond());
        System.out.println("Nanoseconds: " + now.getNano());

        now = LocalTime.of(2, 27);
        System.out.println("now = " + now);

        now = LocalTime.parse("18:30:20");
        System.out.println("now = " + now);

        now = LocalTime.of(19, 30).plusHours(6);
        System.out.println("now = " + now);

        boolean isBefore = LocalTime.now().isBefore(LocalTime.of(11, 0));
        System.out.println("isBefore = " + isBefore);

        boolean isAfter = LocalTime.now().isAfter(LocalTime.of(11, 30));
        System.out.println("isAfter = " + isAfter);

//      Formatter a date
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String nowFormatter = now.format(dateTimeFormatter);
        System.out.println(nowFormatter);

        nowFormatter = dateTimeFormatter.format(now);
        System.out.println(nowFormatter);

        LocalTime max = LocalTime.MAX;
        System.out.println("max = " + max);
        
        LocalTime min = LocalTime.MIN;
        System.out.println("min = " + min);
        
    }

}
