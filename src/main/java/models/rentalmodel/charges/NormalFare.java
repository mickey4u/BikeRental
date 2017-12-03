package models.rentalmodel.charges;

import entities.bike.BikeType;
import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;

/**
 * Normal fare with charges for bike rentals
 */
public class NormalFare  implements IBikeFare {

    @Override
    public MonetaryAmount calculateFare(Long rentalTime, BikeType bikeType) {

        MonetaryAmount normalFare = IBikeFare.bikeRate(bikeType).multiply(rentalTime);
        return Money.from(normalFare);
    }
}
