package com.oocl.cultivation;



public class ParkingBoy {

    public String park(Car car, ParkingLot parkingLot) {
        if (null == car.getCarId()){
            return "the car is null.";
        }
        if (parkingLot.theCarHasParked(car)){
            return "the car has parked.";
        }
        parkingLot.getTicketWithCarRecord().size();
        if (parkingLot.getTicketWithCarRecord().size() < 10){
            parkingLot.acceptCar(car);
            TicketGenerator ticket = new Ticket();
            return ticket.generate(car);
        }
        return "no position.";
    }

    public boolean fetchCar(String ticketToken, ParkingLot parkingLot) {
        if (parkingLot.getTicketWithCarRecord().containsKey(ticketToken)){
            parkingLot.returnCar(ticketToken);
            return true;
        }
        return false;
    }
}
