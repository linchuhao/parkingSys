package com.oocl.cultivation;

public class SuperSmartParkingBoy extends Boy {
    public Message park(Car car, ParkingLotManagement parkingLotManagement) {
        if (null == car.getCarId()){
            return Message.failedMessage("the car is null.");
        }
        if (parkingLotManagement.getParkingLotList().listIterator().next().theCarHasParked(car)){
            return Message.failedMessage("the car has parked.");
        }
        if (parkingLotManagement.acceptCarFromSuperSmartParkingBoy(car)){
            TicketGenerator ticket = new Ticket();
            return Message.successMessageWithTicket("the car has parked.", ticket.generate(car));
        }
        return Message.failedMessage( "Not enough position.");
    }

    public Message fetchCar(String ticketToken, ParkingLotManagement parkingLotManagement) {
        if (null == ticketToken){
            return Message.failedMessage("Please provide your parking ticket.");
        }
        if (parkingLotManagement.returnCar(ticketToken)){
            return Message.successMessage("Fetch the car successfully.");
        }
        return Message.failedMessage("Unrecognized parking ticket.");
    }
}
