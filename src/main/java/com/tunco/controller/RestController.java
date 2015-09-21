package com.tunco.controller;

import com.tunco.model.*;
import com.tunco.service.GenericService;
import com.tunco.service.OrderService;
import com.tunco.service.UserService;
import com.tunco.tool.EmailUtil;
import com.tunco.web.OrderRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dragon on 07-Apr-15.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private GenericService genericService;

    @RequestMapping(value = "/getAllOrders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        Greeting greeting = new Greeting(1, String.format("Hello, %s!", name));
        return greeting;
    }

    @RequestMapping(value = "/fbLogin", method = RequestMethod.POST)
    public String fbLogin(@RequestBody FacebookUser facebookUser) {
        userService.saveUser(facebookUser);
        return "redirect:"+ "/web/order";
    }

    @RequestMapping(value = "/getCompositeDishList")
    public List<String> getCompositeDishList(){
        List<String> ret = new ArrayList<String>();
        for (CompositeDish compositeDish : CompositeDish.values()) {
            ret.add(compositeDish.getDishName());
        }
        return ret;
    }

    @RequestMapping(value = "/getVegetablesList")
    public List<Object> getVegetablesList(){
        return genericService.getAll(VegetableType.class);
    }

    @RequestMapping(value = "/getDrinksList")
    public List<Object> getDrinksList(){
        return genericService.getAll(DrinkType.class);
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ResponseEntity<?> order(@RequestBody OrderRep orderRep) {
//        item.setNoodleType(NoodleType.RIS);
//        item.setSauceType(SauceType.OYSTER);
//        item.setDescription("description");
//        item.setPrice(40);
//        item.setQuantity(1);
//        item.setName("long");
//        item.setTakeAway(false);

//        order.setEmail("ttt");
//        order.setTotalPrice(99);
//        order.setOrderStatus(OrderStatus.REQUEST);
//        item.setOrder(order);

        //email validation
        String email = orderRep.getEmail();
        boolean validEmailAddress = EmailUtil.isValidEmailAddress(email);
        if (!validEmailAddress) {
            return new ResponseEntity<String>("Email is not a valid form.", HttpStatus.BAD_REQUEST);
        }

        //save user
        User user = new User(orderRep.getName(), email);
        userService.saveUser(user);

        Order order = new Order(email, orderRep.getItems(), orderRep.getOrderStatus());
        orderService.saveOrder(order);
        for (Item item : orderRep.getItems()) {
            item.setOrder(order);
            item.setProteinType(ProteinType.BEEF);
            item.setToppingType(ToppingType.BEAN_SPROUTS);
            item.setPrice(item.calculatePrice());
            orderService.saveItem(item);
        }
        EmailUtil.sendEmail(email, "Order Information", order.toString());
        return new ResponseEntity<String>("order sent.", HttpStatus.OK);
    }

}
