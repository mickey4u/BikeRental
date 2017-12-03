package models.rentalmodel.charges;

import entities.users.UserRank;
import models.rentalmodel.fare.*;

/**
 * Creates a fare objects
 */
public class FareFactory {

    /**
     * Instantiates and returns the appropriate fare object
     *
     * @param duration rental duration
     * @return returns a fare class
     */
    public IBikeFare getFare(int duration) {
        IBikeFare fare;
        // check if user is subject to normal fare calculation or penalty
        if (duration < 360) {
            // normal fare
            fare = new NormalFare();
        } else {
            // penalty
            fare = new PenaltyFare();
        }
        return fare;
    }

    /**
     * Instantiates the appropriate decorator object for the final
     * fare calculation based on the users rank
     *
     * @param userRank
     * @return
     */
    public IFare getFinalFare(UserRank userRank) {
        IFare amountToPay;
        if (userRank.equals(UserRank.GOLD)) {
            amountToPay = new BikeFare(new GoldDiscount());
        } else if (userRank.equals(UserRank.SILVER)) {
            amountToPay = new BikeFare(new SilverDiscount());
        } else {
            amountToPay = new BikeFare(new NoDiscount());
        }

        return amountToPay;
    }

}
