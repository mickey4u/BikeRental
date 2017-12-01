package controllers.support;

import com.opensymphony.xwork2.ActionSupport;
import entities.support.Ticket;
import entities.support.TicketSeverity;
import entities.support.TicketStatus;
import utilities.Utils;

public class RaiseTicketAction extends ActionSupport {

    main.BikeRentalSingleton bikeRentalSingleton = main.BikeRentalSingleton.getInstance();
    private String message;
    private String contactNum;
    private TicketSeverity sev;
    private Ticket ticket;
    boolean ticketStatus;
    Utils time = new Utils();

    /*
    * Method for raising a Ticket
    * */
    public String execute()
    {
        ticket.setMessage(message);
        ticket.setContactNum(contactNum);
        ticket.setSev(sev);
        ticket.setStatus(TicketStatus.OPEN);
        ticket.setTimeStamp(time.getTime());
        ticketStatus = bikeRentalSingleton.getSupportModel().raiseTicket(ticket);
        return SUCCESS;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public TicketSeverity getSev() {
        return sev;
    }

    public void setSev(TicketSeverity sev) {
        this.sev = sev;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public boolean isTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(boolean ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
