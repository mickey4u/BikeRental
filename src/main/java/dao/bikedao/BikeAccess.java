package dao.bikedao;

import entities.bike.Bike;
import entities.bike.BikeStatus;
import org.jdbi.v3.sqlobject.SqlObject;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.util.List;
import java.util.Optional;

/**
 * Used for bikes table access from the database
 */
public interface BikeAccess extends SqlObject {


    /**
     * Checks if the bike with this id already exist in the database
     *
     * @param bikeId
     * @return
     */
    @SqlQuery("select true from BIKES where bike_id = :bikeId")
    boolean checkExist(@Bind("bike_id") String bikeId);

    /**
     * Find a Bike from the database wrt The Bike Spots
     *
     * @param bikeSpot name of the bike spot
     * @return return available Bikes if found and null if it doesn't not exist
     */
    @SqlQuery("select * from BIKES where bikeSpot = :bikeSpot and deleted = false")
    @UseRowMapper(BikeMapper.class)
    List<Bike> getAvailableBikesBySpot(@Bind("bikeSpot") String bikeSpot);

    /**
     * Retrieves only registered bikes
     *
     * @return
     */
    @SqlQuery("select * from BIKES where deleted = false")
    @UseRowMapper(BikeMapper.class)
    List<Bike> getAllBikes();


    /**
     * Retrieves all unregistered bikes
     *
     * @return
     */
    @SqlQuery("select * from BIKES where deleted = true")
    @UseRowMapper(BikeMapper.class)
    List<Bike> getAllDeletedBikes();

    /**
     * Retrieves a particular bike from the database
     *
     * @param bikeId
     * @return
     */
    @SqlQuery("select * from BIKES where bikeId = :bikeId")
    Optional<Bike> findBikeById(@Bind("bikeId") String bikeId);

    /**
     * Adds a new bike to the system
     *
     * @param bike
     * @return
     */
    @SqlQuery("insert into BIKES(bike_id, bike_type, bike_spot, bike_available, bike_status, latitude," +
            "longitude, deleted) values(:bikeId, :bikeType, :bikeSpot, :bikeAvailable, :bikeStatus, :latitude," +
            ":longitude)")
    boolean addBike(@BindBean Bike bike);

    /**
     * deletes bike from the bike rental system, soft delete
     *
     * @param bikeId
     * @return
     */
    @SqlUpdate("update BIKES set deleted = true where bikeId = :bikeId")
    boolean deleteBikeById(String bikeId);

    /**
     * Changes the state of the bike
     *
     * @param bikeId
     * @param bikeStatus
     * @return
     */
    @SqlUpdate("update BIKES set bikeStatus = :bikeStatus where bikeId = :bikeId")
    boolean updateBikeStatus(String bikeId, BikeStatus bikeStatus);


}
