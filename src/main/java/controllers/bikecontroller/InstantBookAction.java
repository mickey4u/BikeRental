package controllers.bikecontroller;

import com.opensymphony.xwork2.ActionSupport;
import entities.bike.Booking;
import lombok.Data;

@Data
public class InstantBookAction extends ActionSupport {
    String bikeSpots;
    String bikeType;
    private Booking bookingDetails;
    //Booking booking;
    main.BikeRentalSingleton bikeRentalSingleton = main.BikeRentalSingleton.getInstance();

    /**
     * Responsibe for Instant Booking of the Bike
     * Fetches the list of Bikes For the Given BikeLocation
     * @return
     */
    public String execute()
    {
          Boolean bookingStatus = false;
          System.out.print(bookingStatus);
          bikeRentalSingleton.getBookModel().bookBike(bookingDetails);
          return SUCCESS;
    }
}
