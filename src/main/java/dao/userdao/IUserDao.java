package dao.userdao;

import entities.booking.Booking;
import entities.users.User;

import java.util.List;

/**
 * User Dao contract
 */
public interface IUserDao {

    /**
     * Creates a new user
     *
     * @param user details of the user
     * @return
     */
    boolean createUser(User user);

    /**
     * retrieves a user from the database
     *
     * @param userId id of the user to find
     * @return
     */
    User findUserById(String userId);

    /**
     * Retrieves a users rental histories
     *
     * @param username
     * @return
     */
    List<Booking> getUserRentalHistory(String username);

    /**
     * Resets a user's password
     *
     * @param password new password
     * @return
     */
    Boolean resetPassword(String password);

}
