package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.Ticket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertEquals("ticket: 001",actual);
    }

    @Test
    void should_be_return_true_when_parking_boy_fetch_car_given_right_ticket() {
        //given
        Car existCar = new Car("001");
        Ticket ticket = new Ticket();
        ParkingBoy parkingBoy = new ParkingBoy();
        List<String> ticketList = Collections.singletonList("ticket: " + "001");
        ParkingLot parkingLot = new ParkingLot(1, ticketList);
        boolean fetchCar;
        //when
        fetchCar = parkingBoy.fetchCar(ticket.generate(existCar), parkingLot);
        //then
        assertTrue(fetchCar);
    }

    @Test
    void should_be_return_ticket_when_parking_boy_park_car_given_parking_car() {
        //given
        Car parkingCar = new Car("parking001");
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        //when
        String actual = parkingBoy.park(parkingCar, parkingLot);
        //then
        assertEquals("ticket: parking001",actual);
    }

    @Test
    void should_be_return_true_when_boy_given_right_ticket() {
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
