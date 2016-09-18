import java.util.List;
import java.util.UUID;

public class SmartParkingBoy {

    private List<ParkingLot>  parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public UUID dropOff(Car myCar) throws NoAvailableLotException {
        ParkingLot parkingLot = parkingLots.get(0);

        for(int i = 0; i< parkingLots.size(); i++) {
            if(i > 0 && parkingLots.get(i).availableLotsCount() > parkingLots.get(i-1).availableLotsCount()) {
                parkingLot = parkingLots.get(i);
            }
        }

        return parkingLot.dropOff(myCar);
    }
}
