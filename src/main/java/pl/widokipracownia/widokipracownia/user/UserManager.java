package pl.widokipracownia.widokipracownia.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class UserManager{

    private final UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AppUser save(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        repository.save(appUser);
        return appUser;
    }
}
