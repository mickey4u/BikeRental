package controllers.user;

import com.opensymphony.xwork2.ActionSupport;
import entities.users.User;

/**
 * Registers a user
 */
public class RegisterAction extends ActionSupport {
    User user = new User();
    main.BikeRentalSingleton bikeRentalSingleton = main.BikeRentalSingleton.getInstance();

    @Override
    public String execute() throws Exception {

        bikeRentalSingleton.getUserModel()
                .register(user.getFirstname(), user.getLastname(),
                        user.getUsername(), user.getPassword(),
                        user.getPhoneNumber(), user.getSecretQuestion(),
                        user.getSecretAnswer());

        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
