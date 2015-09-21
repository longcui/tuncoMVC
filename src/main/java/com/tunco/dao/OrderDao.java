package com.tunco.dao;

import com.tunco.model.Item;
import com.tunco.model.Order;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dragon on 17-Mar-15.
 */
@Repository
public class OrderDao extends AbstractDao {
    public void saveItem(Item item) {
        persist(item);
    }

    public List<Order> getAllOrders() {
        Criteria criteria = getSession().createCriteria(Order.class);
        return criteria.list();
    }

    public void deleteOrder(int orderId) {
//        SQLQuery sqlQuery = getSession().createSQLQuery("DELETE FROM tunco.order WHERE id = :orderId");
//        sqlQuery.setInteger("orderId", orderId);
//        sqlQuery.executeUpdate();
        Object o = getSession().get(Order.class, orderId);
        if(o != null) {
            getSession().delete(o);
        }
    }

    public Order getOrder(int orderId) {
//        SQLQuery sqlQuery = getSession().createSQLQuery("SELECT * FROM order WHERE id = : orderId");
//        sqlQuery.setInteger("orderId", orderId);
        return (Order) getSession().get(Order.class, orderId);

    }

    public void saveOrder(Order order) {
        persist(order);
    }

    public Item getItem(int id) {
        return (Item) getSession().get(Item.class, id);
    }

    public List<Item> getAllItems() {
        return getSession().createCriteria(Item.class).list();
    }
}
