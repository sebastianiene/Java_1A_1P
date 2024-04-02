package section_homework1;

import java.time.*;

public class ex1 {
    //Write a program that::
    //
    // Uses methods of LocalDate to instantiate 2 objects, one for current date and one with value for the
    // birthdate;
    // From the second object subtract 9 months and show the result;
    // Instantiate two objects type LocalTime, which represent hour for the lunch and dinner
    // and verify if dinner comes after lunch;
    // Create two objects ZonedDateTime, using the same date, but modifying the zone
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate random_birthday = LocalDate.of(1919, 02,27);
        LocalDate random_birthday_9months_before = random_birthday.minusMonths(9);
        System.out.println(random_birthday_9months_before);

        LocalTime lunchTime = LocalTime.parse("12:30");
        LocalTime dinnerTime = LocalTime.of(18,30);
        boolean shouldBeTrue = dinnerTime.isAfter(lunchTime);
        System.out.println(shouldBeTrue);

        LocalDateTime timeParis = LocalDateTime.parse("2023-05-07T21:45");
        LocalDateTime timeWarsaw = LocalDateTime.parse("2023-05-09T21:45");
        ZonedDateTime timeParisinMadrid = ZonedDateTime.of(timeParis, ZoneId.of("Europe/Madrid"));
        ZonedDateTime timeWarsawinOslo = ZonedDateTime.of(timeWarsaw, ZoneId.of("Europe/Oslo"));
        System.out.println(timeParisinMadrid);
        System.out.println(timeWarsawinOslo);
    }
}
