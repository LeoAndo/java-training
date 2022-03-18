package com.example.ex01;

import java.util.*;

class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("D", "B", "C", "E", "A");
        test01(list);
        System.out.println("----------------------------------------");
        test02(list);
        System.out.println("----------------------------------------");
        test03(list);
        System.out.println("----------------------------------------");
    }

    // java api 1.7までの書き方
    private static void test01(List<String> list) {
        // 辞書式順序で小さい順
        list.sort(new Comparator<String>() {
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        System.out.println(list);

        // 辞書式順序で大きい順
        list.sort(new Comparator<String>() {
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        System.out.println(list);
    }

    // java api ラムダ記法を使った方法
    private static void test02(List<String> list) {
        // 辞書式順序で小さい順
        list.sort((a, b) -> a.compareTo(b));
        System.out.println(list);

        // 辞書式順序で大きい順
        list.sort((a, b) -> b.compareTo(a));
        System.out.println(list);
    }

    // java api  Comparatorで提供されているstaticメソッドを使った方法
    private static void test03(List<String> list) {
        // 辞書式順序で小さい順
        list.sort(Comparator.naturalOrder());
        System.out.println(list);

        // 辞書式順序で大きい順
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
    }
}