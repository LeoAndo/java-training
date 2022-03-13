package com.example.ex02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public record Triple(String name) {
    private static final Map<String, Triple> map = new HashMap<>();

    static {
        String[] names = {"ALPHA", "BETA", "GAMMA"};
        Arrays.stream(names).forEach(s -> map.put(s, new Triple(s)));
    }

    public Triple {
        System.out.println("The instance " + name + " is created.");
    }

    public static Triple getInstance(String name) {
        return map.get(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}