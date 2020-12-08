package pl.widokipracownia.widokipracownia.user.service

import org.springframework.beans.factory.annotation.Autowired
import pl.widokipracownia.widokipracownia.repository.AuthoritiesRepository
import pl.widokipracownia.widokipracownia.repository.UserRepository
import pl.widokipracownia.widokipracownia.user.AppUser
import pl.widokipracownia.widokipracownia.user.AuthorityType
import pl.widokipracownia.widokipracownia.web.dto.AppUserDto
import spock.lang.Shared
import spock.lang.Specification

import java.time.LocalDateTime

class UserManagerTest extends Specification {

    @Shared
    String adminRoleString = "ROLE_ADMIN"
    @Shared
    String userRoleString = "ROLE_USER"

    @Autowired
    UserRepository userRepository
    @Autowired
    AuthoritiesRepository authoritiesRepository
    @Autowired
    UserManager manager

//
//    def setup(){
//        manager = new UserManager(userRepository, authoritiesRepository)
//    }

    def "should set admin authority"() {
        given:
       AppUser user = userRepository.save(new AppUser(1, "email", "username", "password", null, "firstName", "lastName", null, LocalDateTime.now()))
        when:
        manager.setAuthority(adminRoleString, user)
//        AppUser user1 = userRepository.findByUsername("username")
        then:
        def auth = user.getAuthorities()
        print(auth)
//        user1.getUsername() == user.getUsername()

    }
}
