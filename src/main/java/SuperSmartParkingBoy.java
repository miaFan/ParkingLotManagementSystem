import java.util.List;
import java.util.UUID;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public UUID dropOff(Car myCar) throws NoAvailableLotException {
        int maxIndex = 0;
        double maxRate = 0;
        for(int i = 0; i<getParkingLotsSize();i ++) {
            double vacancyRate = getParkingLot(i).getVacancyRate();
            if(vacancyRate > maxRate){
                maxRate = vacancyRate;
                maxIndex = i;
            }
        }
        return getParkingLot(maxIndex).dropOff(myCar);
    }
}
