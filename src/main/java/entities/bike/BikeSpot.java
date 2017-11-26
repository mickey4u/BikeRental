package entities.bike;

import lombok.Data;

/**
 * Represents where bikes can be located
 */
@Data
public class BikeSpot {
    // bike sport id
    private String id;
    // name of the bike spot
    private String name;
    // number of bikes available at this spot
    private int availableBikes;
}
