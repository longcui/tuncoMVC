package com.tunco.configuration.hibernate;

import com.tunco.configuration.AppConfig;
import com.tunco.model.*;
import com.tunco.service.OrderService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = AppConfig.class)
@TransactionConfiguration(defaultRollback = false)
@Transactional

public class HibernateTest extends TestCase {
    @Autowired
    private OrderService orderService;

    @Test
    public void testGetOrder(){
        Order order = orderService.getOrder(29);
        System.out.println(order.getEmail() + "  " + order.getId());
        for (Item item : order.getItems()) {
            System.out.println(item);
        }


        for (Order order1 : orderService.getAllOrders()) {
            System.out.println(order1.getId());
        }

        for (Item item : orderService.getAllItems()) {

            System.out.println(item.getId());
            break;
        }


    }

    @Test
    @Rollback(true)
    public void testOrderSave() {
        Order order = new Order();
        order.setTotalPrice(110);
        order.setEmail("gmail");
        order.setOrderStatus(OrderStatus.COOKING);
        orderService.saveOrder(order);

        Item item = new Item();
        item.setSauceType(SauceType.OYSTER);
        item.setNoodleType(NoodleType.RIS);
        item.setPrice(10);
        item.setName("long");
        item.setDescription("long test");
        item.setQuantity(1);
        item.setTakeAway(false);
        item.setOrder(order);
        orderService.saveItem(item);


        Item item2 = new Item();
        item2.setSauceType(SauceType.PEANUT);
        item2.setNoodleType(NoodleType.EGG);
        item2.setPrice(100);
        item2.setName("long2");
        item2.setDescription("long test2");
        item2.setQuantity(2);
        item2.setTakeAway(true);
        item2.setOrder(order);
        orderService.saveItem(item2);

        //TODO
        List<Item> itemList = new ArrayList<Item>();
        itemList.add(item);
        order.setItems(itemList);
//        orderService.saveOrder(order);

        orderService.deleteOrder(6);

    }

}