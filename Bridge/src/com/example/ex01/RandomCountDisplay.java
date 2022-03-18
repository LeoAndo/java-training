package com.example.ex01;

import com.example.CountDisplay;
import com.example.DisplayImpl;

import java.util.Random;

class RandomCountDisplay extends CountDisplay {
    private final Random random = new Random();

    RandomCountDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void randomDisplay(int times) {
        multiDisplay(random.nextInt(times));
    }
}
