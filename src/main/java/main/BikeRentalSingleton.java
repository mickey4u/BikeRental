package main;
import models.user.UserModel;

/**
 * This class is the application's entry point.
 */
public class BikeRentalSingleton {

    private UserModel userModel = new UserModel();


    private BikeRentalSingleton() {
    }


    public static BikeRentalSingleton getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final BikeRentalSingleton instance = new BikeRentalSingleton();
    }

    public UserModel getUserModel() {
        return userModel;
    }


}
