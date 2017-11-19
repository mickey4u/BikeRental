package models.bikemodel;

public interface Bike {

    boolean rentBike(String bikeSpots);
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notice(String message);
}
