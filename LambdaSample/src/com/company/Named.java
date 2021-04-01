package com.company;

public interface Named {
    default String getName() {
        return "Hello, Java.";
    }
}