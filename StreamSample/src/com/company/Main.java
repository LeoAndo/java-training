package com.company;

import java.util.Arrays;

public class Main {

    private static String[] dataset = {"a", "ab", "abc", "abcd", "abcde", "abcdef"};

    public static void main(String[] args) {
        System.out.println(filterByLength());
    }

    private static long filterByLength() {
        // 元データのdatasetは変更せずに処理結果を返す.
        long count = Arrays.stream(dataset).filter(data -> 3 < data.length()).count();
        return count;
    }
}
