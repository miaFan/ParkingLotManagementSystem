import org.junit.Test;

import java.util.Arrays;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParkingManagerTest {
    @Test
    public void should_pick_up_the_origin_car_when_drop_off_a_car_by_parking_manager() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car myCar = new Car();
        ParkingManager manager = new ParkingManager(Arrays.asList(parkingLot));
        UUID myTicket = manager.dropOff(myCar);
        assertThat(parkingLot.pickUp(myTicket), is(myCar));

    }
}
