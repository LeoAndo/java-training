package com.company;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        long millis = measureTimeMillis(() -> {
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long millis2 = measureTimeMillis(() -> {
            try {
                Thread.sleep(2_010);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(millis);
        System.out.println(millis2);
        if (millis * 2 <= millis2) {
            System.out.println("millis2の方が処理時間が２倍以上かかっている.");
        }

        createLocalDate(() -> DateTimeFormatter.ISO_LOCAL_DATE);
        createNotExistLocalDate();
        until();
        adjustLocalDate();
        startSummerTime();
        endSummerTime();
    }

    /**
     * 処理時間を計測する.
     */
    private static long measureTimeMillis(Runnable runnable) {
        Instant start = Instant.now();
        runnable.run();
        Instant end = Instant.now();
        return Duration.between(start, end).toMillis();
    }

    /*
    today: 2021-04-04
    tomorrow: 2021-04-05
    odaNobunagasBirthday: 1534-06-23
     */
    private static void createLocalDate(Supplier<DateTimeFormatter> formatter) {
        System.out.println("===========createLocalDate-START========");
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        LocalDate odaNobunagasBirthday = LocalDate.of(1534, Month.JUNE, 23);
        System.out.println("today: " + formatter.get().format(today));
        System.out.println("tomorrow: " + formatter.get().format(tomorrow));
        System.out.println("odaNobunagasBirthday: " + formatter.get().format(odaNobunagasBirthday));
        System.out.println("===========createLocalDate-END========");
    }

    /*
    notExistDay1: 2021-02-28
    notExistDay2: 2021-02-28
     */
    private static void createNotExistLocalDate() {
        System.out.println("===========createNotExistLocalDate-START========");
        LocalDate today = LocalDate.now();
        LocalDate notExistDay1 = LocalDate.of(today.getYear(), Month.JANUARY, 31).plusMonths(1);
        LocalDate notExistDay2 = LocalDate.of(today.getYear(), Month.MARCH, 31).minusMonths(1);
        System.out.println("notExistDay1: " + notExistDay1);
        System.out.println("notExistDay2: " + notExistDay2);
        System.out.println("===========createNotExistLocalDate-END========");
    }

    /*
    ２つの日付の差は: 40 日です。
     */
    private static void until() {
        System.out.println("===========until-START========");
        LocalDate today = LocalDate.now();
        LocalDate anotherDay = today.plusMonths(1).plusDays(10);
        long result = today.until(anotherDay, ChronoUnit.DAYS);
        System.out.println("２つの日付の差は: " + result + " 日です。");
        System.out.println("===========until-END=======");
    }

    /*
    2021-04-06
    today hashcode: 4139268
    firstTuesDay hashcode: 4139270
    */
    private static void adjustLocalDate() {
        System.out.println("===========adjustLocalDate-START========");
        LocalDate today = LocalDate.now();
        LocalDate firstTuesDay = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
        System.out.println(firstTuesDay);
        System.out.println("today hashcode: " + today.hashCode());
        System.out.println("firstTuesDay hashcode: " + firstTuesDay.hashCode());
        System.out.println("===========adjustLocalDate-END========");
    }

    private static final String ZONE_ID_EUR = "Europe/Berlin";

    /*
    2013-03-31T03:10+02:00[Europe/Berlin]
     */
    private static void startSummerTime() {
        // 2020年中央ヨーロッパは、3月31日 2:00　からサマータイムが開始
        System.out.println("===========startSummerTime-START========");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(
                LocalDate.of(2013, Month.MARCH, 31),
                LocalTime.of(2, 10), // 存在しない時間
                ZoneId.of(ZONE_ID_EUR)
        );
        System.out.println(zonedDateTime); // サマータイムが始まると１時間進むので 3:10 という結果になる
        System.out.println("===========startSummerTime-END========");
    }

    /*
    zonedDateTime  2013-10-27T02:30+02:00[Europe/Berlin]
    plusOneHours  2013-10-27T02:30+01:00[Europe/Berlin]
    Duration.ofDays(7)  2013-11-03T01:30+01:00[Europe/Berlin]
    Period.ofDays(7)  2013-11-03T02:30+01:00[Europe/Berlin]
    plusDays  2013-11-03T02:30+01:00[Europe/Berlin]
     */
    private static void endSummerTime() {
        System.out.println("===========endSummerTime-START========");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(
                LocalDate.of(2013, Month.OCTOBER, 27),
                LocalTime.of(2, 30),
                ZoneId.of(ZONE_ID_EUR)
        );
        System.out.println("zonedDateTime  " + zonedDateTime);
        System.out.println("plusOneHours  " + zonedDateTime.plusHours(1)); // サマータイムが終わると１時間戻される.

        // サマータイムの境目にまたがる日付を調整する場合、Duration を使うと誤動作するので、PeriodもしくはplusDaysメソッドを使用する.
        System.out.println("Duration.ofDays(7)  " + zonedDateTime.plus(Duration.ofDays(7)));
        System.out.println("Period.ofDays(7)  " + zonedDateTime.plus(Period.ofDays(7)));
        System.out.println("plusDays  " + zonedDateTime.plusDays(7));
        System.out.println("===========endSummerTime-END========");
    }
}
