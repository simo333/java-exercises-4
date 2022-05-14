package com.simo333.learning.java.setmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main03 {
    public static List<Country> initialize() {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Polska", "Warszawa"));
        countries.add(new Country("Niemcy", "Berlin"));
        countries.add(new Country("Włochy", "Rzym"));
        countries.add(new Country("Hiszpania", "Madryt"));
        countries.add(new Country("Francja", "Paryż"));
        return countries;
    }

    public static Map<String, Country> getMap(List<Country> list) {
        Map<String, Country> countryMap = new HashMap<>();
        for (Country country : list) {
            countryMap.put(country.capital, country);
        }
        return countryMap;
    }

    public static void main(String[] args) {
        Map<String, Country> map = getMap(initialize());
        for (String s : map.keySet()) {
            System.out.println(s + " - " + map.get(s).name);
        }
    }
}