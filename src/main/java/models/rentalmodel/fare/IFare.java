package models.rentalmodel.fare;


import org.javamoney.moneta.Money;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDateTime;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

/**
 * Contract for calculating rental fare
 */
public interface IFare {

    // 5 percent discount for gold users
    double GOLD_DISCOUNT = 0.05;
    // 2 percent discount for silver users
    double SILVER_DISCOUNT = 0.02;
    // one euro currency
    CurrencyUnit euro = Monetary.getCurrency("EUR");
    // one euro
    MonetaryAmount oneEuro = Money.of(1, euro);


    MonetaryAmount calculate(Number amount);

    /**
     * Checks if the booking date is a weekend
     *
     * @return returns true if today is a weekend
     */
    default boolean isWeekend() {

        LocalDateTime localDateTime = new LocalDateTime();
        int dayOfWeek = localDateTime.getDayOfWeek();

        if (dayOfWeek == DateTimeConstants.SATURDAY || dayOfWeek == DateTimeConstants.SUNDAY)
            return true;

        return false;
    }

}
