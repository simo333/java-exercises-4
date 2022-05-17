package com.simo333.learning.java.collections.part2;

import java.util.regex.Pattern;

public class Main03 {
    static boolean verifyLogin(String login) {
        String regex = "[a-zA-Z_-][a-zA-Z\\d_-]{4,}";
        return Pattern.matches(regex, login);
    }

    public static void main(String[] args) {
        System.out.println(verifyLogin("123szymon"));
        System.out.println(verifyLogin("szymon"));
    }
}