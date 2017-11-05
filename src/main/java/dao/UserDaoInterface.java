package dao;

import entities.users.IUser;

public interface UserDaoInterface {

    IUser userExist(String id);

}
