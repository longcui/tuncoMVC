package com.tunco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by dragon on 06-Jun-15.
 */
@Entity
@Table(name = "facebookuser")
public class FacebookUser extends User {
    @Column(name = "accessToken")
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
