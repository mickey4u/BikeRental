package dao;


import com.google.gson.reflect.TypeToken;
import entities.users.IUser;


import java.lang.reflect.Type;
import java.util.List;

public class UserDAO implements UserDaoInterface {
    Type type;


    /**
     * This method checks if a user; student/staff exist in the UL database
     *
     * @param id represent the id of the user
     * @return
     */
    public boolean userExist(String id) {

        type = new TypeToken<List<IUser>>() {
        }.getType();

        List<IUser> students = FlatFileReader.readFromflatFile("ulstaff.json", type);
        for (IUser iUser : students) {
            if (iUser.getId().equals(id)) {
                return true;
            }
        }

        return false;
    }

    /**
     *
     * @return
     */
    public boolean createUser(IUser iUser){

        return false;
    }

}
