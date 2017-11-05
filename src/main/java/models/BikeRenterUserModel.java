package models;

import entities.bike.Bike;
import entities.users.RentalHistory;

import java.util.List;

public class BikeRenterUserModel extends UserModelDecorator {

    /**
     * Handles renting of bikes to users
     */
    public void rentBike() {

    }

    /**
     * Handles pre booking of bikes
     */
    public void preBookBike() {

    }

    /**
     * Handles pre-booking of bikes
     */
    public void cancelBooking(){

    }

    /**
     * Method returns a list of bickes available for renting
     */
    public List<Bike> availableBikes() {

        return null;
    }

    /**
     * Enables user to view his rental histories
     *
     * @return returns a list of renter's renting history
     */
    public List<RentalHistory> checkRentalHistory() {

        return null;
    }

	@Override
	public void passwordReset(String secretAnswer) {
		// TODO Auto-generated method stub
		
	}
}
