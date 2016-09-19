package strategies;

import models.ParkingLot;

import java.util.List;

public class MaxVacancyRateStrategy implements FindIdealParkingLotStrategy {
    public ParkingLot findParkingLot(List<ParkingLot> parkingLots) {
        ParkingLot parkingLotWithMaxVacancyRate = parkingLots.get(0);
        double maxRate = parkingLotWithMaxVacancyRate.getVacancyRate();
        for (int i = 1; i < parkingLots.size(); i++) {
            double vacancyRate = parkingLots.get(i).getVacancyRate();
            if (vacancyRate > maxRate) {
                maxRate = vacancyRate;
                parkingLotWithMaxVacancyRate = parkingLots.get(i);
            }
        }
        return parkingLotWithMaxVacancyRate;
    }
}
