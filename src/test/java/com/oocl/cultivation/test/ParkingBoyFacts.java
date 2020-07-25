package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.Ticket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        List<String> ticketList = new ArrayList<>();
        ticketList.add("ticket: 001");
        ticketList.add("ticket: 002");
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
    void should_be_return_false_when_parking_boy_fetch_car_given_wrong_ticket() {
        //given
        Car existCar = new Car("000");
        Ticket ticket = new Ticket();
        ParkingBoy parkingBoy = new ParkingBoy();
        List<String> ticketList = new ArrayList<>();
        ticketList.add("ticket: 001");
        ticketList.add("ticket: 002");
        ParkingLot parkingLot = new ParkingLot(1, ticketList);
        boolean fetchCar;
        //when
        fetchCar = parkingBoy.fetchCar(ticket.generate(existCar), parkingLot);
        //then
        assertFalse(fetchCar);
    }

    @Test
    void should_be_return_false_when_parking_boy_fetch_car_given_expired_ticket() {
        //given
        Car existCar = new Car("001");
        Ticket ticket = new Ticket();
        ParkingBoy parkingBoy = new ParkingBoy();
        List<String> ticketList = new ArrayList<>();
        ticketList.add("ticket: 001");
        ticketList.add("ticket: 002");
        ParkingLot parkingLot = new ParkingLot(1, ticketList);
        boolean firstFetchCar;
        boolean secondFetchCar;
        //when
        firstFetchCar = parkingBoy.fetchCar(ticket.generate(existCar), parkingLot);
        secondFetchCar = parkingBoy.fetchCar(ticket.generate(existCar), parkingLot);
        //then
        assertFalse(secondFetchCar);
    }

    @Test
    void should_be_return_no_position_when_parking_boy_to_park_car_given_parking_lot_is_no_position() {
        //given
        Car car = new Car("001");
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(0);
        //when
        String actual = parkingBoy.park(car, parkingLot);
        //then
        assertEquals("no position",actual);
    }

    @Test
    void should_be_return_the_car_was_parked_when_parking_boy_to_park_car_given_a_parked_car(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        Car parkedCar = new Car("001");
        parkingLot.generateTicket(parkedCar);
        //when
        String actual = parkingBoy.park(parkedCar, parkingLot);
        //then
        assertEquals("the car was parked.", actual);
    }
}
