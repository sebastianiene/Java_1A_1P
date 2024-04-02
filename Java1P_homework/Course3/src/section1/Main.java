package section1;

import java.time.*;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //oldDateTimeAPIExamples();

        // localDateExamples();

        // localTimeExamples();

        // localDateTimeExamples();

        ZoneId defaultTimeZone = ZoneId.systemDefault();
        System.out.println(defaultTimeZone);
        ZoneId bucharestTimeZone = ZoneId.of("Europe/Bucharest");
        System.out.println(bucharestTimeZone);

      //  ZoneId.getAvailableZoneIds().forEach(System.out::println);  //too big output

        LocalDateTime ucl86FinalStartingTime = LocalDateTime.parse("1986-05-07T21:45");
        ZonedDateTime ucl86Final = ZonedDateTime.of(ucl86FinalStartingTime, ZoneId.of("Europe/Madrid"));
        System.out.println(ucl86Final);
        System.out.println(ZonedDateTime.now());


    }

    private static void localDateTimeExamples() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDate localDate =LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime now2 = LocalDateTime.of(localDate, localTime);
        System.out.println(now2);
    }

    private static void localTimeExamples() {
        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalTime breakfastTime = LocalTime.of(8, 30);
        System.out.println(breakfastTime);

        LocalTime lunchTime = LocalTime.parse("13:00");
        System.out.println(lunchTime);

        System.out.println(lunchTime.isAfter(breakfastTime));
    }

    private static void localDateExamples() {
        LocalDate now =LocalDate.now();
        System.out.println(now);
        LocalDate birthday = LocalDate.of(1998, 2, 24);
        System.out.println(birthday);

        LocalDate nextPayDay = LocalDate.parse("2022-07-01");
        System.out.println(nextPayDay);

        System.out.println(birthday.getDayOfWeek());

        System.out.println(birthday.isBefore(now));

        LocalDate localDate = birthday.withYear(2068);
        System.out.println(localDate);
        System.out.println(birthday);
    }

    private static void oldDateTimeAPIExamples() {
        //deprecated stuff below
        Date currentDate = new Date();
        System.out.println(currentDate);

        Calendar calendarInstance = Calendar.getInstance();
        System.out.println(calendarInstance.getTime());
        calendarInstance.set(1998, 1,24);
        System.out.println(calendarInstance.getTime());

        //calling deprecated constructor
        Date date = new Date(1998,1,24);
        System.out.println(date);
    }
}
