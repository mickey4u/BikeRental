package main;

import dao.bikedao.BikeAccess;
import dao.bikedao.BikesDao;
import dao.userdao.UserAccess;
import dao.userdao.UserDAO;
import models.bikemodel.BikeModel;
import models.bikemodel.GearBike;
import models.bikemodel.NormalBike;
import models.usermodel.UserModel;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

/**
 * This class is the application's entry point.
 */
public class BikeRentalSingleton {

    Jdbi jdbi;
    UserDAO userDao;
    UserModel userModel;
    BikesDao bikesDao;
    BikeModel bikeModel;
    GearBike gearBike;
    NormalBike cityBike;

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

        bikesDao = new BikesDao(jdbi.onDemand(BikeAccess.class));
        bikeModel = new BikeModel(bikesDao);

        gearBike = new GearBike(bikesDao);

        cityBike = new NormalBike(bikesDao);

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

    public BikeModel getBikeModel() { return bikeModel; }

    public GearBike getGearBike() { return gearBike; }

    public NormalBike getCityBike() { return cityBike;  }

}
