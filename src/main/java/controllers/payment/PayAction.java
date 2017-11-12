package controllers.payment;

import com.opensymphony.xwork2.ActionSupport;
//import models.Booking; //
import entities.bike.BikeType;
import models.IFareCalculationStrategy;
import models.NormalUsage;
import models.PenaltyUsage;


public class PayAction extends ActionSupport {

    //Strategies for fare calculation
    private final IFareCalculationStrategy CalculationStrategy1 = new NormalUsage();
    private final IFareCalculationStrategy CalculationStrategy2 = new PenaltyUsage();

    @Override
    public String execute() throws Exception {
        return super.execute();
    }

    /*
    * Uses the factory and Strategy pattern
    *
    * */
    public String getTotalFare()
    {
     //   Collection tripDetail = tripDetails.getTripDetails(); //
        Double totalTime=0.0; //Calculate the total Trip time
        Object bike = BikeType.CityBike;   //Get the Bike booked by user
        double fare = 0.0;
        if(totalTime<=6)
        {
            fare = CalculationStrategy1.calculateFare(totalTime,bike);
        }
        else if(totalTime>6)
        {
            fare = CalculationStrategy1.calculateFare(6.0,bike) + CalculationStrategy2.calculateFare(totalTime-6.0,bike);
        }
    return SUCCESS;
    }
}
