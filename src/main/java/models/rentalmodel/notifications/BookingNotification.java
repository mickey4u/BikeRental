package models.rentalmodel.notifications;

public class BookingNotification implements Observer {

    private String message;
    private ISubject subject;

    public BookingNotification(String message) {
        this.message = message;
    }

    /**
     * Method used by the subject to notify/updates its observers
     */
    @Override
    public void update() {

        String msg = (String) subject.getState(this);
        if (msg == null) {
            System.out.println("No notifications");
        } else
            System.err.println("Booking --> " + message);

    }

    /**
     * @param iSubject iSubject the observer wants to observe
     */
    @Override
    public void setSubject(ISubject iSubject) {
        this.subject = iSubject;
    }
}
