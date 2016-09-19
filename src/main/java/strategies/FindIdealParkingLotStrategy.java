package strategies;

import models.ParkingLot;

import java.util.List;

public interface FindIdealParkingLotStrategy {
    ParkingLot findParkingLot(List<ParkingLot> parkingLots);
}
