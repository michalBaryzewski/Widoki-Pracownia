package pl.widokipracownia.widokipracownia.web.service;

import org.springframework.stereotype.Service;
import pl.widokipracownia.widokipracownia.exception.GeneralApplicationException;
import pl.widokipracownia.widokipracownia.exception.NotFoundException;

import java.util.concurrent.Callable;

@Service
public class ActionService {

    private static RuntimeException translateException(RuntimeException e) {
        // switch for more exceptions
        switch (e.getCause().getMessage()) {
            //todo handle exceptions when app has more actions
            case "NotFound!":
                return new NotFoundException();
            default:
                return new GeneralApplicationException();
        }
    }

    public <T> T runActionAndHandleException(Callable<T> action) {
        try {
            return action.call();
        } catch (RuntimeException e) {
            throw translateException(e);
        } catch (Exception e) {
            throw new GeneralApplicationException(e);
        }
    }
}
