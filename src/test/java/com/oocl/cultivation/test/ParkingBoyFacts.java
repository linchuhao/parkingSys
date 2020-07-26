package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyFacts {
    @Test
    void should_be_return_ticket_when_customer_given_car_to_parking_boy() {
        //given
        Car car = new Car("001");
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLotManagement parkingLotManagement = new ParkingLotManagement();
        //when
        String actual = parkingBoy.park(car, parkingLotManagement).getTicketToken();
        //then
        assertEquals("ticket: 001",actual);
    }

    @Test
    void should_be_return_true_when_parking_boy_fetch_car_given_right_ticket() {
        //given
        Car existCar = new Car("001");
        Ticket ticket = new Ticket();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLotManagement parkingLotManagement = new ParkingLotManagement();
        parkingLotManagement.acceptCarFromParkingBoy(existCar);
        String rightTicket = ticket.generate(existCar);
        //when
        boolean fetchCar = parkingBoy.fetchCar(rightTicket, parkingLotManagement).isResult();
        //then
        assertTrue(fetchCar);
    }

    @Test
    void should_be_return_ticket_when_parking_boy_park_car_given_parking_car() {
        //given
        Car parkingCar = new Car("parking001");
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLotManagement parkingLotManagement = new ParkingLotManagement();
        //when
        String actual = parkingBoy.park(parkingCar, parkingLotManagement).getTicketToken();
        //then
        assertEquals("ticket: parking001",actual);
    }

    @Test
    void should_be_return_false_when_parking_boy_fetch_car_given_wrong_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLotManagement parkingLotManagement = new ParkingLotManagement();
        boolean fetchCar;
        String wrongTicket = "wrongTicket";
        //when
        fetchCar = parkingBoy.fetchCar(wrongTicket, parkingLotManagement).isResult();
        //then
        assertFalse(fetchCar);
    }

    @Test
    void should_be_return_false_when_parking_boy_fetch_car_given_expired_ticket() {
        //given
        Car car = new Car("001");
        Ticket ticket = new Ticket();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLotManagement parkingLotManagement = new ParkingLotManagement();
        parkingBoy.park(car, parkingLotManagement);
        boolean firstFetchCar;
        boolean secondFetchCar;
        //when
        firstFetchCar = parkingBoy.fetchCar(ticket.generate(car), parkingLotManagement).isResult();
        secondFetchCar = parkingBoy.fetchCar(ticket.generate(car), parkingLotManagement).isResult();
        //then
        assertFalse(secondFetchCar);
    }

    @Test
    void should_be_return_not_enough_position_when_parking_boy_to_park_car_given_parking_lot_is_no_position() {
        //given TODO add the size of the parkingLot
        Car car = new Car("001");
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLotManagement parkingLotManagement = new ParkingLotManagement(1);
        parkingLotManagement.getParkingLotList().get(0).getTicketWithCarRecord().put("t1","car1");
        parkingLotManagement.getParkingLotList().get(0).getTicketWithCarRecord().put("t2","car2");
        parkingLotManagement.getParkingLotList().get(0).getTicketWithCarRecord().put("t3","car3");
        parkingLotManagement.getParkingLotList().get(0).getTicketWithCarRecord().put("t4","car4");
        parkingLotManagement.getParkingLotList().get(0).getTicketWithCarRecord().put("t5","car5");
        parkingLotManagement.getParkingLotList().get(0).getTicketWithCarRecord().put("t6","car6");
        parkingLotManagement.getParkingLotList().get(0).getTicketWithCarRecord().put("t7","car7");
        parkingLotManagement.getParkingLotList().get(0).getTicketWithCarRecord().put("t8","car8");
        parkingLotManagement.getParkingLotList().get(0).getTicketWithCarRecord().put("t9","car9");
        parkingLotManagement.getParkingLotList().get(0).getTicketWithCarRecord().put("t10","car10");
        //when
        String actual = parkingBoy.park(car, parkingLotManagement).getMessage();
        //then
        assertEquals("Not enough position.",actual);
    }

    @Test
    void should_be_return_the_car_has_parked_when_parking_boy_to_park_car_given_a_parked_car(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLotManagement parkingLotManagement = new ParkingLotManagement();
        Car car = new Car("001");
        parkingLotManagement.getParkingLotList().get(0).acceptCar(car);
        parkingBoy.park(car, parkingLotManagement);
        //when
        String actual = parkingBoy.park(car, parkingLotManagement).getMessage();
        //then
        assertEquals("the car has parked.", actual);
    }

    @Test
    void should_be_return_the_car_is_null_when_parking_boy_to_park_car_given_a_null_car(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLotManagement parkingLotManagement = new ParkingLotManagement();
        Car car = new Car();
        //when
        String actual = parkingBoy.park(car, parkingLotManagement).getMessage();
        //then
        assertEquals("the car is null.", actual);
    }

    @Test
    void should_be_return_error_message_unrecoginized_parking_ticket_when_parking_boy_to_fetch_car_given_wrong_ticket(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLotManagement parkingLotManagement = new ParkingLotManagement();
        String wrongTicket = "wrongTicket";
        //when
        String actual = parkingBoy.fetchCar(wrongTicket, parkingLotManagement).getMessage();
        //then
        assertEquals("Unrecognized parking ticket.", actual);
    }

    @Test
    void should_be_return_error_message_please_provide_your_parking_ticket_when_parking_boy_to_fetch_car_given_wrong_ticket(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLotManagement parkingLotManagement = new ParkingLotManagement();
        //when
        String actual = parkingBoy.fetchCar(null, parkingLotManagement).getMessage();
        //then
        assertEquals("Please provide your parking ticket.", actual);
    }

    @Test
    void should_be_return_true_when_parking_boy_to_park_car_in_the_next_parking_lot_given_the_first_parking_lot_is_no_position(){
        //given
        Car car1 = new Car("001");
        Car car2 = new Car("002");
        Car car3 = new Car("003");
        Car car4 = new Car("004");
        Car car5 = new Car("005");
        Car car6 = new Car("006");
        Car car7 = new Car("007");
        Car car8 = new Car("008");
        Car car9 = new Car("009");
        Car car10 = new Car("0010");
        Car car11 = new Car("0011");
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLotManagement parkingLotManagement = new ParkingLotManagement();
        parkingLotManagement.getParkingLotList().get(0).acceptCar(car1);
        parkingLotManagement.getParkingLotList().get(0).acceptCar(car2);
        parkingLotManagement.getParkingLotList().get(0).acceptCar(car3);
        parkingLotManagement.getParkingLotList().get(0).acceptCar(car4);
        parkingLotManagement.getParkingLotList().get(0).acceptCar(car5);
        parkingLotManagement.getParkingLotList().get(0).acceptCar(car6);
        parkingLotManagement.getParkingLotList().get(0).acceptCar(car7);
        parkingLotManagement.getParkingLotList().get(0).acceptCar(car8);
        parkingLotManagement.getParkingLotList().get(0).acceptCar(car9);
        parkingLotManagement.getParkingLotList().get(0).acceptCar(car10);
        //when
        boolean actual = parkingBoy.park(car11, parkingLotManagement).isResult();
        //then
        assertTrue(actual);
    }

    @Test
    void should_be_return_true_when_smart_parking_boy_to_park_car_will_select_more_empty_parkinglot_given_parkinglot_list(){
        //given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        ParkingLotManagement parkingLotManagement = new ParkingLotManagement();
        ParkingLot parkingLot = new ParkingLot();
        Car car1InParkinglot1 = new Car("001");
        Car car2InParkinglot1 = new Car("002");
        parkingLotManagement.getParkingLotList().get(0).acceptCar(car1InParkinglot1);
        parkingLotManagement.getParkingLotList().get(0).acceptCar(car2InParkinglot1);
        parkingLotManagement.getParkingLotList().add(parkingLot);
        //when
        Car car = new Car("003");
        boolean park = smartParkingBoy.park(car, parkingLotManagement).isResult();
        boolean actual = parkingLotManagement.getParkingLotList().get(1).theCarHasParked(car);
        //then
        assertTrue(park && actual);
    }

    @Test
    void should_be_return_true_when_super_smart_parking_boy_to_park_car_will_select_more_empty_parkinglot_given_parkinglot_list(){
        //given
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
        ParkingLotManagement parkingLotManagement = new ParkingLotManagement();
        ParkingLot parkingLot = new ParkingLot(5);
        Car car1InParkinglot1 = new Car("001");
        Car car2InParkinglot2 = new Car("002");
        parkingLotManagement.getParkingLotList().get(0).acceptCar(car1InParkinglot1);
        parkingLot.acceptCar(car2InParkinglot2);
        parkingLotManagement.getParkingLotList().add(parkingLot);
        //when
        Car car = new Car("003");
        boolean park = superSmartParkingBoy.park(car, parkingLotManagement).isResult();
        boolean actual = parkingLotManagement.getParkingLotList().get(0).theCarHasParked(car);
        //then
        assertTrue(park && actual);
    }

    @Test
    void should_be_return_true_when_manager_add_paring_boy_to_management_list(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Manager manager = new Manager();
        //when
        manager.addMember(parkingBoy);
        //then
        boolean actual = manager.getManagementList().contains(parkingBoy);
        assertTrue(actual);
    }

    @Test
    void should_be_return_true_when_manager_specify_a_paring_boy_to_park_car_given_parking_boy_in_management_list(){
        //given
        Car  car = new Car("0001");
        ParkingBoy parkingBoy = new ParkingBoy();
        Manager manager = new Manager();
        manager.addMember(parkingBoy);
        //when
        boolean actual = manager.specifyBoyToParkCar(parkingBoy, car).isResult();
        //then
        assertTrue(actual);
    }

    @Test
    void should_be_return_true_when_manager_specify_a_paring_boy_to_fetch_car_given_parking_boy_in_management_list_and_right_token(){
        //given
        Car  car = new Car("0001");
        Ticket ticket = new Ticket();
        String ticketToken = ticket.generate(car);
        ParkingBoy parkingBoy = new ParkingBoy();
        Manager manager = new Manager();
        manager.getParkingLotManagement().acceptCarFromParkingBoy(car);
        manager.addMember(parkingBoy);
        //when
        boolean actual = manager.specifyBoyToFetchCar(parkingBoy, ticketToken).isResult();
        //then
        assertTrue(actual);
    }

    @Test
    void should_be_return_true_when_manager_park_car_given_parking_lot(){
        //given
        Car  car = new Car("0001");
        Manager manager = new Manager();
        //when
        boolean actual = manager.parkInOwnParkingLot(car).isResult();
        //then
        assertTrue(actual);
    }
}
