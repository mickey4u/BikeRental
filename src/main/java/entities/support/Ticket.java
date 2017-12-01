package entities.support;

import lombok.Data;

@Data
public class Ticket {

   //Ticket ID
   private String ticket_ID;
    //Ticket Details
    private String message;
    //Contact Number of User who Logs Ticket
    private String contactNum;
    //Ticket Severity
    private TicketSeverity sev;
    //timeStamp of Ticket
    private long TimeStamp;
    //Ticket Status
    private TicketStatus status;
}
