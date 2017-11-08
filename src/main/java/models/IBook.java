package models;

import org.javamoney.moneta.Money;

public interface IBook {

    Money rentFee(double hours);
    Money commission();
}
