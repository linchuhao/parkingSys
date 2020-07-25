package com.oocl.cultivation;

public class Ticket implements TicketGenerator{

    public Ticket() {

    }

    private String token;

    @Override
    public String generate(Car car) {
        return "ticket: " + car.getCarId();
    }
}
