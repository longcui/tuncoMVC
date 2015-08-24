package com.tunco.web;

import com.tunco.model.Item;
import com.tunco.model.OrderStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dragon on 16-May-15.
 */
public class OrderRep {
    private String email, telephone, name;

    private OrderStatus orderStatus;

    private List<Item> items = new ArrayList<Item>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
