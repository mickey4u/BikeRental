package models.bikemodel;

import dao.bikedao.IBikeDAO;

import java.util.ArrayList;
import java.util.List;

public class NormalBike implements Bike {

    IBikeDAO bike;
    private List<Observer> observerList = new ArrayList<Observer>();
    public NormalBike(String bikeSpots)
    {
        rentBike(bikeSpots);
    }

    @Override
    public boolean rentBike(String bikeSpots) {
        List<Bike> AvailableBikes = checkAvailableBikes(bikeSpots);
        models.bikemodel.BikeConstant bikeType = new BikeConstant();
        boolean booking = false;
        if(AvailableBikes.size()>0)
        {
            booking = bike.rentNow(bikeSpots,bikeType.getCityBike());
            return true;
        }
        return false;
    }

    public List<Bike> checkAvailableBikes(String bikeSpot)
    {
        List<Bike> AvailableBikes = bike.fetchAvailableBikes(bikeSpot);
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
