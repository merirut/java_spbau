package edu.au.javacourse.datetime;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.zone.ZoneOffsetTransition;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        long startCalendar = System.currentTimeMillis();
        long startMonotonous = System.nanoTime();

        if (args.length == 0) {
            System.out.println("Please pass the following parameters:" +
                    "1. date/time format pattern" +
                    "2. (optional) maximum date to list offset transitions (if not set all will be listed). Format: <year>-<month>-<day>. Example: 2000-01-01");
            System.exit(0);
        }


        // set date and time format
        DateTimeFormatter formatter = getDateTimeFormatter(args[0]);
        ZonedDateTime maxDateTime;

        // set max date and time from the 2nd argument if given
        if (args.length == 2) {maxDateTime = getMaxDateTime(args[1]);}
        // set max date and time from current date and time
        else{maxDateTime = ZonedDateTime.now(ZoneId.of("Europe/Moscow"));}

            printTransitions(maxDateTime, formatter);

            System.out.println("\n" +
                    "Millis passed: " + (System.currentTimeMillis() - startCalendar));
            System.out.println("Nanos passed: " + (System.nanoTime() - startMonotonous));
        }
    private static DateTimeFormatter getDateTimeFormatter(String example){
        try {
            return DateTimeFormatter.ofPattern(example);
        }
        catch (IllegalArgumentException e) {
            System.out.println("First argument must be a date/time format pattern!" + "\n" + e.getMessage() + "\n");
            return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        }
        catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
            return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        }
    }


    private static ZonedDateTime getMaxDateTime(String date) {
        try {
            return ZonedDateTime.of(
                    LocalDateTime.parse(date + " 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                    ZoneId.of("Europe/Moscow"));
        }
        catch (Exception e) {
            System.out.println("Second argument must be formatted as <year>-<month>-<day>!" + "\n" + e.getMessage());
            return ZonedDateTime.of(
                    LocalDateTime.parse("1970-01-01 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                    ZoneId.of("Europe/Moscow"));}
    }


    private static void printTransitions(ZonedDateTime maxDateTime, DateTimeFormatter formatter) {
        for (String zoneId : ZoneId.getAvailableZoneIds()) {
            for (ZoneOffsetTransition transition : ZoneId.of(zoneId).getRules().getTransitions()) {
                // if time has changed before max date and time
                if (transition.getDateTimeBefore().isBefore(maxDateTime.withZoneSameInstant(ZoneId.of(zoneId)).toLocalDateTime())) {
                    // time difference
                    Duration dur = transition.getDuration();

                    // to hours:minutes:seconds format
                    String hms = String.format("%02d:%02d:%02d",
                            Math.abs(dur.toHours()),
                            Math.abs(dur.toMinutesPart()),
                            Math.abs(dur.toSecondsPart()));

                    String movingType = "";
                    if (transition.isGap()) {
                        movingType = "forward";
                    }
                    if (transition.isOverlap()) {
                        movingType = "backward";
                    }

                    System.out.println(zoneId);
                    System.out.println("Moving " + hms + " " + movingType + " at " +
                            transition.getDateTimeBefore().format(formatter) + " " +
                            "(Moscow time: " + ZonedDateTime.of(transition.getDateTimeBefore(),
                            ZoneId.of(zoneId)).withZoneSameInstant(ZoneId.of("Europe/Moscow")).format(formatter)
                            + ")");
                }
            }
        }
    }
}
