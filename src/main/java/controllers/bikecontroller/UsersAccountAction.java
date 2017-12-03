package controllers.bikecontroller;

import com.opensymphony.xwork2.ActionSupport;
import entities.bike.Booking;

import java.util.List;

public class UsersAccountAction extends ActionSupport{

    main.BikeRentalSingleton bikeRentalSingleton = main.BikeRentalSingleton.getInstance();
    List<Booking> bookings;
    String username;

    /*
    * Fetches the Rental History of the User
    * */
    public String execute()
    {
        bookings = bikeRentalSingleton.getUserModel().viewRentalHistory(username);
        return "success";
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
