package pl.widokipracownia.widokipracownia.web.model;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class GeneralError {
    String message;
    LocalDateTime time;
    String cause;
}
