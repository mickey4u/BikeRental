package Connection;

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
import models.usermodel.IUserModel;
import models.usermodel.UserModel;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

/**
 * MySqlConnection for MySQL connections
 */
public class MySqlConnection implements ConnectionManager {
    private IUserDao userDao;
    public static IUserModel userModel;
    private IBikeDao bikesDao;
    public static IBikeModel bikeModel;
    private IBookDao bookDao;
    public static IBookModel bookModel;
    private Jdbi jdbi;

    @Override
    public void connect() {

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
}
