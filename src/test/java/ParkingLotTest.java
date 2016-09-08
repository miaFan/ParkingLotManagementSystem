import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

public class ParkingLotTest {
    @Test
    public void should_be_able_to_return_original_car_with_ticket_after_parking() throws NoAvailableLotException {
        ParkingLot parkingLot = new ParkingLot(100);
        Car car1 = new Car();
        Car car2 = new Car();

        UUID ticket1 = parkingLot.dropOff(car1);
        UUID ticket2 = parkingLot.dropOff(car2);

        Assert.assertSame(car1, parkingLot.pickUp(ticket1));
        Assert.assertSame(car2, parkingLot.pickUp(ticket2));
    }

    @Test
    public void should_not_return_original_car_when_ticket_is_not_existed() throws NoAvailableLotException {
        ParkingLot parkingLot = new ParkingLot(100);
        Car car = new Car();

        parkingLot.dropOff(car);

        Assert.assertEquals(null, parkingLot.pickUp(UUID.randomUUID()));
    }

    @Test(expected = NoAvailableLotException.class)
    public void should_not_allow_parking_when_no_available_spot() throws NoAvailableLotException {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();

        parkingLot.dropOff(car);
        parkingLot.dropOff(new Car());
    }


}
