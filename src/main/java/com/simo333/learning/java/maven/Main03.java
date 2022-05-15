package com.simo333.learning.java.maven;

import com.google.common.collect.Lists;

import java.util.List;

public class Main03 {
    public static void main(String[] args) {
        List<String> names = Lists.newArrayList("Arek", "Czarek", "Darek");
        List<String> reversed = Lists.reverse(names);
        System.out.println(reversed);
        List<Character> characters = Lists.charactersOf("Szymon");
        System.out.println(characters);
        List<List<String>> partition = Lists.partition(names, 2);
        System.out.println(partition);
    }
}
