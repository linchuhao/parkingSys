package com.oocl.cultivation;

public class ParkingBoy {

    public String park(Car car, ParkingLot parkingLot) {
        if (parkingLot.getPositionNum() < 10){
            return "ticket" + car.getCarId();
        }
        return "not position";
    }
}
