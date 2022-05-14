package com.simo333.learning.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main02 {
    static boolean verifyPassword(String password) {
        Pattern patternLength = Pattern.compile("^\\S{10,15}$");
        Matcher matcherLength = patternLength.matcher(password);
        if (!matcherLength.matches()) {
            return false;
        }
        Pattern patternSmallLetter = Pattern.compile("^.*[a-z].*$");
        Matcher matcherSmallLetter = patternSmallLetter.matcher(password);
        if(!matcherSmallLetter.matches()) {
            return false;
        }
        Pattern patternGreatLetter = Pattern.compile("^.*[A-Z].*$");
        Matcher matcherGreatLetter = patternGreatLetter.matcher(password);
        if(!matcherGreatLetter.matches()) {
            return false;
        }
        Pattern patternMultipleInRow = Pattern.compile("[a-z]{2}|[A-Z]{2}");
        Matcher matcherMultipleInRow = patternMultipleInRow.matcher(password);
        if (matcherMultipleInRow.find()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(verifyPassword("aZ34567890"));
        System.out.println(verifyPassword("aaaZ567890"));
        System.out.println(verifyPassword("a"));
        System.out.println(verifyPassword("1234567890123456"));
    }
}
