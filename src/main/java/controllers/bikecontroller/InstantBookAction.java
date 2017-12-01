package controllers.bikecontroller;

import com.opensymphony.xwork2.ActionSupport;
import entities.bike.Booking;
import entities.bike.BookingType;
import lombok.Data;
import main.BikeRentalSingleton;
import utilities.BookingUtils;

@Data
public class InstantBookAction extends ActionSupport {
    private String bikeId;
    private String bikeSpot;
    private String bookingType;
    boolean bookingStatus;
    main.BikeRentalSingleton bikeRentalSingleton = main.BikeRentalSingleton.getInstance();

    /**
     * Responsibe for Instant Booking of the Bike
     * Fetches the list of Bikes For the Given BikeLocation
     *
     * @return
     */
    public String execute() {
        try {
            Booking bookingDetails = new Booking();
            BookingUtils bookingID = new BookingUtils();
            bookingDetails.setBookingId(bookingID.createBookingID());
            bookingDetails.setStatus(false);
            bookingDetails.setBikeId(bikeId);
            bookingDetails.setBikeSpot(bikeSpot);
            bookingDetails.setBookingType(BookingType.INSTANT_BOOKING);
            bookingStatus = bikeRentalSingleton.getBookModel().bookBike(bookingDetails);
        } catch (Exception e) {
            e.printStackTrace();
        }

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

  /*  public Booking getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(Booking bookingDetails) {
        this.bookingDetails = bookingDetails;
    }*/

    public BikeRentalSingleton getBikeRentalSingleton() {
        return bikeRentalSingleton;
    }

    public void setBikeRentalSingleton(BikeRentalSingleton bikeRentalSingleton) {
        this.bikeRentalSingleton = bikeRentalSingleton;
    }
}
