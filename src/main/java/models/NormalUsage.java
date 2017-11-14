package models;

import entities.bike.BikeType;
import entities.bike.Fares;

public class NormalUsage implements IFareCalculationStrategy {
    double totalFare = 0.0;
    
    public double calculateFare(Double totalTime, Object bike)
    {
        totalFare = Fares.bikeRate((BikeType) bike)*totalTime;
        return totalFare;
    }
}
