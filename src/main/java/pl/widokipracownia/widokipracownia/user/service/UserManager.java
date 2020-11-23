package pl.widokipracownia.widokipracownia.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.widokipracownia.widokipracownia.repository.UserRepository;
import pl.widokipracownia.widokipracownia.user.AppUser;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserManager{

    private final UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<AppUser> findById(Integer id) {
        return repository.findById(id);
    }

    public AppUser save(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        repository.save(appUser);
        log.info("User created!");
        return appUser;
    }

    public AppUser changePassword(AppUser appUser, String password) {
        appUser.setPassword(passwordEncoder.encode(password));
        repository.save(appUser);
        log.info("Password changed!");
        return appUser;
    }



}
