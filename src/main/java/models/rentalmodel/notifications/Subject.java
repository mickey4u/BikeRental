package models.rentalmodel.notifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Notification is a subject for sending notification messages
 */
public class Subject implements ISubject {
    // list of registered observers
    private List<Observer> observers;
    // message to be sent to registered observers
    private String message = null;
    private boolean isUpdated = false;
    /* mutual exclusion object (mutex) allows multiple program threads to
     * share the same resource but not simultaneously
     */
    private final Object MUTEX = new Object();


    public Subject() {
        observers = new ArrayList<>();
    }

    @Override
    public void attach(Observer observer) {
        // throw a null pointer if the observer is null
        Optional.of(observer).orElseThrow(NullPointerException::new);
        // check if observer is already registered,otherwise attach the observer
        synchronized (MUTEX) {
            boolean exist = observers.stream().anyMatch(obs -> obs.equals(observer));
            if (!exist) {
                observers.add(observer);
            }
        }

    }

    @Override
    public void detach(Observer observer) {

        synchronized (MUTEX) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        // holds observers already registered, and the synchronized block ensures
        // observers registered after the this method is called are not notified
        List<Observer> existingObservers = null;
        synchronized (MUTEX) {
            if (!isUpdated) return;
            existingObservers = new ArrayList<>(this.observers);
            isUpdated = false;
        }
        // update/notify all observers
        existingObservers.stream().forEach(eo -> eo.update());
    }

    @Override
    public Object getState(Observer observer) {
        synchronized (MUTEX) {
            if (!observers.stream().anyMatch(obs -> obs.equals(observer))) {
                return null;
            }
            return this.message;
        }
    }


    /**
     * Sends notification to observers registered with it
     *
     * @param notificationMessage message to be sent to observers
     */
    public void sendNotifications(String notificationMessage) {

        System.err.println(notificationMessage);
        this.message = notificationMessage;
        this.isUpdated = true;
        // notify all registered observers
        notifyObservers();
    }
}
