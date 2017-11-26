package models.bikemodel;

import entities.bike.BikeStatus;
import entities.bike.BikeType;

/**
 * Interface for different builders of bicycle
 */
public interface IBicycleBuilder {

    void setBikeType(BikeType bikeType);
    void setBikeStatus(BikeStatus bikeStatus);
}
