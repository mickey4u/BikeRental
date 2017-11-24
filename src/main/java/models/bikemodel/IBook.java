package models.bikemodel;

import org.javamoney.moneta.Money;

public interface IBook {

    Money rentFee(double hours);

    Money commission();

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notice(String message);

    boolean rentBike(String bikeSpots);

}
