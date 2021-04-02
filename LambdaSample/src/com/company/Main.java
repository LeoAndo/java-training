package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    private static final String[] names = new String[]{"abcd", "ab", "a", "abc"};

    public static void main(String[] args) {
        Arrays.sort(names, lengthComparator);
        for (String name : names) {
            System.out.println("sorted names: " + name);
        }
        Stream<Foo> stream = Arrays.stream(names).map(Foo::new);
        List<Foo> fooList = stream.collect(Collectors.toList());
        for (Foo foo : fooList) {
            System.out.println("message: " + foo.getMessage());
        }

        runInterfaceExampleCode();
        repeat(3, () -> System.out.println("Hello, Java8..."));
    }

    private static void repeat(int i, Runnable runnable) {
        IntStream.range(0, i).forEach(index ->
                runnable.run()
        );
    }

    private static void runInterfaceExampleCode() {
        Student s = new Student();
        System.out.println("name: " + s.getName());
    }

    static Comparator<String> lengthComparator = Comparator.comparingInt(String::length);
    /*
    static class LengthComparator implements Comparator<String> {
        @Override
        public int compare(String first, String second) {
            return Integer.compare(first.length(), second.length());
        }
    }
     */
}
