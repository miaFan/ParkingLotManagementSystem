package models;

import exceptions.NoAvailableLotException;
import org.junit.Test;
import strategies.MaxAvailableSpaceCountStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SmartParkingBoyTest {
    @Test
    public void should_pick_origin_car_when_smart_parking_boy_park_a_car_into_parking_lot() throws NoAvailableLotException {
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot);
        SmartParkingBoy boy = new SmartParkingBoy(parkingLots, new MaxAvailableSpaceCountStrategy());
        Car myCar = new Car();

        UUID myTicket = boy.dropOff(myCar);

        assertThat(parkingLot.pickUp(myTicket), is(myCar));
    }

    @Test
    public void should_pick_origin_car_from_the_most_empty_parkinglot_when_smart_parking_boy_park_a_car() throws NoAvailableLotException {
        Car myCar = new Car();
        ParkingLot parkingLot1 = new ParkingLot(2);
        parkingLot1.dropOff(myCar);
        ParkingLot parkingLotWithMoreEmptyLots = new ParkingLot(2);
        SmartParkingBoy boy = new SmartParkingBoy(Arrays.asList(new ParkingLot[]{parkingLot1, parkingLotWithMoreEmptyLots}), new MaxAvailableSpaceCountStrategy());


        UUID myTicket = boy.dropOff(myCar);

        assertThat(parkingLotWithMoreEmptyLots.pickUp(myTicket), is(myCar));
    }

    @Test
    public void should_pick_origin_car_by_smart_parking_boy_from_the_most_empty_parkinglot_when_smart_parking_boy_park_a_car() throws NoAvailableLotException {
        ParkingLot hasMaxAvaliableSpaceParkingLot = new ParkingLot(5);
        ParkingLot parkingLot1 = new ParkingLot(3);
        ParkingLot parkingLot2 = new ParkingLot(2);
        SmartParkingBoy boy = new SmartParkingBoy(Arrays.asList(new ParkingLot[]{hasMaxAvaliableSpaceParkingLot, parkingLot1, parkingLot2}), new MaxAvailableSpaceCountStrategy());
        Car myCar = new Car();

        UUID myTicket = boy.dropOff(myCar);

        assertThat(boy.pickUp(myTicket), is(myCar));
    }

}
