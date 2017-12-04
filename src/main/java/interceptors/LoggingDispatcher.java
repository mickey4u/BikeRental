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
    public void dispatchClientPreRequestPreMarshal(IBookingRequest context) {
        List<IClientBookingInterceptor> existingClientRequestInterceptors = null;
        synchronized (MUTEX) {
            // get all registered interceptors
            existingClientRequestInterceptors = new ArrayList<>(clientRequestInterceptors);
        }

        existingClientRequestInterceptors.forEach(eld -> {
            // dispatch callback hook method
            System.err.println(context.getBooking().toString());
            eld.onPreBookingRequest(context);
        });
    }

    @Override
    public void register(IClientBookingInterceptor clientRequestInterceptor) {
        synchronized (MUTEX) {
            boolean exists = clientRequestInterceptors
                    .stream()
                    .filter(cri -> clientRequestInterceptor.equals(cri))
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
                    .filter(cri -> clientRequestInterceptor.equals(cri))
                    .findFirst()
                    .isPresent();

            if (exists) {
                clientRequestInterceptors.remove(clientRequestInterceptor);
            }
        }
    }
}
