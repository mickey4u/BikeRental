package models.rentalmodel.pay;

import javax.money.MonetaryAmount;

public interface IPayModel {

    MonetaryAmount amountDue(String bookingId);
}
