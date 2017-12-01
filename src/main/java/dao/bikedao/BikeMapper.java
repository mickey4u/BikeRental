package dao.bikedao;

import entities.bike.Bike;
import entities.bike.BikeLocation;
import entities.bike.BikeStatus;
import entities.bike.BikeType;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Bike row mapper for result set from database
 */
public class BikeMapper implements RowMapper<Bike> {

    @Override
    public Bike map(ResultSet rs, StatementContext ctx) throws SQLException {
        Bike bike = new Bike();

        bike.setBikeId(rs.getString("bike_id"));
        bike.setBikeStatus(BikeStatus.valueOf(rs.getString("bike_status")));
        bike.setBikeSpot(rs.getString("bike_spot"));
        bike.setLocation(new BikeLocation(rs.getLong("latitude"),rs.getLong("longitude")));
        bike.setBikeType(BikeType.valueOf(rs.getString("bike_type")));
        bike.setRate(rs.getString("rate"));
        return bike;
    }
}
