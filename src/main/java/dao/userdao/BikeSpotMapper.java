package dao.userdao;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BikeSpotMapper implements RowMapper {
    @Override
    public Object map(ResultSet rs, StatementContext ctx) throws SQLException {
        return null;
    }
}
