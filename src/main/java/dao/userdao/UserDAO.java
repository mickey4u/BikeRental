package dao.userdao;


import com.google.gson.reflect.TypeToken;
import entities.users.RentalHistory;
import entities.users.User;
import utilities.FileManager;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements UserDaoInterface {
    Type type;


    /**
     * This method checks if a user; student/staff exist in the UL database
     *
     * @param id represent the username of the user
     * @return
     */
    public User findUser(String id) {

        type = new TypeToken<List<User>>() {
        }.getType();

        List<User> students = FileManager.readFromflatFile("Users.json", User[].class);
        for (User user : students) {
            if (user.getUsername().equals(id)) {
                System.out.print(user.getUsername());
                return user;
            }
        }

        return null;
    }

    /*
    * Fetches the Rental History based on Input parameter username
    *
    * username
    * bookingTime
    * status
    *
    * Unable to read the file correctly at the moment. Throws a null pointer.
    *
    * */
    public List<RentalHistory> viewRentalHistory(String username) {

        type = new TypeToken<List<RentalHistory>>() {
        }.getType();
        RentalHistory rhistory = new RentalHistory();
        List<RentalHistory> rentalHistory = FileManager.readFromflatFile("bookings.json", RentalHistory[].class);
        for (RentalHistory history : rentalHistory) {
            if (rhistory.username.equals(username)) {
                System.out.print(rhistory.username);
                return rentalHistory;
            }
        }

        return null;
    }


    /**
     * @return
     */
    public boolean createUser(User user) {

        return false;
    }

}
