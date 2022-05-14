package com.simo333.learning.java.regex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main03 {
    static String getStringInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static void main(String[] args) {
        List<String> mathOperations = new ArrayList<>();
        String line = getStringInput();
        while (!"quit".equals(line)) {
            line = line.replaceAll("\\s", "");
            if(checkIfMathOperation(line)) {
                mathOperations.add(line);
            }
            line = getStringInput();
        }
        saveToFile(mathOperations);
    }

    static boolean checkIfMathOperation(String txt) {
        return Pattern.matches("^(-?\\d+[\\+\\*\\-\\\\]?)+(\\d+|\\(-?\\d+\\))=-?\\d+$", txt);
    }

    static void saveToFile(List<String> list) {
        Path path = Paths.get("operations.txt");
        try {
            Files.write(path,list, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.println("Could not save the file." + e.getMessage());
        }
    }
}
