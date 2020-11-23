package pl.widokipracownia.widokipracownia.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDto {
    private String email;
    private String firstName;
    private String lastName;
}
