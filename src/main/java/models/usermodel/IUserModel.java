package models.usermodel;


import entities.bike.Booking;

import java.io.FileNotFoundException;
import java.util.List;

public interface IUserModel {

    /**
     * Methods registers a user on the platform
     *
     * @param firstname      firstname of the user
     * @param lastname       lastname of the user
     * @param id             student/staff username of the user
     * @param phoneNumber    phone number of the user
     * @param secretQuestion secret question of the user
     * @param secretAnswer
     * @return returns true if the user was successfully registered
     */
    boolean register(String firstname, String lastname, String id,
                     String password, String phoneNumber, String secretQuestion,
                     String secretAnswer);

    /**
     * This method logs the user into the system
     *
     * @param userId       username of the user
     * @param userPassword password of the user
     */
    boolean login(String userId, String userPassword);

    /**
     * This method logs the user out of the system
     */
    void logout();

    /**
     * Retreives users rental history
     * @param username
     * @return
     */
    List<Booking> viewRentalHistory(String username);

    /**
     * @param userId
     * @param answer
     * @param newPassword
     */
    Boolean passwordReset(String userId, String answer, String newPassword) throws FileNotFoundException;

}
