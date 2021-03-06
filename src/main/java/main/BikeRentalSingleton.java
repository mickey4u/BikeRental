package main;

import dao.bikedao.BikeAccess;
import dao.bikedao.BikeDao;
import dao.bikedao.IBikeDao;
import dao.bikespot.BikeSpotAccess;
import dao.bikespot.BikeSpotDao;
import dao.bikespot.IBikeSpotDao;
import dao.bookingdao.BookAccess;
import dao.bookingdao.BookDao;
import dao.bookingdao.IBookDao;
import dao.support.ISupportDao;
import dao.support.SupportAccess;
import dao.support.SupportDao;
import dao.userdao.IUserDao;
import dao.userdao.UserAccess;
import dao.userdao.UserDao;
import interceptors.LoggingDispatcher;
import interceptors.perevent.ClientBookingLoggerInterceptor;
import interceptors.perevent.IClientBookingInterceptor;
import models.bikemodel.BikeModel;
import models.bikemodel.IBikeModel;
import models.bikespotmodel.BikeSpotModel;
import models.bikespotmodel.IBikeSpotModel;
import models.rentalmodel.BookModel;
import models.rentalmodel.IBookModel;
import models.rentalmodel.notifications.Subject;
import models.rentalmodel.pay.IPayModel;
import models.rentalmodel.pay.PayModel;
import models.supportmodel.ISupportModel;
import models.supportmodel.SupportModel;
import models.usermodel.IUserModel;
import models.usermodel.UserModel;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.jodatime2.JodaTimePlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

/**
 * This class is the application's entry point.
 */
public class BikeRentalSingleton {
    private IUserModel userModel;
    private IBikeModel bikeModel;
    private IBookModel bookModel;
    private ISupportModel supportModel;
    private IPayModel payModel;
    private IBikeSpotModel bikeSpotModel;

    private BikeRentalSingleton() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Jdbi jdbi = Jdbi.create("jdbc:mysql://localhost:3306/bikerental", "root", "");
        jdbi.installPlugin(new SqlObjectPlugin());
        jdbi.installPlugin(new JodaTimePlugin());

        IUserDao userDao = new UserDao(jdbi.onDemand(UserAccess.class));
        userModel = new UserModel(userDao);

        IBikeDao bikesDao = new BikeDao(jdbi.onDemand(BikeAccess.class));
        bikeModel = new BikeModel(bikesDao);

        IBookDao bookDao = new BookDao(jdbi.onDemand(BookAccess.class));
        bookModel = new BookModel(bookDao, bikeModel, userDao);

        ISupportDao supportDao = new SupportDao(jdbi.onDemand(SupportAccess.class));
        supportModel = new SupportModel(supportDao);

        IBikeSpotDao bikeSpotDao = new BikeSpotDao(jdbi.onDemand(BikeSpotAccess.class));
        bikeSpotModel = new BikeSpotModel(bikeSpotDao);

        payModel = new PayModel(bookDao, userDao, bikesDao);

        IClientBookingInterceptor bookingInterceptor = new ClientBookingLoggerInterceptor();
        LoggingDispatcher.getInstance().register(bookingInterceptor);

    }


    public static BikeRentalSingleton getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {

        private static final BikeRentalSingleton instance = new BikeRentalSingleton();
        private static final Subject notificationSubject = new Subject();
       // private static final IClientBookingInterceptor bookingInterceptor = new ClientBookingLoggerInterceptor();
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

    public ISupportModel getSupportModel() {
        return supportModel;
    }

    public IPayModel getPayModel() {
        return payModel;
    }

    public IBikeSpotModel getBikeSpotModel() {
        return bikeSpotModel;
    }

    public Subject getSubject() { return SingletonHelper.notificationSubject;   }

}
