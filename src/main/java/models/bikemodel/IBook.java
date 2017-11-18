package models.bikemodel;

import org.javamoney.moneta.Money;

interface IBook {

    Money rentFee(double hours);
    Money commission();
}
