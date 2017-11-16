package dao.userdao;


import entities.bike.ActiveBooking;
import entities.bike.Bike;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Test {

    public static void main(String args[]) throws IOException, ParseException {
        String bikeSpots = "KBC";
        String type ="gear";
        JSONParser parser = new JSONParser();
        Bike bike = new Bike();
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
                                System.out.println("Booking ID:"+ currentBooking.getBookingID());
                                System.out.println("Bike Spot:"+ currentBooking.getBikeSpots());
                                System.out.println("Booking Time:"+ currentBooking.getBookingTime());
                                System.out.println("Booking ID:"+ currentBooking.getBikeID());

                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }

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
            System.out.println("Bike Booked");
        }
    }}

