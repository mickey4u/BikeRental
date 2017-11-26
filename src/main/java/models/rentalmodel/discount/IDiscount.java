package models.rentalmodel.discount;

import org.javamoney.moneta.Money;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDateTime;

/**
 * Interface for discount computations
 * Strategy Pattern
 */
public interface IDiscount {
    // currency
    String CURRENCY = "EUR";
    // 5 percent discount for gold users
    double GOLD_DISCOUNT = 0.05;
    // 2 percent discount for silver users
    double SILVER_DISCOUNT = 0.02;

    /**
     * Computes a user's rental discount based on his/her rank
     *
     * @param rentalCharge amount charged for the bike renting without discounts
     * @return returns the discount amount
     */
    Money applyDiscount(Money rentalCharge);

    /**
     * Checks if the booking date is a weekend
     *
     * @return returns true if today is a weekend
     */
    static boolean isWeekend() {

        LocalDateTime localDateTime = new LocalDateTime();
        int dayOfWeek = localDateTime.getDayOfWeek();

        if (dayOfWeek == DateTimeConstants.SATURDAY || dayOfWeek == DateTimeConstants.SUNDAY)
            return true;

        return false;
    }

}
