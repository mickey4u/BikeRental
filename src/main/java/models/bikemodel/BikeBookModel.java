package models.bikemodel;

import dao.bikedao.IBikeDAO;
import org.javamoney.moneta.Money;

import static utilities.Constants.CHARGE_PER_HOUR;

public class BikeBookModel {

    private IBikeDAO iBikeDAO;

    public Money rentFee(double hours) {
            return CHARGE_PER_HOUR;
        }

    public Money commission() {
            return null;
        }

/*    public boolean rentNow(String bikeSpot) {

        BikeConstant bikeType = new BikeConstant();
        BookingUtils bookingDetails = new BookingUtils();

        return iBikeDAO.rentNow(bikeSpot, bikeType.GearBike, bookingDetails.getTime(), bookingDetails.createBookingID());
    }*/

}
