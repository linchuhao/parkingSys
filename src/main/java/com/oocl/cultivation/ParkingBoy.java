package com.oocl.cultivation;



public class ParkingBoy {

    private Message message = new Message();

    public Message park(Car car, ParkingLot parkingLot) {
        if (null == car.getCarId()){
            message.setResult(false);
            message.setMessage("the car is null.");
            return message;
        }
        if (parkingLot.theCarHasParked(car)){
            message.setResult(false);
            message.setMessage("the car has parked.");
            return message;
        }
        if (parkingLot.getTicketWithCarRecord().size() < 10){
            parkingLot.acceptCar(car);
            TicketGenerator ticket = new Ticket();
            message.setResult(true);
            message.setTicketToken(ticket.generate(car));
            message.setMessage("the car has parked.");
            return message;
        }
        message.setResult(false);
        message.setMessage( "Not enough position.");
        return message;
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
