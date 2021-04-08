package com.company;

public class Main {
    public static void main(String[] args) {
        literalInt();
    }
    private static void literalInt() {
        System.out.println("========literalInt-START========");
        // 16進数を扱った整数リテラル (先頭に0xとつける)
        int hexA = 0xA; // 10
        int hexB = 0xB; // 11
        System.out.println("16: a + b = " + (hexA+hexB));

        // 10進数を扱った整数リテラル
        int a = 10;
        int b = 11;
        System.out.println("10: a + b = " + (a+b));

        // 8進数を扱った整数リテラル  (先頭に0とつける)
        int baseA = 012; // 10
        int baseB = 013; // 11
        System.out.println("8: a + b = " + (baseA+baseB));

        // 2進数を扱った整数リテラル  (java7以降: 先頭に"0b" または "0B"とつける)
        int bA = 0b1010; // 10
        int bB = 0b1011; // 11
        System.out.println("2: a + b = " + (bA+bB));

        System.out.println("========literalInt-END========");
    }
}
