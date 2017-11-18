package models.bikemodel;

import org.javamoney.moneta.Money;
import utilities.Constants;

class Book implements IBook, Constants {
    @Override
    public Money rentFee(double hours) {
        return CHARGE_PER_HOUR;
    }

    @Override
    public Money commission() {
        return null;
    }
}
