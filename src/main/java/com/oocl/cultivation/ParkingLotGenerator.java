package com.oocl.cultivation;

public interface ParkingLotGenerator {
    boolean acceptCarFromParkingBoy(Car car);

    boolean acceptCarFromSmartParkingBoy(Car car);

    boolean acceptCarFromSuperSmartParkingBoy(Car car);

    boolean returnCar(String ticketToken);
}
