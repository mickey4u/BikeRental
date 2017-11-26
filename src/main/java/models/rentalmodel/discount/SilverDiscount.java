package models.rentalmodel.discount;

import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;

/**
 * Discount for silver status users for bike rentals on weekends
 */
public class SilverDiscount implements IDiscount {

    @Override
    public Money applyDiscount(Money rentalCharge) {

        MonetaryAmount discountDue = rentalCharge.divide(IDiscount.SILVER_DISCOUNT);
        return Money.from(discountDue);
    }
}
