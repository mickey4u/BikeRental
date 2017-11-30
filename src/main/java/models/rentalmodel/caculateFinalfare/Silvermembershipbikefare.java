package models.rentalmodel.caculateFinalfare;

import models.rentalmodel.discount.IDiscount;
import org.javamoney.moneta.Money;

public class Silvermembershipbikefare extends Decorator{
    public Silvermembershipbikefare(Fare fare) {
        super(fare);
    }

    public Money operation(){
        return super.calculateFare().divide(IDiscount.SILVER_DISCOUNT);

    }
}
