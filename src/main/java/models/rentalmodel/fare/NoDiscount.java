package models.rentalmodel.fare;

import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;

/**
 * No discount for normal users
 */
public class NoDiscount implements IFare {

    @Override
    public MonetaryAmount calculate(Number amount) {
        MonetaryAmount discountAmount = Money.of(0, euro);
        return discountAmount;
    }
}
