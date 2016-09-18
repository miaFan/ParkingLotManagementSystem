import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class ParkingBoyTest {
    @Test
    public void should_pick_the_origin_car_when_boy_park_a_car_success_with_one_parking_lot() throws NoAvailableLotException {
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot);
        ParkingBoy boy = new ParkingBoy(parkingLots);
        Car myCar = new Car();

        UUID myTicket = boy.dropOff(myCar);

        assertThat(parkingLot.pickUp(myTicket), is(myCar));
    }

    @Test(expected = NoAvailableLotException.class)
    public void should_throw_exception_when_boy_park_a_car_failure_with_one_parking_lot() throws NoAvailableLotException {
        List<ParkingLot> parkingLots = Arrays.asList(new ParkingLot(0));
        ParkingBoy boy = new ParkingBoy(parkingLots);
        Car myCar = new Car();

        boy.dropOff(myCar);
    }

    @Test
    public void should_pick_the_origin_car_when_boy_park_a_car_success_with_two_parking_lots() throws NoAvailableLotException {
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = Arrays.asList(new ParkingLot(0), parkingLot);
        ParkingBoy boy = new ParkingBoy(parkingLots);
        Car myCar = new Car();

        UUID myTicket = boy.dropOff(myCar);

        assertThat(parkingLot.pickUp(myTicket), is(myCar));
    }

    @Test(expected = NoAvailableLotException.class)
    public void should_throw_exception_when_boy_park_a_car_failure_with_two_parking_lots() throws NoAvailableLotException {
        List<ParkingLot> parkingLots = Arrays.asList(new ParkingLot(0), new ParkingLot(0));
        ParkingBoy boy = new ParkingBoy(parkingLots);
        Car myCar = new Car();

        boy.dropOff(myCar);
    }

    @Test
    public void should_pick_the_origin_car_when_car_already_parked_in_parking_lots() throws NoAvailableLotException {
        ParkingLot parkingLot = new ParkingLot(1);
        Car myCar = new Car();
        UUID myTicket = parkingLot.dropOff(myCar);
        List<ParkingLot> parkingLots = Arrays.asList(new ParkingLot(0), parkingLot);
        ParkingBoy boy = new ParkingBoy(parkingLots);

        assertThat(boy.pickUp(myTicket), is(myCar));
    }

    @Test
    public void should_not_pick_the_car_when_car_not_found_in_parking_lots() {
        List<ParkingLot> parkingLots = Arrays.asList(new ParkingLot(1));
        ParkingBoy boy = new ParkingBoy(parkingLots);

        assertNull(boy.pickUp(UUID.randomUUID()));
    }
}
