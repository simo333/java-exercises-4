package com.simo333.learning.java.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main01 {

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

        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i));
        }
        System.out.println();

        Iterator<Integer> iterator = elements.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        for(iterator = elements.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
        System.out.println();

        for (Integer element : elements) {
            System.out.println(element);
        }


    }
}
