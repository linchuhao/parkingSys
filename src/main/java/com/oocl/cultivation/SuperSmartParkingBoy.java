package com.oocl.cultivation;

public class SuperSmartParkingBoy extends Boy {
    @Override
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
        return super.fetchCar(ticketToken, parkingLotManagement);
    }
}
