package pl.widokipracownia.widokipracownia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.widokipracownia.widokipracownia.web.model.GeneralError;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GeneralApplicationAdvice {

    @ExceptionHandler
    public ResponseEntity<GeneralError> errorHandler(GeneralApplicationException ex) {
        GeneralError error = new GeneralError(ex.getMessage(), LocalDateTime.now(), ex.getCause().toString());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
