package models;

import strategies.FindIdealParkingLotStrategy;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots, FindIdealParkingLotStrategy strategy) {
        super(parkingLots, strategy);
    }

}
