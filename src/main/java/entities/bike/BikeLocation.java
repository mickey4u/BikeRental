package entities.bike;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This class holds the bicycles location coordinates
 */
@Data
@AllArgsConstructor
public class BikeLocation {

    // latitude value of the coordinate
    private long latitude;
    // longitude value of the coordinate
    private long longitude;

}
