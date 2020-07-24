package com.oocl.cultivation;



public class ParkingBoy {

    public String park(Car car, ParkingLot parkingLot) {
        if (parkingLot.getPositionNum() < 10){
            TicketGenerator ticket = new Ticket();
            return ticket.generate(car);
        }
        return "not position";
    }

    public boolean fetchCar(String ticket, ParkingLot parkingLot) {
        return parkingLot.getTicketList().contains(ticket);
    }
}
