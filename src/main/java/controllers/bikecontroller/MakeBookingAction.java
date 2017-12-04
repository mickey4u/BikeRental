package controllers.bikecontroller;

import com.opensymphony.xwork2.ActionSupport;
import entities.booking.Booking;
import entities.booking.BookingType;
import lombok.Data;

@Data
public class MakeBookingAction extends ActionSupport {
    private String bikeId;
    private String bikeSpot;
    private String bookingType;
    private String username;
    boolean bookingStatus;
    main.BikeRentalSingleton bikeRentalSingleton = main.BikeRentalSingleton.getInstance();

    /**
     * Responsible for Instant Booking of the Bike
     * Fetches the list of Bikes For the Given BikeLocation
     *
     * @return
     */
    public String execute() {
        try {
            Booking bookingDetails = new Booking();
            bookingDetails.setStatus(false);
            bookingDetails.setBikeId(bikeId);
            bookingDetails.setBikeSpot(bikeSpot);
            bookingDetails.setBookingType(BookingType.INSTANT_BOOKING);
            bookingDetails.setUsername(username);
            bookingDetails.setActiveBooking(true);
            bookingStatus = bikeRentalSingleton.getBookModel().bookBike(bookingDetails);
        } catch (Exception e) {
            e.printStackTrace();
        }
       // IClientBookingInterceptor bookingInterceptor = new ClientBookingLoggerInterceptor();
        //LoggingDispatcher.getInstance().register(bookingInterceptor);

        return SUCCESS;
    }

    public String getBikeId() {
        return bikeId;
    }

    public void setBikeId(String bikeId) {
        this.bikeId = bikeId;
    }

    public String getBikeSpot() {
        return bikeSpot;
    }

    public void setBikeSpot(String bikeSpot) {
        this.bikeSpot = bikeSpot;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }


    public String getUsername() { return username;  }

    public void setUsername(String username) { this.username = username;  }

}
