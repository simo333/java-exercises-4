package com.simo333.learning.java.setmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main02 {
    public static Map<String, String> getMap() {
        Map<String, String> questions = new HashMap<>();
        questions.put("ciepło", "zimno");
        questions.put("kot", "pies");
        questions.put("góra", "dół");
        questions.put("lewo", "prawo");
        questions.put("uczciwy", "polityk");
        return questions;
    }

    public static void main(String[] args) {
        Map<String, String> questions = getMap();
        Scanner scanner = new Scanner(System.in);
        int points = 0;
        for (String key : questions.keySet()) {
            System.out.println("Podaj przeciwieństwo do " + key);
            String answer = scanner.nextLine();
            if(questions.get(key).equalsIgnoreCase(answer)) {
                points++;
            }
        }
        System.out.println("Poprawnych odpowiedzi: " + points);
    }
}
