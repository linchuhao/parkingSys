package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ParkingLotManagement implements ParkingLotGenerator{

    private ParkingLot parkingLot = new ParkingLot();

    private List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>(){{
        add(parkingLot);
    }};

    public ParkingLotManagement() {
    }

    @Override
    public boolean acceptCarFromParkingBoy(Car car) {
        AtomicBoolean acceptCarSuccess = new AtomicBoolean(false);
        AtomicBoolean addParkingLot = new AtomicBoolean(false);
        parkingLotList.iterator().forEachRemaining(indexOfParkingLot ->{
            if (indexOfParkingLot.getTicketWithCarRecord().size() < 10){
                indexOfParkingLot.acceptCar(car);
                acceptCarSuccess.set(true);
            }
            if (!acceptCarSuccess.get() && parkingLotList.size() < 10){
                addParkingLot.set(true);
            }
        });
        if (addParkingLot.get()){
            ParkingLot NewParkingLot = new ParkingLot();
            NewParkingLot.acceptCar(car);
            parkingLotList.add(NewParkingLot);
            acceptCarSuccess.set(true);
        }
        return acceptCarSuccess.get();
    }

    @Override
    public boolean returnCar(String ticketToken) {
//        if(parkingLotList.iterator().next().getTicketWithCarRecord().containsKey(ticketToken)){
//        }
        AtomicBoolean returnCarSuccess = new AtomicBoolean(false);
        parkingLotList.iterator().forEachRemaining
                (indexOfParkingLot -> {
                    if (indexOfParkingLot.getTicketWithCarRecord().containsKey(ticketToken)){
                        indexOfParkingLot.returnCar(ticketToken);
                        returnCarSuccess.set(true);
                    }
                });
        return returnCarSuccess.get();
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }
}
