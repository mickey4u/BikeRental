package models.rentalmodel.notifications;

/**
 *
 */
public interface Observer {

    /**
     * Method used by the subject to notify/updates its observers
     */
    void update();

    /**
     * @param ISubject ISubject the observer wants to observe
     */
    void setSubject(ISubject ISubject);
}
