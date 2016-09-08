import java.util.HashMap;
import java.util.UUID;

public class ParkingLot {
    private static final int MAXIMUM_LOTS_NUMBER = 1;
    private HashMap<UUID, Car> car;
    public ParkingLot() {
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
