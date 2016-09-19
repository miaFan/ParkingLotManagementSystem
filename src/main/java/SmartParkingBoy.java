import java.util.List;
import java.util.UUID;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public UUID dropOff(Car myCar) throws NoAvailableLotException {
        ParkingLot parkingLot = getParkingLot(0);
        for(int i = 1; i< getParkingLotsSize(); i++) {
            if(i > 0 && getParkingLot(i).availableLotsCount() > getParkingLot(i-1).availableLotsCount()) {
                parkingLot = getParkingLot(i);
            }
        }

        return parkingLot.dropOff(myCar);
    }

}
