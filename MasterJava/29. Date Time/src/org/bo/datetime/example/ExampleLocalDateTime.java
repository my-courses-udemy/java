package org.bo.datetime.example;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class ExampleLocalDateTime {

    public static void main(String[] args) {

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("dateTime = " + dateTime);

        dateTime = LocalDateTime.of(2020, Month.DECEMBER, 24, 20, 30, 10);
        System.out.println("dateTime = " + dateTime);

        dateTime = LocalDateTime.parse("2020-11-01T20:10");
        System.out.println("dateTime = " + dateTime);

        LocalDateTime dateTime2 = dateTime.plusHours(6).plusMonths(1);
        System.out.println("dateTime = " + dateTime);
        System.out.println("dateTime2 = " + dateTime2);
        System.out.println("dateTime = " + dateTime.minusMonths(3));

        Month month = dateTime.getMonth();
        System.out.println("month = " + month);
        
        int day = dateTime.getDayOfMonth();
        System.out.println("day = " + day);
        
        int year = dateTime.getYear();
        System.out.println("year = " + year);
        
        int hour = dateTime.getHour();
        System.out.println("hour = " + hour);

//        3 ways
        String dateFormat = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println("dateFormat = " + dateFormat);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
        String dateFormat2 = dateTime.format(dateTimeFormatter);
        System.out.println("dateFormat2 = " + dateFormat2);

        String dateFormat3 = dateTimeFormatter.format(dateTime);
        System.out.println("dateFormat3 = " + dateFormat3);

    }

}
