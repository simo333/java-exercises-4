package com.simo333.learning.java.collections.part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

public class Main04 {
    public static void main(String[] args) {
        List<List<String>> stringPeople = readFile();
        List<Person> personList = new ArrayList<>();
        for (List<String> person : stringPeople) {
            if (isCorrectPersonParams(person)) {
                personList.add(new Person(person.get(1), person.get(2),
                        Integer.parseInt(person.get(3)), person.get(4)));
            }
        }

        //Task05
        Map<Integer, List<Person>> peopleByAge = new HashMap<>();
        for (Person person : personList) {
            peopleByAge.computeIfAbsent(person.getAge(), v -> {
                List<Person> list = new ArrayList<>();
                list.add(person);
                return list;
            });
            peopleByAge.computeIfPresent(person.getAge(), (k, v) -> {
                v.add(person);
                return v;
            });
        }

        for (Integer key : peopleByAge.keySet()) {
            System.out.println(key + ": " + peopleByAge.get(key).size());
        }
    }

    static List<List<String>> readFile() {
        List<String> linesFromFile = new ArrayList<>();
        List<List<String>> splitLines = new ArrayList<>();
        Path path = Paths.get("src/main/java/com/simo333/learning/java/collections/part2/people.csv");
        try {
            linesFromFile = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String line : linesFromFile) {
            splitLines.add(Arrays.asList(line.split(",")));
        }
        return splitLines;
    }

    static boolean isCorrectPersonParams(List<String> personStrings) {
        if (personStrings.size() != 5) {
            return false;
        }
        String regexEmail = "^(.+)@(.+)$";
        String regexLettersOnly = "^\\S{2,}$";
        String regexAgeValue = "^0|(1[0-2]\\d)|([1-9]\\d?)$";
        return Pattern.matches(regexEmail, personStrings.get(0))
                && Pattern.matches(regexLettersOnly, personStrings.get(1))
                && Pattern.matches(regexLettersOnly, personStrings.get(2))
                && Pattern.matches(regexLettersOnly, personStrings.get(4))
                && Pattern.matches(regexAgeValue, personStrings.get(3));
    }


}
