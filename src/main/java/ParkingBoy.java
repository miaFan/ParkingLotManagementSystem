import java.util.List;
import java.util.UUID;

public class ParkingBoy implements GetIdealParkingLotAbility {
    private final List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public UUID dropOff(Car car) throws NoAvailableLotException {
        return getIdealParkingLot(parkingLots).dropOff(car);
    }

    public ParkingLot getIdealParkingLot(List<ParkingLot> parkingLots) {
        ParkingLot parkingLotWithAvailableSpace = new ParkingLot(0);
        for (int i = 0; i < parkingLots.size(); ++i) {
            if (parkingLots.get(i).availableLotsCount()>0){
                parkingLotWithAvailableSpace = parkingLots.get(i);
            }
        }
        return parkingLotWithAvailableSpace;
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
