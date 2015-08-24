package com.tunco.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by dragon on 26-Mar-15.
 */
@Entity
@Table(name = "item", catalog = "tunco")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "noodleType", nullable = false)
    private NoodleType noodleType;

    @Column(name = "proteinType", nullable = false)
    private ProteinType proteinType;

    @Column(name = "vegetableType", nullable = false)
    private ArrayList<VegetableType> vegetableType;

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
        if(noodleType != null && sauceType != null) {
            return noodleType.getPrice() + sauceType.getPrice();
        } else {
            return 0;
        }
    }

    public ArrayList<VegetableType> getVegetableType() {
        return vegetableType;
    }

    public void setVegetableType(ArrayList<VegetableType> vegetableType) {
        this.vegetableType = vegetableType;
    }
}
