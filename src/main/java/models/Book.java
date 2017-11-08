package models;

import org.javamoney.moneta.Money;
import utilities.Constants;

public class Book implements IBook, Constants{
    @Override
    public Money rentFee(double hours) {
        return CHARGE_PER_HOUR;
    }

    @Override
    public Money commission() {
        return null;
    }
}
