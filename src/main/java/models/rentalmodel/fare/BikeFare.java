package models.rentalmodel.fare;


import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;

/**
 * Computes rental fare for a normal user
 */
public class BikeFare extends FareDecorator {

    public BikeFare(IFare iFare) {
        super(iFare);
    }

    @Override
    public MonetaryAmount calculate(Number amount) {
        return Money.of(amount, euro).subtract(super.calculate(amount));
    }
}