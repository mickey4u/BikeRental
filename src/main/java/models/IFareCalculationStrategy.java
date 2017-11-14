package models;

import entities.bike.BikeType;

public interface IFareCalculationStrategy {

    double calculateFare(Double totalTime, Object bike);
}
