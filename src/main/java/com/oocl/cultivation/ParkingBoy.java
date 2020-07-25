package com.oocl.cultivation;



public class ParkingBoy {

    public Message park(Car car, ParkingLot parkingLot) {
        if (null == car.getCarId()){
            return Message.failedMessage("the car is null.");
        }
        if (parkingLot.theCarHasParked(car)){
            return Message.failedMessage("the car has parked.");
        }
        if (parkingLot.getTicketWithCarRecord().size() < 10){
            parkingLot.acceptCar(car);
            TicketGenerator ticket = new Ticket();
            return Message.successMessageWithTicket("the car has parked.", ticket.generate(car));
        }
        return Message.failedMessage( "Not enough position.");
    }

    public Message fetchCar(String ticketToken, ParkingLot parkingLot) {
        if (null == ticketToken){
            return Message.failedMessage("Please provide your parking ticket.");
        }
        if (parkingLot.getTicketWithCarRecord().containsKey(ticketToken)){
            parkingLot.returnCar(ticketToken);
            return Message.successMessage("Fetch the car successfully.");
        }
        return Message.failedMessage("Unrecognized parking ticket.");
    }
}
