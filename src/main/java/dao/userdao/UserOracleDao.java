package dao.userdao;

import entities.bike.Booking;
import entities.users.User;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class UserOracleDao implements IUserDao {
    public UserOracleDao(UserAccess access) {
    }
    /**
     * Creates a new user
     *
     * @param user details of the user
     * @return
     */
    @Override
    public boolean createUser(User user) {
        return false;
    }

    /**
     * retrieves a user from the database
     *
     * @param userId id of the user to find
     * @return
     */
    @Override
    public Optional<User> findUserById(String userId) {
        return null;
    }

    /**
     * Retrieves a users rental histories
     *
     * @param username
     * @return
     */
    @Override
    public List<Booking> getUserRentalHistory(String username) {
        return null;
    }

    /**
     * Resets a user's password
     *
     * @param password new password
     * @return
     */
    @Override
    public Boolean resetPassword(String password) {
        return null;
    }
}
