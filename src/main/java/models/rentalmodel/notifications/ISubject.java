package models.rentalmodel.notifications;

/**
 *
 */
public interface ISubject {

    /**
     * Method to attach observers
     *
     * @param observer observer to be registered
     */
    void attach(Observer observer);

    /**
     * Method unregisters observer from the list of observers
     *
     * @param observer observer to detach
     */
    void detach(Observer observer);

    /**
     * Method notifies all observers of an event
     */
    void notifyObservers();

    public Object getState(Observer observer);

}
