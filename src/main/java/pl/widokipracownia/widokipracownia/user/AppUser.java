package pl.widokipracownia.widokipracownia.user;

import lombok.Data;

@Data
public class AppUser {
    private String email;
    private String password;
    private String role;
    private Integer projectId;
    private String firstName;
    private String lastName;
}
