package models;

import strategies.FindIdealParkingLotStrategy;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLots, FindIdealParkingLotStrategy strategy) {
        super(parkingLots, strategy);
    }

}
