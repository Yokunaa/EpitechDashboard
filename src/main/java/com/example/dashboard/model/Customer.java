package com.example.dashboard.model;

public class Customer {

    private String host;

    public Customer(String ip) {
        super();
        this.host = ip;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}