package com.tunco.model;

/**
 * Created by dragon on 28-Jun-15.
 */
public enum VegetableType {
    CARROT("Gulrot", ""),
    BROCCOLI("Brokkoli", ""),
    MUSHROOMS("Sopp", ""),
    PAPRIKA("Paprika", ""),
    ONION("Løk", ""),
    WATER_CHESTNUTS("Vannkatanjer", ""),
    CABBAGE("Hodekål", ""),
    BABY_CORN("Babymais", "");
    ;
    private String name, description;

    VegetableType(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
