package section_homework2;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Ex1 {
    /*  Write a program that:

        Using current date and birthdate, calculates the difference and shows it, specifying number of
        years, months, weeks and days;
        Computes how many hours, minutes, seconds are between lunch and dinner;
        Having a start hour of an event, computes which is the hour for other time zones;
        Reads a date under the format "24-02-1998" and will show under the format "02 24 1998".  */
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate random_birthday = LocalDate.of(1919, 02,27);

        System.out.println("years: " + ChronoUnit.YEARS.between(random_birthday, now));
        System.out.println("months: " + ChronoUnit.MONTHS.between(random_birthday, now));
        System.out.println("weeks: " + ChronoUnit.WEEKS.between(random_birthday, now));
        System.out.println("days: " + ChronoUnit.DAYS.between(random_birthday, now));

        LocalDate date = LocalDate.of(2023, 11, 23);
        LocalTime timeLunch = LocalTime.of(12, 15,  14);
        LocalTime timeDinner = LocalTime.of(18, 15,0);
        LocalDateTime  dateTimeLunch = LocalDateTime.of(date, timeLunch);
        LocalDateTime  dateTimeDinner = LocalDateTime.of(date, timeDinner);
        System.out.println("hours: " + ChronoUnit.HOURS.between(dateTimeLunch, dateTimeDinner));
        System.out.println("minutes: " + ChronoUnit.MINUTES.between(dateTimeLunch, dateTimeDinner));
        System.out.println("seconds: " + ChronoUnit.SECONDS.between(dateTimeLunch, dateTimeDinner));


        LocalDateTime eventMarathonTime = LocalDateTime.parse("2023-10-12T11:45");
        ZoneId helsinkiZone = ZoneId.of("Europe/Helsinki");
        ZoneId lisbonZone = ZoneId.of("Europe/Lisbon");
        ZonedDateTime helsinkiDateTime = ZonedDateTime.of(eventMarathonTime, helsinkiZone);

        System.out.println("Helsinki date and hour: " + helsinkiDateTime); //Helsinki date and hour: 2023-10-12T11:45+03:00[Europe/Helsinki]
        System.out.println("GMT date and hour: " + helsinkiDateTime.toInstant()); // GMT date and hour: 2023-10-12T08:45:00Z
        System.out.println("Lisbon date and hour: " + helsinkiDateTime.toInstant().atZone(lisbonZone)); //Lisbon date and hour: 2023-10-12T09:45+01:00[Europe/Lisbon]


        String birthDateString = "24-02-1998";
        DateTimeFormatter customParseDateFormatInput = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthDate = LocalDate.parse(birthDateString, customParseDateFormatInput);
        DateTimeFormatter customParseDateFormatOutput = DateTimeFormatter.ofPattern("MM dd yyyy");
        System.out.println(birthDate.format(customParseDateFormatOutput)); // 02 24 1998

    }
}
