package models.rentalmodel.notifications;

public class BookingNotification implements Observer {

    private String meesage;
    private Subject subject;

    public BookingNotification(String meesage) {
        this.meesage = meesage;
    }

    /**
     * Method used by the subject to notify/updates its observers
     */
    @Override
    public void update() {

    }

    /**
     * @param ISubject ISubject the observer wants to observe
     */
    @Override
    public void setSubject(ISubject ISubject) {
        this.subject = subject;
    }
}
