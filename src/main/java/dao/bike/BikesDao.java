package dao.bike;

import com.google.gson.reflect.TypeToken;
import entities.bike.ActiveBooking;
import entities.bike.Bike;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utilities.FileManager;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

    @Override
    public boolean rentNow(String bikeSpots, String type) {
        JSONParser parser = new JSONParser();
        Bike bike = new Bike();
        boolean booking = false;
        ActiveBooking currentBooking = new ActiveBooking();
        try {
            JSONArray jsonArray = null;
            try {
                jsonArray = (JSONArray) parser.parse(new FileReader("src\\main\\webapp\\files\\BikeSpots.json"));
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date();
                long time = date.getTime();
                for (Object o : jsonArray) {
                    JSONObject bikeObjects = (JSONObject) o;
                    /*
                    *
                    * If the user's required Bike type and it's availability matches the Bike is allocated to
                    * the user and the Booking details are set in a POJO class.
                    *
                    * */
                    if (type.equals(bikeObjects.get("Type")) && bikeSpots.equals(bikeObjects.get("BikeLocation"))) {
                        String uniqueID = UUID.randomUUID().toString();
                        /*Bike status is updated*/
                        bikeObjects.put("BikeStatus","Booked");
                        /*
                        *
                        * BikeID , Bike Spot, Booking ID and a timestamp is stored in a POJO class
                        *
                        * */
                        currentBooking.setBikeID(String.valueOf(bikeObjects.get("BikeID")));
                        currentBooking.setBikeSpots(String.valueOf(bikeObjects.get("BikeLocation")));
                        currentBooking.setBookingTime(String.valueOf(time));
                        currentBooking.setBookingID(uniqueID);
                        try {
                            try (FileWriter file = new FileWriter("src\\main\\webapp\\files\\BikeSpots.json")) {
                                file.write(jsonArray.toString());
                                System.out.println("Bike Booked");
                                booking = true;
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
                return booking;

            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        finally {
            System.out.println("Exiting the Booking Block");
        }
        return booking;
    }
}
