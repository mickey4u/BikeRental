package models.rentalmodel.notifications;

import java.util.Optional;

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
    public void update() throws NullPointerException {
        System.out.print("observer-----inside----->"+this);
        try{
            Optional<String> msg = Optional.ofNullable((String) subject.getState(this));
            System.out.print("The message is"+ msg);
            if (msg == null) {
                System.out.println("No notifications");
            } else
                System.err.println("Booking --> " + message);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * @param iSubject iSubject the observer wants to observe
     */
    @Override
    public void setSubject(ISubject iSubject) {
        this.subject = iSubject;
    }
}
