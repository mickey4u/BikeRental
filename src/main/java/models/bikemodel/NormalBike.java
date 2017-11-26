package models.bikemodel;

import dao.bikedao.BikesDao;
import dao.bikedao.IBikeDao;
import entities.bike.BookingUtils;
import org.javamoney.moneta.Money;

public class NormalBike  implements IBook{

    private IBikeDao iBikeDAO;
    String bikeType = String.valueOf(new BikeConstant());




    public NormalBike(String bikeType)
    {
        this.bikeType = bikeType;
    }

    public NormalBike(BikesDao bikesDao) {
        this.iBikeDAO = bikesDao;
    }
    /*
    * For Renting a City Bike
    *
    * @param: bikeSpots
    * */
    @Override
    public boolean rentBike(String bikeSpots) {

        BikeConstant bikeType = new BikeConstant();
        BookingUtils bookingDetails = new BookingUtils();
        return false;//iBikeDAO.rentNow(bikeSpots, bikeType.GearBike, bookingDetails.getTime(), bookingDetails.createBookingID());

    }

    @Override
    public Money rentFee(double hours) {
        return null;
    }

    @Override
    public Money commission() {
        return null;
    }


}
