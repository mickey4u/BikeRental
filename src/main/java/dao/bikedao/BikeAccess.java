package dao.bikedao;

import entities.bike.Bike;
import org.jdbi.v3.sqlobject.SqlObject;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.util.List;

/**
 *
 */
public interface BikeAccess extends SqlObject {

    /**
     * Find a Bike from the database wrt The Bike Spots
     *
     * @param bikeSpot
     * @return return available Bikes if found and null if it doesn't not exist
     */
    @SqlQuery("select * from bikeSpots where bikeLocation = :bikeSpot and bikeStatus = :'Available'")
    @UseRowMapper(BikeMapper.class)
    List<Bike> availableBikes(@Bind("bikeSpot") String bikeSpot);

    boolean registerBike(@BindBean Bike bike);

    boolean unregisterBike(String bikeId);


}
