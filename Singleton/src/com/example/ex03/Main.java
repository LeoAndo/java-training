package com.example.ex03;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start.");
        Triple a1 = Triple.valueOf("ALPHA");
        Triple b1 = Triple.valueOf("BETA");
        Triple c1 = Triple.valueOf("GAMMA");
        Triple a2 = Triple.valueOf("ALPHA");
        Triple b2 = Triple.valueOf("BETA");
        Triple c2 = Triple.valueOf("GAMMA");
        if (a1 == a2) {
            System.out.println("a1 == a2 (" + a1 + ")");
        } else {
            System.out.println("a1 != a2");
        }
        if (b1 == b2) {
            System.out.println("b1 == b2 (" + b1 + ")");
        } else {
            System.out.println("b1 != b2");
        }
        if (c1 == c2) {
            System.out.println("c1 == c2 (" + c1 + ")");
        } else {
            System.out.println("c1 != c2");
        }
        System.out.println("End.");
    }
}