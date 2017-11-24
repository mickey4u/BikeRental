package dao.bikedao;

import entities.bike.Bike;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BikeMapper implements RowMapper<List<Bike>> {
    @Override
    public List<Bike> map(ResultSet rs, StatementContext ctx) throws SQLException {
        Bike bike = new Bike();
        List<Bike> list = new ArrayList<Bike>();
        if(rs.next())
        {
            if(rs.getString("bikeStatus").equalsIgnoreCase("Available"))
            {
                bike.setBikeID(rs.getString("bikeID"));
                bike.setBikeType(rs.getString("type"));
                list.add(bike);
            }
        }
        return list;
    }
}
