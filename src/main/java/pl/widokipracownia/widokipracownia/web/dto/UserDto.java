package pl.widokipracownia.widokipracownia.web.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDto {
    String email;
    String firstName;
    String lastName;
}
