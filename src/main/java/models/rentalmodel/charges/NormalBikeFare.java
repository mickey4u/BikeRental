package models.rentalmodel.charges;

import org.javamoney.moneta.Money;

public class NormalBikeFare extends Decroter{

    public NormalBikeFare(Component component){
        super(component);
    }
    @Override
    public Money cost() {
        return super.cost().add(normalFare()) ;
    }

    public Money normalFare(){
        Money fare;
        fare = Money.of(1, "EUR");
        return fare;
    }
}
