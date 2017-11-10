package controllers.bike;

import com.opensymphony.xwork2.ActionSupport;
import models.IBike;

public class InstantBookAction extends ActionSupport {

    IBike bikespotss;
    String bikeSpots;

    @Override
    public String execute() throws Exception {
        return super.execute();
    }

    public String instantBooking()
    {
        Boolean bikeBookStatus = bikespotss.bikeBook(bikeSpots);
        return SUCCESS;
    }
}
