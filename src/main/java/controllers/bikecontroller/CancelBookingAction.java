package controllers.bikecontroller;

import com.opensymphony.xwork2.ActionSupport;

public class CancelBookingAction extends ActionSupport {

    main.BikeRentalSingleton bikeRentalSingleton = main.BikeRentalSingleton.getInstance();
    boolean status;
    String bookingID;

    /**
     * This Action is responsible for cancelling the Booking of the user
     *
     * @return status of cancellation
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {

        status = bikeRentalSingleton.getBookModel().cancelBooking(bookingID);
        return super.execute();
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }
}
