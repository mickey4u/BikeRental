package models.bikespotmodel;

import dao.bikespot.IBikeSpotDao;
import entities.bikeSpot.BikeSpots;
import lombok.Data;

import java.util.List;

@Data
public class BikeSpotModel implements IBikeSpotModel {
    private IBikeSpotDao iBikeSpotDao;

    public BikeSpotModel(IBikeSpotDao iBikeSpotDao) {
        this.iBikeSpotDao = iBikeSpotDao;
    }

    @Override
    public List<BikeSpots> getBikeSpots() {
        return iBikeSpotDao.getBikeSpots();
    }
}
