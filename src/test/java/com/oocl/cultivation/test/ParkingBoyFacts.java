package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.Ticket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyFacts {
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
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.acceptCar(existCar);
        String rightTicket = ticket.generate(existCar);
        //when
        boolean fetchCar = parkingBoy.fetchCar(rightTicket, parkingLot).isResult();
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
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        boolean fetchCar;
        String wrongTicket = "wrongTicket";
        //when
        fetchCar = parkingBoy.fetchCar(wrongTicket, parkingLot).isResult();
        //then
        assertFalse(fetchCar);
    }

    @Test
    void should_be_return_false_when_parking_boy_fetch_car_given_expired_ticket() {
        //given
        Car car = new Car("001");
        Ticket ticket = new Ticket();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        parkingBoy.park(car, parkingLot);
        boolean firstFetchCar;
        boolean secondFetchCar;
        //when
        firstFetchCar = parkingBoy.fetchCar(ticket.generate(car), parkingLot).isResult();
        secondFetchCar = parkingBoy.fetchCar(ticket.generate(car), parkingLot).isResult();
        //then
        assertFalse(secondFetchCar);
    }

    @Test
    void should_be_return_no_position_when_parking_boy_to_park_car_given_parking_lot_is_no_position() {
        //given
        Car car = new Car("001");
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.getTicketWithCarRecord().put("t1","car1");
        parkingLot.getTicketWithCarRecord().put("t2","car2");
        parkingLot.getTicketWithCarRecord().put("t3","car3");
        parkingLot.getTicketWithCarRecord().put("t4","car4");
        parkingLot.getTicketWithCarRecord().put("t5","car5");
        parkingLot.getTicketWithCarRecord().put("t6","car6");
        parkingLot.getTicketWithCarRecord().put("t7","car7");
        parkingLot.getTicketWithCarRecord().put("t8","car8");
        parkingLot.getTicketWithCarRecord().put("t9","car9");
        parkingLot.getTicketWithCarRecord().put("t10","car10");
        //when
        String actual = parkingBoy.park(car, parkingLot);
        //then
        assertEquals("no position.",actual);
    }

    @Test
    void should_be_return_the_car_has_parked_when_parking_boy_to_park_car_given_a_parked_car(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("001");
        parkingLot.acceptCar(car);
        parkingBoy.park(car, parkingLot);
        //when
        String actual = parkingBoy.park(car, parkingLot);
        //then
        assertEquals("the car has parked.", actual);
    }

    @Test
    void should_be_return_the_car_is_null_when_parking_boy_to_park_car_given_a_null_car(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        //when
        String actual = parkingBoy.park(car, parkingLot);
        //then
        assertEquals("the car is null.", actual);
    }

    @Test
    void should_be_return_error_message_unrecoginized_parking_ticket_when_parking_boy_to_fetch_car_given_wrong_ticket(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        String wrongTicket = "wrongTicket";
        //when
        String actual = parkingBoy.fetchCar(wrongTicket, parkingLot).getMessage();
        //then
        assertEquals("Unrecognized parking ticket.", actual);
    }

    @Test
    void should_be_return_error_message_please_provide_your_parking_ticket_when_parking_boy_to_fetch_car_given_wrong_ticket(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        //when
        String actual = parkingBoy.fetchCar(null, parkingLot).getMessage();
        //then
        assertEquals("Please provide your parking ticket.", actual);
    }
}
