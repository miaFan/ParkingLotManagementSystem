import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SuperSmartParkingBoyTest {
    @Test
    public void should_pick_origin_car_when_super_smart_parking_boy_park_a_car_into_parking_lot() throws NoAvailableLotException {
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot);
        SuperSmartParkingBoy boy = new SuperSmartParkingBoy(parkingLots);
        Car myCar = new Car();

        UUID myTicket = boy.dropOff(myCar);

        assertThat(parkingLot.pickUp(myTicket), is(myCar));
    }

    @Test
    public void should_pick_origin_car_from_the_highest_vacancy_rate_when_super_smart_parking_boy_park_a_car() throws NoAvailableLotException {
        Car car1 = new Car();
        Car myCar = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(2);
        parkingLot1.dropOff(car1);
        ParkingLot parkingLotWithhigherVacancyRate = new ParkingLot(10);
        parkingLotWithhigherVacancyRate.dropOff(myCar);
        ParkingLot parkingLot2 = new ParkingLot(2);
        parkingLot2.dropOff(car2);
        SuperSmartParkingBoy boy = new SuperSmartParkingBoy(Arrays.asList(new ParkingLot[]{parkingLot1, parkingLotWithhigherVacancyRate, parkingLot2}));


        UUID myTicket = boy.dropOff(myCar);

        assertThat(parkingLotWithhigherVacancyRate.pickUp(myTicket), is(myCar));
    }

    @Test
    public void should_pick_origin_car_by_smart_parking_boy_from_the_most_empty_parkinglot_when_smart_parking_boy_park_a_car() throws NoAvailableLotException {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        SuperSmartParkingBoy boy = new SuperSmartParkingBoy(Arrays.asList(new ParkingLot[]{parkingLot1, parkingLot2}));
        Car myCar = new Car();

        UUID myTicket = boy.dropOff(myCar);

        assertThat(boy.pickUp(myTicket), is(myCar));
    }

}
