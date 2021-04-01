package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    static List<String> dataset = Arrays.asList(
            "1",
            "12",
            "123",
            "1234",
            "12345",
            "123456",
            "1234567",
            "12345678",
            "123456789",
            "1234567890");

    public static void main(String[] args) {
        System.out.println(filterByLength());
    }

    private static long filterByLength() {
        // 元データのdatasetは変更せずに処理結果を返す.
        long start = System.currentTimeMillis();
        long count = dataset.parallelStream().filter(data -> 3 < data.length()).count();
        long end = System.currentTimeMillis();
        System.out.println("filterByLength 処理時間: " + (end - start) + " milliseconds.");
        return count;
    }
}
