package strategies;

import models.ParkingLot;

import java.util.List;

public class MaxAvailableSpaceCountStrategy implements FindIdealParkingLotStrategy{
    public ParkingLot findParkingLot(List<ParkingLot> parkingLots) {
        ParkingLot parkingLotWithMaxAvailableSpaceCount = parkingLots.get(0);
        for (int i = 1; i < parkingLots.size(); i++) {
            if (parkingLots.get(i).availableLotsCount() > parkingLots.get(i - 1).availableLotsCount()) {
                parkingLotWithMaxAvailableSpaceCount = parkingLots.get(i);
            }
        }
        return parkingLotWithMaxAvailableSpaceCount;
    }
}
