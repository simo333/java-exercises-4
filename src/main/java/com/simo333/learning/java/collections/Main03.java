package com.simo333.learning.java.collections;

import java.util.ArrayList;
import java.util.List;

public class Main03 {
    public static List<City> initialize() {
        List<City> list = new ArrayList<>();
        list.add(new City("Krawków", 315000));
        list.add(new City("Poznań", 520100));
        list.add(new City("Warszawa", 1723500));
        list.add(new City("Wrocław", 612300));
        list.add(new City("Gdańsk", 375000));
        return list;
    }

    public static List<City> firstSubList(List<City> list, int start, int end) {
        if (list == null || list.isEmpty()) {
            return new ArrayList<>();
        }
        if (end < 0 || start < 0) {
            throw new IllegalArgumentException("Params start and end cannot be negative value");
        }
        if (end >= list.size() || start >= list.size()) {
            throw new IllegalArgumentException("Params cannot be greater than list's size");
        }
        if (end < start) {
            throw new IllegalArgumentException("End param cannot be lower than start param");
        }
        List<City> newList = new ArrayList<>();
        for (int i = start; i < end; i++) {
            newList.add(list.get(i));
        }
        return newList;
    }

    public static List<City> secondSubList(List<City> list, int start, int end) {
        return list.subList(start, end);
    }


    public static void main(String[] args) {
        List<City> cityList = initialize();
        System.out.println(cityList);

        List<City> subCityList = firstSubList(cityList, 1, 3);
        System.out.println(subCityList);

        List<City> subCityList2 = firstSubList(cityList, 1, 3);
        System.out.println(subCityList);


    }
}
