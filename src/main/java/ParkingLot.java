import java.util.HashMap;
import java.util.UUID;

public class ParkingLot {
    private int MAXIMUM_LOTS_NUMBER = 0;
    private HashMap<UUID, Car> car;

    public ParkingLot(int parkingLotNumber) {
        this.MAXIMUM_LOTS_NUMBER = parkingLotNumber;
        this.car = new HashMap<>();
    }

    public UUID dropOff(Car car) throws NoAvailableLotException {
        if (this.car.size() >= MAXIMUM_LOTS_NUMBER){
            throw new NoAvailableLotException();
        }

        UUID ticket = UUID.randomUUID();
        this.car.put(ticket, car);
        return ticket;
    }

    public Car pickUp(UUID ticket) {
        return this.car.get(ticket);
    }
}
