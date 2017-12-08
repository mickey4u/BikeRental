package interceptors;

import interceptors.perevent.IBookingRequest;
import interceptors.perevent.IClientBookingInterceptor;

public interface ILoggingDispatcher {

    void dispatchClientRequest(IBookingRequest context);

    void register(IClientBookingInterceptor clientRequestInterceptor);

    void remove(IClientBookingInterceptor clientRequestInterceptor);
}
