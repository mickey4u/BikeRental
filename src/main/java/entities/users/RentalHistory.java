package entities.users;

import lombok.Data;

@Data
public class RentalHistory
{
    public String bookingID;
    public String username;
    public String bookingTime;
    public String status;

}
