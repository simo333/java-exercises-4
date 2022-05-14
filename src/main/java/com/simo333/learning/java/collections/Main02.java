package com.simo333.learning.java.collections;

import java.util.ArrayList;
import java.util.List;

public class Main02 {
    public static void removeDivider(List<Integer> list, int divider) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % divider == 0) {
                list.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<>();
        elements.add(10);
        elements.add(11);
        elements.add(12);
        elements.add(13);
        elements.add(14);
        elements.add(15);
        elements.add(16);
        elements.add(17);
        elements.add(18);
        elements.add(19);

        removeDivider(elements, 2);
        System.out.println(elements);
    }
}
