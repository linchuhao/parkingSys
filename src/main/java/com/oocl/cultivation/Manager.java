package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class Manager{

    private ParkingLotManagement parkingLotManagement = new ParkingLotManagement();

    private List<Boy> managementList = new ArrayList<Boy>();

    public List<Boy> getManagementList() {
        return managementList;
    }

    public Manager() {

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
}
