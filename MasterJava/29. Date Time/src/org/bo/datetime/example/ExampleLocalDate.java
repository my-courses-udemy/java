package org.bo.datetime.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class ExampleLocalDate {

    public static void main(String[] args) {
//        Current date with method now()
        LocalDate currentDate = LocalDate.now();
        System.out.println("currentDate = " + currentDate);
        System.out.println("Day " + currentDate.getDayOfYear());
        System.out.println();

        Month month = currentDate.getMonth();
        System.out.println("Month " + month);
        System.out.println("Number of Month " + month.getValue());
        System.out.println("Month in Spanish " + month.getDisplayName(TextStyle.FULL, new Locale("es", "ES")));
        System.out.println();

        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
        System.out.println("Number of day: " + dayOfWeek.getValue());
        System.out.println("Name of day: " + dayOfWeek.getDisplayName(TextStyle.FULL, new Locale("es", "ES")));
        System.out.println();

        System.out.println("Year " + currentDate.getYear());
        System.out.println("Age " + currentDate.getEra());

//        Create the date with method of(year, month, day)
        currentDate = LocalDate.of(2020, 2, 21);
        System.out.println("currentDate = " + currentDate);

//        Can also be used Month
        currentDate = LocalDate.of(2020, Month.APRIL, 25);
        System.out.println("currentDate = " + currentDate);

        currentDate = LocalDate.parse("2020-02-01");
        System.out.println("currentDate = " + currentDate);

//        Can add days, months, or years from today
        currentDate = LocalDate.now().plusDays(1);
        System.out.println("currentDate = " + currentDate);

//        Can subtract days, months or years from today
        currentDate = LocalDate.now().minusDays(4);
        System.out.println("currentDate = " + currentDate);

        currentDate = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        System.out.println("currentDate = " + currentDate);

        DayOfWeek saturday = LocalDate.parse("2022-01-08").getDayOfWeek();
        System.out.println("saturday = " + saturday);

        int dayOfMonth = LocalDate.now().getDayOfMonth();
        System.out.println("dayOfMonth = " + dayOfMonth);

        boolean isLeapYear = LocalDate.now().isLeapYear();
        System.out.println("isLeapYear = " + isLeapYear);

        boolean isBefore = LocalDate.now().isBefore(LocalDate.parse("2020-01-10"));
        System.out.println("isBefore = " + isBefore);

        boolean isAfter = LocalDate.now().isAfter(LocalDate.of(2020, 11, 11));
        System.out.println("isAfter = " + isAfter);

    }

}
