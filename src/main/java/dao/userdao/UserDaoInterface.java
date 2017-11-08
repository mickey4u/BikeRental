package dao.userdao;

import entities.users.User;

public interface UserDaoInterface {

    User findUser(String id);

}
