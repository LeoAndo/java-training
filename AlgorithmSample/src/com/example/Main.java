package com.example;

public class Main {

    public static void main(String[] args) {
        final int[] scores = {90, 70, 50, 80, 100, 200, 300};
        sort(scores);
        for (int score : scores) {
            System.out.print(score + ",");
        }
    }

    private static void sort(int[] scores) {
        for (int score : scores) {
            boolean isSwap = false;
            for (int j = 0; j < scores.length - 1; j++) {
                if (scores[j] > scores[j + 1]) // swap
                {
                    int temp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp;
                    isSwap = true;
                }
            }
            System.out.println("isSwap: " + isSwap);
            // 並び替えを停止する
            if (!isSwap) {
                break;
            }
        }
    }
}
