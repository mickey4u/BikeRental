package interceptors.perevent;

/**
 *
 */
public interface IClientBookingInterceptor {

    void onPreBookingRequest(IBookingRequest context);

    void onPostBookingRequest(IBookingRequest context);
}
