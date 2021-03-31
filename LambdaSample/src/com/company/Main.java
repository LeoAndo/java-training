package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    private static final String[] names = new String[]{"abcd", "ab", "a", "abc"};
    public static void main(String[] args) {
        // write your code here
        Arrays.sort(names, new LengthComparator());
        for(String name: names) {
            System.out.println("sorted names: " + name);
        }
    }
    static class LengthComparator implements Comparator<String> {
        @Override
        public int compare(String first, String second) {
            return Integer.compare(first.length(), second.length());
        }
    }
}
