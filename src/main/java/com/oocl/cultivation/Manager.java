package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class Manager {

    private ParkingLotManagement parkingLotManagement = new ParkingLotManagement();

    private ParkingLot parkingLot = new ParkingLot();

    private List<Boy> managementList = new ArrayList<>();

    public List<Boy> getManagementList() {
        return managementList;
    }

    public Manager() {

    }

    public ParkingLotManagement getParkingLotManagement() {
        return parkingLotManagement;
    }

    public void setManagementList(List<Boy> managementList) {
        this.managementList = managementList;
    }

    public void addMember(Boy memeber) {
        managementList.add(memeber);
    }

    private boolean findMemberInManagementList(Boy member) {
        for (int i = 0; i < managementList.size(); i++){
            if (managementList.contains(member)){
                return true;
            }
        }
        return false;
    }

    public Message specifyBoyToParkCar(Boy member, Car car) {
        if (findMemberInManagementList(member)){
            return member.park(car, parkingLotManagement);
        }
        return Message.failedMessage("Can not found member in managementList.");
    }

    public Message specifyBoyToFetchCar(Boy member, String ticketToken) {
        if (findMemberInManagementList(member)){
            return member.fetchCar(ticketToken, parkingLotManagement);
        }
        return Message.failedMessage("Can not found member in managementList.");
    }

    public Message parkInOwnParkingLot(Car car) {
        if (null == car.getCarId()){
            return Message.failedMessage("the car is null.");
        }
        if (parkingLot.theCarHasParked(car)){
            return Message.failedMessage("the car has parked.");
        }
        if (parkingLot.acceptCar(car).isResult()){
            TicketGenerator ticket = new Ticket();
            return Message.successMessageWithTicket("the car has parked.", ticket.generate(car));
        }
        return Message.failedMessage( "Not enough position.");
    }

}
