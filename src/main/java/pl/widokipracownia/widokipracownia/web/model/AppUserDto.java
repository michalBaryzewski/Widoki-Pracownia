package pl.widokipracownia.widokipracownia.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDto {

    private String email;
    private String username;
    private String firstName;
    private String lastName;

}
