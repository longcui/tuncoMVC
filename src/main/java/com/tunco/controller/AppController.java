package com.tunco.controller;

import com.tunco.model.Company;
import com.tunco.model.User;
import com.tunco.service.CompanyService;
import com.tunco.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @RequestMapping("/")
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}

    //Spring Security see this :
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }
    @RequestMapping(value = "/newUser", method = RequestMethod.GET)
    public String newUser(ModelMap modelMap) {
        User user = new User();
        modelMap.addAttribute("user", user);
        return "newUser";
    }

    @RequestMapping(value = {"/saveUser"}, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap, HttpServletRequest request) {
        if(bindingResult.hasErrors()) {
            return "newUser";
        }
        Object test1 = request.getSession().getAttribute("test1");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = user.getPassword();
        String encoded = passwordEncoder.encode(password);
        user.setPassword(encoded);

        userService.saveUser(user);

        modelMap.addAttribute("success", "Y");
        return "userCreatedSuccess";
    }

    @RequestMapping(value = {"/userList"}, method = RequestMethod.GET)
    public String getAllUsers(ModelMap modelMap) {
        List<User> users = userService.getAllUsers();
        modelMap.addAttribute("users", users);
        return "userList";
    }

    @RequestMapping(value = "/deleteUser_{id}", method =  RequestMethod.GET)
    public String deleteUser(@PathVariable String id) {
        userService.deleteUserById(Integer.valueOf(id));
        return "redirect:/userList";
    }

    @RequestMapping(value = {"/deleteCompany_{id}"}, method =  RequestMethod.GET)
    public String deleteCompanyById(@PathVariable String id){
        companyService.deleteCompanyById(Integer.valueOf(id));
        return "redirect:/companyList";
    }

    @RequestMapping(value = "/newCompany", method = RequestMethod.GET)
    public String newCompany(ModelMap modelMap) {
        Company company = new Company();
        modelMap.addAttribute("company", company);
        return "newCompany";
    }

    @RequestMapping(value = {"/saveCompany"}, method = RequestMethod.POST)
    public String saveCompany(@Valid Company company, BindingResult bindingResult, ModelMap modelMap, HttpServletRequest request) {
        if(bindingResult.hasErrors()) {
            return "newCompany";
        }
        Object test1 = request.getSession().getAttribute("test1");
        companyService.saveCompany(company);

        modelMap.addAttribute("success", "Y");
        return "companyCreatedSuccess";
    }

    @RequestMapping(value = {"/companyList"}, method = RequestMethod.GET)
    public String getAllCompanies(ModelMap modelMap) {
        List<Company> allCompanies = companyService.getAllCompanies();
        modelMap.addAttribute("companies", allCompanies);
        return "allCompanies";
    }

//    public String order() {
//
//    }

    @RequestMapping(value = {"/order"}, method = RequestMethod.GET)
    public String order() {
        return "order";
    }

    @RequestMapping(value = {"/allOrders"}, method = RequestMethod.GET)
    public String getAllOrders() {
        return "allOrders";
    }

}