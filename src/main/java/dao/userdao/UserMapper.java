package dao.userdao;


import entities.users.User;
import entities.users.UserRank;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserMapper implements RowMapper<User> {
    @Override
    public User map(ResultSet rs, StatementContext ctx) throws SQLException {

        User user = new User();
        user.setUsername(Optional.ofNullable(rs.getString("username")).get());
        user.setPassword(Optional.ofNullable(rs.getString("password")).get());
        user.setUserRank(UserRank.valueOf(rs.getString("userRank")));
        return user;
    }
}
