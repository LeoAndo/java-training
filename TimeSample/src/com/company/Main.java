package com.company;

import java.time.Duration;
import java.time.Instant;

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
}
