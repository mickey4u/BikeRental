package dao.bikespot;

import entities.bikeSpot.BikeSpots;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This Method returns the Location details of the Bikespot
 */
public class BikeSpotMapper implements RowMapper<BikeSpots> {
    @Override
    public BikeSpots map(ResultSet rs, StatementContext ctx) throws SQLException {
        BikeSpots bikeSpot = new BikeSpots();
        bikeSpot.setName(rs.getString("name"));
        bikeSpot.setLatitude(rs.getBigDecimal("latitude"));
        bikeSpot.setLongitude(rs.getBigDecimal("longitude"));
        return bikeSpot;
    }
}
