package dao.support;

import entities.support.Ticket;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

public interface SupportAccess {

    /**
     * Adds a new bike to the system
     *
     * @param ticket
     * @return
     */
    @SqlQuery("insert into Tickets(ticket_ID, message, contactNum, sev, status," +
            "timeStamp) values(:ticket_ID, :message, :contactNum, :sev, :TimeStamp," +
            ":status)")
    boolean insertTicket(@BindBean Ticket ticket);
}
