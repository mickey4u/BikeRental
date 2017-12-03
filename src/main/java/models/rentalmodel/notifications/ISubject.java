package models.rentalmodel.notifications;

/**
 *
 */
public interface ISubject {

    /**
     * Method to register observers
     *
     * @param observer observer to be registered
     */
    void register(Observer observer);

    /**
     * Method unregisters observer from the list of observers
     *
     * @param observer observer to unregister
     */
    void unregister(Observer observer);

    /**
     * Method notifies all observers of an event
     */
    void notifyObservers();

}
