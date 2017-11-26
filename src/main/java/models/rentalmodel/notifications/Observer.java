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
     * @param subject subject the observer wants to observe
     */
    void setSubject(Subject subject);
}
