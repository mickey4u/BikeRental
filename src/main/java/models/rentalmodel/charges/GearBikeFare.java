package models.rentalmodel.charges;

import org.javamoney.moneta.Money;

public class GearBikeFare extends Decroter{

    public GearBikeFare(Component component){
        super(component);
    }

    @Override
    public Money cost() {
        return super.cost().add(gearFare());
    }

    public Money gearFare(){
        Money fare;
        fare = Money.of(2, "EUR");
        return fare;
    }
}
