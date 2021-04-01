package com.company;

public class Main {

    private static String[] dataset = {"a", "ab", "abc", "abcd", "abcde", "abcdef"};

    public static void main(String[] args) {
        System.out.println(filterByLength());
    }

    private static int filterByLength() {
        int count = 0;
        for (String data : dataset) {
            if (3 < data.length()) count++;
        }
        return count;
    }
}
