package com.tunco.model;

/**
 * Created by dragon on 28-Jun-15.
 */
public enum ProteinType {
    BEEF("Biff", ""),
    PORK("Svin", ""),
    FISH("Fisk", ""),
    CHICKEN("Kylling", ""),
    TOFU("Tofu", "");

    private String name, description;

    ProteinType(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
