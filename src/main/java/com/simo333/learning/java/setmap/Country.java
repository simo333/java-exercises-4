package com.simo333.learning.java.setmap;

public class Country {
    String name;
    String capital;

    public Country(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                '}';
    }
}
