package com.oocl.cultivation;

public class ParkingLot {

    private int positionNum;

    private int[] ticket;

    public String generateTicket(Car car) {
        return car.getCarId();
    }

    public int getPositionNum() {
        return positionNum;
    }

    public void setPositionNum(int positionNum) {
        this.positionNum = positionNum;
    }
}
