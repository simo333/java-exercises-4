package com.simo333.learning.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main01 {
    static boolean verifyEmail(String email) {
        Pattern pattern = Pattern.compile("[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    static boolean verifyEmail2(String email) {
        return Pattern.matches("[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}", email);
    }

    public static void main(String[] args) {
        String email = "sz@@pl";
        System.out.println(verifyEmail(email));
    }
}
