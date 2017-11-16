package models.Charges;

public interface IFareCalculationStrategy {

    double calculateFare(Double totalTime, Object bike);
}
