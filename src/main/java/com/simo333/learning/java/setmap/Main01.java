package com.simo333.learning.java.setmap;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main01 {
    static String getStringInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        Set<String> texts = new HashSet<>();
        String line = getStringInput();
        int count = 0;
        while (!"exit".equals(line)) {
            texts.add(line);
            count++;
            line = getStringInput();
        }
        System.out.println("Podanych napisów: " + count + ", Rozmiar kolekcji: " + texts.size());
    }
}
