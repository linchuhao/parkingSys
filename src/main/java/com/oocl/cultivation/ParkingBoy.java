package com.oocl.cultivation;



public class ParkingBoy {

    private Message message = new Message();

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

    public Message fetchCar(String ticketToken, ParkingLot parkingLot) {
        if (null == ticketToken){
            message.setResult(false);
            message.setMessage("Please provide your parking ticket.");
            return message;
        }
        if (parkingLot.getTicketWithCarRecord().containsKey(ticketToken)){
            parkingLot.returnCar(ticketToken);
            message.setResult(true);
            message.setMessage("Fetch the car successfully.");
            return message;
        }
        message.setResult(false);
        message.setMessage("Unrecognized parking ticket.");
        return message;
    }
}
