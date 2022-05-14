package com.simo333.learning.java.collections;

import java.util.*;

public class Main04 {
    public static List<City> reverse(List<City> list) {
        List<City> reversedList = new ArrayList<>();
        for (ListIterator<City> it = list.listIterator(list.size()); it.hasPrevious();) {
            reversedList.add(it.previous());
        }
        return reversedList;
    }

    public static void main(String[] args) {
        List<City> cityList = Main03.initialize();
        List<City> reversedCityList = reverse(cityList);
        System.out.println(reversedCityList);
    }
}
