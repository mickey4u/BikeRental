package models.rentalmodel.discount;

import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;

/**
 * Discount for gold status users for bike rentals on weekdays
 */
public class GoldDiscount implements IDiscount {

    @Override
    public Money applyDiscount(Money rentalCharge) {

        if (IDiscount.isWeekend()) {
            MonetaryAmount discountDue = rentalCharge.divide(IDiscount.GOLD_DISCOUNT);
            return Money.from(discountDue);
        }
        return Money.of(0, rentalCharge.getCurrency());
    }
}
