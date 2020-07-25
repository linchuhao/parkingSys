package com.oocl.cultivation;



public class ParkingBoy {

    public String park(Car car, ParkingLot parkingLot) {
        if (parkingLot.getPositionNum() < 10){
            TicketGenerator ticket = new Ticket();
            return ticket.generate(car);
        }
        return "no position";
    }

    public boolean fetchCar(String ticket, ParkingLot parkingLot) {
        if (parkingLot.getTicketList().contains(ticket)){
            //remove
            parkingLot.getTicketList().remove(ticket);
            return true;
        }
        return false;
    }
}
