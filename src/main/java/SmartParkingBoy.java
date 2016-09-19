import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public ParkingLot getIdealParkingLot(List<ParkingLot> parkingLots) {
        ParkingLot parkingLotWithMaxAvailableSpaceCounts = parkingLots.get(0);
        for(int i = 1; i< parkingLots.size(); i++) {
            if(parkingLots.get(i).availableLotsCount() > parkingLots.get(i-1).availableLotsCount()) {
                parkingLotWithMaxAvailableSpaceCounts = parkingLots.get(i);
            }
        }
        return parkingLotWithMaxAvailableSpaceCounts;
    }

}
