package models.rentalmodel.calculateFinalfare;

import org.javamoney.moneta.Money;

public class gearbikeFare implements Fare {

    @Override
    public Money calculateFare() {
       return Money.of(2, "EUR");
    }
}
