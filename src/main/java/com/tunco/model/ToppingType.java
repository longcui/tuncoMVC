package com.tunco.model;

/**
* Created by dragon on 28-Jun-15.
*/
public enum ToppingType {
    PEANUT("peanøtter", ""),
    CRUSHED("Knuste", ""),
    CORIANDER("Frisk Koriander", ""),
    BEAN_SPROUTS("Bønnespirer", ""),
    LIME("Limebåter", "");

    private String name, description;

    ToppingType(String name, String description) {
        this.name = name;
        this.description = description;
    }
}