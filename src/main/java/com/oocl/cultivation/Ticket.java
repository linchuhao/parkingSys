package com.oocl.cultivation;

public class Ticket implements TicketGenerator{

    public Ticket() {

    }

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

    @Override
    public String generate(Car car) {
        return "ticket: " + car.getCarId();
    }
}
