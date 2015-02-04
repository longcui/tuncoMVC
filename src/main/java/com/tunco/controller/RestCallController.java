//package com.tunco.controller;
//
//import com.tunco.model.User;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.concurrent.atomic.AtomicLong;
//
///**
// * Created by dragon on 24-Jan-15.
// */
//@RestController
//@RequestMapping("/createUser")
//public class RestCallController {
//    private final AtomicLong counter = new AtomicLong();
//
//    @RequestMapping(value = "/not/{name}")
//    public  User createUserWrong(@PathVariable String name) {
//        long cnt = counter.incrementAndGet();
//        return new User(name, (int) cnt);
//    }
//
//    @RequestMapping(value = {"/{name}", "/"})
//    public @ResponseBody String createUser(@PathVariable String name) {
//        long cnt = counter.incrementAndGet();
//        return cnt + " " + name;
//    }
//
//}
