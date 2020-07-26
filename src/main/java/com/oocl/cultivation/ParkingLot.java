package com.oocl.cultivation;

import java.util.HashMap;

public class ParkingLot{

    private Ticket ticket = new Ticket();

    private HashMap<String, String> ticketWithCarRecord = new HashMap<String, String>();

    public ParkingLot() { }

    public boolean theCarHasParked(Car car) {
        if (ticketWithCarRecord.isEmpty()){
            return false;
        }
        return ticketWithCarRecord.containsValue(car.getCarId());
    }

    public void acceptCar(Car car) {
        String ticketToken = ticket.generate(car);
        ticketWithCarRecord.put(ticketToken, car.getCarId());
    }

    public void returnCar(String ticketToken) {
        ticketWithCarRecord.remove(ticketToken);
    }

    public HashMap<String, String> getTicketWithCarRecord() {
        return ticketWithCarRecord;
    }
}
