package dao.userdao;


import entities.bike.Booking;
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

    @Override
    public Optional<User> findUserById(String userId) {
        Optional.ofNullable(userId).orElseThrow(NullPointerException::new);
        // check if the user exist
        if (!access.checkExist(userId)) {
            return null;
        }
        return Optional.of(access.getUser(userId));
    }

    @Override
    public List<Booking> getUserRentalHistory(String username) {
        Optional.ofNullable(username).orElseThrow(NullPointerException::new);
        // check if user exist
        if (!access.checkExist(username)) {
            return null;
        }
        return null;
    }

    @Override
    public Boolean resetPassword(String password) {
        return null;
    }
}