package models.bike;

import org.javamoney.moneta.Money;
import utilities.Constants;

import java.util.List;

public interface Bike {

    boolean rentBike(String bikeSpots);

    class Book implements IBook, Constants {
        @Override
        public Money rentFee(double hours) {
            return CHARGE_PER_HOUR;
        }

        @Override
        public Money commission() {
            return null;
        }
    }

    class IPay {


    }

    interface IBook {

        Money rentFee(double hours);
        Money commission();
    }

    /**
     *
     */
    interface IBike {

        /**
         * this method returns a list of available bikes
         *
         * @param bikeSpot represents the name of bike spot
         * @return a list of available bikes
         */
        List<entities.bike.Bike> checkAvailableBikes(String bikeSpot);

        Boolean bikeBook(String bikeSpots);
    }
}
