package com.tunco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by dragon on 27-Jun-15.
 */
@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @Column(name = "user_role_id")
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "ROLE")
    private String role;

    public UserRole(String userName, String role) {
        this.userName = userName;
        this.role = role;
    }

    public int getId() {
        return id;
    }


    public String getUserName() {
        return userName;
    }


    public String getRole() {
        return role;
    }

}
