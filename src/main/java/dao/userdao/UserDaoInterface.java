package dao.userdao;

import entities.users.RentalHistory;
import entities.users.User;

import java.util.List;

public interface UserDaoInterface {

    User findUser(String id);

    List<RentalHistory> viewRentalHistory(String username);
    
}
