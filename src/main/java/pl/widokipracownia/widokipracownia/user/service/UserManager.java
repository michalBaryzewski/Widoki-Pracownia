package pl.widokipracownia.widokipracownia.user.service;

import pl.widokipracownia.widokipracownia.user.AppUser;
import pl.widokipracownia.widokipracownia.web.model.AppUserDto;

import java.util.List;

public interface UserManager {

    AppUser findById(Integer id);
    AppUser findByUsername(String username);
    AppUser createUser(AppUserDto appUserDto, String password, String authority);
    AppUser save(AppUser appUser);
    AppUser changePassword(AppUser appUser, String password);
    List<AppUser> findAll();
    void setAuthority(String authority, AppUser user);

}
