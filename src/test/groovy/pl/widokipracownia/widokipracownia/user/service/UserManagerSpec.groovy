package pl.widokipracownia.widokipracownia.user.service

import org.mapstruct.factory.Mappers
import org.springframework.security.crypto.password.PasswordEncoder
import pl.widokipracownia.widokipracownia.mapper.UserMapper
import pl.widokipracownia.widokipracownia.repository.UserRepository
import pl.widokipracownia.widokipracownia.user.AppUser
import pl.widokipracownia.widokipracownia.web.model.AppUserDto
import spock.lang.Shared
import spock.lang.Specification

class UserManagerSpec extends Specification {

    @Shared
    def ADMIN_ROLE_STRING = "ROLE_ADMIN"
    @Shared
    def USER_ROLE_STRING = "ROLE_USER"
    @Shared
    def USERNAME = "username"
    @Shared
    def USER = new AppUser(9999, "email", USERNAME, PASSWORD, null, "name", "last", null, null)
    @Shared
    def APP_USER_DTO = new AppUserDto("email", USERNAME, "first", "last")
    @Shared
    def PASSWORD = "pass"
    @Shared
    def USER_MAPPER = Mappers.getMapper(UserMapper.class)

    def mockPasswordEncoder = Mock(PasswordEncoder.class)
    def mockUserRepository = Mock(UserRepository.class)
    @Shared
    def MANAGER

    def setup() {
        MANAGER = new UserManagerImpl(mockUserRepository, USER_MAPPER, mockPasswordEncoder)
        MANAGER.save(USER)
    }

    def cleanup() {
        USER = new AppUser(9999, "email", USERNAME, PASSWORD, null, "name", "last", null, null)
        APP_USER_DTO = new AppUserDto("email", USERNAME, "first", "last")
    }


    def "should save user"() {
        when:
        def savedUser = MANAGER.save(USER)
        then:
        savedUser == USER
    }


    def "should set admin authority"() {
        when:
        MANAGER.setAuthority(ADMIN_ROLE_STRING, USER)
        then:
        USER.authorities.first().name.toString() == ADMIN_ROLE_STRING
    }

    def "should set user authority"() {
        when:
        MANAGER.setAuthority(USER_ROLE_STRING, USER)
        then:
        USER.authorities.first().name.toString() == USER_ROLE_STRING
    }

    def "should change password with encoded one"() {
        given:
        def newPassword = "newPassword"
        def encodedPass = mockPasswordEncoder.encode(newPassword)
        when:
        MANAGER.changePassword(USER, newPassword)
        then:
        USER.password == encodedPass
        USER.password != PASSWORD
    }

}
