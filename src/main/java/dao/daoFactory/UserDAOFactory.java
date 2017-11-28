package dao.daoFactory;

import com.sun.media.jfxmedia.logging.Logger;
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
        Logger.logMsg(1,"Entering getUserDAO in IUserDao");
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
