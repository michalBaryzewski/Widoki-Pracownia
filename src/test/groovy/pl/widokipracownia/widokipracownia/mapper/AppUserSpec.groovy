package pl.widokipracownia.widokipracownia.mapper

import org.mapstruct.factory.Mappers
import pl.widokipracownia.widokipracownia.user.AppUser
import pl.widokipracownia.widokipracownia.web.model.AppUserDto
import spock.lang.Shared
import spock.lang.Specification

import java.time.LocalDateTime

class AppUserSpec extends Specification implements MapperUtils {

    @Shared
    UserMapper mapper = Mappers.getMapper(UserMapper.class)
    @Shared
    AppUser appUserEntity = new AppUser(1, "email", "username", "pass", null, "firstName", "lastName", null, LocalDateTime.now())
    @Shared
    AppUserDto appUserDto = new AppUserDto("email", "username", "firstName", "lastName")


    def "should map user entity to dto"() {
        when:
        AppUserDto dto = mapper.userEntityToDto(appUserEntity)
        then:
        compareAppUserEntityToDto(appUserEntity, dto)
    }

    def "should map user dto to entity"() {
        when:
        AppUser user = mapper.dtoToUserEntity(appUserDto)
        then:
        compareAppUserEntityToDto(user, appUserDto)
    }

}
