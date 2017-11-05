package models;

import entities.bookkeeping.Revenue;

import java.util.List;

/**
 *
 */
public class BikeOwnerUserModel extends UserModelDecorator {

    /**
     * Method for handling registration of bike for a user
     */
    public void registerBike() {

    }

    /**
     * Removes bike owner's bike from the system
     */
    public void unregisterBike() {

    }

    /**
     * Returns a list of revenues made from renting his/her bike renting
     */
    public List<Revenue> checkRevenue() {

        return null;
    }

	@Override
	public void passwordReset(String secretAnswer) {
		// TODO Auto-generated method stub
		
	}
}
