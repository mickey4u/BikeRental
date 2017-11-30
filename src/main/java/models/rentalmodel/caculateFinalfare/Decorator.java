package models.rentalmodel.caculateFinalfare;

import org.javamoney.moneta.Money;

public class Decorator implements Fare {
    private Fare fare;

    public Decorator(Fare fare){
        this.fare = fare;
    }

    @Override
    public Money calculateFare() {
        return fare.calculateFare();
    }
}
