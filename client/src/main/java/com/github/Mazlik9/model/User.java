package com.github.Mazlik9.model;

public class User {
    private String username;
    private String password;

    // constructors
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    // getters
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
}
