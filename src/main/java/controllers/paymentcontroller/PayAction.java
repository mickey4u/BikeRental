package controllers.paymentcontroller;

import com.opensymphony.xwork2.ActionSupport;

//import models.Booking; //


public class PayAction extends ActionSupport {

/*    //Strategies for fare calculation
    private final IBikeFare calculationStrategy1 = new NormalFare();
    private final IBikeFare calculationStrategy2 = new PenaltyFare();
    double fare = 0.0;

    @Override
    public String execute() throws Exception {
        return super.execute();
    }

    *//*
    * Uses the factory and Strategy pattern
    *
    * *//*
    public String getTotalFare()
    {
        Double totalTime=8.0;               //Calculate the total Trip time(Static Content)
        Object bike = BikeType.CITY_BIKE;   //Get the Bike booked by user(Static Content)
        if(totalTime<=6.0)
        {
            fare = calculationStrategy1.calculateFare(totalTime,bike);
        }
        else if(totalTime>6.0)
        {
            fare = calculationStrategy1.calculateFare(6.0,bike) + calculationStrategy2.calculateFare(totalTime-6.0,bike);
        }
    return SUCCESS;
    }*/
}
