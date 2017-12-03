package dao.userdao;


import entities.booking.Booking;
import entities.users.User;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

/**
 * User Data Access Object
 */
@AllArgsConstructor
public class UserDao implements IUserDao {

    private final UserAccess access;


    /**
     * This method checks if a user; student/staff exist in the UL database
     *
     * @param id represent the username of the user
     * @return
     */
    public User findUser(String id) {
        return access.getUser(id);
    }

    /**
     * This method creates a user on the bike rental platform
     *
     * @param user details of the user to be registered
     * @return returns true if successful
     */
    public boolean registerUser(User user) {
        return access.createUser(user);
    }


    @Override
    public boolean createUser(User user) {
        return access.createUser(user);
    }

    /**
     *
     *
     * This Method gets a user in the Platform from Database
     * @param userId id of the user to find
     * @return the user details
     */
    @Override
    public User findUserById(String userId) {
        //Optional.ofNullable(userId).orElseThrow(NullPointerException::new);
        // check if the user exist
        if (!access.checkExist(userId)) {
            return null;
        }
        return access.getUser(userId);
    }

    /**
     * This method fetches the Rental History of the user
     *
     * @param username username of the user
     * @return List of rental history
     */
    @Override
    public List<Booking> getUserRentalHistory(String username) {
        Optional.ofNullable(username).orElseThrow(NullPointerException::new);
        // check if user exist
        if (access.checkExist(username)) {
            return access.getRentalHistory(username);
        }
        return null;
    }

    @Override
    public Boolean resetPassword(String password) {
        return null;
    }

}
