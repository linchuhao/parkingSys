package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.Ticket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingBoyFacts {
    @Test
    void write_your_first_test() {

    }

    @Test
    void should_be_return_ticket_when_customer_given_car_to_parking_boy() {
        //given
        Car car = new Car("001");
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        //when
        String actual = parkingBoy.park(car, parkingLot);
        //then
        assertEquals("ticket001",actual);
    }

    @Test
    void should_be_return_car_when_parking_lot_given_right_ticket_to_boy() {
        //given
        Car existCar = new Car("001");
        Ticket ticket = new Ticket("ticket001");
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        //when
        Car fetchCar;
        fetchCar = parkingBoy.fetchCar(ticket, parkingLot);
        //then
        assertEquals(existCar.getCarId(),fetchCar.getCarId());
    }

    @Test
    void should_be_return_ticket_when_boy_parking() {
        //given

        //when

        //then
    }

    @Test
    void should_be_return_car_when_boy_given_right_ticket() {
        //given

        //when

        //then
    }

    @Test
    void should_be_not_return_car_when_customer_given_wrong_ticket() {
        //given

        //when

        //then
    }

    @Test
    void should_be_not_return_car_when_customer_given_repeat_ticket() {
        //given

        //when

        //then
    }

    @Test
    void should_be_not_return_ticket_when_boy_parking_lot_is_no_position() {
        //given

        //when

        //then
    }
}
