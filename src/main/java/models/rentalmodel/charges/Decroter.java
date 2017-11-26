package models.rentalmodel.charges;

import org.javamoney.moneta.Money;

public class Decroter implements Component{

    private Component component;
    public Decroter(Component component){
        this.component = component;
    }
    @Override
    public Money cost(){
        Money cost;
        cost = component.cost();
        return cost;
    }
}