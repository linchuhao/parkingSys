package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

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
            if (indexOfParkingLot.getCarQuantity() < 10){
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
    public boolean acceptCarFromSmartParkingBoy(Car car) {
        int moreEmpty = 0;
        for (int i = 0; i < parkingLotList.size(); i++){
            if (parkingLotList.get(i).getCarQuantity() < parkingLotList.get(moreEmpty).getCarQuantity()){
                moreEmpty = i;
            }
        }
        if (parkingLotList.get(moreEmpty).getCarQuantity() < 10){
            parkingLotList.get(moreEmpty).acceptCar(car);
            return true;
        }
        return false;
    }

    @Override
    public boolean acceptCarFromSuperSmartParkingBoy(Car car) {
        float availablePositionRate = 0;
        int topAvailablePositionRateParkingLot = 0;
        for (int i = 0; i < parkingLotList.size(); i++){
            if (1 - (float)parkingLotList.get(i).getCarQuantity() / (float)parkingLotList.get(i).getCapacity() > availablePositionRate){
                topAvailablePositionRateParkingLot = i;
                availablePositionRate = 1.0f - (float)parkingLotList.get(i).getCarQuantity() / (float)parkingLotList.get(i).getCapacity();
            }
        }
        if (parkingLotList.get(topAvailablePositionRateParkingLot).getCarQuantity() < parkingLotList.get(topAvailablePositionRateParkingLot).getCapacity()){
            parkingLotList.get(topAvailablePositionRateParkingLot).acceptCar(car);
            return true;
        }
        return false;
    }

    @Override
    public boolean returnCar(String ticketToken) {
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
