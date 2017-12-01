package dao.daoFactory;

import dao.userdao.IUserDao;
import dao.userdao.UserAccess;
import dao.userdao.UserDao;
import dao.userdao.UserOracleDao;
import entities.database.Database;

import java.util.Optional;

/**
 * The Dao Factory for different Databases
 */
public class UserDAOFactory {
    private UserAccess access;

    public IUserDao getUserDAO(Database type) {
        Optional.ofNullable(type).orElseThrow(NullPointerException::new);
        switch (type)
        {
            case SQL:
                return new UserDao(access);
            case POSTGRE:
                return new UserOracleDao(access);
            default:
                return null;
        }
    }
}
