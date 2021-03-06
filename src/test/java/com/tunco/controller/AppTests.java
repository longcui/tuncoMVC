package com.tunco.controller;

import com.tunco.configuration.AppConfig;
import com.tunco.model.Item;
import com.tunco.model.NoodleType;
import com.tunco.model.Order;
import com.tunco.model.SauceType;
import com.tunco.service.OrderService;
import com.tunco.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = AppConfig.class)
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class AppTests {
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void simple() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"));
    }

    @Test
    public void testOrderSave() {
        Order order = new Order();
        order.setTotalPrice(110);
        order.setEmail("gmail");
//        orderService.saveOrder(order);

        Item item = new Item();
        item.setSauceType(SauceType.OYSTER);
        item.setNoodleType(NoodleType.RIS);
        item.setPrice(10);
        item.setName("long");
        item.setDescription("long test");
        item.setQuantity(1);
        item.setTakeAway(false);
        item.setOrder(order);
//        orderService.saveItem(item);


        Item item2 = new Item();
        item2.setSauceType(SauceType.PEANUT);
        item2.setNoodleType(NoodleType.EGG);
        item2.setPrice(100);
        item2.setName("long2");
        item2.setDescription("long test2");
        item2.setQuantity(2);
        item2.setTakeAway(true);
        item2.setOrder(order);
//        orderService.saveItem(item2);

        List<Item> itemList = new ArrayList<Item>();
        itemList.add(item);
        order.setItems(itemList);
        orderService.saveOrder(order);
    }

    @Test
    public void testSaveUser() {
//        User user = new User();
//        user.setEmail("aa");
//        user.setName("aa");
//        user.setPassword("aa");
//        userService.saveUser(user);
    }
}
