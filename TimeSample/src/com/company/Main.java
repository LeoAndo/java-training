package com.company;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
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

        exampleLocalDate(() -> DateTimeFormatter.ISO_LOCAL_DATE);
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

    private static void exampleLocalDate(Supplier<DateTimeFormatter> formatter) {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        LocalDate odaNobunagasBirthday = LocalDate.of(1534, Month.JUNE, 23);
        System.out.println("today: " + formatter.get().format(today));
        System.out.println("tomorrow: " + formatter.get().format(tomorrow));
        System.out.println("odaNobunagasBirthday: " + formatter.get().format(odaNobunagasBirthday));
    }
}
