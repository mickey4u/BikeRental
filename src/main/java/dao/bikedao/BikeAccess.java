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
    @SqlQuery("select * from BIKES where bike_spot = :bikeSpot and deleted = false and bike_status = 'AVAILABLE'")
    @UseRowMapper(BikeMapper.class)
    List<Bike> getAvailableBikesBySpot(@Bind("bikeSpot") String bikeSpot);

    /**
     * Find a Bike from the database wrt The Bike Spots
     *
     * @return return available Bikes if found and null if it doesn't not exist
     */
    @SqlQuery("select * from BIKES where bike_status = :bikeStatus deleted = false")
    @UseRowMapper(BikeMapper.class)
    List<Bike> getAllBikes(@Bind("bikeStatus") BikeStatus bikeStatus);

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
    @SqlQuery("select * from BIKES where bike_id = :bikeId")
    @UseRowMapper(BikeMapper.class)
    Optional<Bike> findBikeById(@Bind("bikeId") String bikeId);

    /**
     * Adds a new bike to the system
     *
     * @param bike
     * @return
     */
    @SqlQuery("insert into BIKES(bike_id, bike_type, bike_spot, bike_status, latitude," +
            "longitude, deleted) values(:bikeId, :bikeType, :bikeSpot, :bikeStatus, :latitude," +
            ":longitude)")
    boolean addBike(@BindBean Bike bike);

    /**
     * deletes bike from the bike rental system, soft delete
     *
     * @param bikeId
     * @return
     */
    @SqlUpdate("update BIKES set deleted = true where bike_id = :bikeId")
    boolean deleteBikeById(String bikeId);

    /**
     * Changes the state of the bike
     *
     * @param bikeId
     * @param bikeStatus
     * @return
     */
    @SqlUpdate("update BIKES set bike_status = :bikeStatus where bike_id = :bikeId")
    boolean updateBikeStatus(@Bind("bikeId") String bikeId, @Bind("bikeStatus") BikeStatus bikeStatus);


}
