package com.oocl.cultivation;

public interface ParkingLotGenerator {
    boolean acceptCarFromParkingBoy(Car car);

    boolean returnCar(String ticketToken);
}
