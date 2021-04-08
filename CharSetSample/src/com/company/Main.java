package com.company;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {

    // フォーマット: 0埋め,２桁,１６進数(Xで大文字,xで小文字になる)
    private static final String FORMAT = " %02X";
    public static void main(String[] args) {
        utf8Test();
        utf16Test();
        utf32Test();
    }

    private static void utf8Test() {
        System.out.println("==========utf8Test-START==========");
        byte[] utf8AsciiBytes = "R".getBytes(StandardCharsets.UTF_8); // UTF-8: Ascii文字は8ビット(1バイト)で表現
        for (byte b : utf8AsciiBytes) {
            System.out.printf(FORMAT, b);
        }
        System.out.println();

        byte[] utf8Bytes = "あ".getBytes(StandardCharsets.UTF_8); // UTF-8: 日本語は24ビット(３バイト)で表現
        for (byte b : utf8Bytes) {
            System.out.printf(FORMAT, b);
        }
        System.out.println();
        System.out.println("==========utf8Test-END==========");
    }

    private static void utf16Test() {
        System.out.println("==========utf16Test-START==========");
        // UTF-16: 全ての文字を16ビット(2バイト)で表現

        byte[] utf16AsciiBytes = "R".getBytes(StandardCharsets.UTF_16);
        for (byte b : utf16AsciiBytes) {
            System.out.printf(FORMAT, b);
        }
        System.out.println();

        byte[] utf16Bytes = "あ".getBytes(StandardCharsets.UTF_16);
        for (byte b : utf16Bytes) {
            System.out.printf(FORMAT, b);
        }
        System.out.println();
        System.out.println("==========utf16Test-END==========");
    }

    private static void utf32Test() {
        System.out.println("==========utf32Test-START==========");
        // UTF-32: 全ての文字を32ビット(4バイト)で表現
        // メモリをよく使うのであまり使われていない.

        byte[] utf32AsciiBytes = "R".getBytes(Charset.forName("UTF-32"));
        for (byte b : utf32AsciiBytes) {
            System.out.printf(FORMAT, b);
        }
        System.out.println();

        byte[] utf32Bytes = "あ".getBytes(Charset.forName("UTF-32"));
        for (byte b : utf32Bytes) {
            System.out.printf(FORMAT, b);
        }
        System.out.println();
        System.out.println("==========utf32Test-END==========");
    }
}
