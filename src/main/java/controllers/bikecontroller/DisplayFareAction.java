package controllers.bikecontroller;

import com.opensymphony.xwork2.ActionSupport;
import main.BikeRentalSingleton;

public class DisplayFareAction extends ActionSupport {
    public String bookingID;
    public String fare;
    BikeRentalSingleton bikeRentalSingleton = main.BikeRentalSingleton.getInstance();
    /**
     *
     * @return Total fare for the Trip
     */
    public String execute(){
        fare = bikeRentalSingleton.getPayModel().amountDue(bookingID).toString();
        return SUCCESS;
    }
}
