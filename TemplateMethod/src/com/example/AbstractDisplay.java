package com.example;

public interface AbstractDisplay {
    // open, print, closeはサブクラスに実装をまかせる抽象メソッド
    void open();

    void print();

    void close();

    // displayはAbstractDisplayで実装してるメソッド
    default void display() {
        open();
        for (int i = 0; i < 5; i++) { // 5回出力する仕様とする
            print();
        }
        close();
    }
}
