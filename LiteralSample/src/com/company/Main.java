package com.company;

public class Main {
    public static void main(String[] args) {
        literalInt();
        literalDouble();
        literalChar();
        literalLong();
        literalFloat();
    }

    private static void literalFloat() {
        System.out.println("========literalFloat-START========");
        // float a = 10000000000; // コンパイルエラー (int型の値として認識されてるため、int型で扱える範囲を越した場合コンパイルエラーが起きる)
        float a = 10000000000F; // long型のリテラルはLもしくはlをつける
        System.out.println(a);
        System.out.println("========literalFloat-END========");
    }

    private static void literalLong() {
        System.out.println("========literalLong-START========");
        // long a = 10000000000; // コンパイルエラー (int型の値として認識されてるため、int型で扱える範囲を越した場合コンパイルエラーが起きる)
        long a = 10000000000L; // long型のリテラルはLもしくはlをつける
        System.out.println(a);
        System.out.println("========literalLong-END========");
    }

    private static void literalChar() {
        System.out.println("========literalChar-START========");
        // 1文字
        char x = 'A';
        // 特殊文字 (先頭に ¥u をつけて4桁の16進数のUnicode(UTF-16)を指定する)
        char y = '\u3012';
        char z = '\t'; //Tab
        System.out.println(x);
        System.out.println(y);
        System.out.println("A" + z + "B");
        System.out.println("========literalChar-END========");
    }

    private static void literalDouble() {
        System.out.println("========literalInt-START========");
        // 10進数表記
        double a = 12.34;
        System.out.println("a: " + a);
        // 指数表記 (eまたはEで指数を表す)
        double b = 2.34e3; // 2.34 × 10の3乗(1000) = 2340.0
        double c = 2.34e-3; // 2.34 × 10の-3乗(0.001) = 0.00234
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        System.out.println("========literalInt-END========");
    }

    private static void literalInt() {
        System.out.println("========literalInt-START========");
        // 16進数を扱った整数リテラル (先頭に0xとつける)
        int hexA = 0xA; // 10
        int hexB = 0xB; // 11
        System.out.println("16: a + b = " + (hexA + hexB));

        // 10進数を扱った整数リテラル
        int a = 10;
        int b = 11;
        System.out.println("10: a + b = " + (a + b));

        // 8進数を扱った整数リテラル  (先頭に0とつける)
        int baseA = 012; // 10
        int baseB = 013; // 11
        System.out.println("8: a + b = " + (baseA + baseB));

        // 2進数を扱った整数リテラル  (java7以降: 先頭に"0b" または "0B"とつける)
        int bA = 0b1010; // 10
        int bB = 0b1011; // 11
        System.out.println("2: a + b = " + (bA + bB));

        System.out.println("========literalInt-END========");
    }
}
