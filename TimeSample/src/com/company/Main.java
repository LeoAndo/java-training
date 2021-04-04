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
}
