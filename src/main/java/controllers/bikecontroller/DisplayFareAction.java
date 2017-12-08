package controllers.bikecontroller;

import com.opensymphony.xwork2.ActionSupport;
import main.BikeRentalSingleton;

public class DisplayFareAction extends ActionSupport {
    public String bookingID;
    public String fare;
    final BikeRentalSingleton bikeRentalSingleton = main.BikeRentalSingleton.getInstance();

    /**
     *
     * @return Total fare for the Trip

     */
    public String execute(){
        fare = bikeRentalSingleton.getPayModel().amountDue(bookingID).toString();
        return SUCCESS;
    }


    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }
}
