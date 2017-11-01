import models.users.CreateAccount;

/**
 * This class is the application's entry point.
 */
public class BikeRentalSingleton {

    private BikeRentalSingleton() {
    }


    public static BikeRentalSingleton getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final BikeRentalSingleton instance = new BikeRentalSingleton();
    }

    /**
     * This method handles login for a user
     *
     * @param userName user's username
     * @param password user's password
     * @return token a token is returned after a successful login
     */
    public String login(String userName, String password) {

        return null;
    }

    /**
     * This method handles user creation/registration on the
     * BikeRental platform
     *
     * @param account user's account details
     */
    public void createAccount(CreateAccount account) {

    }

    /**
     * This method enables a user on the platform to reset his/her
     * password if he/she has forgotten.
     *
     * @param email
     */
    public void resetPassword(String email) {

    }
}
