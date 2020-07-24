package com.oocl.cultivation;

import java.util.List;

public class ParkingLot {

    private int positionNum;

    private List<String> ticketList;

    public ParkingLot() {

    }

    public List<String> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<String> ticketList) {
        this.ticketList = ticketList;
    }

    public ParkingLot(int positionNum, List<String> ticketList) {
        this.positionNum = positionNum;

        this.ticketList = ticketList;
    }

    public String generateTicket(Car car) {
        this.ticketList.add(car.getCarId());
        return car.getCarId();
    }

    public int getPositionNum() {
        return positionNum;
    }

    public void setPositionNum(int positionNum) {
        this.positionNum = positionNum;
    }
}
