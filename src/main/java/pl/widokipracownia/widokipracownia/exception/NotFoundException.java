package pl.widokipracownia.widokipracownia.exception;

public class NotFoundException extends RuntimeException{

    public static final String MESSAGE = "Not found";

    public NotFoundException() {
        super(MESSAGE);
    }
}
