package com.example.ex01;

import com.example.StringDisplayImpl;

public class Main {
    public static void main(String[] args) {
        final RandomCountDisplay d4 = new RandomCountDisplay(new StringDisplayImpl("Hello, World."));
        d4.display();
        d4.randomDisplay(10);
    }
}
