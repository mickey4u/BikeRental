package dao;


import com.google.gson.reflect.TypeToken;
import entities.users.Admin;
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
    public IUser userExist(String id) {

        type = new TypeToken<List<Admin>>() {
        }.getType();

        List<IUser> students = FlatFileReader.readFromflatFile("ulstaff.json", type);
        for (IUser iUser : students) {
            if (iUser.getId().equals(id)) {
                return iUser;
            }
        }

        return null;
    }

    /**
     * @return
     */
    public boolean createUser(IUser iUser) {

        return false;
    }

}
