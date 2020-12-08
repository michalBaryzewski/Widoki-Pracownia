package pl.widokipracownia.widokipracownia.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.widokipracownia.widokipracownia.repository.AuthoritiesRepository;
import pl.widokipracownia.widokipracownia.repository.UserRepository;
import pl.widokipracownia.widokipracownia.user.AppUser;
import pl.widokipracownia.widokipracownia.user.Authority;
import pl.widokipracownia.widokipracownia.user.AuthorityType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserManager{

    private final UserRepository userRepository;
    private final AuthoritiesRepository authoritiesRepository;

    private final PasswordEncoder passwordEncoder;

    public Optional<AppUser> findById(Integer id) {
        return userRepository.findById(id);
    }

    public AppUser save(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUser.setCreated(LocalDateTime.now());
        userRepository.save(appUser);
        log.info("User created!");
        return appUser;
    }

    public AppUser changePassword(AppUser appUser, String password) {
        appUser.setPassword(passwordEncoder.encode(password));
        userRepository.save(appUser);
        log.info("Password changed!");
        return appUser;
    }

    public List<AppUser> findAll() {
        return userRepository.findAll();
    }

    public void setAuthority(String authority, AppUser user) {
        if (authority.equals(AuthorityType.ROLE_ADMIN.toString())) {
            setAdminAuthority(user);
        }
        else if (authority.equals(AuthorityType.ROLE_USER.toString())) {
            setUserAuthority(user);
        }
    }

    public void setUserAuthority(AppUser user) {
        Authority authority = authoritiesRepository.findById(2);
        user.setAuthorities(Set.of(authority));
    }

    public void setAdminAuthority(AppUser user) {
        Authority authority = authoritiesRepository.findById(1);
        user.setAuthorities(Set.of(authority));
    }


}
