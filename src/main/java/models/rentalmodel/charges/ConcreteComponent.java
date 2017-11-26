package models.rentalmodel.charges;

import org.javamoney.moneta.Money;

public class ConcreteComponent implements Component{
    @Override
    public Money cost() {
        Money bikeRateCharge;
        bikeRateCharge = Money.of(0, "EUR");
        return bikeRateCharge;
    }
}
