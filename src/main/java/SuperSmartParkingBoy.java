import java.util.List;
import java.util.UUID;

/**
 * Created by twer on 9/18/16.
 */
public class SuperSmartParkingBoy {
    private List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {

        this.parkingLots = parkingLots;
    }

    public UUID dropOff(Car myCar) throws NoAvailableLotException {
        int maxIndex = 0;
        double maxRate = 0;
        for(int i = 0; i<parkingLots.size();i ++) {
            double vacancyRate = parkingLots.get(i).getVacancyRate();
            if(vacancyRate > maxRate){
                maxRate = vacancyRate;
                maxIndex = i;
            }
        }
        return parkingLots.get(maxIndex).dropOff(myCar);
    }
}
