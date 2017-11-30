package models.rentalmodel.caculateFinalfare;

import models.rentalmodel.discount.IDiscount;
import org.javamoney.moneta.Money;

public class Goldenmenbershipbikefare extends Decorator {
    public Goldenmenbershipbikefare(Fare fare) {
        super(fare);
    }

    public Money operation(){
        return super.calculateFare().divide(IDiscount.GOLD_DISCOUNT);

    }

}
