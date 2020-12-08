package pl.widokipracownia.widokipracownia.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.widokipracownia.widokipracownia.exception.NotFoundException;
import pl.widokipracownia.widokipracownia.mapper.UserMapper;
import pl.widokipracownia.widokipracownia.repository.UserRepository;
import pl.widokipracownia.widokipracownia.user.AppUser;
import pl.widokipracownia.widokipracownia.user.Authority;
import pl.widokipracownia.widokipracownia.user.AuthorityType;
import pl.widokipracownia.widokipracownia.web.model.AppUserDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserManagerImpl implements UserManager{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    public AppUser findById(Integer id) {
        if (userRepository.findById(id).isPresent()) {
            return userRepository.findById(id).get();
        } else {
            throw new NotFoundException();
        }
    }

    public AppUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public AppUser createUser(AppUserDto appUserDto, String password, String authority) {
        AppUser user = userMapper.dtoToUserEntity(appUserDto);
        user.setPassword(password);
        user.setCreated(LocalDateTime.now());
        setAuthority(authority, user);
        return save(user);
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
        } else if (authority.equals(AuthorityType.ROLE_USER.toString())) {
            setUserAuthority(user);
        }
    }

    public void setUserAuthority(AppUser user) {
        Authority authority = new Authority();
        authority.setName(AuthorityType.ROLE_USER);
        user.setAuthorities(Set.of(authority));
    }

    public void setAdminAuthority(AppUser user) {
        Authority authority = new Authority();
        authority.setName(AuthorityType.ROLE_ADMIN);
        user.setAuthorities(Set.of(authority));
    }


}
