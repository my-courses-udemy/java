package org.bo.datetime.example;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class ExamplePeriod {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(1988, 1, 1);
        LocalDate date2 = LocalDate.of(2020, Month.APRIL, 12);
        date2 = date2.withMonth(12);
        date2 = date2.withDayOfYear(300);

        Period period = Period.between(date, date2);
        System.out.println("period = " + period);
        System.out.printf("Period between %s and %s there is a %d years, %d months, and %d days difference", date, date2,
                period.getYears(), period.getMonths(), period.getDays());
    }

}
