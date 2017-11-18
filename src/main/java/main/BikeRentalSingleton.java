package main;

import dao.user.UserAccess;
import dao.user.UserDAO;
import models.user.UserModel;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

/**
 * This class is the application's entry point.
 */
public class BikeRentalSingleton {

    Jdbi jdbi;
    UserDAO userDao;
    UserModel userModel;

    private BikeRentalSingleton() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        jdbi = Jdbi.create("jdbc:mysql://localhost:3306/bikerental", "root", "");
        jdbi.installPlugin(new SqlObjectPlugin());
        userDao = new UserDAO(jdbi.onDemand(UserAccess.class));
        userModel = new UserModel(userDao);
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
