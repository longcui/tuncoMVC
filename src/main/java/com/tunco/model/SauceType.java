package com.tunco.model;

/**
 * Created by dragon on 26-Mar-15.
 */
public enum SauceType {
    OYSTER("Østers", "*Gluten,alergen 2…", 10),
    TANDOORI("Tandoori", "", 10),
    MEXICAN("Meksikansk", "", 10),
    RED_CURRY("Rød karri", "", 10),
    PEANUT("Peanøtt", "", 20);

    private String name;
    private String description;
    private double price;

    SauceType(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
