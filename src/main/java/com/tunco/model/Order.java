package com.tunco.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
* Created by dragon on 26-Mar-15.
 * about relationship， it defaults to FetchType.LAZY.
*/
@Entity
@Table(name = "order", catalog = "tunco")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", items=" + items.get(0).toString() +
                ", email='" + email + '\'' +
                ", totalPrice=" + totalPrice +
                ", orderStatus=" + orderStatus +
                '}';
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
    private List<Item> items = new ArrayList<Item>();

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "totalPrice", nullable = false)
    private double totalPrice;

    private OrderStatus orderStatus;

    public Order () {

    }

    public Order (String email, List<Item> items, OrderStatus orderStatus) {
        this.email = email;
        this.items = items;
        this.orderStatus = orderStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
