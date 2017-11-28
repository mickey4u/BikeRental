package main;

import Connection.*;
import com.sun.media.jfxmedia.logging.Logger;
import entities.database.Database;
import models.bikemodel.IBikeModel;
import models.rentalmodel.IBookModel;
import models.usermodel.IUserModel;

/**
 * This class is the application's entry point.
 */
public class BikeRentalSingleton {

    /* We should fetch the database type from an
    external resource (ex: configuration file).
    In order to keep things simple we will
    use a private static method and an Enum */

    Database databaseType = Database.SQL;

    private BikeRentalSingleton() {
        ConnectionFactory connectionFactory = getConnectionFactory(databaseType);
        ConnectionManager connection = connectionFactory.getConnection();
        connection.connect();
    }

    private ConnectionFactory getConnectionFactory(Database databaseType) {
        switch (databaseType) {
            case SQL:
                Logger.logMsg(1,"Entered MySQLconnectionFactory getUserModel");
                return new MySQLconnectionFactory();
            default:
                Logger.logMsg(1,"Entered PostGREconnectionFactory getUserModel");
                return new PostGREconnectionFactory();
        }
    }


    public static BikeRentalSingleton getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {

        private static final BikeRentalSingleton instance = new BikeRentalSingleton();
    }

    public IUserModel getUserModel() {
        switch (databaseType) {
            case SQL:
                MySqlConnection connection1 = new MySqlConnection();
                Logger.logMsg(1,"Entered MySqlConnection getUserModel");
                return connection1.userModel;
            default:
                PostGREconnection connection2 = new PostGREconnection();
                Logger.logMsg(1,"Entered PostGREconnection getUserModel");
                return null;
        }
    }

    public IBikeModel getBikeModel() {
        switch (databaseType) {
            case SQL:
                MySqlConnection connection1 = new MySqlConnection();
                Logger.logMsg(1,"MySqlConnection getBikeModel");
                return connection1.bikeModel;
            default:
                PostGREconnection connection2 = new PostGREconnection();
                Logger.logMsg(1,"PostGREconnection getBikeModel");
                return null;
        }
    }

    public IBookModel getBookModel() {
        switch (databaseType) {
            case SQL:
                MySqlConnection connection1 = new MySqlConnection();
                return connection1.bookModel;
            default:
                PostGREconnection connection2 = new PostGREconnection();
                return null;
        }
    }
}

