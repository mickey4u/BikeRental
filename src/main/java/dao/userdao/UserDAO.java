package dao.userdao;


import com.google.gson.reflect.TypeToken;
import entities.users.User;
import utilities.FileManager;


import java.lang.reflect.Type;
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


    /**
     * @return
     */
    public boolean createUser(User user) {

        return false;
    }

}
