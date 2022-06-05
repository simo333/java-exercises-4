package com.simo333.learning.java.extratasks.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GenerateRandom {
    public static Map<Integer, Integer> checkRand(int amount, int interval) {
        Map<Integer, Integer> mapRandom = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < amount; i++) {
            int newRandom = random.nextInt(interval);
            mapRandom.putIfAbsent(newRandom, 1);
            mapRandom.computeIfPresent(newRandom, (k, v) -> v + 1);
        }
        return mapRandom;
    }
}
