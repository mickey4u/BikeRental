package dao.bikespot;

import entities.bikeSpot.BikeSpots;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.util.List;

public interface BikeSpotAccess {

    @SqlQuery("select * from SPOTS")
    @UseRowMapper(BikeSpotMapper.class)
    List<BikeSpots> getBikeSpots();

}
