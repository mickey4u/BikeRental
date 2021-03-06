package interceptors;

import interceptors.perevent.IBookingRequest;
import interceptors.perevent.IClientBookingInterceptor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class LoggingDispatcher implements ILoggingDispatcher {

    private List<IClientBookingInterceptor> clientRequestInterceptors = null;
    private final Object MUTEX = new Object();

    private LoggingDispatcher() {
        clientRequestInterceptors = new ArrayList<>();
    }

    public static LoggingDispatcher getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {

        private static final LoggingDispatcher instance = new LoggingDispatcher();
    }

    @Override
    public void dispatchClientRequest(IBookingRequest context) {
        List<IClientBookingInterceptor> existingClientRequestInterceptors = null;
        synchronized (MUTEX) {
            // get all registered interceptors
            existingClientRequestInterceptors = new ArrayList(clientRequestInterceptors);
        }

        existingClientRequestInterceptors.forEach(eld -> {
            // dispatch callback hook method
            if(context.getBooking().getStartTime() == null) {
                eld.onPreBookingRequest(context);
            }else{
                eld.onPostBookingRequest(context);
            }
        });
    }

    @Override
    public void register(IClientBookingInterceptor clientRequestInterceptor) {
        synchronized (MUTEX) {
            boolean exists = clientRequestInterceptors
                    .stream()
                    .filter(clientRequestInterceptor::equals)
                    .findFirst()
                    .isPresent();

            if (!exists) {
                clientRequestInterceptors.add(clientRequestInterceptor);
            }
        }
    }

    @Override
    public void remove(IClientBookingInterceptor clientRequestInterceptor) {
        synchronized (MUTEX) {
            boolean exists = clientRequestInterceptors
                    .stream()
                    .filter(clientRequestInterceptor::equals)
                    .findFirst()
                    .isPresent();

            if (exists) {
                clientRequestInterceptors.remove(clientRequestInterceptor);
            }
        }
    }
}
