package entities.bikeSpot;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BikeSpots {
    //Name of BikeSpot
    private String name;
    //Latitude of BikeSpot
    private BigDecimal latitude;
    //Longitude of BikeSpot
    private BigDecimal longitude;
}
