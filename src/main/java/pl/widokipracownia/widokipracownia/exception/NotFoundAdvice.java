package pl.widokipracownia.widokipracownia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.widokipracownia.widokipracownia.web.model.Error;

import java.time.LocalDateTime;

@RestControllerAdvice
public class NotFoundAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Error> notFoundAdvice(NotFoundException ex) {
        Error error = new Error(ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
