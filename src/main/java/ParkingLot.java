import java.util.HashMap;
import java.util.UUID;

public class ParkingLot {
    private int MAXIMUM_LOTS_NUMBER = 0;
    private HashMap<UUID, Car> cars;

    public ParkingLot(int parkingLotNumber) {
        this.MAXIMUM_LOTS_NUMBER = parkingLotNumber;
        this.cars = new HashMap<UUID, Car>();
    }

    public UUID dropOff(Car car) throws NoAvailableLotException {
        if (this.cars.size() >= MAXIMUM_LOTS_NUMBER){
            throw new NoAvailableLotException();
        }

        UUID ticket = UUID.randomUUID();
        this.cars.put(ticket, car);
        return ticket;
    }

    public Car pickUp(UUID ticket) {
        return this.cars.get(ticket);
    }

    public int availableLotsCount() {
        return MAXIMUM_LOTS_NUMBER - cars.size();
    }


    public double getVacancyRate() {
        return 1.0 * this.availableLotsCount() / MAXIMUM_LOTS_NUMBER;
    }
}
