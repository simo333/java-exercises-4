package com.simo333.learning.java.session;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class CartItem {
    private String name;
    private int quantity;
    private double price;

    public CartItem(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.price = BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceForQuantity() {
        return BigDecimal.valueOf(price * quantity).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public String toString() {
        return name + " - " + quantity + " x " + price + "zł = " + getPriceForQuantity() + "zł";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return Objects.equals(name, cartItem.name);
    }
}
