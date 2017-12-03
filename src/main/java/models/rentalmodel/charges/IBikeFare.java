package models.rentalmodel.charges;

import entities.bike.BikeType;
import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;

/**
 * Bike rental calculation contract
 * Strategy pattern
 */
public interface IBikeFare {

    /**
     * Computes fare for the duration for the bike rent
     *
     * @param rentalTime
     * @param bikeType
     * @return
     */
    MonetaryAmount calculateFare(Long rentalTime, BikeType bikeType);

    /**
     * Bike rate for bikes on the rental platform
     *
     * @param bikeType the type of bike
     * @return returns the charge per hour depending on the bike
     */
    static MonetaryAmount bikeRate(BikeType bikeType) {
        Money bikeRateCharge;

        switch (bikeType) {
            case CITY_BIKE:
                // one euro for city bikes per hour
                bikeRateCharge = Money.of(1, "EUR");
                break;
            case GEAR_BIKE:
                // one euro for gear bikes per hour
                bikeRateCharge = Money.of(2, "EUR");
                break;
            default:
                bikeRateCharge = Money.of(0, "EUR");
        }
        return bikeRateCharge;
    }
}
