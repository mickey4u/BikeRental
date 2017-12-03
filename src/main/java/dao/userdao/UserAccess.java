package dao.userdao;

import entities.bike.Booking;
import entities.users.User;
import org.jdbi.v3.sqlobject.SqlObject;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.util.List;

/**
 * Used for Users table access in the database
 */
public interface UserAccess extends SqlObject {

    /**
     * Checks if the user with this id already exist in the database
     *
     * @param username
     * @return
     */
    @SqlQuery("select true from USERS where username = :username")
    boolean checkExist(@Bind("username") String username);

    /**
     * Find a user from the database
     *
     * @param username user's username
     * @return return user if found and null if use doesn't not exist
     */
    @SqlQuery("select * from USERS where username = :username")
    @UseRowMapper(UserMapper.class)
    User getUser(@Bind("username") String username);

    /**
     * Create a user
     *
     * @param user user details
     * @return true if user creation was successful
     */
    @SqlUpdate("insert into Users (username,password,firstname,lastname,phoneNumber," +
            "secretQuestion,secretAnswer) values (:username,:password,:firstname,:lastname,:phoneNumber," +
            ":secretQuestion,:secretAnswer)")
    boolean createUser(@BindBean User user);

    /**
     *
     * Gets the Rental History of the user
     * @param username
     * @return List of Rental History
     */
    @SqlQuery("select * from BOOKINGS where username = :username")
    @UseRowMapper(RentalHistoryMapper.class)
    List<Booking> getRentalHistory(@Bind("username") String username);

}
