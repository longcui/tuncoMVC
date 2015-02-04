package com.tunco.controller;

import com.tunco.model.User;
import com.tunco.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newUser(ModelMap modelMap) {
        User user = new User();
        modelMap.addAttribute("user", user);
        return "registration";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap, HttpServletRequest request) {
        if(bindingResult.hasErrors()) {
            return "registration";
        }
        Object test1 = request.getSession().getAttribute("test1");
        userService.saveUser(user);

        modelMap.addAttribute("success", "Y");
        return "success";
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String getAllUsers(ModelMap modelMap) {
        List<User> users = userService.getAllUsers();
        modelMap.addAttribute("users", users);
        return "allUsers";
    }

    @RequestMapping(value = "/delete-{id}", method =  RequestMethod.GET)
    public String deleteUser(@PathVariable String id) {
        userService.deleteUserById(Integer.valueOf(id));
        return "redirect:/list";
    }
}