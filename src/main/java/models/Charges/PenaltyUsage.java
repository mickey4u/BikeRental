package models.Charges;

import entities.bike.BikeType;
import entities.bike.Fares;

public class PenaltyUsage implements IFareCalculationStrategy {
    Double totalFare = 0.0;

    @Override
    public double calculateFare(Double totalTime, Object bike)
    {
        totalFare = Fares.bikeRate((BikeType) bike)*totalTime;
        return totalFare;
    }

}
