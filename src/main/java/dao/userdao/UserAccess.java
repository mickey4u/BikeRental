package dao.userdao;

import entities.users.User;
import org.jdbi.v3.sqlobject.SqlObject;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

/**
 *
 */
public interface UserAccess extends SqlObject {

    /**
     * Find a user from the database
     *
     * @param username user's username
     * @return return user if found and null if use doesn't not exist
     */
    @SqlQuery("select * from USERS where username = :username")
    @UseRowMapper(UserMapper.class)
    User findUser(@Bind("username") String username);

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

}
