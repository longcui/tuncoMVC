package com.tunco.dao;

import com.tunco.model.User;

import java.util.List;
 
public interface UserDao {
 
    void saveUser(User user);
     
    List<User> findAllUsers();
     
    void deleteUserByName(String name);

    void deleteUserById(int id);
}