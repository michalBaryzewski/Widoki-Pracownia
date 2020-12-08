package pl.widokipracownia.widokipracownia.web.model;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class Error {
    String message;
    LocalDateTime time;
}
