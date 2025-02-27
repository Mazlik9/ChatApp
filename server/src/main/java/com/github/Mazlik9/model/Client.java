package com.github.Mazlik9.model;

public class Client {
    private String id;
    private String name;

    // constructors
    public Client(String id, String name){
        this.id = id;
        this.name = name;
    }

    // getters
    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
}
