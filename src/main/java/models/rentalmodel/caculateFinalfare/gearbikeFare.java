package models.rentalmodel.caculateFinalfare;

import org.javamoney.moneta.Money;

public class gearbikeFare implements Fare {

    @Override
    public Money calculateFare() {
       return Money.of(2, "EUR");
    }
}
