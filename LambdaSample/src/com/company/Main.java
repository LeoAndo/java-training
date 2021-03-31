package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    private static final String[] names = new String[]{"abcd", "ab", "a", "abc"};

    public static void main(String[] args) {
        Arrays.sort(names, lengthComparator);
        for (String name : names) {
            System.out.println("sorted names: " + name);
        }
    }

    static Comparator<String> lengthComparator = (first, second) -> {
        return Integer.compare(first.length(), second.length());
    };
    /*
    static class LengthComparator implements Comparator<String> {
        @Override
        public int compare(String first, String second) {
            return Integer.compare(first.length(), second.length());
        }
    }
     */
}
