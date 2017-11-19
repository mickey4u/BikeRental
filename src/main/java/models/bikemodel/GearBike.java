package models.bikemodel;

import dao.bikedao.IBikeDAO;

import java.util.ArrayList;
import java.util.List;

public class GearBike implements Bike {

    IBikeDAO bike;
    private List<Observer> observerList = new ArrayList<Observer>();
    public GearBike(String bikeSpots)
    {
        rentBike(bikeSpots);
    }

    public boolean rentBike(String bikeSpots)
    {
        List<entities.bike.Bike> AvailableBikes = checkAvailableBikes(bikeSpots);
        boolean booking = false;
        BikeConstant bikeType = new BikeConstant();
        if(AvailableBikes.size()>0)
        {
            booking = bike.rentNow(bikeSpots,bikeType.getGearBike());
            return true;
        }
        return false;
    }

    public List<entities.bike.Bike> checkAvailableBikes(String bikeSpot)
    {
        List<entities.bike.Bike> AvailableBikes = bike.fetchAvailableBikes(bikeSpot);
        return AvailableBikes;
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
