package com.stackroute.model;

import org.springframework.beans.factory.annotation.Autowired;

public class User {
    private int userId;
    private String userName;
    private String password;

    @Autowired
    private Address address;

    public  User(){}

    public User(int userId, String userName, String password,Address address ) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.address=address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }
   // @Autowired
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                '}';
    }
}
