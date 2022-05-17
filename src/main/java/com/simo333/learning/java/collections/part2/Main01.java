package com.simo333.learning.java.collections.part2;

import java.util.Map;

public class Main01 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = GenerateRandom.checkRand(500000, 10);
        for (Integer key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }

}
