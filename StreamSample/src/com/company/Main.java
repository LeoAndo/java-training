package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    static List<String> dataset2 = Arrays.asList(
            "abc",
            "def",
            "defg",
            "defgh"
    );
    static List<Boolean> dataset3 = Arrays.asList(
            true,
            true,
            false,
            true
    );

    public static void main(String[] args) {
        System.out.println(filterByLength());
        toUpperCase();
        generateStream();
        concatStream();
        findFirst();
        findAny();
        anyMatch();
    }

    /**
     * 条件に一致した最初の要素を取得する.
     */
    private static void findFirst() {
        Optional<String> result = dataset2.stream().filter(s -> s.startsWith("def")).findFirst();
        result.ifPresent(s -> System.out.println("findFirst: " + s));
    }

    /**
     * 条件に一致したいずれかの要素を取得する.
     */
    private static void findAny() {
        Optional<String> result = dataset2.stream().parallel().filter(s -> s.startsWith("def")).findAny();
        result.ifPresent(s -> System.out.println("findAny: " + s));
    }

    /**
     * 条件に一致した場合、trueを返す.
     */
    private static void anyMatch() {
        boolean result = dataset3.stream().parallel().anyMatch(b -> !b);
        System.out.println("anyMatch: " + result);
    }

    /**
     * ２つのStreamを結合する
     */
    private static void concatStream() {
        Stream<String> stream1 = Stream.of("Hello, ");
        Stream<String> stream2 = Stream.of("Java8.");
        Stream<String> combined = Stream.concat(stream1, stream2);
        System.out.println(combined.collect(Collectors.joining()));
    }

    /**
     * Streamオブジェクトの生成
     */
    private static void generateStream() {
        Stream<Double> stream = Stream.generate(Math::random).limit(3);
        stream.forEach(System.out::println);
    }

    /**
     * 元となるStreamの値を変換する.
     */
    private static void toUpperCase() {
        Stream<String> stream = dataset2.stream().map(s -> s.toUpperCase());
        stream.forEach(System.out::println);
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
