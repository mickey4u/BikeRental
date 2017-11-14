package dao.userdao;

import com.google.gson.reflect.TypeToken;
import entities.bike.Bike;
import entities.users.RentalHistory;
import utilities.FileManager;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String args[])
    {
        try{
            Type type;

            List<RentalHistory> listOfbookings = new ArrayList();
            type = new TypeToken<List<RentalHistory>>() {
            }.getType();
            RentalHistory rhistory = new RentalHistory();
            List<RentalHistory> rentalHistory = FileManager.readFromflatFile("bookings.json", RentalHistory[].class);
            for (RentalHistory history : rentalHistory) {
                if (rhistory.username.equals("2024")) {
                    System.out.print(rhistory.username);
                    System.out.print(rentalHistory);
                }
            }
        }
        catch(Exception e)
        {
            System.out.print(e);
        }

    }


}
