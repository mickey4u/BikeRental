package main;

import dao.bikedao.BikeAccess;
import dao.bikedao.BikeDao;
import dao.bikedao.IBikeDao;
import dao.bookingdao.BookAccess;
import dao.bookingdao.BookDao;
import dao.bookingdao.IBookDao;
import dao.userdao.IUserDao;
import dao.userdao.UserAccess;
import dao.userdao.UserDao;
import models.bikemodel.BikeModel;
import models.bikemodel.IBikeModel;
import models.rentalmodel.BookModel;
import models.rentalmodel.IBookModel;
import models.usermodel.IUserModel;
import models.usermodel.UserModel;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

/**
 * This class is the application's entry point.
 */
public class BikeRentalSingleton {
    private Jdbi jdbi;
    private IUserDao userDao;
    private IUserModel userModel;
    private IBikeDao bikesDao;
    private IBikeModel bikeModel;
    private IBookDao bookDao;
    private IBookModel bookModel;

    private BikeRentalSingleton() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        jdbi = Jdbi.create("jdbc:mysql://localhost:3306/bikerental", "root", "");
        jdbi.installPlugin(new SqlObjectPlugin());

        userDao = new UserDao(jdbi.onDemand(UserAccess.class));
        userModel = new UserModel(userDao);

        bikesDao = new BikeDao(jdbi.onDemand(BikeAccess.class));
        bikeModel = new BikeModel(bikesDao);

        bookDao = new BookDao(jdbi.onDemand(BookAccess.class));
        bookModel = new BookModel(bookDao);
    }


    public static BikeRentalSingleton getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {

        private static final BikeRentalSingleton instance = new BikeRentalSingleton();
    }

    public IUserModel getUserModel() {
        return userModel;
    }

    public IBikeModel getBikeModel() {
        return bikeModel;
    }

    public IBookModel getBookModel() {
        return bookModel;
    }

}
