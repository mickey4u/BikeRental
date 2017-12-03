package dao.bikespot;

import entities.bikeSpot.BikeSpots;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class BikeSpotDao implements IBikeSpotDao {
    BikeSpotAccess access;

    /**
     * @return
     */
    @Override
    public List<BikeSpots> getBikeSpots() {
        List<BikeSpots> bikespots = access.getBikeSpots();
        System.out.print("Final spots------------------>"+bikespots);
        return bikespots;
    }
}
