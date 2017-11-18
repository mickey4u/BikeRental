package controllers.usercontroller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Handles user logout
 */
public class LogoutAction extends ActionSupport {

    main.BikeRentalSingleton bikeRentalSingleton = main.BikeRentalSingleton.getInstance();

    @Override
    public String execute() throws Exception {

        bikeRentalSingleton.getUserModel().logout();
        return SUCCESS;
    }
}
