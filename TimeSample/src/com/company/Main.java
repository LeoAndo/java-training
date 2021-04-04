package com.company;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
                Thread.sleep(2_500);
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
        createNotExistLocalDate(() -> DateTimeFormatter.ISO_LOCAL_DATE);
        until();
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

    private static void createLocalDate(Supplier<DateTimeFormatter> formatter) {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        LocalDate odaNobunagasBirthday = LocalDate.of(1534, Month.JUNE, 23);
        System.out.println("today: " + formatter.get().format(today));
        System.out.println("tomorrow: " + formatter.get().format(tomorrow));
        System.out.println("odaNobunagasBirthday: " + formatter.get().format(odaNobunagasBirthday));
    }

    private static void createNotExistLocalDate(Supplier<DateTimeFormatter> formatter) {
        LocalDate today = LocalDate.now();
        LocalDate notExistDay1 = LocalDate.of(today.getYear(), Month.JANUARY, 31).plusMonths(1);
        LocalDate notExistDay2 = LocalDate.of(today.getYear(), Month.MARCH, 31).minusMonths(1);
        System.out.println("notExistDay1: " + formatter.get().format(notExistDay1));
        System.out.println("notExistDay2: " + formatter.get().format(notExistDay2));
    }

    private static void until() {
        LocalDate today = LocalDate.now();
        LocalDate anotherDay = today.plusMonths(1).plusDays(10);
        long result = today.until(anotherDay, ChronoUnit.DAYS);
        System.out.println("２つの日付の差は: " + result + " 日です。");
    }
}
