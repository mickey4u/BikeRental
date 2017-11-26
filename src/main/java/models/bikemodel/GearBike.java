package models.bikemodel;

import dao.bikedao.BikesDao;
import dao.bikedao.IBikeDao;
import entities.bike.BookingUtils;
import org.javamoney.moneta.Money;

public class GearBike implements IBook {

    private IBikeDao iBikeDAO;

    String bikeType = String.valueOf(new BikeConstant());

    public GearBike(String bikeType)
    {
        this.bikeType = bikeType;
    }

    public GearBike(BikesDao bikesDao) {
        this.iBikeDAO = bikesDao;
    }

    @Override
    public Money rentFee(double hours) {
        return null;
    }
    
    @Override
    public boolean rentBike(String bikeSpots) {

        BikeConstant bikeType = new BikeConstant();
        BookingUtils bookingDetails = new BookingUtils();
        return false;//iBikeDAO.rentNow(bikeSpots, bikeType.GearBike, bookingDetails.getTime(), bookingDetails.createBookingID());

    }

    @Override
    public Money commission() {
        return null;
    }

}
