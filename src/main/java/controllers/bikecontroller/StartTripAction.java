package controllers.bikecontroller;

import com.opensymphony.xwork2.ActionSupport;

public class StartTripAction extends ActionSupport {
    boolean tripStatus;
    String bookingID;
    main.BikeRentalSingleton bikeRentalSingleton = main.BikeRentalSingleton.getInstance();

    /**
     *
     * Controller for Simulating the trip start
     * @return
     */
    public String execute()
    {
        tripStatus = bikeRentalSingleton.getBookModel().startRentalTime(bookingID);
        return SUCCESS;
    }

    public String getBookingID() {
        return bookingID;
    }
    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }
    public Boolean getTripStatus() {
        return tripStatus;
    }
    public void setTripStatus(Boolean tripStatus) {
        this.tripStatus = tripStatus;
    }
}
