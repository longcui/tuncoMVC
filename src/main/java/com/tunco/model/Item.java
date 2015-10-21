package com.tunco.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by dragon on 26-Mar-15.
 */
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", noodleType=" + noodleType +
                ", proteinType=" + proteinType +
                ", vegetableTypes=" + vegetableTypes +
                ", sauceType=" + sauceType +
                ", toppingType=" + toppingType +
                ", price=" + price +
                ", takeAway=" + takeAway +
                ", quantity=" + quantity +
                '}';
    }

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "noodleType", nullable = false)
    private NoodleType noodleType;

    @Column(name = "proteinType", nullable = false)
    private ProteinType proteinType;

    @Transient
    private ArrayList<VegetableType11> vegetableTypes;

    @Column(name = "sauceType", nullable = false)
    private SauceType sauceType;

    @Column(name = "toppingType", nullable = false)
    private ToppingType toppingType;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "takeAway", nullable = false)
    private boolean takeAway;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private Order order;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Transient
    public double calculatePrice() {
        if (noodleType != null && sauceType != null) {
            return noodleType.getPrice() + sauceType.getPrice();
        } else {
            return 0;
        }
    }


    public ArrayList<VegetableType11> getVegetableTypes() {
        return vegetableTypes;
    }

    public void setVegetableTypes(ArrayList<VegetableType11> vegetableTypes) {
        this.vegetableTypes = vegetableTypes;
    }

    public ProteinType getProteinType() {
        return proteinType;
    }

    public void setProteinType(ProteinType proteinType) {
        this.proteinType = proteinType;
    }

    public ToppingType getToppingType() {
        return toppingType;
    }

    public void setToppingType(ToppingType toppingType) {
        this.toppingType = toppingType;
    }
}
