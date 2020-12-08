package pl.widokipracownia.widokipracownia.exception;

public class GeneralApplicationException extends RuntimeException{

    public static final String MESSAGE = "Whoops... something went wrong :(";

    public GeneralApplicationException() {
        super(MESSAGE);
    }

    public GeneralApplicationException(Throwable t) {
        super(MESSAGE, t);
    }
}

