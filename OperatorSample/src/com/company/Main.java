package com.company;

public class Main {
    public static void main(String[] args) {
        // 加算代入
        int x = 100;
        x += 10;
        System.out.println(x);

        // インクリメント
        x++;
        System.out.println(x);

        // 割り算
        System.out.println(10 / 3);
        System.out.println(10 / 3.0);

        // 単項演算子を使うサンプル.
        testUnaryOperator();
    }

    private static void testUnaryOperator() {
        System.out.println("===========testUnaryOperator-START=============");
        int a = 10;
        int b;
        b = ++a;
        System.out.println(a);
        System.out.println(b);

        int c = 10;
        int d;
        d = c++;
        System.out.println(c);
        System.out.println(d);
        System.out.println("===========testUnaryOperator-END=============");
    }
}
