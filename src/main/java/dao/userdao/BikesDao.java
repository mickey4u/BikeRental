package dao.userdao;

import com.google.gson.reflect.TypeToken;
import entities.bike.Bike;
import utilities.FlatFileReader;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BikesDao implements IBikeDAO {
    Type type;

    @Override
    public List<Bike> fetchAvailableBikes(String bikeSpot) {

        List<Bike> listOfAvailableBikes = new ArrayList();
        type = new TypeToken<List<Bike>>() {
        }.getType();

        List<Bike> bikes = FlatFileReader.readFromflatFile("BikeSpots.json", Bike[].class);
        for (Bike bike : bikes)
            if (bike.getBikeStatus() == "Available" && bike.getBikeSpotLocation() == bikeSpot) {
                listOfAvailableBikes.add(bike);
            }

        return listOfAvailableBikes;
    }
}
