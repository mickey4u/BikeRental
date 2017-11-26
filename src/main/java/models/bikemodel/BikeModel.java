package models.bikemodel;

import dao.bikedao.IBikeDao;
import entities.bike.Bike;
import entities.bike.BikeStatus;

import java.util.List;
import java.util.Optional;

/**
 * Bike business logic
 */
public class BikeModel implements IBikeModel {
    private IBikeDao bikeDao;

    public BikeModel(IBikeDao bikeDao) {
        this.bikeDao = bikeDao;
    }

    @Override
    public List<Bike> getAvailableBikesBySpot(String bikeSpot) {
        return bikeDao.getAvailableBikesBySpot(bikeSpot);
    }

    @Override
    public List<Bike> getAllBikes() {
        return bikeDao.getAllBikes();
    }

    @Override
    public List<Bike> getAllDeletedBikes() {
        return bikeDao.getAllDeletedBikes();
    }

    @Override
    public Optional<Bike> findBikeById(String bikeId) {
        return bikeDao.findBikeById(bikeId);
    }

    @Override
    public boolean registerBike(Bike bike) {
        return bikeDao.registerBike(bike);
    }

    @Override
    public boolean unregisterBikeById(String bikeId) {
        return bikeDao.deleteBikeById(bikeId);
    }

    @Override
    public boolean updateBikeStatus(String bikeId, BikeStatus bikeStatus) {
        return bikeDao.updateBikeStatus(bikeId, bikeStatus);
    }
}
