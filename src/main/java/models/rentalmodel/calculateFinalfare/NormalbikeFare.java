package models.rentalmodel.calculateFinalfare;


import org.javamoney.moneta.Money;

public class NormalbikeFare implements Fare {


    @Override
    public Money calculateFare() {
        return Money.of(1, "EUR");
    }
}