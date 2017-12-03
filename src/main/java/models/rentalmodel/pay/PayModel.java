package models.rentalmodel.pay;

import dao.bikedao.IBikeDao;
import dao.bookingdao.IBookDao;
import dao.userdao.IUserDao;
import entities.bike.Bike;
import entities.bike.BikeType;
import entities.booking.Booking;
import entities.users.User;
import entities.users.UserRank;
import models.rentalmodel.charges.FareFactory;
import models.rentalmodel.charges.IBikeFare;
import models.rentalmodel.fare.IFare;
import org.joda.time.DateTime;
import org.joda.time.Minutes;

import javax.money.MonetaryAmount;

/**
 * Payment Model
 */
public class PayModel implements IPayModel {
    private IBookDao bookDao;
    private IUserDao userDao;
    private IBikeDao bikeDao;

    public PayModel(IBookDao bookDao, IUserDao userDao, IBikeDao bikesDao) {
        this.bookDao = bookDao;
        this.userDao = userDao;
        this.bikeDao = bikesDao;
    }

    @Override
    public MonetaryAmount amountDue(String bookingId) {
        // get the time the bike was submitted check if penalty is applied
        Booking booking = bookDao.findBookingById(bookingId);
        DateTime start = new DateTime(booking.getStartTime().getTime());
        DateTime stop = new DateTime(booking.getEndTime().getTime());
        int duration = Minutes.minutesBetween(start, stop).getMinutes();

        // get the user rank
        User renter = userDao.findUserById(booking.getUsername());
        UserRank userRank = renter.getUserRank();

        // get the bike and check the bike type to determine rate
        Bike rentedBike = bikeDao.findBikeById(booking.getBikeId()).get();
        BikeType bikeType = rentedBike.getBikeType();

        FareFactory fareFactory = new FareFactory();
        IBikeFare fare;

        // get users fare type if user is subject to penalty fare or not
        fare = fareFactory.getFare(duration);

        // get fare amount without discounts
        MonetaryAmount fareAmount = fare.calculateFare(Long.valueOf(duration), bikeType);
        // amount to pay by applying appropriate rank attached to a user
        IFare amountToPay = fareFactory.getFinalFare(userRank);
        // compute the amount due
        Number amountDue = fareAmount.getNumber();

        return amountToPay.calculate(amountDue);
    }
}
