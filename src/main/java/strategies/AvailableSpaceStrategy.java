package strategies;

import models.ParkingLot;

import java.util.List;

public class AvailableSpaceStrategy implements FindIdealParkingLotStrategy {
    public ParkingLot findParkingLot(List<ParkingLot> parkingLots) {
        ParkingLot parkingLotWithAvailableSpace = new ParkingLot(0);
        for (int i = 0; i < parkingLots.size(); ++i) {
            if (parkingLots.get(i).availableLotsCount() > 0) {
                parkingLotWithAvailableSpace = parkingLots.get(i);
            }
        }
        return parkingLotWithAvailableSpace;
    }
}
