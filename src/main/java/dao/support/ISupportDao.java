package dao.support;

import entities.support.Ticket;

public interface ISupportDao {
    /**
     * Inserts Ticket into Database
     * @param ticket
     * @return
     */
    boolean insertTicket(Ticket ticket);
}
