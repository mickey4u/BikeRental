package dao.userdao;

import entities.users.RentalHistory;
import entities.users.User;

import java.io.FileNotFoundException;
import java.util.List;

public interface IUserDao {

    User findUser(String id);

    List<RentalHistory> viewRentalHistory(String username);

    Boolean updateDetails(String newPassword) throws FileNotFoundException;
}
