package com.tunco.model;

/**
 * Created by dragon on 28-Jun-15.
 */
public enum CompositeDish {
    KICKING_OYSTER("Kicking Oyster", "Risnudler,egg" +
            "Gulrot,paprika,soppbrokkoli,løk" +
            "Kylling" +
            "Østerssaus" +
            "Ferskkoriander,limebåter"),
    TEST("test", "this is a test dish");


    private String dishName, Description;

    CompositeDish(String dishName, String description) {
        this.dishName = dishName;
        Description = description;
    }

    public String getDishName() {
        return dishName;
    }

    public String getDescription() {
        return Description;
    }
}
