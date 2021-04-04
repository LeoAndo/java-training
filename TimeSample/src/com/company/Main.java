package com.company;

import java.time.Duration;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        long millis = measureTimeMillis(() -> {
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(millis);
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
