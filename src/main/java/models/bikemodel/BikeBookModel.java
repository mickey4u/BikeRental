package models.bikemodel;

import dao.bikedao.IBikeDao;
import org.javamoney.moneta.Money;

import static utilities.Constants.CHARGE_PER_HOUR;

public class BikeBookModel {

    private IBikeDao iBikeDAO;

    public Money rentFee(double hours) {
        return CHARGE_PER_HOUR;
    }

    public Money commission() {
        return null;
    }

}
