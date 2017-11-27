package dao.bikedao;

import entities.bike.Bike;
import entities.bike.BikeLocation;
import entities.bike.BikeStatus;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 * Bike row mapper for result set from database
 */
public class BikeMapper implements RowMapper<Bike> {

    @Override
    public Bike map(ResultSet rs, StatementContext ctx) throws SQLException {
        Bike bike = new Bike();

        bike.setBikeId(Optional.of(rs.getString("bike_id")));
        bike.setBikeAvailable(rs.getBoolean("bike_available"));
        bike.setBikeStatus(BikeStatus.valueOf(rs.getString("bike_status")));
        bike.setBikeSpot(Optional.of(rs.getString("bike_spot")));
        bike.setLocation(new BikeLocation(rs.getLong("latitude"),
                rs.getLong("longitude")));

        return bike;
    }
}
