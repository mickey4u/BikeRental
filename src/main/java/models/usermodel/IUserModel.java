package models.usermodel;


import entities.users.RentalHistory;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

public interface IUserModel {

    /**
     * Methods registers a user on the platform
     *
     * @param firstname      firstname of the user
     * @param lastname       lastname of the user
     * @param id             student/staff username of the user
     * @param phoneNumber    phone number of the user
     * @param secretQuestion secret question of the user
     * @return returns true if the user was successfully registered
     */
    boolean register(Optional<String> firstname, Optional<String> lastname, Optional<String> id,
                     Optional<String> password, Optional<String> phoneNumber, Optional<String> secretQuestion,
                     Optional<String> secretAnswer);

    /**
     * This method logs the user into the system
     *
     * @param userId       username of the user
     * @param userPassword password of the user
     */
    boolean login(Optional<String> userId, Optional<String> userPassword);

    /**
     * This method logs the user out of the system
     */
    void logout();

    List<RentalHistory> viewRentalHistory(String username);

    /**
     * @param userId
     * @param answer
     * @param newPassword
     */
    Boolean passwordReset(String userId, String answer, String newPassword) throws FileNotFoundException;

}
