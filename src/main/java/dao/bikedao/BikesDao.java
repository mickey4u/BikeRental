package dao.bikedao;

import com.google.gson.reflect.TypeToken;
import entities.bike.Bike;
import entities.users.User;
import lombok.AllArgsConstructor;
import utilities.FileManager;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * User Data Access Object
 */
@AllArgsConstructor
public class BikesDao implements IBikeDAO {

    Type type;
    private BikeAccess access;

    public <E> BikesDao(E e) {
    }

    @Override
    public List<Bike> fetchAvailableBikes(String bikeSpot) {

        return access.availableBikes(bikeSpot);

    }


    @Override
    public boolean rentNow(String bikeSpot, String bikeType, long time, String bookingID) {

        return access.rentBike(bikeSpot,bikeType,time,bookingID);

    }

    @Override
    public List<Bike> fetchAllBikes() {

        List<Bike> listOfAllBikes = new ArrayList<Bike>();
        type = new TypeToken<List<Bike>>() {
        }.getType();

        List<Bike> bikes = FileManager.readFromflatFile("BikeSpots.json", Bike[].class);
        for (Bike bike : bikes)
            listOfAllBikes.add(bike);

        return listOfAllBikes;
    }

    public Boolean addServicedBike(Bike ServiceBike) {

        type = new TypeToken<List<User>>() {
        }.getType();

        List<Bike> listOfAllBikes = FileManager.readFromflatFile("BikeSpots.json", User[].class);
        for (Bike bike : listOfAllBikes) {
            if (bike.getBikeID().equals(ServiceBike.getBikeID())) {
                return false;
            }
            else{
                listOfAllBikes.add(ServiceBike);
                return true;
            }
        }

        return null;
    }

    public Boolean updateBikeStatus(entities.bike.Bike rentBike){
        List<Bike> listOfAvailableBikes = new ArrayList();
        List<Bike> bikes = FileManager.readFromflatFile("BikeSpots.json", Bike[].class);
        for(Bike bike:bikes){
            int index;
            if(bike.getBikeID() == rentBike.getBikeID() && bike.getBikeStatus() == "Available"){
                bike.setBikeStatus("Unavailable");

            }

        }
        return Boolean.TRUE;
    }

}
