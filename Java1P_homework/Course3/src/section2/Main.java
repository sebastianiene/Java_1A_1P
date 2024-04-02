package section2;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {

        // periodExamples();

        // durationExamples();

        // chronoUnitExamples();

        // instantExamples();

        String birthDateString = "1998/02/24";
        DateTimeFormatter customDatePattern = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate birthDate = LocalDate.parse(birthDateString, customDatePattern);
        System.out.println(birthDate);

        DateTimeFormatter customPrintDateFormat = DateTimeFormatter.ofPattern("dd-MM--yy");
        System.out.println(birthDate.format(customPrintDateFormat));

        LocalDateTime ucl86FinalStartingTime = LocalDateTime.parse("1986-05-07T21:45");
        ZonedDateTime ucl86Final = ZonedDateTime.of(ucl86FinalStartingTime, ZoneId.of("Europe/Madrid"));

      //  DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

        System.out.println(ucl86Final.format(dateTimeFormatter));

    }

    private static void instantExamples() {
        LocalDateTime ucl86FinalStartingTime = LocalDateTime.parse("1986-05-07T21:45");
        ZoneId bucharestZone =ZoneId.of("Europe/Bucharest");
        ZoneId madridZone = ZoneId.of("Europe/Madrid");
        ZonedDateTime bucharestDateTime = ZonedDateTime.of(ucl86FinalStartingTime, bucharestZone);
        System.out.println(bucharestDateTime);
        System.out.println(bucharestDateTime.toInstant());
        System.out.println(bucharestDateTime.toInstant().atZone(madridZone));
    }

    private static void chronoUnitExamples() {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(1998, Month.FEBRUARY, 24);
        System.out.println(birthDate);
        System.out.println(ChronoUnit.YEARS.between(birthDate,currentDate));
        System.out.println(ChronoUnit.DAYS.between(birthDate,currentDate));

        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);
        LocalTime breakfastTime= LocalTime.of(8, 30);
        System.out.println(ChronoUnit.MINUTES.between(currentTime,breakfastTime));
        System.out.println(ChronoUnit.HOURS.between(currentTime, breakfastTime));
    }

    private static void durationExamples() {
        Duration daily = Duration.ofDays(1);
        Duration hourly = Duration.ofHours(1);
        Duration everyMinute = Duration.ofMinutes(1);
        Duration every10Seconds = Duration.ofSeconds(10);

        System.out.println(daily);
        System.out.println(hourly);
        System.out.println(everyMinute);
        System.out.println(every10Seconds);

        LocalTime currentTime = LocalTime.now();
        LocalTime minus = currentTime.minus(daily);
        System.out.println(minus);
    }

    private static void periodExamples() {
        Period annually = Period.ofYears(1);
        Period quarterly = Period.ofMonths(3);
        Period everyThreeWeeks = Period.ofWeeks(3);
        Period everyDay = Period.ofDays(1);
        Period everyYearAndAWeek = Period.of(1, 0, 7);

        System.out.println(annually);
        System.out.println(quarterly);
        System.out.println(everyThreeWeeks);
        System.out.println(everyDay);
        System.out.println(everyYearAndAWeek);

        LocalDate now = LocalDate.now();
        LocalDate plus = now.plus(annually);
        System.out.println(now);
        System.out.println(plus);
    }
}
