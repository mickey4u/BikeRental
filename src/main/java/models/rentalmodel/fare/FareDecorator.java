package models.rentalmodel.fare;

import javax.money.MonetaryAmount;

public abstract class FareDecorator implements IFare {
    private IFare iFare;

    public FareDecorator(IFare iFare) {
        this.iFare = iFare;
    }

    @Override
    public MonetaryAmount calculate(Number amount) {
        return iFare.calculate(amount);
    }
}
