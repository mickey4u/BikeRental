package models.supportmodel;

import entities.support.Ticket;

/*
*
* Contract For User Support
* */
public interface ISupportModel {
    /**
     *
     * Logs a Ticket for the User
     *
     * @param ticket
     * @return
     */
    boolean raiseTicket(Ticket ticket);
}
