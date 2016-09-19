import org.junit.Test;

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
        DropOffAbility boy = new SmartParkingBoy(parkingLots);
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
        DropOffAbility boy = new SmartParkingBoy(Arrays.asList(new ParkingLot[]{parkingLot1, parkingLotWithMoreEmptyLots}));


        UUID myTicket = boy.dropOff(myCar);

        assertThat(parkingLotWithMoreEmptyLots.pickUp(myTicket), is(myCar));
    }

    @Test
    public void should_pick_origin_car_by_smart_parking_boy_from_the_most_empty_parkinglot_when_smart_parking_boy_park_a_car() throws NoAvailableLotException {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        SmartParkingBoy boy = new SmartParkingBoy(Arrays.asList(new ParkingLot[]{parkingLot1, parkingLot2}));
        Car myCar = new Car();

        UUID myTicket = boy.dropOff(myCar);

        assertThat(boy.pickUp(myTicket), is(myCar));
    }

}
