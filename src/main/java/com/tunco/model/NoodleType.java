package com.tunco.model;

/**
 * Created by dragon on 26-Mar-15.
 */
public enum NoodleType {
    RIS("Risnudler", "aa", 100),
    HVETE("Hvetenudler", "*Gluten", 100),
    FULLKORN("Fullkornsris", "aa", 100),
    JASMIN("Jasminris", "aa", 100),
    EGG("Eggnudler", "bb", 200);

    private String name;
    private String description;
    private double price;

    NoodleType(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
