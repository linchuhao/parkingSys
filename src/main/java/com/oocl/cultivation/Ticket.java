package com.oocl.cultivation;

public class Ticket {

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;

    public Ticket(String token) {
        this.token = token;
    }
}
