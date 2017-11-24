package models.bikemodel;

import dao.bikedao.BikesDao;
import dao.bikedao.IBikeDAO;
import entities.bike.BookingUtils;
import org.javamoney.moneta.Money;

import java.util.ArrayList;
import java.util.List;

public class NormalBike implements IBook {

    private IBikeDAO iBikeDAO;
    private List<Observer> observerList = new ArrayList<Observer>();
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
        return iBikeDAO.rentNow(bikeSpots, bikeType.GearBike, bookingDetails.getTime(), bookingDetails.createBookingID());

    }

    @Override
    public Money rentFee(double hours) {
        return null;
    }

    @Override
    public Money commission() {
        return null;
    }

    @Override
    public void addObserver(Observer observer) {
        if(!observerList.contains(observer)){
            observerList.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if(!observerList.contains(observer)){
            observerList.remove(observer);
        }
    }

    @Override
    public void notice(String message) {
        for(Observer observer:observerList){
            observer.update(message);
        }
    }
}
