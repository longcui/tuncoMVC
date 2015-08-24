package com.tunco.web;

import com.tunco.model.NoodleType;
import com.tunco.model.SauceType;

/**
 * Created by dragon on 16-May-15.
 */
public class ItemRep {
    private String name, description;
    private NoodleType noodleType;
    private SauceType sauceType;
    private  boolean takeAway;
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NoodleType getNoodleType() {
        return noodleType;
    }

    public void setNoodleType(NoodleType noodleType) {
        this.noodleType = noodleType;
    }

    public SauceType getSauceType() {
        return sauceType;
    }

    public void setSauceType(SauceType sauceType) {
        this.sauceType = sauceType;
    }

    public boolean isTakeAway() {
        return takeAway;
    }

    public void setTakeAway(boolean takeAway) {
        this.takeAway = takeAway;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
