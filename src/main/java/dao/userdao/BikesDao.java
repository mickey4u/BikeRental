package dao.userdao;

import com.google.gson.reflect.TypeToken;
import entities.bike.Bike;
import utilities.FileManager;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BikesDao implements IBikeDAO {
    Type type;

    @Override
    public List<Bike> fetchAvailableBikes(String bikeSpot) {

        List<Bike> listOfAvailableBikes = new ArrayList();
        type = new TypeToken<List<Bike>>() {
        }.getType();

        List<Bike> bikes = FileManager.readFromflatFile("BikeSpots.json", Bike[].class);
        for (Bike bike : bikes)
            if (bike.getBikeStatus() == "Available" && bike.getBikeSpotLocation() == bikeSpot) {
                listOfAvailableBikes.add(bike);
            }

        return listOfAvailableBikes;
    }

/*    @Override
    public Collection getBookingDetails() {

        Collection lastBooking = new ArrayList();
        type = new TypeToken<List>() {
        }.getType();

        List bikes = FileManager.readFromflatFile("BookingHistory.json", Bike[].class);
        for (Bike bike : bikes)
            if (bike.getBikeStatus() == "Available" && bike.getBikeSpotLocation() == bikeSpot) {
                listOfAvailableBikes.add(bike);
            }

        return lastBooking;
    }*/
}
