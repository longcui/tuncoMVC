package com.tunco.model;

import javax.persistence.*;

/**
 * Created by dragon on 24-Jan-15.
 */
@Entity
@Table(name = "user",  uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

//    @Size(min = 3, max = 50)
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = true)
    private String password;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User () {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
