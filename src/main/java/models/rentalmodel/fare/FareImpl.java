package models.rentalmodel.fare;

import javax.money.MonetaryAmount;

public class FareImpl implements IFare {
    @Override
    public MonetaryAmount calculate(Number amount) {
        return null;
    }

//    @Override
//    public MonetaryAmount calculate() {
//        return Money.of(2000, Monetary.getCurrency("EUR"));
//    }
}
