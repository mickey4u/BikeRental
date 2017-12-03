package controllers.bikecontroller;

import com.opensymphony.xwork2.ActionSupport;

public class EndTripAction extends ActionSupport {

    public String bookingID;
    public boolean bookingStatus;
    main.BikeRentalSingleton bikeRentalSingleton = main.BikeRentalSingleton.getInstance();

    /**
     * The Method to simulate ending a trip
     * @return bookingStatus
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
        bookingStatus = bikeRentalSingleton.getBookModel().endRentalTime(bookingID);
        return SUCCESS;
    }

    public boolean isBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(boolean bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }
}
