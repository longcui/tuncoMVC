package com.tunco.service;

import com.tunco.dao.OrderDao;
import com.tunco.model.Item;
import com.tunco.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dragon on 17-Mar-15.
 */
@Service("orderService")
@Transactional
public class OrderService   {
    @Autowired
    OrderDao orderDao;

    public void saveItem(Item item) {
        orderDao.saveItem(item);
    }


    public Item getItem(int id) {
         return orderDao.getItem(id);
    }

    public List<Item> getAllItems() {
        return  orderDao.getAllItems();
    }
    public void saveOrder(Order order) {
        orderDao.saveOrder(order);
    }

    public Order getOrder(int orderId) {
        return orderDao.getOrder(orderId);
    }

    public void deleteOrder(int orderId) {
        orderDao.deleteOrder(orderId);
    }

    public List<Order> getAllOrders(){
        return orderDao.getAllOrders();
    }
}
