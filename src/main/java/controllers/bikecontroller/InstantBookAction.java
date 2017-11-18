package controllers.bikecontroller;

import com.opensymphony.xwork2.ActionSupport;
import models.bikemodel.Bike;
import models.bikemodel.BikeFactory;

public class InstantBookAction extends ActionSupport {

    BikeFactory bikefactory=new BikeFactory();
    String bikeSpots;
    String bikeType;

    @Override
    public String execute() throws Exception {
        return super.execute();
    }

    public String instantBooking()
    {
        Bike bikeBookStatus = bikefactory.bikeBook(bikeSpots,bikeType);
        return SUCCESS;
    }
}
