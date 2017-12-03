package models.rentalmodel.fare;

import org.javamoney.moneta.Money;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryOperator;

/**
 * Computes rental fare for users with silver rank
 */
public class SilverDiscount implements IFare {
    @Override
    public MonetaryAmount calculate(Number fareAmount) {
        MonetaryAmount discountAmount = Money.of(0, euro);
        if (isWeekend()) {
            MonetaryAmount euroAmount = oneEuro.multiply(fareAmount);
            discountAmount = euroAmount.multiply(SILVER_DISCOUNT);
            MonetaryOperator roundingOperator = Monetary.getRounding(euro);
            MonetaryAmount roundedEuro = discountAmount.with(roundingOperator);
            discountAmount = roundedEuro;
        }
        return discountAmount;
    }

}
