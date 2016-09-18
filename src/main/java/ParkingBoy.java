import java.util.List;
import java.util.UUID;

public class ParkingBoy {
    private final List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public UUID dropOff(Car car) throws NoAvailableLotException {
        for (int i = 0; i < parkingLots.size(); ++i) {
            ParkingLot parkingLot = parkingLots.get(i);
            try {
                return parkingLot.dropOff(car);
            } catch (NoAvailableLotException e) {
                if (i + 1 >= parkingLots.size()) {
                    throw e;
                }
            }
        }
        return null;
    }

    public Car pickUp(UUID ticket) {
        Car car = null;
        for (ParkingLot parkingLot : parkingLots) {
            car = parkingLot.pickUp(ticket);
            if (car != null) {
                break;
            }
        }
        return car;
    }
}
