package models;

import exceptions.NoAvailableLotException;
import strategies.FindIdealParkingLotStrategy;

import java.util.List;
import java.util.UUID;

public class ParkingBoy {
    private final List<ParkingLot> parkingLots;
    private final FindIdealParkingLotStrategy strategy;

    public ParkingBoy(List<ParkingLot> parkingLots, FindIdealParkingLotStrategy strategy) {
        this.parkingLots = parkingLots;
        this.strategy = strategy;
    }

    public UUID dropOff(Car car) throws NoAvailableLotException {
        return strategy.findParkingLot(parkingLots).dropOff(car);
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
