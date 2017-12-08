package models.rentalmodel.charges;

import entities.bike.BikeType;
import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;

/**
 * Penalty fare with charges for bike rentals
 */
public class PenaltyFare implements IBikeFare {

    @Override
    public Money calculateFare(Long rentalTime, BikeType bikeType) {

        MonetaryAmount normalFare = IBikeFare.bikeRate(bikeType).multiply(rentalTime).multiply(1.5);
        return Money.from(normalFare);
    }
}
