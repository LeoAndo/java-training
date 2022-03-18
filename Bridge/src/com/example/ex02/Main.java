package com.example.ex02;

import com.example.CountDisplay;

public class Main {
    public static void main(String[] args) {
        final String filename = "/Users/ando/work/java/java-training/Bridge/src/com/example/ex02/star.txt";
        final CountDisplay d = new CountDisplay(new FileDisplayImpl(filename));
        d.multiDisplay(3);
    }
}
