package dao.bikedao;

import entities.bike.Bike;
import entities.bike.BikeStatus;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

/**
 * Bike Data Access Object
 */
@AllArgsConstructor
public class BikeDao implements IBikeDao {
    private final BikeAccess access;


    @Override
    public List<Bike> getAvailableBikesBySpot(String bikeSpot) {
        Optional.ofNullable(bikeSpot).orElseThrow(NullPointerException::new);
        return access.getAvailableBikesBySpot(bikeSpot);
    }

    @Override
    public List<Bike> getAllBikes() {
        return access.getAllBikes();
    }

    @Override
    public List<Bike> getAllDeletedBikes() {
        return access.getAllDeletedBikes();
    }

    @Override
    public Optional<Bike> findBikeById(String bikeId) {
        Optional.ofNullable(bikeId).orElseThrow(NullPointerException::new);
        return access.findBikeById(bikeId);
    }

    @Override
    public boolean registerBike(Bike bike) {
        Optional.ofNullable(bike).orElseThrow(NullPointerException::new);
        // check if bike with id already exist
        if (Boolean.TRUE.equals(access.checkExist(bike.getBikeId().toString()))) {
            return false;
        }
        return access.addBike(bike);
    }

    @Override
    public boolean deleteBikeById(String bikeId) {
        Optional.ofNullable(bikeId).orElseThrow(NullPointerException::new);
        // check if bike with id exist before attempting to delete
        if (Boolean.TRUE.equals(access.checkExist(bikeId))) {
            return false;
        }
        return access.deleteBikeById(bikeId);
    }

    @Override
    public boolean updateBikeStatus(String bikeId, BikeStatus bikeStatus) {
        Optional.ofNullable(bikeId).orElseThrow(NullPointerException::new);
        Optional.ofNullable(bikeStatus).orElseThrow(NullPointerException::new);
        return access.updateBikeStatus(bikeId, bikeStatus);
    }

    /**
     * Retrieve a list of bikes based on a bike status
     *
     * @param bikeStatus
     * @return list of bikes
     */
    @Override
    public List<Bike> getAllBikes(BikeStatus bikeStatus) {
        return access.getAllBikes(bikeStatus);
    }
}
