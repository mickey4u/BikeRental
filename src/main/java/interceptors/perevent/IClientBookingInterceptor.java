package interceptors.perevent;

import interceptors.MarshaledRequest;

/**
 *
 */
public interface IClientBookingInterceptor {

    void onPreBookingRequest(IBookingRequest context);

    void onPostBookingRequest(MarshaledRequest context);
}
