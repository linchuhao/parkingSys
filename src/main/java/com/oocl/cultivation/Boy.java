package com.oocl.cultivation;

public abstract class Boy {
    private Message Message;

    public abstract Message park(Car car, ParkingLotManagement parkingLotManagement) ;

    Message fetchCar(String ticketToken, ParkingLotManagement parkingLotManagement) {
        if (null == ticketToken){
            return Message.failedMessage("Please provide your parking ticket.");
        }
        if (parkingLotManagement.returnCar(ticketToken)){
            return Message.successMessage("Fetch the car successfully.");
        }
        return Message.failedMessage("Unrecognized parking ticket.");
    }
}
