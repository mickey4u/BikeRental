package models.bikemodel;

import org.javamoney.moneta.Money;

public interface IBook {

    Money rentFee(double hours);

    Money commission();

    boolean rentBike(String bikeSpots);

}
